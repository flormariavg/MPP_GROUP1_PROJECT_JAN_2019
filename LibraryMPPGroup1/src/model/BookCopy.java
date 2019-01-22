package model;

public class BookCopy {
	private String copyNumber;
	private Book book;

	public BookCopy(String copyNumber) {
		this.copyNumber = copyNumber;
	}

	public String getCopyNumber() {
		return copyNumber;
	}

	public Book getBook() {
		return book;
	}

}
