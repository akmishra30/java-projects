package com.makhir.springboot.jms.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.makhir.springboot.jms.model.Message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MessageSender {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void sendMessage(final Message message){
		try {
			log.info("## Sending sample message to jms queue: {} : message : {}", message.getQueue(), message.getPayload());
			
			jmsTemplate.convertAndSend(message.getQueue(), message.getPayload());
			
			log.info("## Message sent successfully.");
			
		} catch (Exception e) {
			log.error("There was a problem while sending message to jms queue. Error message: {}", e.getMessage());
			e.printStackTrace();
		}
	}
}
