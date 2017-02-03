package org.es.project.beans;

import org.es.project.models.Product;
import org.es.project.models.User;

public class AddNDeleteProductEvaluationBean {
	private User user;
	private Product product;
	private int grade;
	private String comment;
	
	
	public AddNDeleteProductEvaluationBean(User user, Product product, int grade, String comment) {
		this.user = user;
		this.product = product;
		this.grade = grade;
		this.comment = comment;
	}
	
	public AddNDeleteProductEvaluationBean(){
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
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
