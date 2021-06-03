package com.cognizant.truyum;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@SpringBootApplication
public class TruyumApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);

	private static MenuItemService menuItemService;

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(TruyumApplication.class, args);

		menuItemService = context.getBean(MenuItemService.class);

		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testGetMenuById();
		testModifyMenuActive();
	}

	private static void testGetMenuItemListAdmin() {
		LOGGER.info("---------- Start Get Menu List Admin ----------");

		List<MenuItem> menuItemList = menuItemService.getMenuItemListAdmin();

		LOGGER.info("Admin Menu List: ");

		for (MenuItem menuItem : menuItemList) {
			LOGGER.debug("   {}", menuItem);
		}

		LOGGER.info("---------- End Get Menu List Admin ----------");
	}

	private static void testGetMenuItemListCustomer() {
		LOGGER.info("---------- Start Get Menu List Customer ----------");

		List<MenuItem> menuItemList = menuItemService.getMenuItemListCustomer();

		LOGGER.info("Customer Menu List:");

		for (MenuItem menuItem : menuItemList) {
			LOGGER.debug("   {}", menuItem);
		}

		LOGGER.info("---------- End Get Menu List Customer ----------");
	}

	private static void testGetMenuById() {
		LOGGER.info("---------- Start Get Menu By Id ----------");

		MenuItem menuItem = null;
		try {
			menuItem = menuItemService.getMenuItem(1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		LOGGER.debug("Menu Item: {}", menuItem);

		LOGGER.info("---------- End Get Menu By Id ----------");
	}

	private static void testModifyMenuActive() {
		LOGGER.info("---------- Start Modify Menu ----------");

		MenuItem menuItem = null;

		try {
			menuItem = menuItemService.getMenuItem(4);

			LOGGER.debug("Menu Item before update : {}", menuItem);

			menuItem = menuItemService.modifyMenuItem(4, "YES");

			LOGGER.debug("Menu Item after update : {}", menuItem);
		} catch (Exception e) {
			e.printStackTrace();
		}

		LOGGER.info("---------- End Modify Menu ----------");
	}
}
