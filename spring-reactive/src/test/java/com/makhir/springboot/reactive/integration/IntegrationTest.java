package com.makhir.springboot.reactive.integration;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import com.makhir.springboot.reactive.controller.ReactiveController;
import com.makhir.springboot.reactive.entity.Stock;
import com.makhir.springboot.reactive.entity.Trade;
import com.makhir.springboot.reactive.repository.StockRepository;
import com.makhir.springboot.reactive.repository.TradeRepository;
import com.makhir.springboot.reactive.service.ReactiveService;
import com.makhir.springboot.reactive.util.TestUtil;

@WebFluxTest(controllers = ReactiveController.class)
//@ExtendWith(SpringExtension.class)
@Import(ReactiveService.class)
public class IntegrationTest {

	@MockBean
	StockRepository stockRepository;
	
	@MockBean
	TradeRepository tradeRepository;
	
	@Autowired
	private WebTestClient testClient;
	
	@Test
	void testGetStock() {
		Mockito.when(stockRepository.findByCode(Mockito.anyString())).thenReturn(TestUtil.getStockObject());
		
		testClient.get().uri("/api/stock/{code}", "RIL")
			.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON.toString())
			.exchange()
            .expectStatus().isOk()
            .expectBodyList(Stock.class);
		
		Mockito.verify(stockRepository, Mockito.times(1)).findByCode(Mockito.anyString());
	}
	
	@Test
	void testGetAllStock() {
		Mockito.when(stockRepository.findAll()).thenReturn(TestUtil.getStockObjects());
		
		testClient.get().uri("/api/stocks")
			.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON.toString())
			.exchange()
            .expectStatus().isOk()
            .expectBodyList(Stock.class);
		
		Mockito.verify(stockRepository, Mockito.times(1)).findAll();
	}
	
	@Test
	void testAddStock() {
		Stock stock = TestUtil.getStockObject();
		Mockito.when(stockRepository.save(stock)).thenReturn(stock);
		
		testClient.post().uri("/api/stock")
			.contentType(MediaType.APPLICATION_JSON)
			.body(BodyInserters.fromValue(stock))
			.exchange()
            .expectStatus().isCreated();
		
		Mockito.verify(stockRepository, Mockito.times(1)).save(stock);
	}
	
	@Test
	void testGetTrade() {
		Mockito.when(tradeRepository.findByCode(Mockito.anyString())).thenReturn(TestUtil.getTradeObjects());
		
		testClient.get().uri("/api/trade/{code}", "RIL")
			.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON.toString())
			.exchange()
            .expectStatus().isOk()
            .expectBodyList(Trade.class);
		
		Mockito.verify(tradeRepository, Mockito.times(1)).findByCode(Mockito.anyString());
	}
	
	@Test
	void testGetAllTrade() {
		Mockito.when(tradeRepository.findAll()).thenReturn(TestUtil.getTradeObjects());
		
		testClient.get().uri("/api/trades")
			.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON.toString())
			.exchange()
            .expectStatus().isOk()
            .expectBodyList(Trade.class);
		
		Mockito.verify(tradeRepository, Mockito.times(1)).findAll();
	}
	
	@Test
	void testAddTrade() {
		Trade trade = TestUtil.getTradeObject();
		Mockito.when(tradeRepository.save(trade)).thenReturn(trade);
		
		testClient.post().uri("/api/trade")
			.contentType(MediaType.APPLICATION_JSON)
			.body(BodyInserters.fromValue(trade))
			.exchange()
            .expectStatus().isCreated();
		
		Mockito.verify(tradeRepository, Mockito.times(1)).save(trade);
	}
}
