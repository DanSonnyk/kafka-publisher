package com.netshoes.kafkapublisher.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "kafka.payment.pre-authorization-status")
public class KafkaTestProcuderProperties {

    private String bootstrapServers;

    private String groupId;
}
