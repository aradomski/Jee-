package com.example.jeedemo.domain;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "PERSON_ITEM")
@AssociationOverrides({
		@AssociationOverride(name = "pk.person", joinColumns = @JoinColumn(name = "person_id")),
		@AssociationOverride(name = "pk.item", joinColumns = @JoinColumn(name = "item_id")) })
// referencedColumnName = "COMPANY_ID", insertable = false, updatable = false
public class PersonItem {

	private PersonItemId pk = new PersonItemId();
	private int quantity;

	@EmbeddedId
	public PersonItemId getPk() {
		return pk;
	}

	public void setPk(PersonItemId pk) {
		this.pk = pk;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Transient
	public Person getPerson() {
		return getPk().getPerson();
	}

	public void setPerson(Person person) {
		getPk().setPerson(person);
	}

	@Transient
	public Item getItem() {
		return getPk().getItem();
	}

	public void setItem(Item item) {
		getPk().setItem(item);
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		PersonItem that = (PersonItem) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}

	public String toString() {
		return "quantity = " + quantity + pk.toString();
	}
}
