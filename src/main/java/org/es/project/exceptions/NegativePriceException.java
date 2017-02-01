package org.es.project.exceptions;

public class NegativePriceException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3067898365960820725L;

	public NegativePriceException(){
		super("Invalid price: The desired price is negative");
	}
	
	

}
