package model;

import java.time.LocalDate;

public class CheckoutEntry {
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private String status;
	private BookCopy bookCopy;

	public CheckoutEntry(LocalDate checkoutDate, LocalDate dueDate, String status, BookCopy bookCopy) {
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
		this.status = status;
		this.bookCopy = bookCopy;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public String getStatus() {
		return status;
	}

	public BookCopy getBookCopy() {
		return bookCopy;
	}

}
