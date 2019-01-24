package ui;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class RootLayoutController {

	@FXML
	private void initialize() {
		preJava8();
	}

	private void preJava8() {

	}

	@FXML
	public void back() {
		mainApp.showMenu(mainApp.roles);
	}

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

	@FXML
	public void handleAddNewBook() {
		mainApp.showAddNewBook();
	}

	@FXML
	public void handleAddNewLibraryMember() {
		mainApp.showMemberOverview();
	}
	
	@FXML
	public void handleOverdue() {
		mainApp.showOverdue();
	}
	
	@FXML
	private void handleLogout() {
		mainApp.showLoginScreen();
	}
}
