package org.es.project.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class PointOfSale {
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User creator;
	
	@Column(unique = true)
	private String name;
	private String comment;
	private String image;
	@OneToOne(cascade = CascadeType.ALL)
	private Location location;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> products;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Evaluation> evaluations;
	
	
	public PointOfSale(User creator, String name, double longitude, double latitude, String comment, String image){
		this.creator = creator;
		this.name = name;
		this.comment = comment;
		this.image = image;
		location = new Location(longitude, latitude);
		products = new ArrayList<>();
		evaluations = new ArrayList<>();
	}
	
	
	public PointOfSale(User creator, String name, double longitude, double latitude, String comment){
		this(creator, name, longitude, latitude, comment, null);
	}
	
	public PointOfSale(User creator, String name, double longitude, String image, double latitude){
		this(creator, name, longitude, latitude, "", image);
	}
	
	public PointOfSale(User creator, String name, double longitude, double latitude){
		this(creator, name, longitude, latitude, "", null);
	}

	public void addProduct(User creator, String name, double price, String comment, String image){
		Product product = new Product(creator, this, name, price, comment, image);
		products.add(product);
	}
	public void addProduct(User creator, String name, String comment,  double price){
		Product product = new Product(creator, this, name, price, comment);
		products.add(product);
	}
	public void addProduct(User creator, String name, double price, String image){
		Product product = new Product(creator, this, name, price, image);
		products.add(product);
	}
	public void addProduct(User creator, String name, double price){
		Product product = new Product(creator, this, name, price);
		products.add(product);
	}

	public void editProduct(String name, double price, String comment, String image){
		
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
		return location.getLongitude();
	}


	public double getLatitude() {
		return location.getLatitude();
	}


	public String getComment() {
		return comment;
	}


	public String getImage() {
		return image;
	}


	public List<Product> getProducts() {
		return products;
	}
	
	public Long getId(){
		return id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
	

	
	
}
