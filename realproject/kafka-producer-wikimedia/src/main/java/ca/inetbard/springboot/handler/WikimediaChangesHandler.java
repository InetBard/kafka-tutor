package ca.inetbard.springboot.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.MessageEvent;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;

import lombok.Data;

@Data
public class WikimediaChangesHandler implements BackgroundEventHandler{

	private static final Logger LOG = LoggerFactory.getLogger(WikimediaChangesHandler.class);
	
	private final KafkaTemplate<String, String> kafkaTemplate;
	
	private final String topic;
	
	@Override
	public void onOpen() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClosed() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(String event, MessageEvent messageEvent) throws Exception {
		
		LOG.info(String.format("event data -> %s", messageEvent.getData()));
		
		kafkaTemplate.send(topic, messageEvent.getData());
	}

	@Override
	public void onComment(String comment) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub
		
	}

}
