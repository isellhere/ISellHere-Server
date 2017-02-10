package org.es.project.controllers;

import javax.servlet.ServletException;

import org.es.project.beans.EditUserBean;
import org.es.project.beans.RegistrationBean;
import org.es.project.exceptions.ExceptionHandler;
import org.es.project.exceptions.InvalidRegistrationBodyException;
import org.es.project.exceptions.Validator;
import org.es.project.models.User;
import org.es.project.services.interfaces.UserService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server/users")
public class UserController {
	
	private UserService userService;
	
	
	@RequestMapping(value = "/new", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@RequestBody RegistrationBean requestBody) throws ServletException{
		try{
			ExceptionHandler.checkRegistrationBody(requestBody);
			User newUser = new User(requestBody.getUsername(), requestBody.getEmail(), requestBody.getPassword());
			userService.save(newUser);
			return new ResponseEntity<>(newUser, HttpStatus.CREATED); // Vai ser http mesmo?
			
		} catch(InvalidRegistrationBodyException irbe){
			throw new ServletException("An error has occurred: " +irbe.getMessage());
		}catch(DataAccessException dae){
			throw new ServletException("An error has occurred: " +dae.getMessage());
		}
	}
	
	@RequestMapping(value = "/get/{username}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser(@PathVariable String username){
		
		User dbUser = userService.findByUsername(username);
		ResponseEntity<User> response;
		if(Validator.isEmpty(dbUser)){
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			response = new ResponseEntity<>(HttpStatus.OK);
		}
		
		return response;
	}
	
	@RequestMapping(value = "/update", 
			method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@RequestBody User reqBody) {
		User updatedUser = userService.update(reqBody);

		if (updatedUser == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/edit", 
			method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> editUser(@RequestBody EditUserBean reqBody) throws ServletException{
		try{
			ExceptionHandler.checkPassword(reqBody.getNewPassword());
			User dbUser = userService.findByUsername(reqBody.getUser().getUsername());
			dbUser.setPassword(reqBody.getNewPassword());
			
			User updatedUser = userService.update(dbUser);
			
			return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
		} catch(InvalidRegistrationBodyException irbe){
			throw new ServletException("An error has occurred: " +irbe.getMessage());
		} catch(DataAccessException dae){
			throw new ServletException("An error has occurred: " +dae.getMessage());
		}
	}
	
	

}
