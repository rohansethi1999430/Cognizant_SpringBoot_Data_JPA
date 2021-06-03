package com.cognizant.ormlearn.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	CountryRepository countryRepo;

	/*
	 * @Transactional public List<Country> getAllCountries() {
	 * 
	 * return countryRepo.findAll(); }
	 */

	/*
	 * @Transactional public Country findCountryByCode(String countryCode) throws
	 * CountryNotFoundException {
	 * 
	 * Optional<Country> result = countryRepo.findById(countryCode);
	 * 
	 * if (!result.isPresent()) { throw new
	 * CountryNotFoundException("Country code not found!"); }
	 * 
	 * return result.get(); }
	 */

	@Transactional
	public void updateCountry(Country country) {

		countryRepo.save(country);
	}
}
