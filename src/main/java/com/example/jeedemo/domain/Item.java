package com.example.jeedemo.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "item.unsold", query = "Select c from Item c where c.sold = false")
@Table(name = "item")
public class Item {

	private Long id;
	private String name;
	private String description;
	private double price;
	private int quantity;
	private Boolean sold = false;

	private Set<PersonItem> stockCategories = new HashSet<PersonItem>(0);

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Boolean getSold() {
		return sold;
	}

	public void setSold(Boolean sold) {
		this.sold = sold;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "pk.item")
	// @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	public Set<PersonItem> getStockCategories() {
		return stockCategories;
	}

	public void setStockCategories(Set<PersonItem> stockCategories) {
		this.stockCategories = stockCategories;
	}

	public String toString() {
		return "name = "+ name + " description = " + description + " price = " + price + " quantity = " + quantity + " sold = "
				+ sold;
	}
}
