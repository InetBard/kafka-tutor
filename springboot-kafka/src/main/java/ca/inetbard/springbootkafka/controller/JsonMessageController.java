package ca.inetbard.springbootkafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.inetbard.springbootkafka.kafka.JsonKafkaProducer;
import ca.inetbard.springbootkafka.model.User;
import lombok.Data;

@RestController
@RequestMapping("/api/v1/kafka")
@Data
@Component
public class JsonMessageController {

	private final JsonKafkaProducer kafkaProducer;
	
	//http:localhost:8080/api/v1/kafka/publish?message=hello world
	//bin/kafka-console-consumer.sh --topic kafkatopicbean --from-beginning --bootstrap-server localhost:9092
	@PostMapping("/publish/json")
	public ResponseEntity<String> publish(@RequestBody User user){
		
		kafkaProducer.sendMessage(user);
		
		return ResponseEntity.ok(String.format("Json message | %s | -> sent to kafka", user.toString()));
		
	}
}
