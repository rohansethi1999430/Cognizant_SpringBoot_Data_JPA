package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

@SpringBootApplication
public class Handson1OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(Handson1OrmLearnApplication.class);

	private static void testGetAllCountries(CountryService countryService) {

		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		countries.forEach(c -> LOGGER.info(c.getCode() + " - " + c.getName()));
		// LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Handson1OrmLearnApplication.class, args);

		CountryService countryService = context.getBean(CountryService.class);

		testGetAllCountries(countryService);
	}
}
