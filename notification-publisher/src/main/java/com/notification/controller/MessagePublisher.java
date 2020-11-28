package com.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.notification.MessageSource;

@RestController
@EnableBinding(MessageSource.class)
public class MessagePublisher {

	@Autowired
	private MessageSource messageSource;
	

	@PostMapping(value = "/sendMessage",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String sendMessage(@RequestBody String payload) {
		  ObjectMapper obj = new ObjectMapper(); 
		  obj.enableDefaultTyping(ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE, JsonTypeInfo.As.PROPERTY);

		  Order order = null; 
		  try { 
			  order =  obj.readValue(payload, Order.class); 
			  } catch (JsonProcessingException e) {
				  	
		  }
		 
		messageSource.sendMessage().send(MessageBuilder.withPayload(payload).setHeader("myHeader", "myHeaderValue").build());
		System.out.println("Successfully sent message to our app !");
		return "success";
	}
}
