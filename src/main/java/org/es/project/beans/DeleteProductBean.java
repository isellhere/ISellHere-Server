package org.es.project.beans;

import org.es.project.models.User;

public class DeleteProductBean {
	String requester;
	String productName;
	
	public DeleteProductBean(String requester, String productName){
		this.requester = requester;
		this.productName = productName;
	}
	
	public DeleteProductBean(){
		
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
	
	
}
