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

import org.es.project.beans.modelbeans.ProductBean;
import org.es.project.exceptions.NoCommentsException;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private Long id;
	
	private String creator;
	private String pointOfSale;
	private String name;
	private String comment;
	private double price;
	@Column(length = 10000000)
	private String image;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Evaluation> evaluations;
	
	
	public Product(){
		
	}
	
	
	public Product(String creator, String pointOfSale, String name, double price, String comment, String image){
		this.creator = creator;
		this.pointOfSale = pointOfSale;
		this.name = name;
		this.price = price;
		this.comment = comment;
		this.image = image; // A gente tem que achar uma imagem default depois pra nao ficar NULL
		evaluations = new ArrayList<>();
	}
	
	
	public void addEvaluation(int grade, String comment, String creatorUsername){
		Evaluation evaluation = new Evaluation(grade, comment, creatorUsername);
		evaluations.add(evaluation);
	}
	
	public double showProductGrade(){
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
	
	public ProductBean createBean(){
		return new ProductBean(creator, pointOfSale, name, comment, price, image, evaluations);
	}
	
	
	// GETTERS AND SETTERS
	
	public String getName() {
		return name;
	}

	public String getComment() {
		return comment;
	}

	public double getPrice() {
		return price;
	}

	public String getImage() {
		return image;
	}
	
	public String getPointOfSale(){
		return pointOfSale;
	}
	
	public String getCreator(){
		return creator;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getId() {
		return id;
	}
	
	public List<Evaluation> getEvaluations(){
		return evaluations;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pointOfSale == null) ? 0 : pointOfSale.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Product)){
			return false;
		}
		Product other = (Product) obj;
		if(creator.equals(other.getCreator()) && name.equals(other.getName()) && pointOfSale.equals(other.getPointOfSale())){
			return true;
		}else{
		return false;}
		
	}
	
	
	

	
	

}
