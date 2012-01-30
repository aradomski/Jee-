package com.example.jeedemo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({ @NamedQuery(name = "person.all", query = "Select p from Person p") })
@Table(name = "person")
public class Person {

	private Long id;

	private String firstName = "unknown";
	private String pin = "";
	private Date registrationDate = new Date();

	private List<Item> items = new ArrayList<Item>();

	private Set<PersonItem> personItems = new HashSet<PersonItem>(0);

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "person_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Size(min = 2, max = 20)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Size(min = 2)
	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Temporal(TemporalType.DATE)
	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	// Be careful here, both with lazy and eager fetch type
	// @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.person")
	// @OneToMany(fetch = FetchType.LAZY)
	public Set<PersonItem> getPersonItems() {
		return personItems;
	}

	public void setPersonItems(Set<PersonItem> personItems) {
		this.personItems = personItems;
	}

	public String toString() {
		return "firstName = " +  firstName + "  pin = " + pin + " id = " + id + " registrationDate = " + registrationDate;
	}
}
