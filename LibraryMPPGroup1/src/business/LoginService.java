package business;

import dataaccess.LoginDAO;
import model.Login;

public class LoginService {

	public boolean login(Login login) {
		return LoginDAO.checkAccount(login);

	}

}
