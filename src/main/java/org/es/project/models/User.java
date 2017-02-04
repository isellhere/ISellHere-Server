package org.es.project.models;

import java.awt.Image;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	
	public User(String username, String email, String password){
		this.username = username;
		this.email = email;
		this.password = password;
}

	
	public void createPointOfSale(String name, double longitude, double latitude, String comment, Image image){
		
	}
	
	public void editPointOfSale(PointOfSale pointOfSale , String name, String comment, Image image){
		pointOfSale.setName(name);
		pointOfSale.setComment(comment);
		pointOfSale.setImage(image);
	}
	
	public void editProduct(Product product, String name, double price, String comment, Image image){
		product.setName(name);
		product.setPrice(price);
		product.setComment(comment);
		product.setImage(image);
	}
	
	//TODO
	public void deletePointOfSale(String name, double longitude, double latitude){
		
	}
	
	//TODO
	public PointOfSale searchPointOfSale(String pointName, int distance){
		return null;
		
	}
	
	//TODO
	public Product searchProduct(String productName, int distance){
		return null;
		
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
	
	//falta inserir restrição de senha
	public void setPassword(String password){
		this.password = password;
	}

}