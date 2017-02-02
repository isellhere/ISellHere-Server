package org.es.project.models;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class PointOfSale {
	private User creator;
	private String name;
	private double longitude;
	private double latitude;
	private String comment;
	private Image image;
	private List<Product> products;
	private List<Evaluation> evaluations;
	
	
	public PointOfSale(User creator, String name, double longitude, double latitude, String comment, Image image){
		this.creator = creator;
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.comment = comment;
		this.image = image;
		products = new ArrayList<>();
		evaluations = new ArrayList<>();
	}
	
	
	public PointOfSale(User creator, String name, double longitude, double latitude, String comment){
		this(creator, name, longitude, latitude, comment, null);
	}
	
	public PointOfSale(User creator, String name, double longitude, double latitude, Image image){
		this(creator, name, longitude, latitude, "", image);
	}
	
	public PointOfSale(User creator, String name, double longitude, double latitude){
		this(creator, name, longitude, latitude, "", null);
	}

	public void addProduct(User creator, String name, double price, String comment, Image image){
		Product product = new Product(creator, this, name, price, comment, image);
		products.add(product);
	}
	public void addProduct(User creator, String name, double price, String comment){
		Product product = new Product(creator, this, name, price, comment);
		products.add(product);
	}
	public void addProduct(User creator, String name, double price, Image image){
		Product product = new Product(creator, this, name, price, image);
		products.add(product);
	}
	public void addProduct(User creator, String name, double price){
		Product product = new Product(creator, this, name, price);
		products.add(product);
	}

	public void editProduct(String name, double price, String comment, Image image){
		
	}
	
	public void deleteProduct(String name){
		
	}
	
	//falta os metodos, lembrar que algumas operações só o criador pode fazer
	
	public void addEvaluation(int grade, String comment){
		Evaluation evaluation = new Evaluation(grade, comment);
		evaluations.add(evaluation);
	}
	
	public void addEvaluation(int grade){
		Evaluation evaluation = new Evaluation(grade);
		evaluations.add(evaluation);
	}
	
	public double showPointOfSaleGrade(){
		double grade = 0.0;
		
		if(!evaluations.isEmpty()){
			
			for(Evaluation ev : evaluations){
				grade += ev.getGrade();
			}
			grade = grade / evaluations.size();
		}
		
		return grade;		
	}
	
	public String[] showRecentComments(){
		String[] recentComments = new String[3];
		int count = 0;
		for(int i = evaluations.size() - 1; i > 0; i--){
			if(!evaluations.get(i).getComment().equals("")){
				recentComments[count] = evaluations.get(i).getComment();
				count++;
			}
		}
		return recentComments;
	}

	//GETTERS AND SETTERS
	public User getCreator() {
		return creator;
	}


	public String getName() {
		return name;
	}


	public double getLongitude() {
		return longitude;
	}


	public double getLatitude() {
		return latitude;
	}


	public String getComment() {
		return comment;
	}


	public Image getImage() {
		return image;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public void setImage(Image image) {
		this.image = image;
	}
	
	
	
	
	

	
	
}
