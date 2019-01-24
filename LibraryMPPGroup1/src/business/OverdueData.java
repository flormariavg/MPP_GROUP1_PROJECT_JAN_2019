package business;

public class OverdueData {
	
	private String isbn;
	private String bookTitle;
	private String copyNumber;
	private String member;
	private String duedate;
	public OverdueData(String isbn, String bookTitle, String copyNumber, String member, String duedate) {
		super();
		this.isbn = isbn;
		this.bookTitle = bookTitle;
		this.copyNumber = copyNumber;
		this.member = member;
		this.duedate = duedate;
	}
	public String getIsbn() {
		return isbn;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public String getCopyNumber() {
		return copyNumber;
	}
	public String getMember() {
		return member;
	}
	public String getDuedate() {
		return duedate;
	}

	
}
