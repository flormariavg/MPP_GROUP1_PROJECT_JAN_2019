package model;

import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Author extends Person implements Serializable {
	private String credentials;
	private String aShortBio;

	public Author(){

	}
	public Author(String id, String firstName, String lastName, String phoneNumber, Address address, String credentials, String aShortBio) {
		super(id, firstName, lastName, phoneNumber, address);
		this.credentials = credentials;
		this.aShortBio = aShortBio;
	}

	public String getCredentials() {
		return credentials;
	}

	public String getaShortBio() {
		return aShortBio;
	}

	public StringProperty getFirstNameProperty() {
		return new SimpleStringProperty(getFirstName());
	}

	public StringProperty getLastNameProperty() {
		return new SimpleStringProperty(getLastName());
	}

	public StringProperty getPhoneNumberProperty() {
		return new SimpleStringProperty(getPhoneNumber());
	}

	public StringProperty getAddressProperty() {
		Address address = getAddress();
		String result = address.getStreet() + ", " + address.getCity() + ", " + address.getPostalCode() + ", " + address.getState();
		return new SimpleStringProperty(result);
	}

	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}
	public void setaShortBio(String aShortBio) {
		this.aShortBio = aShortBio;
	}

}
