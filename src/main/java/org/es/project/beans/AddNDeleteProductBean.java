package org.es.project.beans;

import java.io.File;
import java.util.List;

import org.es.project.models.Evaluation;
import org.es.project.models.PointOfSale;
import org.es.project.models.User;

public class AddNDeleteProductBean {
	private String creator;
	private String pointOfSale;
	private String productName;
	private String productComment;
	private double productPrice;
	private File productImage;
	
	
	
	public AddNDeleteProductBean(String creator, String pointOfSale, String productName, String productComment,
			double productPrice, File productImage) {
		this.creator = creator;
		this.pointOfSale = pointOfSale;
		this.productName = productName;
		this.productComment = productComment;
		this.productPrice = productPrice;
		this.productImage = productImage;
	}
	
	public AddNDeleteProductBean(){
		
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

	public File getProductImage() {
		return productImage;
	}

	public void setProductImage(File productImage) {
		this.productImage = productImage;
	}
	
}
