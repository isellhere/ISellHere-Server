package org.es.project.models;

import java.awt.Image;

public class User {
	private String username;
	private String email;
	private String password;
	
	public User(String username, String email, String password){
		this.username = username;
		this.email = email;
		this.password = password;
}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	public void editUser(String username, String email, String senha){
		
	}
	
	public void createPointOfSale(String name, double longitude, double latitude, String comment, Image image){
		
	}
	
	public void editPointOfSale(String name, double longitude, double latitude, String comment, Image image){
		
	}
	
	public void deletePointOfSale(String name, double longitude, double latitude){
		
	}
	
	public PointOfSale searchPointOfSale(int distance){
		return null;
		
	}
	
	public Product searchProduct(int distance){
		return null;
		
	}

}