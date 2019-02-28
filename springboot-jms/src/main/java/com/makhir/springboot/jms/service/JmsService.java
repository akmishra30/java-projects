package com.makhir.springboot.jms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makhir.springboot.jms.model.Message;
import com.makhir.springboot.jms.receiver.MessageReceiver;
import com.makhir.springboot.jms.sender.MessageSender;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JmsService {
	
	@Autowired
	private MessageSender sender;
	
	@Autowired
	private MessageReceiver receiver;
	
	public void postMessage(Message message){
		log.info("## Posting message : {}", message.toString());
		
		sender.sendMessage(message);
		
		log.info("## message submission successful.");
	}
	
	public List<Message> getMessages(){
		return null;
	}
}
