package model;

import java.io.Serializable;

public class BookCopy implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5709847709503180469L;
	
	public String id;
	
	private int copyNumber;
	
	private String isbn;
	
	//private Book book;
	
	private boolean availability;

	public BookCopy(int copyNumber, boolean availability) {
		this.copyNumber = copyNumber;
		this.availability=availability;
	}

	public int getCopyNumber() {
		return copyNumber;
	}

//	public Book getBook() {
//		return book;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getId() {
		return id;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}