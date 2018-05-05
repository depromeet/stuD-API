package com.depromeet.auth;

import javax.servlet.http.HttpServletRequest;

public class AccountCredentials {
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public static AccountCredentials fromRequest(HttpServletRequest request) {
		AccountCredentials creds = new AccountCredentials();
		creds.setUsername(request.getParameter("username"));
		creds.setPassword(request.getParameter("password"));
		return creds;
	}
}
