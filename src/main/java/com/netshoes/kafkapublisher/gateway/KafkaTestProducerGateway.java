package com.netshoes.kafkapublisher.gateway;

import com.netshoes.kafkapublisher.json.KafkaTestProducerMessageResponseJson;

public interface KafkaTestProducerGateway {
    void sendMessage(KafkaTestProducerMessageResponseJson kafkaTestProducerMessageResponseJson);
}
