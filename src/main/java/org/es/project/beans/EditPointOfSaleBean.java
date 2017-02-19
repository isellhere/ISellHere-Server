package org.es.project.beans;

import java.util.List;

import org.es.project.models.Evaluation;
import org.es.project.models.PointOfSale;
import org.es.project.models.Product;
import org.es.project.models.User;

public class EditPointOfSaleBean {
	private User creator;
	private PointOfSale selectedPoint;
	private String pointName;
	private double pointLongitude;
	private double pointLatitude;
	private String pointComment;
	private String pointImage;
	private List<Product> pointProducts;
	private List<Evaluation> pointEvaluations;
	
	
	public EditPointOfSaleBean(User creator, PointOfSale selectedPoint, String pointName, double pointLongitude,
			double pointLatitude, String pointComment, String pointImage, List<Product> pointProducts,
			List<Evaluation> pointEvaluations) {
		this.creator = creator;
		this.selectedPoint = selectedPoint;
		this.pointName = pointName;
		this.pointLongitude = pointLongitude;
		this.pointLatitude = pointLatitude;
		this.pointComment = pointComment;
		this.pointImage = pointImage;
		this.pointProducts = pointProducts;
		this.pointEvaluations = pointEvaluations;
	}
	
	public EditPointOfSaleBean(){
		
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public PointOfSale getSelectedPoint() {
		return selectedPoint;
	}

	public void setSelectedPoint(PointOfSale selectedPoint) {
		this.selectedPoint = selectedPoint;
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
