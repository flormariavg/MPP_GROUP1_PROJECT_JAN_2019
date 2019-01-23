package business;

import dataaccess.BookDAO;
import model.Book;

public class AddBookCopyService {

	BookDAO bookDAO;

	public AddBookCopyService() {
		this.bookDAO = new BookDAO();
	}

	public Book searchBook(String isbn) {
		return this.bookDAO.findByISBN(isbn);
	}

	public boolean addBookCopies(Book book, int numberOfCopies){
		return this.bookDAO.createBookCopies(book, numberOfCopies);
	}

	public static void main(String[] args) {
		AddBookCopyService service = new AddBookCopyService();

		service.bookDAO.create(new Book("123", "123", null, "123", 21));
	}

}
