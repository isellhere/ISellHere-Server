package org.es.project.beans;

import org.es.project.models.Location;
import org.es.project.models.User;

public class GetProductBean {
	private String productName;
	private double longitude;
	private double latitude;
	
	public GetProductBean(String productName, double longitude, double latitude){
		this.productName = productName;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public GetProductBean(){
		
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	

	
	
}
