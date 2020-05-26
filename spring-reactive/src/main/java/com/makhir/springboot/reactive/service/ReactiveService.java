package com.makhir.springboot.reactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.makhir.springboot.reactive.entity.Stock;
import com.makhir.springboot.reactive.entity.Trade;
import com.makhir.springboot.reactive.repository.StockRepository;
import com.makhir.springboot.reactive.repository.TradeRepository;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@Transactional
@NoArgsConstructor
public class ReactiveService {
	
	@Autowired(required = true)
	private StockRepository stockRepository;
	
	@Autowired(required = true)
	private TradeRepository tradeRepository;
	
	public void addNewStock(Stock stock) {
		stockRepository.save(stock);
	}
	
	public Mono<Stock> getStock(String code) { 
		return Mono.just(stockRepository.findByCode(code));
	}
	
	public Flux<Stock> getStocks() { 
		log.info("get request for all stocks...");
		return Flux.fromIterable(stockRepository.findAll());
	}
	
	public Mono<Trade> submtTrade(Trade trade) {
		return Mono.just(tradeRepository.save(trade));
	}
	
	public Flux<Trade> getAllTrades(){
		return Flux.fromIterable(tradeRepository.findAll());
	}
	
	public Flux<Trade> getAllTrades(String code){
		return Flux.fromIterable(tradeRepository.findByCode(code));
	}
}
