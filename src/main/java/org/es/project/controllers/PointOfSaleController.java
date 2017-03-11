package org.es.project.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.es.project.beans.AddPointOfSaleBean;
import org.es.project.beans.AddPointOfSaleEvaluationBean;
import org.es.project.beans.DeletePointOfSaleBean;
import org.es.project.beans.EditPointOfSaleBean;
import org.es.project.beans.GetPointOfSaleBean;
import org.es.project.beans.modelbeans.PointOfSaleBean;
import org.es.project.exceptions.ExceptionHandler;
import org.es.project.exceptions.InvalidDataException;
import org.es.project.exceptions.NotCreatorException;
import org.es.project.exceptions.Validator;
import org.es.project.models.Evaluation;
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
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<PointOfSaleBean> createPointOfSale(@RequestBody AddPointOfSaleBean requestBody) throws ServletException{
		User creator = userService.findByUsername(requestBody.getCreator());
		ExceptionHandler.checkUser(creator);
		PointOfSale newPoint = new PointOfSale(creator, requestBody.getPointName(),
				requestBody.getPointLongitude(), requestBody.getPointLatitude(), requestBody.getPointComment(),
				requestBody.getPointImage());
		
		pointOfSaleService.save(newPoint);
		return new ResponseEntity<>(newPoint.createBean(), HttpStatus.CREATED); 
	}
		
	@RequestMapping(value = "/get",
					method = RequestMethod.POST,
					consumes = MediaType.APPLICATION_JSON_VALUE,
			        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PointOfSaleBean> getPointOfSaleByLocation(@RequestBody GetPointOfSaleBean requestBody){
		//Location location = new Location(requestBody.getLongitude(), requestBody.getLatitude());
		PointOfSale point = pointOfSaleService.findByName(requestBody.getPointName());
		ResponseEntity<PointOfSaleBean> result;
		
		if(Validator.isEmpty(point)){
			result = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			result = new ResponseEntity<>(point.createBean(), HttpStatus.OK);
		}
		
		return result;
	}
	
	@RequestMapping(value = "/edit",
					method = RequestMethod.PUT,
					consumes = MediaType.APPLICATION_JSON_VALUE,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PointOfSaleBean> editPointOfSale(@RequestBody EditPointOfSaleBean requestBody) throws ServletException{
		try{
			
			PointOfSale point = pointOfSaleService.findByName(requestBody.getSelectedPoint());
			ExceptionHandler.checkPointOfSale(point);
			User requester = userService.findByUsername(requestBody.getRequester());
			ExceptionHandler.checkUser(requester);
			
			ExceptionHandler.checkEditPointOfSaleBody(requestBody, requester, point);
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
			
			return new ResponseEntity<>(updatedPoint.createBean(), HttpStatus.OK);
			
		} catch(InvalidDataException ide){
			throw new ServletException("An error has occurred: " +ide.getMessage());
		}catch(NotCreatorException nce){
			throw new ServletException("An error has occurred: " +nce.getMessage());
		}catch(DataAccessException dae){
			throw new ServletException("An error has occurred: " +dae.getMessage());
		}  
		
	}
	
	@RequestMapping(value = "/delete",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PointOfSaleBean> deletePointOfSale(@RequestBody DeletePointOfSaleBean requestBody) throws ServletException{
		try{
			PointOfSale pointToBeDeleted = pointOfSaleService.findByName(requestBody.getPointName());
			ExceptionHandler.checkPointOfSale(pointToBeDeleted);
			User requester = userService.findByUsername(requestBody.getRequester());
			ExceptionHandler.checkUser(requester);
			ExceptionHandler.checkUserPermission(requester, pointToBeDeleted);
			
			PointOfSale deletedPoint = pointOfSaleService.delete(pointToBeDeleted.getId());
			if(Validator.isEmpty(deletedPoint)){
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
			}else{
				return new ResponseEntity<>(deletedPoint.createBean(), HttpStatus.OK);
			}
		}catch(NotCreatorException nce){
			throw new ServletException("An error has occurred: " + nce.getMessage());
		}catch(DataAccessException dae){
			throw new ServletException("An error has occurred: " + dae.getMessage());
		}  
		
	}
		
	@RequestMapping(value =  "/evaluate",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PointOfSaleBean> evaluatePointOfSale(@RequestBody AddPointOfSaleEvaluationBean requestBody){
		
		User creator = userService.findByUsername(requestBody.getUser());
		PointOfSale point = pointOfSaleService.findByName(requestBody.getPoint());
		
		ExceptionHandler.checkPointOfSale(point);
		ExceptionHandler.checkUser(creator);
		
		point.addEvaluation(requestBody.getGrade(), requestBody.getComment(), requestBody.getUser());
		
		return new ResponseEntity<>(point.createBean(), HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value = "/getEvaluations/{name}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Evaluation>> getEvaluation(@PathVariable String name){
		PointOfSale point = pointOfSaleService.findByName(name);
		
		ExceptionHandler.checkPointOfSale(point);
		
		List<Evaluation> evaluations = point.getEvaluations();
		
		return new ResponseEntity<List<Evaluation>>(evaluations, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/getAllPoints",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PointOfSaleBean>> getAllPoints(){
		
		List<PointOfSaleBean> allPoints = new ArrayList<>();
		for(PointOfSale point : pointOfSaleService.findAll()){
			allPoints.add(point.createBean());
		}
		
		return new ResponseEntity<List<PointOfSaleBean>>(allPoints, HttpStatus.OK);
		
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
