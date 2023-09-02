package com.gaber.kafkatest;

import com.gaber.kafkatest.producer.KafkaProducer1;
import com.gaber.kafkatest.producer.KafkaProducer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkatestApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkatestApplication.class, args);
	}

	@Autowired
	private KafkaProducer1 kafkaProducer1;

	@Autowired
	private KafkaProducer2 kafkaProducer2;

	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate){
		return args -> {
			for (int i = 0; i < 50; i++) {
				kafkaProducer1.sendMessage("hello_kafka_n_" + i);

				kafkaProducer2.sendMessage("hello_kafka_n_" + i);
			}

		};
	}

}
