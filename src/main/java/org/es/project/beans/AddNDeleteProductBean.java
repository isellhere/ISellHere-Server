package org.es.project.beans;

import java.awt.Image;
import java.util.List;

import org.es.project.models.Evaluation;
import org.es.project.models.PointOfSale;
import org.es.project.models.User;

public class AddNDeleteProductBean {
	private User creator;
	private PointOfSale pointOfSale;
	private String productName;
	private String productComment;
	private double productPrice;
	private Image productImage;
	private List<Evaluation> productEvaluations;
	
	
	public AddNDeleteProductBean(User creator, PointOfSale pointOfSale, String productName, String productComment,
			double productPrice, Image productImage, List<Evaluation> productEvaluations) {
		this.creator = creator;
		this.pointOfSale = pointOfSale;
		this.productName = productName;
		this.productComment = productComment;
		this.productPrice = productPrice;
		this.productImage = productImage;
		this.productEvaluations = productEvaluations;
	}
	
	public AddNDeleteProductBean(){
		
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public PointOfSale getPointOfSale() {
		return pointOfSale;
	}

	public void setPointOfSale(PointOfSale pointOfSale) {
		this.pointOfSale = pointOfSale;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductComment() {
		return productComment;
	}

	public void setProductComment(String productComment) {
		this.productComment = productComment;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public Image getProductImage() {
		return productImage;
	}

	public void setProductImage(Image productImage) {
		this.productImage = productImage;
	}

	public List<Evaluation> getProductEvaluations() {
		return productEvaluations;
	}

	public void setProductEvaluations(List<Evaluation> productEvaluations) {
		this.productEvaluations = productEvaluations;
	}
	
}
