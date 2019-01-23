package model;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckoutEntry implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = -7107940604611490743L;
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

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("|	Checkout Date	|	DueDate		|	BookCopy	|	status	|");
		str.append("|	" + getCheckoutDate() +"	|	" + getDueDate()	+	"	|	" + getBookCopy().getCopyNumber() + " 	|	" + getStatus() + "	|");

		return str.toString();
	}

}
