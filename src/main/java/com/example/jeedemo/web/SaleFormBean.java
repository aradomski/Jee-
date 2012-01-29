package com.example.jeedemo.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Item;
import com.example.jeedemo.domain.Person;
import com.example.jeedemo.service.PersonManager;
import com.example.jeedemo.service.SellingManager;

@SessionScoped
@Named("saleBean")
public class SaleFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private SellingManager sm;

	@Inject
	private PersonManager pm;

	private Long itemId;
	private Long personId;
	private int quantity;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<Item> getAvailableItems() {
		return sm.getAvailableItems();
	}

	public List<Person> getAllPersons() {
		return pm.getAllPersons();
	}

	public String sellItem() {
		sm.sellItem(personId, itemId, quantity);
		return "item sold";
	}
}
