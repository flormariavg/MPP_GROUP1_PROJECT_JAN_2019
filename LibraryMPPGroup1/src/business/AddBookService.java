package business;

import java.util.HashMap;

import dataaccess.BookDAO;
import model.Book;

public class AddBookService {

	public boolean addBookListToDatabase (HashMap<String, Book> bookList) {

		return BookDAO.addListBookToDatabase(bookList);
	}



}
