package com.cognizant.ormlearn.repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Stock;

@Repository // optional
public interface StockRepository extends JpaRepository<Stock, String> {

	List<Stock> findByCodeAndDateBetween(String code, Date dateStart, Date dateEnd);

	List<Stock> findByCodeAndCloseGreaterThan(String code, BigDecimal close);

	List<Stock> findTop3ByOrderByVolumeAsc();

	List<Stock> findTop6ByCodeOrderByCloseAsc(String code);
}
