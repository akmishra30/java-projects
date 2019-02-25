package com.makhir.camel.mybatis.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.makhir.camel.mybatis.entity.Customer;

public class DataProcessor implements Processor{

	final static Logger logger = LoggerFactory.getLogger(DataProcessor.class);
	private final static int MAX_RANGE = 999999;
	private final static int MIN_RANGE = 1000;
	
	public void process(Exchange exchange) throws Exception {
		Customer customer = new Customer();
		customer.setId(exchange.getProperty("id", Integer.class));
		
		exchange.getMessage().setBody(customer);
	}

	public Customer createSampleCustomer(){
		Customer customer = new Customer();
		int randomNo = generateRandomNo();
		customer.setId(randomNo);
		customer.setName("Ashking-" + randomNo);
		customer.setCity("Singapore");
		customer.setAddress("Address-" + randomNo);
		customer.setContact("8888-" + randomNo);
	
		return customer;
	}
	
	private int generateRandomNo(){
		 int range = (MAX_RANGE - MIN_RANGE) + 1;     
		 return (int)(Math.random() * range) + MIN_RANGE;
	}
}
