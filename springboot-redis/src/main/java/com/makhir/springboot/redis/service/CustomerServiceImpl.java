package com.makhir.springboot.redis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makhir.springboot.redis.entity.Customer;
import com.makhir.springboot.redis.repository.RedisH2Repository;
import com.makhir.springboot.redis.repository.RedisRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private RedisRepository redisRepository;
	
	@Autowired
	private RedisH2Repository redisH2Repository;
	
	@Override
	public void saveCustomer(Customer customer) {
		log.debug("## Customer to be{}", customer);
		Customer dbCust = redisH2Repository.save(customer);
		log.debug("## Db customer: {}", dbCust);
		redisRepository.save(dbCust);
	}

	@Override
	public void deleteCustomer(long id) {
		Customer customer = new Customer();
		customer.setId(id);
		redisRepository.delete(customer);
		redisH2Repository.delete(customer);
	}

	@Override
	public Customer getCustomer(long id) {
		Optional<Customer> result = redisRepository.findById(id);
		if(result.isPresent()){
			log.info("## Present in Redis cache");
			return result.get();
		} else {
			log.info("## Not Present in Redis cache");
			Optional<Customer> cust = redisH2Repository.findById(id);
			if(cust.isPresent()){
				log.info("## Present in DB.");
				redisRepository.save(cust.get());
				return cust.get();
			}
		}
		return null;
	}

	@Override
	public List<Customer> listCustomers() {
		Iterable<Customer> results = redisRepository.findAll();
		List<Customer> list = new ArrayList<Customer>(2);
		results.forEach(c ->{
			if(c != null)
				list.add(c);
		});
		log.info("## Total data in cache: {}", list.size());
		return list;
	}

	@Override
	public long refreshCustomerCache() {
		long count = redisRepository.count();
		log.info("## Total data to be deleted from cache : {}", count);
		redisRepository.deleteAll();
		return count;
	}
}
