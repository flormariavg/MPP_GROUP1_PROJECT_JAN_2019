package ui;

import java.util.HashMap;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Book;

public class BookController {

	@FXML
	private TextField txtNumber;
	@FXML
	private TextField txtTitle;
	@FXML
	private TextField txtMaximumCheckoutLenght;
	@FXML
	private TextField txtNumberOfCopy;
	@FXML
	private TableView<String> tableView;

	private Main mainApp;

	private HashMap<String, Book> bookList;

	public void addNewBook(Book book) {

		bookList.put(book.getISBNNumber(), book);

	}

	public BookController() {

		bookList = new HashMap<>();
	}

	@FXML
	public void handleAddAuthor(){

	}

	@FXML
	public void handleAddNewBook() {


	}

	@FXML
	public void handleCancel() {

	}

	public void setMainApp(Main main) {

		this.mainApp = main;

	}

}
