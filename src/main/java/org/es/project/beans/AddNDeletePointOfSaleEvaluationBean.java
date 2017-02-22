package org.es.project.beans;

import org.es.project.models.PointOfSale;
import org.es.project.models.User;

public class AddNDeletePointOfSaleEvaluationBean {
	private String user;
	private String point;
	private int grade;
	private String comment;
	
	
	public AddNDeletePointOfSaleEvaluationBean(String user, String point, int grade, String comment) {
		this.user = user;
		this.point = point;
		this.grade = grade;
		this.comment = comment;
	}
	
	public AddNDeletePointOfSaleEvaluationBean(){
		
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
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
