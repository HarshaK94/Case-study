package com.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
@SpringBootApplication
public class NotificationConsumerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationConsumerServiceApplication.class, args);
	}

	@StreamListener(target = Sink.INPUT)
	public void processRegisterCarts(String payloads) {
		System.out.println("Employees Registered by Client " + payloads);
	}
}
