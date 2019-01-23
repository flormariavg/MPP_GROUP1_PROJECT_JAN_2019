package model;

import java.io.Serializable;

public class Address implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public String id;
	private String street;
	private String postalCode;
	private String city;
	private String state;

	public Address(String street, String postalCode, String city, String state) {
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public String getStreet() {
		return street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getCity() {
		return city;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", postalCode=" + postalCode + ", city=" + city + "]";
	}


}
