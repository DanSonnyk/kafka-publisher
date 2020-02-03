package com.netshoes.kafkapublisher.json;

import lombok.*;

import java.util.List;
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class KafkaTestProducerMessageResponseJson {

    private String asynchronousKey;

    private List<String> preAuthorizedTokenStatus;

    private String cartHash;

    private String storeId;

}
