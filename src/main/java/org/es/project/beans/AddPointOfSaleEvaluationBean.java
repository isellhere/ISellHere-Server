package org.es.project.beans;


public class AddPointOfSaleEvaluationBean {
	private String user;
	private String point;
	private int grade;
	private String comment;
	
	
	public AddPointOfSaleEvaluationBean(String user, String point, int grade, String comment) {
		this.user = user;
		this.point = point;
		this.grade = grade;
		this.comment = comment;
	}
	
	public AddPointOfSaleEvaluationBean(){
		
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
