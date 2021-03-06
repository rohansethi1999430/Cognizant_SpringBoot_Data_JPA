package com.cognizant.ormlearn;

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

	/*
	 * private static void testGetAllCountries(CountryService countryService) {
	 * 
	 * LOGGER.info("Start"); List<Country> countries =
	 * countryService.getAllCountries(); LOGGER.debug("countries={}", countries);
	 * LOGGER.info("End"); }
	 */

	/*
	 * private static void testGetAllCountries(CountryService countryService) {
	 * 
	 * LOGGER.info("Start"); Country country = null; try { country =
	 * countryService.findCountryByCode("TY"); LOGGER.debug("Country:{}", country);
	 * LOGGER.info("End"); } catch (CountryNotFoundException e) {
	 * LOGGER.error(e.getMessage()); } }
	 */

	private static void updateCountry(CountryService countryService) {

		LOGGER.info("Start");
		Country country = new Country("TY", "Tyrant");
		countryService.updateCountry(country);
		LOGGER.info("Country details updated!");
		LOGGER.info("End");
	}

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Handson1OrmLearnApplication.class, args);

		CountryService countryService = context.getBean(CountryService.class);

		updateCountry(countryService);
	}
}
