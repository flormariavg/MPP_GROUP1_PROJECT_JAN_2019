package model;

import java.util.ArrayList;
import java.util.List;

public class Login {
	private String userName;
	private String password;
	private List<Role> roles;

	public Login(String userName, String password) {
		this.userName = userName;
		this.password = password;
		roles = new ArrayList<>();
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	

}
