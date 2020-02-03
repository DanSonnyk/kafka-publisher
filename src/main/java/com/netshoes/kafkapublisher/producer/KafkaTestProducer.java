package com.netshoes.kafkapublisher.producer;

import com.netshoes.kafkapublisher.gateway.KafkaTestProducerGateway;
import com.netshoes.kafkapublisher.json.KafkaTestProducerMessageResponseJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaTestProducer implements KafkaTestProducerGateway {

    private final KafkaTemplate<String, KafkaTestProducerMessageResponseJson> kafkaTemplate;

    @Value(value = "${kafka.kafkapublisher.pre-authorization-status.producer.topic}")
    private String preAuthorizationPaymentTokenStatusResponseTopic;
    public KafkaTestProducer(@Qualifier("kafkaTestTemplate") KafkaTemplate<String, KafkaTestProducerMessageResponseJson> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(final KafkaTestProducerMessageResponseJson kafkaTestProducerMessageResponseJson) {
        log.info("Publishing PaymentTokenStatus verification response asynchronousKey: {} cartHash: {} ",
                kafkaTestProducerMessageResponseJson.getAsynchronousKey(), kafkaTestProducerMessageResponseJson.getCartHash());

        kafkaTemplate.send(preAuthorizationPaymentTokenStatusResponseTopic, kafkaTestProducerMessageResponseJson);
    }
}

