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

	public static void main(String[] args) {
		//		System.out.println(bookDAO.findById("ABCD", Book.class));

		BookService service = new BookService();
		Book book = new Book("title1","1234", null, "abc");
		System.out.println(service.createBook(book));
	}

}
