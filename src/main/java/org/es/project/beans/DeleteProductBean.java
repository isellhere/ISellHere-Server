package org.es.project.beans;

import org.es.project.models.User;

public class DeleteProductBean {
	User requester;
	String productName;
	
	public DeleteProductBean(User requester, String productName){
		this.requester = requester;
		this.productName = productName;
	}
	
	public DeleteProductBean(){
		
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
	
	
}
