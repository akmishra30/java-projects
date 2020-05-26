package com.makhir.springboot.reactive.service;

import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.makhir.springboot.reactive.entity.Stock;
import com.makhir.springboot.reactive.entity.Trade;
import com.makhir.springboot.reactive.repository.StockRepository;
import com.makhir.springboot.reactive.repository.TradeRepository;
import com.makhir.springboot.reactive.util.TestUtil;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@ExtendWith(SpringExtension.class)
@WebFluxTest()
@ContextConfiguration(classes = {ReactiveService.class})
public class ReactiveServiceTests {
	
	@Autowired
	private ReactiveService reactiveService;
	
	@MockBean
	StockRepository stockRepository;
	
	@MockBean
	TradeRepository tradeRepository;
	
	@Test
	public void testGetStock() {
		log.info("Started ... testGetStock");
		when(stockRepository.findByCode(Mockito.anyString())).thenReturn(TestUtil.getStockObject());
		Mono<Stock> stock = reactiveService.getStock(Mockito.anyString());
		Assertions.assertNotNull(stock);
		log.info("Finished ... testGetStock");
	}
	
	@Test
	public void testGetStocks() {
		log.info("Started ... testGetStocks");
		when(stockRepository.findAll()).thenReturn(Arrays.asList(TestUtil.getStockObject()));
		Flux<Stock> stocks = reactiveService.getStocks();
		Assertions.assertNotNull(stocks);
		log.info("Finished ... testGetStocks");
	}
	
	@Test
	public void testGetSelectedTrades() {
		log.info("Started ... testGetSelectedTrades");
		when(tradeRepository.findByCode(Mockito.anyString())).thenReturn(Arrays.asList(TestUtil.getTradeObject()));
		Flux<Trade> trades = reactiveService.getAllTrades(Mockito.anyString());
		Assertions.assertNotNull(trades);
		log.info("Finished ... testGetSelectedTrades");
	}
	
	@Test
	public void testGetAllTrades() {
		log.info("Started ... testGetAllTrades");
		when(tradeRepository.findAll()).thenReturn(Arrays.asList(TestUtil.getTradeObject()));
		Flux<Trade> trades = reactiveService.getAllTrades();
		Assertions.assertNotNull(trades);
		log.info("Finished ... testGetAllTrades");
	}
}

