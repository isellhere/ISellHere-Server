package org.es.project.exceptions;

import org.es.project.beans.RegistrationBean;
import org.es.project.models.User;

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
	
	public static void checkLoginBody(User requestBody){
		if (Validator.isEmpty(requestBody.getUsername())) {
			throw new InvalidRequestBodyException("Request without email or username.");
		}
		
		if (Validator.isEmpty(requestBody.getPassword())) {
			throw new InvalidRequestBodyException("Request without password.");
		}
	}
	
	public static void checkLoginSuccess(User requestBody, User dbUser) {
		if (Validator.isEmpty(dbUser) || !dbUser.getPassword().equals(requestBody.getPassword())) {
			throw new InvalidDataException("Invalid username or password.");
		}
	}

}
