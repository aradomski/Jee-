package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Item;
import com.example.jeedemo.domain.Person;

/* 
 * This is a Stateless EJB Bean
 * All its methods are transactional
 */
@Stateless
public class SellingManager {

	@PersistenceContext
	EntityManager em;

	public void sellItem(Long personId, Long itemId, int quantity) {

		Person person = em.find(Person.class, personId);
		Item item = em.find(Item.class, itemId);
		if (item.getQuantity() > quantity) {
			item.setQuantity(item.getQuantity() - quantity);
		} else {
			item.setSold(true);
		}
		person.getItems().add(item);
	}

	@SuppressWarnings("unchecked")
	public List<Item> getAvailableItems() {
		return em.createNamedQuery("item.unsold").getResultList();
	}

	public void disposeItem(Person person, Item item) {

		person = em.find(Person.class, person.getId());
		item = em.find(Item.class, item.getId());

		Item toRemove = null;
		// lazy loading here (person.getItems)
		for (Item aItem : person.getItems())
			if (aItem.getId().compareTo(item.getId()) == 0) {
				toRemove = aItem;
				break;
			}

		if (toRemove != null)
			person.getItems().remove(toRemove);

		item.setSold(false);
	}
}
