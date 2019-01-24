package ui;

import java.io.IOException;

import application.Main;
import business.AddBookCopyService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Book;
import model.BookCopy;
import model.CheckoutEntry;

public class BookCopyController {

	@FXML
	private TextField isbn;
	@FXML
	private TextField copyNumber;
	@FXML
	private Label lblBookAvailable;
	@FXML
	private Button btnAddCopy;
	@FXML
	private TableView<BookCopy> bookCopyTable;
	@FXML
	private TableColumn<BookCopy, String> copyNumberColumn;

	private Book book = null;
	
	AddBookCopyService service;

	public BookCopyController() {
		service = new AddBookCopyService();
	}
	@FXML
	public void btnSearch(ActionEvent event) throws IOException {
		book = service.searchBook(isbn.getText());
		if(book!=null) {
			lblBookAvailable.setText(book.toString());
			btnAddCopy.setDisable(false);
			copyNumber.setDisable(false);
			copyNumberColumn.setCellValueFactory(new PropertyValueFactory<BookCopy, String>("copyNumber"));
			bookCopyTable.getItems().setAll(book.getBooks());
		}else {
			lblBookAvailable.setText("");
			btnAddCopy.setDisable(true);
			copyNumber.setDisable(true);
			Util.showAlert(AlertType.ERROR, "Error", "Book not found", "The book with the ISBN : "+isbn.getText()+" was not found, please try again with another isbn number");
		}
	}

	@FXML
	public void btnAddCopy() {
		try {
			int numberOfCopies = Integer.valueOf(copyNumber.getText());
			service.addBookCopies(book, numberOfCopies);
			copyNumberColumn.setCellValueFactory(new PropertyValueFactory<BookCopy, String>("copyNumber"));
			bookCopyTable.getItems().setAll(book.getBooks());
			Util.showAlert(AlertType.CONFIRMATION, "Confirmation", "Copies saved", "The "+numberOfCopies+" copy(ies) of the book \""+book.getTitle()+"\" was(were) saved successfully");
		} catch (NumberFormatException e) {
			Util.showAlert(AlertType.ERROR, "Error", "Incorrect Number", "Number of copies should be an Integer");
		}
		
	}

	private Main mainApp;

	public void setMainApp(Main main) {
		this.mainApp = main;
	}

}
