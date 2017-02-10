package org.es.project.exceptions;

public class InvalidRegistrationBodyException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7281125625032556335L;
	
	public InvalidRegistrationBodyException(String message){
		super(message);
	}

}
