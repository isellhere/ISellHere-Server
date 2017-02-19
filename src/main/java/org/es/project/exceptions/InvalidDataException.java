package org.es.project.exceptions;

public class InvalidDataException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7155386661194057242L;
	
	public InvalidDataException(){
		super("Invalid data");
	}
	
	public InvalidDataException(String message){
		super(message);
	}

}
