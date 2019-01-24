package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Login implements Serializable{
	private String userName;
	private String password;
	private HashMap<String, Role> roles;


	public Login(String userName, String password) {
		this.userName = userName;
		this.password = password;
		roles = new HashMap<>();
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public HashMap<String, Role> getRoles() {
		return roles;
	}

	public void addRole(Role role) {
		if (roles == null) {
			roles = new HashMap<>();
		}
		roles.put(role.getRoleName(), role);
	}


	@Override
	public String toString() {
		//return "Login [userName=" + userName + ", password=" + password + ", roles=" + roles + "]";

		return getUserName() + " " + getPassword();
	}



}
