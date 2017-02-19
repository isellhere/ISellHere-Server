package org.es.project.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7746145703361814193L;

	public UsernameAlreadyExistsException(){
		super("The username already exists!");
	}
}
