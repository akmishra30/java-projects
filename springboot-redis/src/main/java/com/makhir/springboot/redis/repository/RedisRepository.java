package com.makhir.springboot.redis.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.makhir.springboot.redis.entity.Customer;

public interface RedisRepository extends CrudRepository<Customer, Long> {
	List<Customer> findAll();
}
