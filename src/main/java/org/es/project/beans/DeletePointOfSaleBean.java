package org.es.project.beans;



public class DeletePointOfSaleBean {
	
	private String requester;
	private String pointName;
	
	public DeletePointOfSaleBean(String requester, String pointName){
		this.requester = requester;
		this.pointName = pointName;
	}

	public String getRequester() {
		return requester;
	}

	public void setRequester(String requester) {
		this.requester = requester;
	}

	public String getPointName() {
		return pointName;
	}

	public void setPointName(String pointName) {
		this.pointName = pointName;
	}
	
	

}
