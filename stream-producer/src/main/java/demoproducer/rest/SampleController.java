package demoproducer.rest;

import demoproducer.message.Sample;
import demoproducer.producer.SampleProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class SampleController {

    private final SampleProducer publisher;

    private Message<Sample> makeMessage(Sample message) {
        return MessageBuilder.withPayload(message).build();
    }

    @PostMapping("/samples")
    public boolean directMessage(@RequestBody Sample message) {
        return publisher.sampleStream(makeMessage(message));
    }


}

