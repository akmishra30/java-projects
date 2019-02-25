package com.makhir.camel.postgres.processor;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataProcessor implements Processor{
	final static Logger logger = LoggerFactory.getLogger(DataProcessor.class);
	private final static int MAX_RANGE = 999999;
	private final static int MIN_RANGE = 1000;

	public void process(Exchange exchange) throws Exception {
		Map<String, Object> rowData = new HashMap<String, Object>();
		int ranNo = generateRandomNo();
		rowData.put("id", ranNo);
		rowData.put("name", "name-" + ranNo);
		rowData.put("city", "city-" + ranNo);
		rowData.put("address", "address-" + ranNo);
		rowData.put("contact", "8888" + ranNo);
		logger.info("## Generated Row : {}", rowData.toString());
		exchange.getMessage().setBody(rowData);
	}
	
	private int generateRandomNo(){
		 int range = (MAX_RANGE - MIN_RANGE) + 1;     
		 return (int)(Math.random() * range) + MIN_RANGE;
	}
}
