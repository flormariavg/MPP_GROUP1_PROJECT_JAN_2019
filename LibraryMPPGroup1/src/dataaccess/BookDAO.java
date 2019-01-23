package dataaccess;

import java.util.HashMap;
import java.util.List;

import model.Book;
import util.WriteReadFileUtil;

public class BookDAO extends GenericDAO<Book> {

	public static final String OUTPUT_DIR = System.getProperty("user.dir") + "\\src\\database\\book.txt";

	public static boolean addListBookToDatabase(HashMap<String, Book> bookList) {

		return WriteReadFileUtil.writeDataObject(OUTPUT_DIR, bookList);

	}

	@Override
	public Class getClazz() {
		// TODO Auto-generated method stub
		return Book.class;
	}

	public Book findByISBN(String isbn) {
		List<Book> books = findAll();
		for (Book b : books) {
			if (b.getISBNNumber().equals(isbn)) {
				return b;
			}
		}
		return null;
	}

	public boolean createBookCopies(Book book, int numberOfCopies) {
		int actualNumberOfCopies = 0;
		if (book.getBooks() != null) {
			actualNumberOfCopies = book.getBooks().size();
		}
		System.out.println("Numero :" + actualNumberOfCopies);
		for (int i = 0; i < numberOfCopies; i++) {
			actualNumberOfCopies++;
			book.addBook(actualNumberOfCopies);
		}
		return true;
	}

}
