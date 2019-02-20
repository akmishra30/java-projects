package com.makhir.api.doc.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.makhir.api.doc.entity.Customer;
import com.makhir.api.doc.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path="/customer")
@Api(value="/customer", produces ="application/json", tags="Customer Rest Controller")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@RequestMapping(path = "/get/{cid}", method = RequestMethod.GET)
	@ApiOperation(value = "This API fetches the customer with given customer id in URI.", response=Customer.class)
	@ApiParam(name = "cusomter id", required = true, format="Numerical value")
	@ApiResponses(value={
		//Set custom response code which ever you wish to add. By default :- 200 - OK, 401 - Unauthorized, 403 - Forbidden, 404 - Not Found	
	})
	public ResponseEntity<?> getCustomer(@PathVariable @ApiParam(value="Customer id of customer to be fetched.") long cid){
		log.info("Get cusomer with id: {}", cid);
		Customer customer = service.getCustomer(cid);
		
		if(customer != null){
			log.info("Returned customer : {}", customer.toString());
			return ResponseEntity.ok()
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(customer);
		} else {
			log.info("No cusomer found with cid: {}", cid);
			return ResponseEntity.notFound().build();
		}
	}
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	@ApiOperation(value = "This API to save the customer in DB.", consumes = "application/json")
	@ApiResponses(value={
		//Set custom response code which ever you wish to add. By default :- 200 - OK, 201 - Created, 401 - Unauthorized, 403 - Forbidden, 404 - Not Found	
	})
	public ResponseEntity<?> saveCustomer(@RequestBody @ApiParam(value="Customer model in json format to be saved.") Customer customer) throws URISyntaxException{
		long cid = service.saveCustomer(customer);
		
		if(cid > 0){
			log.info("saved customer cid: {}", cid);
			return ResponseEntity.created(new URI("/makhir/customer/get/"+cid)).build();
		} else {
			log.info("No cusomer found with cid: {}", cid);
			return ResponseEntity.badRequest().body("There was a problem while saving customer");
		}
	}
	
	@RequestMapping(path = "/getAll", method = RequestMethod.GET)
	@ApiOperation(value = "This API fetches all the customers from backend.", consumes = "application/json")
	@ApiResponses(value={
		//Set custom response code which ever you wish to add. By default :- 200 - OK, 201 - Created, 401 - Unauthorized, 403 - Forbidden, 404 - Not Found	
	})
	public ResponseEntity<?> getCustomers(){
		log.info("Inside getCustomers");
		List<Customer> customers = service.getCustomers();
		
		if(customers != null){
			log.info("Returned total customer : {}", customers.size());
			return ResponseEntity.ok()
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(customers);
		} else {
			log.info("No cusomer found.");
			return ResponseEntity.notFound().build();
		}
	}
	
	@RequestMapping(path = "/search/{key}", method = RequestMethod.GET)
	@ApiOperation(value = "Search the customer with search with key name, email, contact, city", consumes = "application/json")
	@ApiResponses(value={
		//Set custom response code which ever you wish to add. By default :- 200 - OK, 201 - Created, 401 - Unauthorized, 403 - Forbidden, 404 - Not Found	
	})
	public ResponseEntity<?> searchCustomers(@PathVariable String searchKey){
		log.info("Inside searchCustomers search key : {}", searchKey);
		List<Customer> customers = service.searchCustomer(searchKey);
		if(customers != null){
			log.info("Total customer found : {}", customers.size());
			return ResponseEntity.ok()
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(customers);
		} else {
			log.info("No cusomer found.");
			return ResponseEntity.notFound().build();
		}
	}
}
