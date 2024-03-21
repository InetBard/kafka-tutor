package ca.inetbard.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import ca.inetbard.springbootkafka.model.User;
import lombok.Data;

@Service
@Data
public class JsonKafkaProducer {
	
	private static final Logger LOG = LoggerFactory.getLogger(JsonKafkaProducer.class);
	
	private final KafkaTemplate<String, User> kafkaTemplate;
	
	public void sendMessage(User data) {
		
		LOG.info(String.format("Message sent -> %s", data.toString()));
		
		Message<User> message = MessageBuilder.withPayload(data) 
				.setHeader(KafkaHeaders.TOPIC, "kafkajsontopicbean")
				.build();
		
		kafkaTemplate.send(message);
	}
}
