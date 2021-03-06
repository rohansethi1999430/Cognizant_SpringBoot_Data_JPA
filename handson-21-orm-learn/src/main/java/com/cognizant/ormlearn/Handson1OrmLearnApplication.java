package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;

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

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Handson1OrmLearnApplication.class, args);

		LOGGER.info("$$$ Inside Main $$$");

		CountryRepository countryRepo = context.getBean(CountryRepository.class);

		LOGGER.info("----Start----");
		List<Country> country = countryRepo.findByNameContaining("ou");
		country.forEach(c -> LOGGER.debug(c.toString()));
		LOGGER.info("----End----");

		LOGGER.info("----Start----");
		List<Country> country2 = countryRepo.findByNameContaining("Z");
		country2.forEach(c -> LOGGER.debug(c.toString()));
		LOGGER.info("----End----");
	}
}
