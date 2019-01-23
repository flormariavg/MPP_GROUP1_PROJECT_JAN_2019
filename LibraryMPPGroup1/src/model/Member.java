package model;

public class Member extends Person {


	
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

	@Override
	public String toString() {
		return "Member [id=" + id + ", memberNumber=" + memberNumber + "]"+super.toString();
	}

	
	
	
	

}
