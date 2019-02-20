package com.makhir.api.doc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.makhir.api.doc.entity.Customer;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {
	public Customer getCustomer(long cid){
		Customer customer = new Customer();
		customer.setId(cid);
		customer.setName("Customer-"+cid);
		customer.setContact("12345678");
		customer.setCity("Anand");
		customer.setEmail("email@test.com");
		
		log.debug("Retreived customer: {}", customer.toString());
		
		return customer;
	}
	
	public long saveCustomer(Customer customer){
		log.debug("Customer Saved successfully: {}", customer.toString());
		return 100;
	}
	
	public List<Customer> getCustomers(){
		log.debug("Customer Saved successfully: {}");
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer(100, "Customer-" + 100, "987987987", "Anand", "abc@email.com"));
		customers.add(new Customer(101, "Customer-" + 101, "987980087", "Ahmedabad", "abc1@email.com"));
		customers.add(new Customer(102, "Customer-" + 102, "987987787", "Baroda", "abc2@email.com"));
		customers.add(new Customer(103, "Customer-" + 103, "987988787", "Surat", "abc3@email.com"));
		customers.add(new Customer(104, "Customer-" + 104, "987987966", "Nadiad", "abc4@email.com"));
		log.debug("Total returned customers: {}", customers.size());
		return customers;
	}
	
	public List<Customer> searchCustomer(String searchKey){
		log.debug("Key to search: {}", searchKey);
	
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer(100, "Customer-" + 100, "987987987", "Anand", "abc@email.com"));
		customers.add(new Customer(101, "Customer-" + 101, "987980087", "Ahmedabad", "abc1@email.com"));
		customers.add(new Customer(102, "Customer-" + 102, "987987787", "Baroda", "abc2@email.com"));
		customers.add(new Customer(103, "Customer-" + 103, "987988787", "Surat", "abc3@email.com"));
		customers.add(new Customer(104, "Customer-" + 104, "987987966", "Nadiad", "abc4@email.com"));
		log.debug("Total mapped customers: {}", customers.size());
		return customers;
	}
}
