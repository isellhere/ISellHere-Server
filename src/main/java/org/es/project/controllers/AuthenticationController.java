package org.es.project.controllers;

import javax.servlet.ServletException;

import org.es.project.beans.AuthenticationResponse;
import org.es.project.exceptions.ExceptionHandler;
import org.es.project.models.User;
import org.es.project.services.implementations.UserServiceImpl;
import org.es.project.services.interfaces.UserService;
import org.es.project.util.ServerConstants;
import org.es.project.util.tokens.HS512_24Hours_Token;
import org.es.project.util.tokens.TokenBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ServerConstants.AUTHENTICATION_REQUEST)
public class AuthenticationController {
	
	private UserService userService;
	private TokenBuilder tokenBuilder;
	
	@RequestMapping(value = "/new",
			method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuthenticationResponse> login(@RequestBody User requestBody) throws ServletException {
		try {
			ExceptionHandler.checkLoginBody(requestBody);
			
			User dbUser = userService.findByUsername(requestBody.getUsername());
			
			ExceptionHandler.checkLoginSuccess(requestBody, dbUser);
			
			String token = tokenBuilder.build(dbUser);
			AuthenticationResponse response = new AuthenticationResponse(token, dbUser);
			
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch(RuntimeException e) {
			e.printStackTrace();
			throw new ServletException("Request error while trying to login... " + e.getMessage());
		}
	}
	
	@Autowired
	public void setUserService(UserServiceImpl userServiceImpl) {
		this.userService = userServiceImpl;
	}
	
	@Autowired
	public void setTokenBuilder(HS512_24Hours_Token tokenBuilder) {
		this.tokenBuilder = tokenBuilder;
	}
	

}
