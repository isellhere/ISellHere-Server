package org.es.project.exceptions;

public class NoCommentsException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5804288809182547640L;
	
	public NoCommentsException(){
		super("No comments found.");
	}

}
