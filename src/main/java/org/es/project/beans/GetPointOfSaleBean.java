package org.es.project.beans;

import org.es.project.models.Location;
import org.es.project.models.User;

public class GetPointOfSaleBean {
	private User user;
	private String pointName;
	private Location location;
	
	public GetPointOfSaleBean(User user, String pointName, Location location){
		this.user = user;
		this.pointName = pointName;
		this.location = location;
	}
	
	public GetPointOfSaleBean(){
		
	}

	public String getPointName() {
		return pointName;
	}

	public void setPointName(String pointName) {
		this.pointName = pointName;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
