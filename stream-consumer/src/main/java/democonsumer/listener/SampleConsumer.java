package democonsumer.listener;

import democonsumer.message.Sample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
public class SampleConsumer {

    @Bean("sample-stream")
    public Consumer<Message<Sample>> sampleStream() {
        return message -> log.info("RECV {}", message.getPayload());
    }
}

