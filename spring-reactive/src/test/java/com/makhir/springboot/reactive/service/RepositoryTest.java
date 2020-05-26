package com.makhir.springboot.reactive.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.makhir.springboot.reactive.entity.Stock;
import com.makhir.springboot.reactive.entity.Trade;
import com.makhir.springboot.reactive.repository.StockRepository;
import com.makhir.springboot.reactive.repository.TradeRepository;
import com.makhir.springboot.reactive.util.TestUtil;

@DataJpaTest
public class RepositoryTest {
	@Autowired
	StockRepository stockRepository;
	
	@Autowired
	TradeRepository tradeRepository;
	
	@Test
	public void testStockRepository() {
		
		stockRepository.save(TestUtil.getStockObject());
		
		Stock stock = stockRepository.findByCode("RIL");
		
		Assertions.assertTrue(stock.getCode().equalsIgnoreCase("RIL"));
	}
	
	@Test
	public void testTradeRepository() {
		tradeRepository.save(TestUtil.getTradeObject());
		
		List<Trade> trades = tradeRepository.findByCode("RIL");
		
		Assertions.assertTrue(trades.get(0).getCode().equalsIgnoreCase("RIL"));
	}
}
