package org.es.project.beans;

import org.es.project.models.PointOfSale;
import org.es.project.models.User;

public class EditPointOfSaleBean {
	private User requester;
	private PointOfSale selectedPoint;
	private String pointName;
	private String pointComment;
	private String pointImage;

	
	
	public EditPointOfSaleBean(User requester, PointOfSale selectedPoint, String pointName, String pointComment, String pointImage) {
		this.requester = requester;
		this.selectedPoint = selectedPoint;
		this.pointName = pointName;
		this.pointComment = pointComment;
		this.pointImage = pointImage;
	}
	
	public EditPointOfSaleBean(){
		
	}

	public User getRequester() {
		return requester;
	}

	public void setRequester(User requester) {
		this.requester = requester;
	}

	public PointOfSale getSelectedPoint() {
		return selectedPoint;
	}

	public void setSelectedPoint(PointOfSale selectedPoint) {
		this.selectedPoint = selectedPoint;
	}

	public String getPointName() {
		return pointName;
	}

	public void setPointName(String pointName) {
		this.pointName = pointName;
	}

	public String getPointComment() {
		return pointComment;
	}

	public void setPointComment(String pointComment) {
		this.pointComment = pointComment;
	}

	public String getPointImage() {
		return pointImage;
	}

	public void setPointImage(String pointImage) {
		this.pointImage = pointImage;
	}	
	

}
