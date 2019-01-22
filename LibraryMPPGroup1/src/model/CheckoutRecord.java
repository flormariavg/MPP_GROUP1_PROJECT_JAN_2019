package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord {
	
	private List<CheckoutEntry> checkoutEntries;

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

	
}
