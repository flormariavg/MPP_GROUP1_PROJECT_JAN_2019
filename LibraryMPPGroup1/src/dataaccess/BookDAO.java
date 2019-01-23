package dataaccess;


import java.util.HashMap;

import model.Book;
import util.WriteReadFileUtil;

public class BookDAO {

	public static final String OUTPUT_DIR = System.getProperty("user.dir")
			+ "\\src\\database\\book.txt";

	public static boolean addListBookToDatabase (HashMap<String, Book> bookList) {

			return WriteReadFileUtil.writeDataObject(OUTPUT_DIR, bookList);

		}


}
