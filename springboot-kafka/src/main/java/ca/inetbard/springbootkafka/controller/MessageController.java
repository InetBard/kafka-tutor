package ca.inetbard.springbootkafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.inetbard.springbootkafka.kafka.KafkaProducer;
import lombok.Data;

@RestController
@RequestMapping("/api/v1/kafka")
@Data
@Component
public class MessageController {

	private final KafkaProducer kafkaProducer;
	
	//http:localhost:8080/api/v1/kafka/publish?message=hello world
	//bin/kafka-console-consumer.sh --topic kafkatopicbean --from-beginning --bootstrap-server localhost:9092
	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestParam("message") String message){
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok(String.format("Message | %s | -> sent to topic", message));
		
	}
}
