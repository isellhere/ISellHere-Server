package org.es.project.models;

public class Evaluation {
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
	

}
