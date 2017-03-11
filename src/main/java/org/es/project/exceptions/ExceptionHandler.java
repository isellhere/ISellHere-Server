package org.es.project.exceptions;

import org.es.project.beans.AddPointOfSaleBean;
import org.es.project.beans.AddProductBean;
import org.es.project.beans.EditPointOfSaleBean;
import org.es.project.beans.EditProductBean;
import org.es.project.beans.LoginBean;
import org.es.project.beans.RegistrationBean;
import org.es.project.models.PointOfSale;
import org.es.project.models.Product;
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
		checkStringLength(body.getUsername(), "Username", 30);
		checkStringLength(body.getPassword(), "Password", 50);
		checkStringLength(body.getEmail(), "Email", 100);
		
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
	
	public static void checkLoginSuccess(String password, User dbUser) {
		if (Validator.isEmpty(dbUser) || !dbUser.getPassword().equals(password)) {
			throw new InvalidDataException("Invalid username or password.");
		}
	}
	
	public static void checkEditPointOfSaleBody(EditPointOfSaleBean requestBody, User requester, PointOfSale point){
		if(requestBody.getRequester() == null || 
				requestBody.getSelectedPoint() == null ||
				requestBody.getPointComment() == null ||
				requestBody.getPointName() == null){
			throw new InvalidDataException("One of the fields is null");
		}
		if(!requester.equals(point.getCreator())){
			throw new NotCreatorException();
		}
		checkStringLength(requestBody.getPointName(), "Point Name", 50);
		checkStringLength(requestBody.getPointComment(), "Comment", 200);
		
			
	}
	
	public static void checkEditProductBody(EditProductBean body, User requester, Product product){
		if(body.getRequester() == null ||
				body.getProductName() == null 
				|| body.getSelectedProduct() == null 
				|| body.getProductComment() == null 
				|| body.getProductImage() == null){
			
			throw new InvalidDataException("One of the fields is null");
		}
		
		if(body.getProductPrice() < 0){
			
			throw new InvalidDataException("Price can not be negative");
		}
		
		checkStringLength(body.getProductName(), "Product Name", 50);
		checkStringLength(body.getProductComment(), "Comment", 200);
	}
	
	public static void checkUserPermission(User user, PointOfSale point){
		if(!point.getCreator().equals(user)) throw new NotCreatorException();
	}
	
	public static void checkUserPermission(User user, Product product){
		if(!(product.getCreator().equals(user) || product.getPointOfSale().getCreator().equals(user))) throw new NotCreatorException();
	}
		
	public static void checkAddProductBody(AddProductBean body){
			if(body.getCreator() == null ||
					body.getProductName() == null 
					|| body.getProductComment() == null 
					|| body.getProductImage() == null){
				
				throw new InvalidDataException("One of the fields is null");
			}
			
			
			if(body.getProductPrice() < 0){
				
				throw new InvalidDataException("Price can not be negative");
			}
			
			checkStringLength(body.getProductName(), "Product Name", 50);
			checkStringLength(body.getProductComment(), "Comment", 200);
	}
	
	public static void checkUser(User user){
		if(Validator.isEmpty(user)){
			throw new InvalidDataException("User not found");
		}
	}
	
	public static void checkPointOfSale(PointOfSale point){
		if(Validator.isEmpty(point)){
			throw new InvalidDataException("Point not found");
		}
	}
	
	public static void checkProduct(Product product){
		if(Validator.isEmpty(product)){
			throw new InvalidDataException("Product not found");
		}
	}
	
	public static void checkProductExistence(PointOfSale point, String productName){
		for(Product product: point.getProducts()){
			if(product.getName().equals(productName)){
				throw new RuntimeException("There is already a product with this name at this point of sale");
			}
		}
	}
	
	public static void checkNewPointOfSale(AddPointOfSaleBean bean){
		if(Validator.isEmpty(bean.getPointName())){
			throw new RuntimeException("Invalid name");
		}
		checkStringLength(bean.getPointName(), "Point Name", 50);
		checkStringLength(bean.getPointComment(), "Comment", 200);
	}
	
	public static void checkStringLength(String name, String field, int num){
		if(name.length() > num){
			throw new RuntimeException(field+ " can't have more than " +num+ " characters");
		}
	}
	
	

}
