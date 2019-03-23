package com.makhir.springboot.redis.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

@Data
@RedisHash(value="customer-bucket", timeToLive=60*60) //1hr
@Entity(name="CUSTOMER")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="idSeqGenerator")
	@SequenceGenerator(name="idSeqGenerator", sequenceName="ID_SEQ")
	@Column(name="ID")
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="CONTACT")
	private String contact;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="CREATED_TIME")
	//@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
	private String createdTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S").format(new Date());

}
