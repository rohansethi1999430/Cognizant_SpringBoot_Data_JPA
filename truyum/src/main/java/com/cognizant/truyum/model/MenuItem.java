package com.cognizant.truyum.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu_item")
public class MenuItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "me_id")
	private int id;

	@Column(name = "me_name")
	private String name;

	@Column(name = "me_price", columnDefinition = "DECIMAL(8,2)")
	private double price;

	@Column(name = "me_active")
	private String active;

	@Column(name = "me_date_of_launch")
	private Date date_of_launch;

	@Column(name = "me_category")
	private String category;

	@Column(name = "me_free_delivery")
	private String free_delivery;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Date getDate_of_launch() {
		return date_of_launch;
	}

	public void setDate_of_launch(Date date_of_launch) {
		this.date_of_launch = date_of_launch;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getFree_delivery() {
		return free_delivery;
	}

	public void setFree_delivery(String free_delivery) {
		this.free_delivery = free_delivery;
	}

	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + ", price=" + price + ", active=" + active + ", date_of_launch="
				+ date_of_launch + ", category=" + category + ", free_delivery=" + free_delivery + "]";
	}
}
