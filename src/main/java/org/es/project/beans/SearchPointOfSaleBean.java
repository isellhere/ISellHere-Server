package org.es.project.beans;

import org.es.project.models.User;

public class SearchPointOfSaleBean {
	private User user;
	private String pointName;
	private int distance;
	
	public SearchPointOfSaleBean(User user, String pointName, int distance){
		this.user = user;
		this.pointName = pointName;
		this.distance = distance;
	}
	
	public SearchPointOfSaleBean(){
		
	}

	public String getPointName() {
		return pointName;
	}

	public void setPointName(String pointName) {
		this.pointName = pointName;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
