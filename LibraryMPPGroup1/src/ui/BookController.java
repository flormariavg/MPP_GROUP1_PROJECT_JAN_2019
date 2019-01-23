package ui;

import java.util.ArrayList;
import java.util.List;

import application.Main;
import business.BookService;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;
import model.Author;
import model.Book;


public class BookController {

	@FXML
	private TableView<Author> authorTable;
	@FXML
	private TableColumn<Author, String> firstNameColumn;
	@FXML
	private TableColumn<Author, String> lastNameColumn;
	@FXML
	private TableColumn<Author, String> phoneNumberColumn;
	@FXML
	private TableColumn<Author, String> addressColumn;
	@FXML
	private TableView<Book> bookTable;
	@FXML
	private TableColumn<Book, String> BookIDColumn;
	@FXML
	private TableColumn<Book, String> TitleColumn;
	@FXML
	private TextField txtNumber;
	@FXML
	private TextField txtTitle;
	@FXML
	private TextField txtNumberOfCopy;
	@FXML
	private TableView<String> tableView;

	@FXML
	private ChoiceBox<Integer> cb;

	private Main mainApp;

	//private HashMap<String, Book> bookList;

	private ObservableList<Author> authorData = FXCollections.observableArrayList();

	private ObservableList<Book>  bookList = FXCollections.observableArrayList();

	public void addNewBook(Book book) {

		if (book != null)
			bookList.add(book);

	}

	public void getBookListFromDatabase() {

		BookService bookService = new BookService();
		List<Book> list = bookService.getBookList();
		bookList.addAll(list);
	}

	@FXML
	private void initialize() {

		preJava8();
		//cb = new ChoiceBox(FXCollections.observableArrayList(21, 7 ));

		 cb.setItems(FXCollections.observableArrayList(
		     21,7)
		 );

		 txtNumberOfCopy.setText("0");
		 txtNumberOfCopy.setDisable(true);
		// getList data from database
		getBookListFromDatabase();

		// Add observable list data to the table
		authorTable.setItems(getAuthorData());
		bookTable.setItems(bookList);

		bookTable.getSelectionModel().selectedItemProperty()
		.addListener((observable, oldValue, newValue) -> showBookData(newValue));

		if (bookList.size() > 0 ) {
			bookTable.getSelectionModel().selectFirst();
			authorData.clear();
			List<Author> ath = bookList.get(0).getAuthorList();
			if (ath != null)
				authorData.addAll(ath);
		}

	}

	public BookController() {


	}

	public void showBookData(Book book) {

		if (book != null) {
			txtNumber.setText(book.getISBNNumber());
			txtTitle.setText(book.getTitle());
			txtNumberOfCopy.setText(""+ book.getBooks().size());
			if (book.getMaximumCheckOutLength()!= 21 && book.getMaximumCheckOutLength()!= 7)
				cb.getSelectionModel().selectFirst();
			else
				cb.getSelectionModel().select(book.getMaximumCheckOutLength());


			authorData.clear();
			List<Author> ath =book.getAuthorList();
			if (ath != null)
				authorData.addAll(ath);

		} else {

			txtNumber.setText("");
			txtTitle.setText("");
			txtNumberOfCopy.setText("");
			cb.getSelectionModel().selectFirst();
			authorData.clear();
		}

	}
	private void preJava8() {
		firstNameColumn.setCellValueFactory(new Callback<CellDataFeatures<Author, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<Author, String> param) {
				return  param.getValue().getFirstNameProperty();
			}
		});

		lastNameColumn.setCellValueFactory(new Callback<CellDataFeatures<Author, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<Author, String> param) {
				return param.getValue().getLastNameProperty();
			}
		});
		phoneNumberColumn.setCellValueFactory(new Callback<CellDataFeatures<Author, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<Author, String> param) {
				return param.getValue().getPhoneNumberProperty();
			}
		});
		addressColumn.setCellValueFactory(new Callback<CellDataFeatures<Author, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<Author, String> param) {
				return param.getValue().getAddressProperty();
			}
		});
		BookIDColumn.setCellValueFactory(new Callback<CellDataFeatures<Book, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<Book, String> param) {
				return param.getValue().getISBNNumberProperty();
			}
		});
		TitleColumn.setCellValueFactory(new Callback<CellDataFeatures<Book, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<Book, String> param) {
				return param.getValue().getTitleProperty();
			}
		});
	}

	@FXML
	public void handleClearAllScreen() {


		txtNumber.setText("");
		txtTitle.setText("");
		txtNumberOfCopy.setText("");
		cb.getSelectionModel().selectFirst();
		authorData.clear();
	}

	@FXML
	public void handleAddAuthor() {

			Author tempAuthor = new Author();
			boolean okClicked = mainApp.showAuthorDialog(tempAuthor);
			if (okClicked) {
				addAuthortoTable(tempAuthor);
			}

	}

	@FXML
	public void handleAddNewBook() {

		if (isInputValid()) {
			String title = txtTitle.getText();
			String iSBNNumber = txtNumber.getText();
			String availability = "1"; // can borrow
			List<Author> auth = new ArrayList<>();

			for (Author author : authorData) {
				auth.add(author);
			}

			Book book = new Book(title, iSBNNumber, auth, availability, cb.getSelectionModel().getSelectedItem());
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Add book");
			alert.setHeaderText("Add book");

			// add to database
			BookService bookService = new BookService();
			if (bookService.createBook(book)) {
				addNewBook(book);
				alert.setContentText("Add book successfully!");

			} else {
				alert.setContentText("Book is added before!");
			}
			alert.showAndWait();
		}
	}

	@FXML
	public void handleCancel() {

	}


	/**
	 * Validates the user input in the text fields.
	 *
	 * @return true if the input is valid
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (txtTitle.getText() == null || txtTitle.getText().length() == 0) {
			errorMessage += "No valid title !\n";
		}
		if (txtNumber.getText() == null || txtNumber.getText().length() == 0) {
			errorMessage += "No valid Booknumer !\n";
		}
		if (txtNumberOfCopy.getText() == null || txtNumberOfCopy.getText().length() == 0) {
			errorMessage += "No valid NumberOfCopy!\n";
		}

		if (txtNumberOfCopy.getText() == null || txtNumberOfCopy.getText().length() == 0) {
			errorMessage += "No valid postal code!\n";
		} else {
			// try to parse the postal code into an int.
			try {
				Integer.parseInt(txtNumberOfCopy.getText());
			} catch (NumberFormatException e) {
				errorMessage += "No valid NumberOfCopy (must be an integer)!\n";
			}
		}

//		if (cb.selectionModelProperty().get == null || txtMaximumCheckoutLenght.getText().length() == 0) {
//			errorMessage += "No valid MaximumCheckoutLenght!\n";
//		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}

	public ObservableList<Author> getAuthorData() {
		return authorData;
	}

	public void setMainApp(Main main) {

		this.mainApp = main;

	}

	public void addAuthortoTable(Author author) {

		if (author != null )
			authorData.add(author);
	}

}
