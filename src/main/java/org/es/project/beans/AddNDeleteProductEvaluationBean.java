package org.es.project.beans;


public class AddNDeleteProductEvaluationBean {
	private String user;
	private String product;
	private int grade;
	private String comment;
	
	
	public AddNDeleteProductEvaluationBean(String user, String product, int grade, String comment) {
		this.user = user;
		this.product = product;
		this.grade = grade;
		this.comment = comment;
	}
	
	public AddNDeleteProductEvaluationBean(){
		
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
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
