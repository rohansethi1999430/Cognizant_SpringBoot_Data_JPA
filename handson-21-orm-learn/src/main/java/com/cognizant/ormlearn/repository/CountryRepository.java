package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

@Repository // optional
public interface CountryRepository extends JpaRepository<Country, String> {

	// @Query(value = "select c from com.cognizant.ormlearn.model.Country c where
	// c.name like %:check% order by c.name")
	public List<Country> findByNameContaining(@Param("check") String s);

	@Query(value = "select c from com.cognizant.ormlearn.model.Country c where c.name like :check% order by c.name")
	public List<Country> findByNameStarting(@Param("check") String s);
}
