package com.example.jeedemo.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class PersonItemId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Person person;
	private Item item;

	@ManyToOne
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@ManyToOne
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		PersonItemId that = (PersonItemId) o;

		if (person != null ? !person.equals(that.person) : that.person != null)
			return false;
		if (item != null ? !item.equals(that.item) : that.item != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result;
		result = (person != null ? person.hashCode() : 0);
		result = 31 * result + (item != null ? item.hashCode() : 0);
		return result;
	}

	public String toString() {
		return "person = " + person.toString() + "\n" + " item ="
				+ item.toString();
	}
}
