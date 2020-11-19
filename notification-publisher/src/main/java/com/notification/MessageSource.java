package com.notification;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MessageSource {

	@Output("messageSourceChannel")
	MessageChannel sendMessage();
	
}
