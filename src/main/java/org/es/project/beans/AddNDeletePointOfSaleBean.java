package org.es.project.beans;

import java.io.File;
import java.util.List;

import org.es.project.models.Evaluation;
import org.es.project.models.Product;
import org.es.project.models.User;

public class AddNDeletePointOfSaleBean {
	private String creator;
	private String pointName;
	private double pointLongitude;
	private double pointLatitude;
	private String pointComment;
	private File pointImage;
	
	
	public AddNDeletePointOfSaleBean(String creator, String pointName, double pointLongitude, double pointLatitude, String pointComment, File pointImage) {
		this.creator = creator;
		this.pointName = pointName;
		this.pointLongitude = pointLongitude;
		this.pointLatitude = pointLatitude;
		this.pointComment = pointComment;
		this.pointImage = pointImage;
	}

	public AddNDeletePointOfSaleBean(){
		
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
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

	public File getPointImage() {
		return pointImage;
	}

	public void setPointImage(File pointImage) {
		this.pointImage = pointImage;
	}
	
}