package model;

import java.io.Serializable;

public class BookCopy implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5709847709503180469L;
	
	public String id;
	
	private int copyNumber;
	
	private Book book;

	public BookCopy(int copyNumber) {
		this.copyNumber = copyNumber;
	}

	public int getCopyNumber() {
		return copyNumber;
	}

	public Book getBook() {
		return book;
	}

}