package com.makhir.springboot.jms.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Message implements Serializable{
	private String queue;
	private String payload;
}
