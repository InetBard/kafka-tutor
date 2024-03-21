package ca.inetbard.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import ca.inetbard.springbootkafka.model.User;

@Service
public class JsonKafkaConsumer {
	
	private static final Logger LOG = LoggerFactory.getLogger(JsonKafkaConsumer.class);

	@KafkaListener(topics = "kafkajsontopicbean", groupId = "myGroup")
	public void consume(User user) {
		LOG.info(String.format("Message received -> %s", user.toString()));
	}
	
}
