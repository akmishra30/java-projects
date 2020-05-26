package com.makhir.springboot.reactive.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.makhir.springboot.reactive.entity.Trade;

@Repository
public interface TradeRepository extends CrudRepository<Trade, Long>{

	List<Trade> findByCode(String code);
	
}
