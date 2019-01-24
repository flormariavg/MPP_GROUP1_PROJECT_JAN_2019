package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Book implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = -4656978044891832694L;
	public String id;
	private String title;
	private String ISBNNumber;
	private List<Author> authorList;
	private String availability;
	private List<BookCopy> bookCopies;
	private int maximumCheckOutLength;

	public int getMaximumCheckOutLength() {
		return maximumCheckOutLength;
	}

	public void setMaximumCheckOutLength(int maximumCheckOutLength) {
		this.maximumCheckOutLength = maximumCheckOutLength;
	}

	public Book(String title, String iSBNNumber, List<Author>  authorList, String availability, int maxCheckoutLength) {
		this.title = title;
		this.ISBNNumber = iSBNNumber;
		this.id = iSBNNumber;
		this.authorList = authorList;
		this.availability = availability;
		this.bookCopies = new ArrayList<>();
		this.maximumCheckOutLength = maxCheckoutLength;
	}

	public void addBook(int copyNumber) {
		BookCopy bookCopy= new BookCopy(copyNumber, true);
		bookCopies.add(bookCopy);
		}

	public String getTitle() {
		return title;
	}

	public String getISBNNumber() {
		return ISBNNumber;
	}

	public List<Author> getAuthorList() {
		return authorList;
	}

	public String getAvailability() {
		return availability;
	}

	public List<BookCopy> getBooks() {
		return bookCopies;
	}
	public StringProperty getISBNNumberProperty() {
		return new SimpleStringProperty(getISBNNumber());
	}

	public StringProperty getTitleProperty() {
		return new SimpleStringProperty(getTitle());
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", ISBNNumber=" + ISBNNumber + ", authorList=" + authorList
				+ ", availability=" + availability + ", bookCopies=" + bookCopies + "]";
	}

}
