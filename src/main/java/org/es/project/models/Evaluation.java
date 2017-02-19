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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + grade;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Evaluation other = (Evaluation) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
			
		} else if (!comment.equals(other.comment))
			return false;
		
		if (grade != other.grade)
			return false;
		
		if (id == null) {
			if (other.id != null)
				return false;
			
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
