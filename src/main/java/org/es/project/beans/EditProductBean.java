package org.es.project.beans;

import java.io.File;

import org.es.project.models.Product;
import org.es.project.models.User;

public class EditProductBean {
	private User requester;
	private String productName;
	private String productComment;
	private double productPrice;
	private File productImage;
	private Product selectedProduct;
	
	
	public EditProductBean(User requester, String productName, String productComment, double productPrice, File productImage, Product selectedProduct) {
		this.requester = requester;
		this.productName = productName;
		this.productComment = productComment;
		this.productPrice = productPrice;
		this.productImage = productImage;
		this.selectedProduct = selectedProduct;
	}
	
	public EditProductBean(){
		
	}

	public User getRequester() {
		return requester;
	}

	public void setRequester(User requester) {
		this.requester = requester;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductComment() {
		return productComment;
	}

	public void setProductComment(String productComment) {
		this.productComment = productComment;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public File getProductImage() {
		return productImage;
	}

	public void setProductImage(File productImage) {
		this.productImage = productImage;
	}

	public Product getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	
}
