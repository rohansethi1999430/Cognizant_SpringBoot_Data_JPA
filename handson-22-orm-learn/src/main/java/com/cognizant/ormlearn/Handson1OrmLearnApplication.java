package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.service.StockService;

@SpringBootApplication
public class Handson1OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(Handson1OrmLearnApplication.class);

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Handson1OrmLearnApplication.class, args);

		LOGGER.info("$$$---------------------- Inside Main ---------------------------------$$$");

		StockService stockService = context.getBean(StockService.class);

//		LOGGER.info("----Start ----------getByCodeAndDate()----");
//		List<Stock> stock = stockService.getByCodeAndDate();
//		stock.forEach(s -> LOGGER.debug(s.toString()));
//		LOGGER.info("----End--------------------getByCodeAndDate()----");

//		LOGGER.info("----Start-------------getByCodeAndStockPrice()--");
//		List<Stock> stock2 = stockService.getByCodeAndStockPrice();
//		stock2.forEach(s -> LOGGER.info("{} - {}-{}-{}",s.getCode(),s.getDate(),s.getVolume(),s.getClose()));
//		LOGGER.info("----End--------getByCodeAndStockPrice()---");

//		LOGGER.info("----Start--------------getTop3ByVolume()---------");
//		List<Stock> stock3 = stockService.getTop3ByVolume();
//		stock3.forEach(s -> LOGGER.debug(s.toString()));
//		LOGGER.info("----End----------------getTop3ByVolume()-------------");

		LOGGER.info("----Start-----------getTop3ByCode()---");
		List<Stock> stock4 = stockService.getTop3ByCode();
		stock4.forEach(s -> LOGGER.debug(s.toString()));
		LOGGER.info("----End-----------getTop3ByCode()----------------");
	}
}
