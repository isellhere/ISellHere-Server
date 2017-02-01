package org.es.project.models;

import java.awt.Image;

import org.es.project.exceptions.NegativePriceException;

public class Product {
	private User creator;
	private PointOfSale pointOfSale;
	private String name;
	private String comment;
	private double price;
	private Image image;
	
	
	public Product(User creator, PointOfSale pointOfSale, String name, double price, String comment, Image image){
		this.creator = creator;
		this.pointOfSale = pointOfSale;
		this.name = name;
		this.price = price;
		this.comment = comment;
		this.image = image; // A gente tem que achar uma imagem default depois pra nao ficar NULL
	}
	
	public Product(User creator, PointOfSale pointOfSale, String name, double price, String comment){
		this(creator, pointOfSale, name, price, comment, null);
	}
	
	public Product(User creator, PointOfSale pointOfSale, String name, double price, Image image){
		this(creator, pointOfSale, name, price, "", image);
	}
	
	public Product(User creator, PointOfSale pointOfSale, String name, double price){
		this(creator, pointOfSale, name, price, "", null);
	}
	
	//lembrar que algumas operações so o criador do produto e do ponto de venda pode fazer

	
	

}
