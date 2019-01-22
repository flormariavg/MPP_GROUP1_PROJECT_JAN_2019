package model;

public class Member extends Person {

	private String memberNumber;

	public Member(String firstName, String lastName, String phoneNumber, Address address, String memberNumber) {
		super(firstName, lastName, phoneNumber, address);
		// TODO Auto-generated constructor stub
		this.memberNumber = memberNumber;
	}

	public String getMemberNumber() {
		return memberNumber;
	}

}
