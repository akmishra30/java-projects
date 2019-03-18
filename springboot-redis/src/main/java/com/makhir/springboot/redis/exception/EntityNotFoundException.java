package com.makhir.springboot.redis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends Exception {
	private String id;
	private String message;
	
	public EntityNotFoundException(String message, String id){
		this.message = message;
		this.id = id;
	}
	
	public String getId(){
		return id;
	}
	
	@Override
	public String getMessage(){
		return message.concat(id);
	}
}
