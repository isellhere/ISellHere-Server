package org.es.project.exceptions;

public class NotCreatorException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8038073340560302459L;
	
	public NotCreatorException(){
		super("Can't do that, you are not the creator!"); //essa mensagem ta ruim, precisa melhorar
	}

}
