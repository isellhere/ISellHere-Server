package org.es.project.beans;

import org.es.project.models.User;

public class SearchProductBean {
	private User user;
	private String productName;
	private int distance;
	
	public SearchProductBean(User user, String productName, int distance){
		this.user = user;
		this.productName = productName;
		this.distance = distance;
	}
	
	public SearchProductBean(){
		
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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
