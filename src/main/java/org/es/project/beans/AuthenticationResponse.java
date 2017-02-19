package org.es.project.beans;

import org.es.project.models.User;

public class AuthenticationResponse {
	private String token;
	private User user;
	
	
	public AuthenticationResponse(String token, User user) {
		this.token = token;
		this.user = user;
	}
	
	
	public String getToken() {
		return token;
	}
	
	
	public User getUser() {
		return user;
	}
}
