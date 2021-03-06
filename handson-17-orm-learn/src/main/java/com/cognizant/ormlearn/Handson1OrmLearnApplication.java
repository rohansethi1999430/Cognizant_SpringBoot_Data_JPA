package com.cognizant.ormlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class Handson1OrmLearnApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(Handson1OrmLearnApplication.class);

	@Autowired
	private CountryService countryService;
	/*
	 * private static void testGetAllCountries(CountryService countryService) {
	 * 
	 * LOGGER.info("Start"); List<Country> countries =
	 * countryService.getAllCountries(); LOGGER.debug("countries={}", countries);
	 * LOGGER.info("End"); }
	 */

	private void testGetAllCountries() {

		LOGGER.info("Start");
		Country country = null;
		try {
			country = countryService.findCountryByCode("IN");
			LOGGER.debug("Country:{}", country);
		} catch (CountryNotFoundException e) {
			LOGGER.error(e.getMessage());
		}
		LOGGER.info("End");
	}

	private void testAddCountry() {

		LOGGER.info("Start");
		Country country = new Country("TY", "Transylvania"); //
		countryService.addCountry(country);
		// LOGGER.info("Country details added!");
		LOGGER.info("End");
	}

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Handson1OrmLearnApplication.class, args);

		// CountryService countryService = context.getBean(CountryService.class);

		// testAddCountry(countryService);
		// testGetAllCountries(countryService);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// testGetAllCountries();
		testAddCountry();
	}
}
