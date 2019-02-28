package com.makhir.springboot.jms.receiver;

import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MessageReceiver {
	
	@JmsListener(destination = "message.queue")
	public void receiveMessages(final Message message){
		log.info("## inside receive messages.");
		try {
			if(message instanceof TextMessage){
				TextMessage txtMsg = (TextMessage) message;
				log.info("## Received message: {}", txtMsg.getText());
			}
		} catch (Exception e) {
			log.error("There was a problem while reading message from queue. error message : {}", e.getMessage());
			e.printStackTrace();
		}
		
	}
}
