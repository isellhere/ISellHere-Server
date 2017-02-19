package org.es.project.beans;

import org.es.project.models.User;

public class DeletePointOfSaleBean {
	
	private User requester;
	private String pointName;
	
	public DeletePointOfSaleBean(User requester, String pointName){
		this.requester = requester;
		this.pointName = pointName;
	}

	public User getRequester() {
		return requester;
	}

	public void setRequester(User requester) {
		this.requester = requester;
	}

	public String getPointName() {
		return pointName;
	}

	public void setPointName(String pointName) {
		this.pointName = pointName;
	}
	
	

}
