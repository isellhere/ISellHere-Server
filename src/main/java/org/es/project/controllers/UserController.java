package org.es.project.controllers;

import javax.servlet.ServletException;

import org.es.project.beans.EditUserBean;
import org.es.project.beans.RegistrationBean;
import org.es.project.beans.modelbeans.UserBean;
import org.es.project.exceptions.ExceptionHandler;
import org.es.project.exceptions.InvalidRegistrationBodyException;
import org.es.project.exceptions.Validator;
import org.es.project.models.User;
import org.es.project.services.implementations.UserServiceImpl;
import org.es.project.services.interfaces.UserService;
import org.es.project.util.ServerConstants;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(ServerConstants.USER_REQUEST)
public class UserController {
	
	private UserService userService;
	
	
	@RequestMapping(value = "/new", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserBean> createUser(@RequestBody RegistrationBean requestBody) throws ServletException{
		try{
			ExceptionHandler.checkRegistrationBody(requestBody);
			User newUser = new User(requestBody.getUsername(), requestBody.getEmail(), requestBody.getPassword());
			userService.save(newUser);
			return new ResponseEntity<UserBean>(newUser.createBean(), HttpStatus.CREATED);
			
		} catch(InvalidRegistrationBodyException irbe){
			throw new ServletException("An error has occurred: " +irbe.getMessage());
		}catch(DataAccessException dae){
			throw new ServletException("An error has occurred: " +dae.getMessage());
		}
	}
	
	@RequestMapping(value = "/get/{username}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserBean> getUser(@PathVariable String username){
		
		User dbUser = userService.findByUsername(username);
		ResponseEntity<UserBean> response;
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
	public ResponseEntity<UserBean> updateUser(@RequestBody User reqBody) {
		User updatedUser = userService.update(reqBody);

		if (updatedUser == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(updatedUser.createBean(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/edit", 
			method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserBean> editUser(@RequestBody EditUserBean reqBody) throws ServletException{
		try{
			ExceptionHandler.checkPassword(reqBody.getNewPassword());
			ExceptionHandler.checkPassword(reqBody.getOldPassword());
			ExceptionHandler.checkStringLength(reqBody.getNewPassword(), "New Password", 50);
			User dbUser = userService.findByUsername(reqBody.getUser());
			ExceptionHandler.checkUser(dbUser);
			ExceptionHandler.checkLoginSuccess(reqBody.getOldPassword(), dbUser);
			dbUser.setPassword(reqBody.getNewPassword());
			
			User updatedUser = userService.update(dbUser);
			
			return new ResponseEntity<UserBean>(updatedUser.createBean(), HttpStatus.OK);
		} catch(InvalidRegistrationBodyException irbe){
			throw new ServletException("An error has occurred: " +irbe.getMessage());
		} catch(DataAccessException dae){
			throw new ServletException("An error has occurred: " +dae.getMessage());
		}
	}
	
	@Autowired
	public void setUserService(UserServiceImpl userServiceImpl) {
		this.userService = userServiceImpl;
	}
	
	

}
