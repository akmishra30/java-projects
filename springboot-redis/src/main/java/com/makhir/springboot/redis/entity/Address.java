package com.makhir.springboot.redis.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private long cid;
	
	private String type;
	
	private String unit;
	
	private String street;
	
	private String town;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private int pin;
}
