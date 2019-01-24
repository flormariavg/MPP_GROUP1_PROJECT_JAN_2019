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

}
