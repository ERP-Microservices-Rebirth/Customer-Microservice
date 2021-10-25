package tn.esprit.erp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "customer")
public class Customer {

	@Id
	private String id;

	@Field(value = "first_name")
	private String firstName;

	@Field(value = "last_name")
	private String lastName;

	private String email;
	
	private String secteur;

	public Customer() {

	}

	public Customer(String firstName, String lastName, String email, String secteur) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.secteur = secteur;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSecteur() {
		return secteur;
	}

	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", secteur=" + secteur + "]";
	}
}