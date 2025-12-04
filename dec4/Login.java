package com.java.entites;

import com.java.exceptions.InValidCredentials;

public class Login {
	private static final String USERNAME = "pranay";
	private static final String PASSWORD = "pranay@18";

	public Login() {

	}

	public static boolean validateCredentials(String username, String password) throws InValidCredentials {
		if (USERNAME.equals(username) && PASSWORD.equals(password)) {
			return true;
		}
		throw new InValidCredentials("InValid Credentials");
	}

}
