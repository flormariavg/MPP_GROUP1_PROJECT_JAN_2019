package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4656978044891832694L;
	public String id;
	private String title;
	private String ISBNNumber;
	private String authorList;
	private String availability;
	private List<BookCopy> bookCopies;

	public Book(String id, String title, String iSBNNumber, String authorList, String availability) {
		this.title = title;
		ISBNNumber = iSBNNumber;
		this.authorList = authorList;
		this.availability = availability;
		this.id=id;
		this.bookCopies = new ArrayList<>();
	}

	public void addBook(int copyNumber) {
		BookCopy bookCopy= new BookCopy(copyNumber);
		bookCopies.add(bookCopy);
		}
	
	public String getTitle() {
		return title;
	}

	public String getISBNNumber() {
		return ISBNNumber;
	}

	public String getAuthorList() {
		return authorList;
	}

	public String getAvailability() {
		return availability;
	}

	public List<BookCopy> getBooks() {
		return bookCopies;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", ISBNNumber=" + ISBNNumber + ", authorList=" + authorList
				+ ", availability=" + availability + ", bookCopies=" + bookCopies + "]";
	}

}
