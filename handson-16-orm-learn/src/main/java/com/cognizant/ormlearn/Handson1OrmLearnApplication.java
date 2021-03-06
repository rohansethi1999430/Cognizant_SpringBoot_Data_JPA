package com.cognizant.ormlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class Handson1OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(Handson1OrmLearnApplication.class);

	/*
	 * private static void testGetAllCountries(CountryService countryService) {
	 * 
	 * LOGGER.info("Start"); List<Country> countries =
	 * countryService.getAllCountries(); LOGGER.debug("countries={}", countries);
	 * LOGGER.info("End"); }
	 */

	private static void testGetAllCountries(CountryService countryService) {

		LOGGER.info("Start");
		Country country = null;
		try {
			country = countryService.findCountryByCode("TX");
			LOGGER.debug("Country:{}", country);
		} catch (CountryNotFoundException e) {
			LOGGER.error(e.getMessage());
		}
		LOGGER.info("End");
	}

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Handson1OrmLearnApplication.class, args);

		CountryService countryService = context.getBean(CountryService.class);

		testGetAllCountries(countryService);
	}
}
