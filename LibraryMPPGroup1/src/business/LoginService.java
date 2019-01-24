package business;

import dataaccess.LoginDAO;
import model.Login;

public class LoginService {

	public Login login(Login login) {
		return LoginDAO.checkAccount(login);

	}

}
