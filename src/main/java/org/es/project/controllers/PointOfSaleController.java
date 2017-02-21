package org.es.project.controllers;

import javax.servlet.ServletException;

import org.es.project.beans.AddNDeletePointOfSaleBean;
import org.es.project.beans.DeletePointOfSaleBean;
import org.es.project.beans.EditPointOfSaleBean;
import org.es.project.beans.GetPointOfSaleBean;
import org.es.project.exceptions.ExceptionHandler;
import org.es.project.exceptions.InvalidDataException;
import org.es.project.exceptions.NotCreatorException;
import org.es.project.exceptions.Validator;
import org.es.project.models.Location;
import org.es.project.models.PointOfSale;
import org.es.project.models.User;
import org.es.project.services.implementations.PointOfSaleServiceImpl;
import org.es.project.services.implementations.UserServiceImpl;
import org.es.project.services.interfaces.PointOfSaleService;
import org.es.project.services.interfaces.UserService;
import org.es.project.util.ServerConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(ServerConstants.POINT_OF_SALE_REQUEST)
public class PointOfSaleController {
	
	private PointOfSaleService pointOfSaleService;
	private UserService userService;
	
	@RequestMapping(value = "/new", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PointOfSale> createPointOfSale(@RequestBody AddNDeletePointOfSaleBean requestBody) throws ServletException{
		PointOfSale point = pointOfSaleService.findByLocation(new Location(requestBody.getPointLongitude(), requestBody.getPointLatitude()));
		if(!Validator.isEmpty(point)){
			throw new RuntimeException("There is already a point at this location");
		}
		User creator = userService.findByUsername(requestBody.getCreator());
		if(Validator.isEmpty(creator)){
			throw new RuntimeException("Invalid Username");
		}
		PointOfSale newPoint = new PointOfSale(creator, requestBody.getPointName(),
				requestBody.getPointLongitude(), requestBody.getPointLatitude(), requestBody.getPointComment(),
				requestBody.getPointImage());
		
		pointOfSaleService.save(newPoint);
		return new ResponseEntity<>(newPoint, HttpStatus.CREATED); 
	}
		
	@RequestMapping(value = "/get",
					method = RequestMethod.POST,
			        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PointOfSale> getPointOfSaleByLocation(@RequestBody GetPointOfSaleBean requestBody){
	
		PointOfSale point = pointOfSaleService.findByNameNLocation(requestBody.getLocation(), requestBody.getPointName());
		ResponseEntity<PointOfSale> result;
		
		if(Validator.isEmpty(point)){
			result = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			result = new ResponseEntity<>(point, HttpStatus.OK);
		}
		
		return result;
	}
	
	@RequestMapping(value = "/edit",
					method = RequestMethod.PUT,
					consumes = MediaType.APPLICATION_JSON_VALUE,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PointOfSale> editPointOfSale(@RequestBody EditPointOfSaleBean requestBody) throws ServletException{
		try{
			ExceptionHandler.checkEditPointOfSaleBody(requestBody);
			PointOfSale point = pointOfSaleService.findByName(requestBody.getSelectedPoint().getName());
			if(!point.getName().equals(requestBody.getPointName())){
				point.setName(requestBody.getPointName());
			}
			if(!point.getComment().equals(requestBody.getPointComment())){
				point.setComment(requestBody.getPointComment());
			}
			if(!point.getImage().equals(requestBody.getPointImage())){
				point.setImage(requestBody.getPointImage());
			}
			
			PointOfSale updatedPoint = pointOfSaleService.update(point);			
			if (updatedPoint == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(updatedPoint, HttpStatus.OK);
			
		} catch(InvalidDataException ide){
			throw new ServletException("An error has occurred: " +ide.getMessage());
		}catch(NotCreatorException nce){
			throw new ServletException("An error has occurred: " +nce.getMessage());
		}catch(DataAccessException dae){
			throw new ServletException("An error has occurred: " +dae.getMessage());
		}  
		
	}
	
	@RequestMapping(value = "/delete",
			method = RequestMethod.DELETE,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PointOfSale> deletePointOfSale(@RequestBody DeletePointOfSaleBean requestBody) throws ServletException{
		try{
			PointOfSale pointToBeDeleted = pointOfSaleService.findByName(requestBody.getPointName());
			if(!requestBody.getRequester().equals(pointToBeDeleted.getCreator())) throw new NotCreatorException();
			
			PointOfSale deletedPoint = pointOfSaleService.delete(pointToBeDeleted.getId());
			if(Validator.isEmpty(deletedPoint)){
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
			}else{
				return new ResponseEntity<>(deletedPoint, HttpStatus.OK);
			}
		}catch(NotCreatorException nce){
			throw new ServletException("An error has occurred: " + nce.getMessage());
		}catch(DataAccessException dae){
			throw new ServletException("An error has occurred: " + dae.getMessage());
		}  
		
	}
		
		
	
	@Autowired
	public void setPointOfSaleService(PointOfSaleServiceImpl pointOfSaleServiceImpl) {
		this.pointOfSaleService = pointOfSaleServiceImpl;
	}
	
	@Autowired
	public void setUserService(UserServiceImpl userServiceImpl) {
		this.userService = userServiceImpl;
	}
}
