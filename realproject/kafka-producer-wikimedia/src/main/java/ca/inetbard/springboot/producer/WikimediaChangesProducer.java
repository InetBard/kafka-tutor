package ca.inetbard.springboot.producer;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;

import ca.inetbard.springboot.handler.WikimediaChangesHandler;
import lombok.Data;

@Service
@Data
public class WikimediaChangesProducer {

	private static final Logger LOG = LoggerFactory.getLogger(WikimediaChangesProducer.class);
	
	private final KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage() throws InterruptedException {
		String topic = "wikimedia_recentchange";
		
		//to read real time stream data from wikimedia, we use event source
		BackgroundEventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, topic);
		
		String url = "https://stream.wikimedia.org/v2/stream/recentchange";
		
//		EventSource.Builder builder = new EventSource.Builder(URI.create(url));
//		builder.build();
		
		BackgroundEventSource.Builder builder = new BackgroundEventSource.Builder(
				eventHandler, 
				new EventSource.Builder(URI.create(url))
				);
		BackgroundEventSource eventSource = builder.build();
		
		eventSource.start();
		
		TimeUnit.MINUTES.sleep(10);
		
	}
}
