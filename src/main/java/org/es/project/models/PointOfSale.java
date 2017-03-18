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

import org.es.project.beans.modelbeans.PointOfSaleBean;
import org.es.project.exceptions.NoCommentsException;

@Entity
public class PointOfSale {
	@Id
	@GeneratedValue
	private Long id;
	
	private String creator;
	
	@Column(unique = true)
	private String name;
	private String comment;
	@Column(length = 10000000)
	private String image;
	@OneToOne(cascade = CascadeType.ALL)
	private Location location;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> products;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Evaluation> evaluations;
	
	
	public PointOfSale(){
		this.products = new ArrayList<>();
		this.evaluations = new ArrayList<>();
	}
	
	public PointOfSale(String creator, String name, double longitude, double latitude, String comment, String image){
		this.creator = creator;
		this.name = name;
		this.comment = comment;
		this.image = image;
		this.location = new Location(longitude, latitude);
		this.products = new ArrayList<>();
		this.evaluations = new ArrayList<>();
	}


	public Product addProduct(String creator, String name, double price, String comment, String image){
		Product product = new Product(creator, this.name, name, price, comment, image);
		getProducts().add(product);
		return product;
	}

	
	public void deleteProduct(String name){
		
		if (!getProducts().isEmpty()){
			for(int i = 0; i < getProducts().size(); i++){
				if(getProducts().get(i).getName().equals(name)){
					getProducts().remove(i);
					break;
				}
			}
		}
		
	}
	
	

	public void addEvaluation(int grade, String comment, String creatorUsername){
		Evaluation evaluation = new Evaluation(grade, comment, creatorUsername);
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
	
	public String[] showRecentComments() throws NoCommentsException{
		String[] recentComments = new String[3];		
		
		int count = 0;
		int i = evaluations.size() -1;
		while(count < 3 && i >= 0){
			if(!evaluations.get(i).getComment().equals("")){
				recentComments[count] = evaluations.get(i).getComment();
				count++;
			}
			i--;
		}
		
		
		return recentComments;
	}
	
	public PointOfSaleBean createBean(){
		return new PointOfSaleBean(creator, name, comment, image, location);
	}

	//GETTERS AND SETTERS
	public String getCreator() {
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
	
	public List<Evaluation> getEvaluations(){
		return evaluations;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof PointOfSale)){
			return false;
		}
		PointOfSale other = (PointOfSale) obj;
		if(name.equals(other.getName()) && creator.equals(other.getCreator()) && location.equals(other.getLocation())){
			return true;
		}else{
			return false;	
		}
	}


	public Location getLocation() {
		return location;
	}
	

	
	
	
	

	
	
}
