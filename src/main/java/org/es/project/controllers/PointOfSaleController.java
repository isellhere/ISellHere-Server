package org.es.project.controllers;

import javax.servlet.ServletException;

import org.es.project.beans.AddNDeletePointOfSaleBean;
import org.es.project.beans.EditPointOfSaleBean;
import org.es.project.beans.SearchPointOfSaleBean;
import org.es.project.exceptions.Validator;
import org.es.project.models.PointOfSale;
import org.es.project.services.interfaces.PointOfSaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/pointofsale")

public class PointOfSaleController {
	private PointOfSaleService pointOfSaleService;
	
	@RequestMapping(value = "/new", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<PointOfSale> createPointOfSale(@RequestBody AddNDeletePointOfSaleBean requestBody) throws ServletException{
	
		PointOfSale newPoint = new PointOfSale(requestBody.getCreator(), requestBody.getPointName(),
				requestBody.getPointLongitude(), requestBody.getPointLatitude(), requestBody.getPointComment(),
				requestBody.getPointImage());
		
		pointOfSaleService.save(newPoint);
		return new ResponseEntity<>(newPoint, HttpStatus.CREATED); 
	}
	
	
	@RequestMapping(value = "/get",
					method = RequestMethod.POST,
			        produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<PointOfSale> getPointOfSaleByLocation(@RequestBody SearchPointOfSaleBean requestBody){
	
		PointOfSale point = pointOfSaleService.findByNameNLocation(requestBody.getLocation(), requestBody.getPointName());
		ResponseEntity<PointOfSale> result;
		
		if(Validator.isEmpty(point)){
			result = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			result = new ResponseEntity<>(HttpStatus.OK);
		}
		
		return result;
	}
	
	@RequestMapping(value = "/edit",
					method = RequestMethod.PUT,
					consumes = MediaType.APPLICATION_JSON_VALUE,
					produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<PointOfSale> editPointOfSale(@RequestBody EditPointOfSaleBean requestBody){
		
		PointOfSale updatedPoint = pointOfSaleService.update(new PointOfSale(requestBody.getCreator(), requestBody.getPointName(),
				requestBody.getPointLongitude(), requestBody.getPointLatitude(), requestBody.getPointComment(), 
				requestBody.getPointImage()));
		
		if (updatedPoint == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(updatedPoint, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/delete/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<PointOfSale> deletePointOfSale(@PathVariable Long id){
		
		PointOfSale deletedPoint = pointOfSaleService.delete(id);
		
		if(Validator.isEmpty(deletedPoint)){
			return new ResponseEntity<>(deletedPoint, HttpStatus.NOT_FOUND);
		
		}else{
			
			return new ResponseEntity<>(deletedPoint, HttpStatus.OK);
		}
}
	
	
}
