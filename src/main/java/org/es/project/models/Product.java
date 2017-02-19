package org.es.project.models;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.es.project.exceptions.NoCommentsException;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne(cascade = CascadeType.ALL)
	private User creator;
	@ManyToOne(cascade = CascadeType.ALL)
	private PointOfSale pointOfSale;
	private String name;
	private String comment;
	private double price;
	private File image;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Evaluation> evaluations;
	
	
	public Product(User creator, PointOfSale pointOfSale, String name, double price, String comment, File image){
		this.creator = creator;
		this.pointOfSale = pointOfSale;
		this.name = name;
		this.price = price;
		this.comment = comment;
		this.image = image; // A gente tem que achar uma imagem default depois pra nao ficar NULL
		evaluations = new ArrayList<>();
	}
	
	public Product(User creator, PointOfSale pointOfSale, String name, double price, String comment){
		this(creator, pointOfSale, name, price, comment, null);
	}
	
	public Product(User creator, PointOfSale pointOfSale, String name, File image, double price){
		this(creator, pointOfSale, name, price, "", image);
	}
	
	public Product(User creator, PointOfSale pointOfSale, String name, double price){
		this(creator, pointOfSale, name, price, "", null);
	}
	
	//lembrar que algumas operações so o criador do produto e do ponto de venda pode fazer
	
	public void addEvaluation(int grade, String comment){
		Evaluation evaluation = new Evaluation(grade, comment);
		evaluations.add(evaluation);
	}
	
	public void addEvaluation(int grade){
		Evaluation evaluation = new Evaluation(grade);
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
		
		if(evaluations.size() >= 3){
			for(int i = evaluations.size() - 1; i >= (evaluations.size() - 3); i--){
				if(!evaluations.get(i).getComment().equals("")){
					recentComments[count] = evaluations.get(i).getComment();
					count++;}
				}
			return recentComments;	
			
		}else{
			if(!evaluations.isEmpty()){
				for (Evaluation e : evaluations){
					recentComments[count] = e.getComment();
					count++;}
				return recentComments;
				
			}else{
				throw new NoCommentsException();}
		}
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

	public File getImage() {
		return image;
	}
	
	public PointOfSale getPointOfSale(){
		return pointOfSale;
	}
	
	public User getCreator(){
		return creator;
	}
	
	// Deve haver uma checagem se o usuario tem permissao de realizar tal ação. Isso deve ser feito em services.
	public void setName(String name) {
		this.name = name;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public Long getId() {
		return id;
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
