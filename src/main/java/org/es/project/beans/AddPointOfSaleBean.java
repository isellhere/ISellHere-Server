package org.es.project.beans;


public class AddPointOfSaleBean {
	private String creator;
	private String pointName;
	private double pointLongitude;
	private double pointLatitude;
	private String pointComment;
	private String pointImage;
	
	public AddPointOfSaleBean(String creator, String pointName, double pointLongitude, double pointLatitude, String pointComment, String pointImage) {
		this.creator = creator;
		this.pointName = pointName;
		this.pointLongitude = pointLongitude;
		this.pointLatitude = pointLatitude;
		this.pointComment = pointComment;
		this.pointImage = pointImage;
	}

	public AddPointOfSaleBean(){
		
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

	public String getPointImage() {
		return pointImage;
	}

	public void setPointImage(String pointImage) {
		this.pointImage = pointImage;
	}
	
}