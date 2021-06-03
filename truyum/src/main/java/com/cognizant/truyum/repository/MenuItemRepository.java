package com.cognizant.truyum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.model.MenuItem;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {

	@Query(value = "SELECT mi FROM MenuItem mi WHERE mi.date_of_launch <= NOW() AND mi.active LIKE 'YES'")
	List<MenuItem> getMenuItemListCustomer();
}
