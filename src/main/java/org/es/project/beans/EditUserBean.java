package org.es.project.beans;


public class EditUserBean {
	
	private String user;
	private String newPassword;
	
	public EditUserBean(String user, String newPassword){
		this.user = user;
		this.newPassword = newPassword;
	}
	
	public EditUserBean(){
		
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	

}
