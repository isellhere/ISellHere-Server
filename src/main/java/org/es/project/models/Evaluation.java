package org.es.project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Evaluation {
	@Id
	@GeneratedValue
	private Long id;
	
	
	private int grade; // depois eh bom ser enum
	private String comment;
	
	public Evaluation(int grade, String comment){
		this.grade = grade;
		this.comment = comment;
	}
	
	public Evaluation(int grade){
		this(grade, "");
	}

	public int getGrade() {
		return grade;
	}

	public String getComment() {
		return comment;
	}
	
	public Long getId(){
		return id;
	}
	

}
