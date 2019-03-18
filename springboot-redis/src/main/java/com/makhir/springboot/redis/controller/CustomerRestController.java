package com.makhir.springboot.redis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.makhir.springboot.redis.entity.Customer;
import com.makhir.springboot.redis.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(path="/customer")
@RestController
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(path="/add", method=RequestMethod.POST)
	public ResponseEntity<?> saveCustomer(@RequestBody @Valid Customer customer){
		log.info("## customer to be saved: {}", customer);
		customerService.saveCustomer(customer);
		log.info("## saved customer : {}", customer);
		return ResponseEntity.ok("Customer has been created.");
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getCustomer(@PathVariable long id){
		log.info("## customer to be get: {}", id);
		Customer customer = customerService.getCustomer(id);
		log.info("## fetched customer: {}", customer);
		return ResponseEntity.ok(customer);
	}
	
	@RequestMapping(path="/list", method=RequestMethod.GET)
	public ResponseEntity<?> listCustomers(){
		List<Customer> customers = customerService.listCustomers();
		Map<String, Object> result = new HashMap<String, Object>(2, 0.75f);
		result.put("data", customers);
		result.put("total", customers != null ? customers.size() : 0);
		return ResponseEntity.ok(result);
	}
	
	@RequestMapping(path="/delete/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteCustomers(@PathVariable long id){
		log.info("## customer to be deleted: {}", id);
		customerService.deleteCustomer(id);
		log.info("## customer got deleted : {}", id);
		return ResponseEntity.ok("Customer has been removed with id: " + id);
	}
	
	@RequestMapping(path="/cache/refresh", method=RequestMethod.DELETE)
	public ResponseEntity<?> cacheRefresh(){
		customerService.refreshCustomerCache();
		return ResponseEntity.ok("Customer cache refreshed successfully.");
	}
}
