package com.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.core.annotation.Order;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.notification.MessageSource;

@RestController
@EnableBinding(MessageSource.class)
public class MessagePublisher {

	@Autowired
	private MessageSource messageSource;
	
	@PostMapping(value = "/sendMessage")
	public String sendMessage(@RequestBody String payload) {
		ObjectMapper obj = new ObjectMapper();
		Order order = null;
		try {
			order = obj.readValue(payload, Order.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		messageSource.sendMessage().send(MessageBuilder.withPayload(order).setHeader("myHeader", "myHeaderValue").build());
		System.out.println("Successfully sent message to our app !");
		return "success";
	}
}
