package org.es.project.exceptions;

public class InvalidRequestBodyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2462785345962816785L;
	
	public InvalidRequestBodyException(){
		super("Invalid request body");
	}
	
	public InvalidRequestBodyException(String message){
		super(message);
	}

}
