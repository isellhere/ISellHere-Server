package org.es.project.beans;

import org.es.project.models.User;

public class EditUserBean {
	
	private User user;
	private String newPassword;
	
	public EditUserBean(User user, String newPassword){
		this.user = user;
		this.newPassword = newPassword;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	

}
