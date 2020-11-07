package com.notification;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.shared.model.Order;

@EnableBinding(Sink.class)
public class MassageConsumer {

	@StreamListener(Sink.INPUT)
	public void log(Order order) {
		System.out.println("  Message received order id is "+order.getOrderId());
	}
}
