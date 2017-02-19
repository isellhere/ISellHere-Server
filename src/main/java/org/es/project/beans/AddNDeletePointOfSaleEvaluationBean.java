package org.es.project.beans;

import org.es.project.models.PointOfSale;
import org.es.project.models.User;

public class AddNDeletePointOfSaleEvaluationBean {
	private User user;
	private PointOfSale point;
	private int grade;
	private String comment;
	
	
	public AddNDeletePointOfSaleEvaluationBean(User user, PointOfSale point, int grade, String comment) {
		this.user = user;
		this.point = point;
		this.grade = grade;
		this.comment = comment;
	}
	
	public AddNDeletePointOfSaleEvaluationBean(){
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PointOfSale getPoint() {
		return point;
	}

	public void setPoint(PointOfSale point) {
		this.point = point;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	

}
