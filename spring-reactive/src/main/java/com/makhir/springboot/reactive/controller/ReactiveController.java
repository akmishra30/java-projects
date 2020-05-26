package com.makhir.springboot.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.makhir.springboot.reactive.entity.Stock;
import com.makhir.springboot.reactive.entity.Trade;
import com.makhir.springboot.reactive.service.ReactiveService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
@Slf4j
public class ReactiveController {
	
	@Autowired
	private ReactiveService service;
	
	@PostMapping(path = "/stock")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addStock(@RequestBody Stock stock) {
		service.addNewStock(stock);
	}
	
	@GetMapping(path = "/stock/{code}")
	@ResponseStatus(code = HttpStatus.OK)
	public Mono<Stock> getStock(@PathVariable(name = "code", required = true) String code) {
		return service.getStock(code);
	}
	
	@GetMapping(path = "/stocks")
	@ResponseStatus(code = HttpStatus.OK)
	public Flux<Stock> getAllStocks() {
		log.info("get request for all stocks...");
		return service.getStocks();
	}
	
	@PostMapping(path = "/trade")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addStock(@RequestBody Trade trade) {
		service.submtTrade(trade);
	}
	
	@GetMapping(path = "/trade/{code}")
	@ResponseStatus(code = HttpStatus.OK)
	public Flux<Trade> getTrade(@PathVariable(name = "code", required = true) String code) {
		return service.getAllTrades(code);
	}
	
	@GetMapping(path = "/trades")
	@ResponseStatus(code = HttpStatus.OK)
	public Flux<Trade> getTrades() {
		return service.getAllTrades();
	}
}
