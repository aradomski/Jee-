package com.example.jeedemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Item;
import com.example.jeedemo.domain.Person;
import com.example.jeedemo.web.Logging;

@Stateless
public class PersonManager {

	@PersistenceContext
	EntityManager em;
	Logger logger = new Logging().getLogger();

	public void addPerson(Person person) {
		person.setId(null);
		em.persist(person);
	}

	public void deletePerson(Person person) {
		person = em.find(Person.class, person.getId());
		em.remove(person);
	}

	@SuppressWarnings("unchecked")
	public List<Person> getAllPersons() {
		return em.createNamedQuery("person.all").getResultList();
	}

	public List<Item> getOwnedItems(Person person) {
		person = em.find(Person.class, person.getId());
		// lazy loading here - try this code without this (shallow) copying
		List<Item> items = new ArrayList<Item>(person.getItems());
		for (Item item : items) {
			logger.info(item.toString());
		}
		return items;
	}

}
