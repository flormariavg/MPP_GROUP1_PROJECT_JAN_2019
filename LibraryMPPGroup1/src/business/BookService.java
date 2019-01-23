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
		Book book = new Book("abc", "abc", "abc", "abc");
		book.id = "12345";
		System.out.println(service.createBook(book));
	}

}
