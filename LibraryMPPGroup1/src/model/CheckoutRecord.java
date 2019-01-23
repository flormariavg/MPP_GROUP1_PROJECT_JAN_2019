package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -8584613369863546430L;
	private List<CheckoutEntry> checkoutEntries;
	private String id;
	private Member member;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public void setCheckoutEntries(List<CheckoutEntry> checkoutEntries) {
		this.checkoutEntries = checkoutEntries;
	}

	public CheckoutRecord() {
		this.checkoutEntries = new ArrayList<>();
	}

	public void addCheckOutEntry(LocalDate checkoutDate, LocalDate dueDate, String status, BookCopy bookCopy) {
		CheckoutEntry checkoutEntry= new CheckoutEntry(checkoutDate, dueDate, status, bookCopy);
		checkoutEntries.add(checkoutEntry);

	}

	public List<CheckoutEntry> getCheckoutEntries() {
		return checkoutEntries;
	}

	@Override
	public String toString() {

		return "CheckoutID = " +  getId();
	}

}
