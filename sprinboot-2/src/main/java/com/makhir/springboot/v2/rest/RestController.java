package com.makhir.springboot.v2.rest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@org.springframework.web.bind.annotation.RestController
@Slf4j
@RequestMapping("/api")
public class RestController {
	
	private static final String greetingMsg = "Hello SpringBoot!. Hit counter \n %s!";
    private final AtomicLong counter = new AtomicLong();
	
    @RequestMapping(path="/greeting", method = RequestMethod.GET)
	public ResponseEntity<String> showGreeting(){
    	
    	log.info("Enter: RestController.showGreeting");
    	
		return ResponseEntity.ok()
				.body(String.format(greetingMsg, counter.incrementAndGet()));
	}
}
