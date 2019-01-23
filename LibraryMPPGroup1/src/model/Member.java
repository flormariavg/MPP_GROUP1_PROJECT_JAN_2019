package model;

import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Member extends Person implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String memberNumber;

	public Member() {
		// TODO Auto-generated constructor stub

	}

	public Member(String id, String firstName, String lastName, String phoneNumber, Address address, String memberNumber) {
		super(id, firstName, lastName, phoneNumber, address);
		// TODO Auto-generated constructor stub
		this.memberNumber = memberNumber;
	}

	public String getMemberNumber() {
		return memberNumber;
	}

	public StringProperty firstNameProperty() {
		return new SimpleStringProperty(getFirstName());
	}

	public StringProperty lastNameProperty() {
		return new SimpleStringProperty(getLastName());
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", memberNumber=" + memberNumber + "]"+super.toString();
	}






}
