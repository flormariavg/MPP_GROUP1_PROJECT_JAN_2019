package ui;

import application.Main;
import business.CheckoutBookService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ChechoutBookOverviewController {
	
	// Reference to the main application.
		private Main mainApp;
		
		@FXML
		private TextField txtMemberId;
		@FXML
		private TextField txtISBN;
		
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
		String memberId= txtMemberId.getText();
		String isbn= txtISBN.getText();
		System.out.println(txtMemberId.getText());
		System.out.println(txtISBN.getText());
		
		CheckoutBookService bookService= new CheckoutBookService();
		bookService.getBook(isbn);
		bookService.getMember(memberId);
		
		System.out.println(bookService.getBook(isbn));
		System.out.println(bookService.getMember(memberId));
	
		if(bookService.getBook(isbn)!=null && bookService.getMember(memberId)!=null) {
			
			
		}

	}

}
