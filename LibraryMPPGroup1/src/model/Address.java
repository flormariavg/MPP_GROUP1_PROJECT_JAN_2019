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

	public Address(String street, String postalCode, String city) {
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
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
