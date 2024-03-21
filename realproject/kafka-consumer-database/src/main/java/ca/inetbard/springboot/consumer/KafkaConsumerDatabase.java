package ca.inetbard.springboot.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import ca.inetbard.springboot.model.WikimediaData;
import ca.inetbard.springboot.repository.WikiMediaRepository;
import lombok.Data;

@Service
@Data
public class KafkaConsumerDatabase {

	private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumerDatabase.class);
	
	private final WikiMediaRepository repository;
	
	@KafkaListener(
			topics = "wikimedia_recentchange", 
			groupId = "myGroup"
			)
	public void consume(String eventMessage) {
		LOG.info(String.format("Message received %s", eventMessage));
		
		WikimediaData data = new WikimediaData();
		data.setWikiEventData(eventMessage);
		
		repository.save(data);
		
	}
}
