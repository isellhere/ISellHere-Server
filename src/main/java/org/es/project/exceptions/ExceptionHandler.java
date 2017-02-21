package org.es.project.exceptions;

import org.es.project.beans.EditPointOfSaleBean;
import org.es.project.beans.EditProductBean;
import org.es.project.beans.LoginBean;
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
	
	public static void checkLoginBody(LoginBean requestBody){
		if (Validator.isEmpty(requestBody.getUsername())) {
			throw new InvalidRequestBodyException("Request without email or username.");
		}
		
		if (Validator.isEmpty(requestBody.getPassword())) {
			throw new InvalidRequestBodyException("Request without password.");
		}
	}
	
	public static void checkLoginSuccess(LoginBean requestBody, User dbUser) {
		if (Validator.isEmpty(dbUser) || !dbUser.getPassword().equals(requestBody.getPassword())) {
			throw new InvalidDataException("Invalid username or password.");
		}
	}
	
	public static void checkEditPointOfSaleBody(EditPointOfSaleBean requestBody){
		if(requestBody.getRequester() == null || 
				requestBody.getSelectedPoint() == null ||
				requestBody.getPointComment() == null ||
				requestBody.getPointName() == null){
			throw new InvalidDataException("One of the fields is null");
		}
		if(!requestBody.getRequester().equals(requestBody.getSelectedPoint().getCreator())){
			throw new NotCreatorException();
		}
			
	}
	
	public static void checkEditProductBody(EditProductBean body){
		if(body.getRequester() == null ||
				body.getProductName() == null 
				|| body.getSelectedProduct() == null 
				|| body.getProductComment() == null 
				|| body.getProductImage() == null
				|| body.getProductPrice() <= 0){
			
			throw new InvalidDataException("One of the fields is null");
		}
		
		if(!(body.getRequester().equals(body.getSelectedProduct().getCreator()) || body.getRequester().equals(body.getSelectedProduct().getPointOfSale().getCreator()))){
			throw new NotCreatorException();
		}
		
	}

}
