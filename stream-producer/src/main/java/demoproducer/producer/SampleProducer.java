package demoproducer.producer;

import demoproducer.message.Sample;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class SampleProducer {
    private final StreamBridge streamBridge;

    public SampleProducer(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public boolean sampleStream(Message<Sample> message) {
        return streamBridge.send("sample-stream-out-0", message);
    }
}