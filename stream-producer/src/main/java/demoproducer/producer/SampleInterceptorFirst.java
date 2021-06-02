/*
 * SampleInterceptor.java 2021. 06. 03
 *
 * Copyright 2021 Naver Cloud Corp. All rights Reserved.
 * Naver Business Platform PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package demoproducer.producer;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.stereotype.Service;

/**
 * @author dongju.paek
 */
@Service
public class SampleInterceptorFirst implements ChannelInterceptor {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        MessageHeaderAccessor mutableAccessor = MessageHeaderAccessor.getMutableAccessor(message);
        mutableAccessor.setHeader("Sample-Header-01", "Test-Sample-Value-01");
        return new GenericMessage<>(message.getPayload(), mutableAccessor.getMessageHeaders());
    }
}


