package org.es.project.beans.modelbeans;

import org.es.project.models.Location;

public class PointOfSaleBean {
	
	private String creator;
	private String name;
	private String comment;
	private String image;
	private Location location;
	
	public PointOfSaleBean(){
		
	}
	
	public PointOfSaleBean(String creator, String name, String comment, String image, Location location){
		this.creator = creator;
		this.name = name;
		this.comment = comment;
		this.image = image;
		this.location = location;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	
	
	
}
