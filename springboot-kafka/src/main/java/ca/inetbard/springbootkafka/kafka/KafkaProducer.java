package ca.inetbard.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Data
public class KafkaProducer {
	
	private static final Logger LOG = LoggerFactory.getLogger(KafkaProducer.class);
	
	private final KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String message) {
		LOG.info(String.format("Message sent %s", message));
		kafkaTemplate.send("kafkatopicbean", message);
	}
	
	
}
