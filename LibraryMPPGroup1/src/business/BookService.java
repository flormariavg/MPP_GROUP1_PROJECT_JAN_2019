package business;

import dataaccess.BookDAO;
import model.Book;

public class BookService {
	
	BookDAO bookDAO = new BookDAO();
	
	public boolean createBook(Book book) {
		return bookDAO.create(book);
	}
	
	public static void main(String[] args) {
		//		System.out.println(bookDAO.findById("ABCD", Book.class));
		
		BookService service = new BookService();
		Book book = new Book("123","abc", "abc", "abc", "abc");
		System.out.println(service.createBook(book));
	}

}
