/*
 * KafkaConfig.java 2021. 06. 02
 *
 * Copyright 2021 Naver Cloud Corp. All rights Reserved.
 * Naver Business Platform PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package demoproducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dongju.paek
 */

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic createSampleTopic() {
        return new NewTopic("sample-topic", 1, (short) 1);
    }
}