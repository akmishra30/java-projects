package com.makhir.springboot.reactive.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.makhir.springboot.reactive.entity.Stock;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long>{

	Stock findByCode(String code);
	
}
