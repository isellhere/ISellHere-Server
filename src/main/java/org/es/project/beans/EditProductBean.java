package org.es.project.beans;


public class EditProductBean {
	private String requester;
	private String productName;
	private String productComment;
	private double productPrice;
	private String productImage;
	private String selectedProduct;
	
	
	public EditProductBean(String requester, String productName, String productComment, double productPrice, String productImage, String selectedProduct) {
		this.requester = requester;
		this.productName = productName;
		this.productComment = productComment;
		this.productPrice = productPrice;
		this.productImage = productImage;
		this.selectedProduct = selectedProduct;
	}
	
	public EditProductBean(){
		
	}

	public String getRequester() {
		return requester;
	}

	public void setRequester(String requester) {
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

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(String selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	
}
