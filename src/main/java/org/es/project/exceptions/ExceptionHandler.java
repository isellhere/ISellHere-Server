package org.es.project.exceptions;

import org.es.project.beans.RegistrationBean;

public class ExceptionHandler {
	
	public static void checkRegistrationBody(RegistrationBean body){
		if(Validator.isUsernameInvalid(body.getUsername())){
			throw new InvalidRegistrationBodyException("The username " + body.getUsername() + " is not valid");
		}
		
		if(Validator.isEmailInvalid(body.getEmail())){
			throw new InvalidRegistrationBodyException("The E-mail " + body.getEmail() + " is not valid");
		}
		
		checkPassword(body.getPassword());
		
	}
	
	public static void checkPassword(String password){
		if(Validator.isPasswordInvalid(password)){
			throw new InvalidRegistrationBodyException("Invalid Password");
		}
	}

}
