package com.cognizant.truyum.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.MenuItemRepository;

@Service
public class MenuItemService {

	@Autowired
	private MenuItemRepository menuItemRepository;

	@Transactional
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemRepository.findAll();
	}

	@Transactional
	public List<MenuItem> getMenuItemListCustomer() {
		return menuItemRepository.getMenuItemListCustomer();
	}

	@Transactional
	public MenuItem getMenuItem(int id) throws Exception {
		Optional<MenuItem> result = menuItemRepository.findById(id);

		if (!result.isPresent()) {
			throw new Exception("Menu Item not found");
		}

		return result.get();
	}

	@Transactional
	public MenuItem modifyMenuItem(int id, String isActive) throws Exception {
		MenuItem menuItem = getMenuItem(id);

		menuItem.setActive(isActive);

		menuItemRepository.save(menuItem);

		return menuItem;
	}
}
