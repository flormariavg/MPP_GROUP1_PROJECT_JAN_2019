package ui;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.Administrator;
import model.Librarian;
import model.Role;
import util.Functions;
import util.StringUtil;

public class MenuController {

	private Main mainApp;

	@FXML
	private Button addNewBookBtn;

	@FXML
	private Button addNewMemberBtn;

	@FXML
	private Button checkoutBookBtn;

	private HashMap<String, Role> roles;
	public void setMainApp(Main main) {
		this.mainApp = main;
	}

	public void setFuntionList (HashMap<String, Role> roles) {

		this.roles = roles;
		addNewBookBtn.setDisable(true);
		addNewMemberBtn.setDisable(true);
		checkoutBookBtn.setDisable(true);
		if (roles != null) {
			  Set<String> keys = roles.keySet();
		        for(String key: keys){
		            if (key.equals(StringUtil.ADMIN_ROLE)) {
		            	Administrator a  = new Administrator();
		            	List<Integer> list = a.getListFunction();
		            	for (Integer integer : list) {
		            		if (integer == Functions.ADD_NEW_BOOK.getValue()){
								addNewBookBtn.setDisable(false);
							} else if (integer == Functions.ADD_NEW_MEMBER.getValue()){
								addNewMemberBtn.setDisable(false);
							} else if (integer == Functions.CHEKOUTBOOK.getValue()){
								checkoutBookBtn.setDisable(false);
							}
						}
		            } else if (key.equals(StringUtil.LIBRARIAN_ROLE)){
		            	Librarian a  = new Librarian();
		            	List<Integer> list = a.getListFunction();
		            	for (Integer integer : list) {
		            		if (integer == Functions.ADD_NEW_BOOK.getValue()){
								addNewBookBtn.setDisable(false);
							} else if (integer == Functions.ADD_NEW_MEMBER.getValue()){
								addNewMemberBtn.setDisable(false);
							} else if (integer == Functions.CHEKOUTBOOK.getValue()){
								checkoutBookBtn.setDisable(false);
							}

		            }
		        }

		        }
		}

	}
	@FXML
	private void initialize() {



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
	
}

