package demoproducer.producer;

import demoproducer.message.Sample;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SampleProducer {
    private final StreamBridge streamBridge;

    public boolean sampleStream(Message<Sample> message) {
        return streamBridge.send("sample-stream-out-0", message);
    }
}