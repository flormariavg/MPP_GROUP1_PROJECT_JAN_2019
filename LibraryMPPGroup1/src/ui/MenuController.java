package ui;

import application.Main;
import javafx.fxml.FXML;

public class MenuController {




	private Main mainApp;

	public void setMainApp(Main main) {

		this.mainApp = main;

	}

	@FXML
	private void handleChekoutBook() {
		mainApp.showCheckoutBook();

	}

	@FXML
	public void handleBookCopy() {
		mainApp.showBookCopy();
	}
}
