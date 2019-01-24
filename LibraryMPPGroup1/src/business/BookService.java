package business;

import java.util.List;

import dataaccess.BookDAO;
import model.Book;

public class BookService {

	BookDAO bookDAO = new BookDAO();

	public boolean createBook(Book book) {
		return bookDAO.create(book);
	}

	public List<Book> getBookList() {
		return (List<Book>) bookDAO.findAll();
	}



}
