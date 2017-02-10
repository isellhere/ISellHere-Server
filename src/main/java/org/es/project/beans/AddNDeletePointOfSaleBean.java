package org.es.project.beans;

import java.util.List;

import org.es.project.models.Evaluation;
import org.es.project.models.Product;
import org.es.project.models.User;

public class AddNDeletePointOfSaleBean {
	private User creator;
	private String pointName;
	private double pointLongitude;
	private double pointLatitude;
	private String pointComment;
	private String pointImage;
	private List<Product> pointProducts;
	private List<Evaluation> pointEvaluations;
	
	
	public AddNDeletePointOfSaleBean(User creator, String pointName, double pointLongitude, double pointLatitude, String pointComment, String pointImage,
			List<Product> pointProducts, List<Evaluation> pointEvaluations) {
		this.creator = creator;
		this.pointName = pointName;
		this.pointLongitude = pointLongitude;
		this.pointLatitude = pointLatitude;
		this.pointComment = pointComment;
		this.pointImage = pointImage;
		this.pointProducts = pointProducts;
		this.pointEvaluations = pointEvaluations;
	}

	public AddNDeletePointOfSaleBean(){
		
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public String getPointName() {
		return pointName;
	}

	public void setPointName(String pointName) {
		this.pointName = pointName;
	}

	public double getPointLongitude() {
		return pointLongitude;
	}

	public void setPointLongitude(double pointLongitude) {
		this.pointLongitude = pointLongitude;
	}

	public double getPointLatitude() {
		return pointLatitude;
	}

	public void setPointLatitude(double pointLatitude) {
		this.pointLatitude = pointLatitude;
	}

	public String getPointComment() {
		return pointComment;
	}

	public void setPointComment(String pointComment) {
		this.pointComment = pointComment;
	}

	public String getPointImage() {
		return pointImage;
	}

	public void setPointImage(String pointImage) {
		this.pointImage = pointImage;
	}

	public List<Product> getPointProducts() {
		return pointProducts;
	}

	public void setPointProducts(List<Product> pointProducts) {
		this.pointProducts = pointProducts;
	}

	public List<Evaluation> getPointEvaluations() {
		return pointEvaluations;
	}

	public void setPointEvaluations(List<Evaluation> pointEvaluations) {
		this.pointEvaluations = pointEvaluations;
	}
	
}