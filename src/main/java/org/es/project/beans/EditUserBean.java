package org.es.project.beans;


public class EditUserBean {
	
	private String user;
	private String oldPassword;
	private String newPassword;
	
	public EditUserBean(String user, String newPassword, String oldPassword){
		this.user = user;
		this.newPassword = newPassword;
		this.oldPassword = oldPassword;
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

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	
	
	
	

}
