package org.es.project.models;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class PointOfSale {
	private User creator;
	private String name;
	private double longitude;
	private double latitude;
	private String comment;
	private Image image;
	private List<Product> products;
	
	
	public PointOfSale(User creator, String name, double longitude, double latitude, String comment, Image image){
		this.creator = creator;
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.comment = comment;
		this.image = image;
		products = new ArrayList<>();
	}
	
	
	public PointOfSale(User creator, String name, double longitude, double latitude, String comment){
		this(creator, name, longitude, latitude, comment, null);
	}
	
	public PointOfSale(User creator, String name, double longitude, double latitude, Image image){
		this(creator, name, longitude, latitude, "", image);
	}
	
	public PointOfSale(User creator, String name, double longitude, double latitude){
		this(creator, name, longitude, latitude, "", null);
	}
	
	//falta os metodos, lembrar que algumas operações só o criador pode fazer
	

	

	
	
}
