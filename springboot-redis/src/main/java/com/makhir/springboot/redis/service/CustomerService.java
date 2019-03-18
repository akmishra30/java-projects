package com.makhir.springboot.redis.service;

import java.util.List;

import com.makhir.springboot.redis.entity.Customer;

public interface CustomerService {
	void saveCustomer(Customer customer);
	
	void deleteCustomer(long id);
	
	Customer getCustomer(long id);
	
	List<Customer> listCustomers();
	
	void refreshCustomerCache();
}
	
	
