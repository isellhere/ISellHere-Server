package org.es.project.beans;


public class GetProductBean {
	private String productName;
	private String pointName;
	
	public GetProductBean(String productName, String pointName){
		this.productName = productName;
		this.pointName = pointName;
	}
	
	public GetProductBean(){
		
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPointName() {
		return pointName;
	}

	public void setPointName(String pointName) {
		this.pointName = pointName;
	}

	
	
	

	
	
}
