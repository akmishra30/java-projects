package com.makhir.springboot.jms.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.makhir.springboot.jms.model.Message;
import com.makhir.springboot.jms.service.JmsService;

import lombok.extern.slf4j.Slf4j;

@org.springframework.web.bind.annotation.RestController
@Slf4j
@RequestMapping(path="/jms/service")
public class RestController {
	
	@Autowired
	private JmsService jmsService;
	
	@RequestMapping(path="/message", method = RequestMethod.POST)
	public ResponseEntity<?> postMessage(@RequestBody Message message){
		log.info("## Received message for posting. {}", message.toString());
		
		jmsService.postMessage(message);
		
		log.info("## Message posting successful.");
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(path="/get", method = RequestMethod.POST)
	public ResponseEntity<?> getMessages(){
		return null;
	}
}
