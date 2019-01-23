package ui;

import application.Main;
import business.LoginService;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Login;

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
		if(loginService.login(login)) {

			mainApp.showAddNewBook();

		} else {
			System.out.println("Login fail");

		}}

	public void setMainApp(Main main) {

		this.mainApp = main;

	}

}
