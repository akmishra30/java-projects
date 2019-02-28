package com.makhir.springboot.jms.exception;

import org.springframework.util.ErrorHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomErrorHandler implements ErrorHandler {

	@Override
	public void handleError(Throwable t) {
		log.error("Error thrown while doing jms transaction. Error message : {}", t.getMessage());
		t.printStackTrace();
	}

}
