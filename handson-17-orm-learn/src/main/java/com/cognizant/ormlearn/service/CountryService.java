package com.cognizant.ormlearn.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

	@Autowired
	CountryRepository countryRepo;

	/*
	 * @Transactional public List<Country> getAllCountries() {
	 * 
	 * return countryRepo.findAll(); }
	 */

	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException {

		Optional<Country> result = countryRepo.findById(countryCode);

		if (!result.isPresent()) {
			throw new CountryNotFoundException("Country code not found!");
		}

		return result.get();
	}

	@Transactional
	public void addCountry(Country country) {

		LOGGER.info(countryRepo.existsById(country.getCode()) + " ");
		if (!countryRepo.existsById(country.getCode())) {
			countryRepo.save(country);
		} else {
			// System.out.println("Country code already exists!");
			LOGGER.info("Country code already exists!");
		}

	}
}
