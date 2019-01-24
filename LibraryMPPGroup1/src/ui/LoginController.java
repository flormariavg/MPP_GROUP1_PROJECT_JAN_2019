package ui;

import application.Main;
import business.LoginService;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.Login;
import util.Util;

public class LoginController {
	@FXML
	private TextField txtUser;
	@FXML
	private PasswordField txtPassword;

	private Main mainApp;

	@FXML
	private void handleLogin() {
		Login login = new Login(txtUser.getText(), txtPassword.getText());
		LoginService loginService= new LoginService();
		login = loginService.login(login) ;
		if(login != null) {
		
			mainApp.showMenu(login.getRoles());
			//mainApp.showAddNewBook();


		} else {
			Util.showAlert(AlertType.ERROR, "Error", "Login fail", "please try again!");


		}}

	public void setMainApp(Main main) {

		this.mainApp = main;

	}

}
