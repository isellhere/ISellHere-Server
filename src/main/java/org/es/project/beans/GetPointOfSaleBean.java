package org.es.project.beans;


public class GetPointOfSaleBean {
	private String pointName;
	private double latitude;
	private double longitude;
	
	public GetPointOfSaleBean(String pointName, double latitude, double longitude){
		this.pointName = pointName;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public GetPointOfSaleBean(){
		
	}

	public String getPointName() {
		return pointName;
	}

	public void setPointName(String pointName) {
		this.pointName = pointName;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	
	
}
