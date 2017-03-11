package org.es.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.es.project.beans.modelbeans.UserBean;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true)
	private String username;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	
	
	public User(){
		
	}
	
	public User(String username, String email, String password){
		this.username = username;
		this.email = email;
		this.password = password;
	}

	
	public UserBean createBean(){
		return new UserBean(username, email);
	}
	
	//GETTERS AND SETTERS
	
	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	public Long getId(){
		return id;
	}
	
	public void setPassword(String password){
		this.password = password;
	}	
	
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof User)){
			return false;
		}
		User aux = (User)obj;
		if(username.equals(aux.getUsername()) && password.equals(aux.getPassword()) && email.equals(aux.getEmail())){
			return true;
		} else {
			return false;
		}
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

}