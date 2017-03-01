package org.es.project.beans.modelbeans;

import java.util.List;
import org.es.project.models.Evaluation;


public class ProductBean {
	
	private String creator;
	private String pointOfSale;
	private String name;
	private String comment;
	private double price;
	private String image;
	private List<Evaluation> evaluations;
	
	public ProductBean(){
		
	}
	
	public ProductBean(String creator, String pointOfSale, String name, String comment, double price, String image, List<Evaluation> evaluations){
		this.creator = creator;
		this.pointOfSale = pointOfSale;
		this.name = name;
		this.comment = comment;
		this.price = price;
		this.image = image;
		this.evaluations = evaluations;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getPointOfSale() {
		return pointOfSale;
	}

	public void setPointOfSale(String pointOfSale) {
		this.pointOfSale = pointOfSale;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}
	
	

}
