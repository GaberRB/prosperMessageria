package com.gaber.kafkatest.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaProducer2 {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducer2(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {

        log.info("Mensagem recebida no producer 2 message:{} ", message);
        kafkaTemplate.send("topico_java", message);
        log.info("[KafkaProducer2] mensagem enviada com sucesso");
    }
}


