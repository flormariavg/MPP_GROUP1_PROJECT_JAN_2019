package model;

public class Author extends Person {
	private String credentials;
	private String aShortBio;
	
	public Author(String firstName, String lastName, String phoneNumber, Address address, String credentials, String aShortBio) {
		super(firstName, lastName, phoneNumber, address);
		// TODO Auto-generated constructor stub
	}

	public String getCredentials() {
		return credentials;
	}

	public String getaShortBio() {
		return aShortBio;
	}
	

}
