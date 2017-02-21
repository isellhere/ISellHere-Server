package org.es.project.beans;

import java.io.File;

import org.es.project.models.PointOfSale;
import org.es.project.models.User;

public class EditPointOfSaleBean {
	private String requester;
	private String selectedPoint;
	private String pointName;
	private String pointComment;
	private File pointImage;

	
	
	public EditPointOfSaleBean(String requester, String selectedPoint, String pointName, String pointComment, File pointImage) {
		this.requester = requester;
		this.selectedPoint = selectedPoint;
		this.pointName = pointName;
		this.pointComment = pointComment;
		this.pointImage = pointImage;
	}
	
	public EditPointOfSaleBean(){
		
	}

	public String getRequester() {
		return requester;
	}

	public void setRequester(String requester) {
		this.requester = requester;
	}

	public String getSelectedPoint() {
		return selectedPoint;
	}

	public void setSelectedPoint(String selectedPoint) {
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

	public File getPointImage() {
		return pointImage;
	}

	public void setPointImage(File pointImage) {
		this.pointImage = pointImage;
	}	
	

}
