package org.nameless.kafka.amqp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishMessage(String topic, Object message) {
        log.info("Publishing to {}. Payload: {}", topic, message);
        kafkaTemplate.send(topic, message);
        log.info("Published to {}. Payload: {}", topic, message);
    }
}
