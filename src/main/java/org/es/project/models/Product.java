package org.es.project.models;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;


public class Product {
	private User creator;
	private PointOfSale pointOfSale;
	private String name;
	private String comment;
	private double price;
	private Image image;
	private List<Evaluation> evaluations;
	
	
	public Product(User creator, PointOfSale pointOfSale, String name, double price, String comment, Image image){
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
	
	public Product(User creator, PointOfSale pointOfSale, String name, double price, Image image){
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

	public Image getImage() {
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

	public void setImage(Image image) {
		this.image = image;
	}
	
	
	

	
	

}
