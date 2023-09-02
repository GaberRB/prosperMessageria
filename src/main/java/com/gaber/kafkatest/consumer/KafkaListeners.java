package com.gaber.kafkatest.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Component
@Slf4j
public class KafkaListeners {

    private final HttpClient httpClient;

    public KafkaListeners() {
        this.httpClient = HttpClient.newHttpClient();
    }

    @KafkaListener(
            topics = "topico_java",
            groupId = "groupId",
            containerFactory="kafkaListenerContainerFactory"
    )
    public void listerner(List<String> dados){
        log.info("Consumo das mensagens em Lote de  ", dados.size());
        if (dados.size() > 0){
            Executor executor = Executors.newFixedThreadPool(10);
            List<CompletableFuture<Void>> futures = new ArrayList<>();
            StopWatch processWatch = StopWatch.createStarted();
            for(var dado : dados){
                CompletableFuture<Void> future = CompletableFuture.runAsync(() ->{
                    log.info("Consumindo a mensagem: ", dado);
                }, executor);
                futures.add(future);
            }

            futures.stream().map(CompletableFuture::join).collect(Collectors.toList());

            processWatch.stop();;

            log.info("fim do consumo das mensagens : {} ", processWatch);
        }

    }

}
