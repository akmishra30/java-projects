package com.makhir.springboot.redis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidDataException extends Exception {
	private String payload;
	private String message;
	
	public InvalidDataException(String message, String payload){
		this.message = message;
		this.payload = payload;
	}
	
	public String getPayload(){
		return payload;
	}
	
	@Override
	public String getMessage(){
		return message.concat(payload);
	}
}
