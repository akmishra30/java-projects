package com.makhir.springboot.redis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.makhir.springboot.redis.entity.Customer;

@Repository
public interface RedisH2Repository extends CrudRepository<Customer, Long> {

}
