package com.example.jeedemo.domain;

import java.util.ArrayList;
import java.util.List;

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

	private List<PersonItem> personItems = new ArrayList<PersonItem>();

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
	public List<PersonItem> getPersonItems() {
		return personItems;
	}

	public void setPersonItems(List<PersonItem> personItems) {
		this.personItems = personItems;
	}

	public String toString() {
		return "name = " + name + " description = " + description + " price = "
				+ price + " quantity = " + quantity + " sold = " + sold;
	}

}
