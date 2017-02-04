package org.es.project.controllers;

import javax.servlet.ServletException;

import org.es.project.beans.RegistrationBean;
import org.es.project.exceptions.Validator;
import org.es.project.models.User;
import org.es.project.services.interfaces.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("TO_BE_DEFINED")
public class UserController {
	
	private UserService userService;
	
	
	@RequestMapping(value = "/new", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@RequestBody RegistrationBean requestBody) throws ServletException{
		//Falta try-catch e checagem de excecao
		User newUser = new User(requestBody.getUsername(), requestBody.getEmail(), requestBody.getPassword());
		userService.save(newUser);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED); // Vai ser http mesmo?
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
	
	

}
