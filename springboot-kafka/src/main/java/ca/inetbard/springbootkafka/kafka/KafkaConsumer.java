package ca.inetbard.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	
	private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumer.class);

	@KafkaListener(topics = "kafkatopicbean", groupId = "myGroup")
	public void consume(String message) {
		LOG.info(String.format("Message received -> %s", message));
	}
	
}
