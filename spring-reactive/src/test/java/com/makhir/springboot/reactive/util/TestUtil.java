package com.makhir.springboot.reactive.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.makhir.springboot.reactive.entity.Stock;
import com.makhir.springboot.reactive.entity.Trade;

public class TestUtil {

	public static Trade getTradeObject() {
		Trade trade = new Trade();
		trade.setId(100000l);
		trade.setCode("RIL");
		trade.setTradeAmount(new BigDecimal(1500));
		trade.setTradeTime(new Timestamp(System.currentTimeMillis()));
		trade.setQuantity(10000l);
		return trade;
	}

	public static Stock getStockObject() {
		Stock stc = new Stock();
		stc.setId(100000l);
		stc.setCode("RIL");
		stc.setPrice(new BigDecimal(1500));
		stc.setDescription("Reliance stock");
		stc.setQuantity(15000l);
		return stc;
	}

	public static List<Trade> getTradeObjects() {
		Trade trade = new Trade();
		trade.setId(100000l);
		trade.setCode("INFY");
		trade.setTradeAmount(new BigDecimal(1500));
		trade.setTradeTime(new Timestamp(System.currentTimeMillis()));
		trade.setQuantity(10000l);

		List<Trade> trades = new ArrayList<Trade>();
		trades.add(trade);
		trades.add(getTradeObject());
		return trades;
	}

	public static List<Stock> getStockObjects() {
		Stock stc = new Stock();
		stc.setId(100000l);
		stc.setCode("RIL");
		stc.setPrice(new BigDecimal(1500));
		stc.setDescription("Reliance stock");
		stc.setQuantity(15000l);

		List<Stock> stocks = new ArrayList<Stock>();
		stocks.add(stc);
		stocks.add(getStockObject());

		return stocks;
	}
}
