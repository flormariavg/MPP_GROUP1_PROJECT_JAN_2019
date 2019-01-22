package ui;

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

	@FXML
	private void handleLogin() {
		Login login = new Login(txtUser.getText(), txtPassword.getText());
		LoginService loginService= new LoginService();
		if(loginService.login(login)) {
			System.out.println(login);

		} else {
			System.out.println("Login fail");

		}



	}

}
