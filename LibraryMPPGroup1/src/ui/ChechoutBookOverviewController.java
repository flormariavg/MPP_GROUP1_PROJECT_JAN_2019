package ui;

import java.time.LocalDate;
import java.util.List;

import application.Main;
import business.CheckoutBookService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Book;
import model.BookCopy;
import model.CheckoutEntry;
import model.CheckoutRecord;
import model.Member;

public class ChechoutBookOverviewController {

	// Reference to the main application.
	private Main mainApp;

	@FXML
	private TextField txtMemberId;
	@FXML
	private TextField txtISBN;

	@FXML
	private Label lblMemberId;
	@FXML
	private Label lblFirstName;
	@FXML
	private Label lblLastName;
	@FXML
	private Label lblISBN;
	@FXML
	private Label lblTitle;
	@FXML
	private Label lblAuthor;
	@FXML
	private Label lblAvailableCopies;
	@FXML
	private Label lblNumberCopies;
	@FXML
	private Label lblNumberAvailableCopies;
	
	@FXML
	private TableView<CheckoutEntry> checkoutEntryTable;
	@FXML
	private TableColumn<CheckoutEntry, String> bookCopyNumberColumn;
	@FXML
	private TableColumn<CheckoutEntry, String> checkoutDateColumn;
	@FXML
	private TableColumn<CheckoutEntry, String> dueDateColumn;
	@FXML
	private TableColumn<CheckoutEntry, String> statusColumn;
	
	/**
	 * Is called by the main application to give a reference back to itself.
	 *
	 * @param mainApp
	 */
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	private void handleChekoutBooks() {
		String memberId = txtMemberId.getText();
		String isbn = txtISBN.getText();
		System.out.println(txtMemberId.getText());
		System.out.println(txtISBN.getText());

		CheckoutBookService checkoutBookService = new CheckoutBookService();

		if (checkoutBookService.getBook(isbn) != null && checkoutBookService.getMember(memberId) != null) {
			Book book = checkoutBookService.getBook(isbn);
			Member member = checkoutBookService.getMember(memberId);

			int numCopies = 0, numCopiesAvailable = 0;
			boolean available = true;
			BookCopy bookCopyA=null;

			lblMemberId.setText(member.id);
			lblFirstName.setText(member.getFirstName().toString());
			lblLastName.setText(member.getLastName());
			lblISBN.setText(book.getISBNNumber());
			lblTitle.setText(book.getTitle());
			// lblAuthor.setText(Arrays.toString(book.getAuthorList().toArray()));
			List<BookCopy> bookCopies = book.getBooks();

			System.out.println(bookCopies.size());
			numCopies = bookCopies.size();
			numCopiesAvailable = numCopies;
			
			for (BookCopy bookCopy : bookCopies) {
				available = true;
				if (!bookCopy.isAvailability()) {
					numCopiesAvailable--;
					available = false;
				}else {
					if(bookCopyA==null) {
						bookCopy.setAvailability(false);
						numCopiesAvailable--;
						bookCopyA=bookCopy;
						
						
					}
						
				}
			}
			
			System.out.println(numCopies);
			System.out.println(numCopiesAvailable);
			lblNumberCopies.setText(String.valueOf(numCopies));
			lblNumberAvailableCopies.setText(String.valueOf(numCopiesAvailable));
			
			CheckoutRecord checkoutRecord;
			
			if(member.getCheckoutRecord()!=null)
				checkoutRecord=member.getCheckoutRecord();
			else
				checkoutRecord= new CheckoutRecord();
			
			if (!available) {
				lblAvailableCopies.setText("NO");
				Util.showAlert(AlertType.WARNING, "Warning", "Copies not available", "There aren't copies for the book : "+book.getTitle());
			}
			else {
				lblAvailableCopies.setText("YES");
				
				int maxDay=book.getMaximumCheckOutLength();
				LocalDate dueDate= LocalDate.now().plusDays(maxDay);
				checkoutRecord.addCheckOutEntry(LocalDate.now(), dueDate, "Borrowed", bookCopyA);
				
				member.setCheckoutRecord(checkoutRecord);
				checkoutBookService.createCheckoutRecord(member, book);
			}
			
			bookCopyNumberColumn.setCellValueFactory(new PropertyValueFactory<CheckoutEntry, String>("bookCopyNumber"));
			checkoutDateColumn.setCellValueFactory(new PropertyValueFactory<CheckoutEntry, String>("checkoutDateFormatted"));
			dueDateColumn.setCellValueFactory(new PropertyValueFactory<CheckoutEntry, String>("dueDateFormatted"));
			statusColumn.setCellValueFactory(new PropertyValueFactory<CheckoutEntry, String>("status"));
			
	        checkoutEntryTable.getItems().setAll(checkoutRecord.getCheckoutEntries());
	        
		}
	}
}
