package org.es.project.beans;

import org.es.project.beans.modelbeans.UserBean;

public class AuthenticationResponse {
	private String token;
	private UserBean user;
	
	
	public AuthenticationResponse(String token, UserBean user) {
		this.token = token;
		this.user = user;
	}
	
	
	public String getToken() {
		return token;
	}
	
	
	public UserBean getUser() {
		return user;
	}
}
