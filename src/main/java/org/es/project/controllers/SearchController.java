package org.es.project.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.es.project.models.Location;
import org.es.project.models.PointOfSale;
import org.es.project.models.Product;
import org.es.project.models.User;
import org.es.project.services.implementations.PointOfSaleServiceImpl;
import org.es.project.services.implementations.ProductServiceImpl;
import org.es.project.services.interfaces.PointOfSaleService;
import org.es.project.services.interfaces.ProductService;
import org.es.project.util.search.SearchTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server/search")
public class SearchController {
	
	private ProductService productService;
	private PointOfSaleService pointOfSaleService;
	
	
	@RequestMapping(value = "/searchpoint/name={name}&latitude={latitude}&longitude={longitude}&ray={ray}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PointOfSale>> searchPointOfSale(@PathVariable String name, @PathVariable Double latitude, @PathVariable Double longitude, @PathVariable Integer ray){
		Location currentLocation = new Location(longitude, latitude);
		List<PointOfSale> points = SearchTool.searchPointOfSale(name, currentLocation, ray, pointOfSaleService);
		return new ResponseEntity<List<PointOfSale>>(points, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/searchproductinpoint/productname={productname}&pointname={pointname}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> searchProductInPoint(@PathVariable String productname, @PathVariable String pointname) throws ServletException{
		try{
			PointOfSale point = pointOfSaleService.findByName(pointname);
			List<Product> products = SearchTool.searchProductInPoint(point, productname);
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		}catch(DataAccessException dae){
			throw new ServletException("An error has occurred: " +dae.getMessage());
		}
		
	}
	
	@RequestMapping(value = "/searchproductgeneral/name={name}&latitude={latitude}&longitude={longitude}&ray={ray}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> searchProductGeneral(@PathVariable String name, @PathVariable Double latitude, @PathVariable Double longitude, @PathVariable Integer ray){
		Location currentLocation = new Location(longitude, latitude);
		List<Product> points = SearchTool.searchProductGeneral(name, currentLocation, ray, productService);
		return new ResponseEntity<List<Product>>(points, HttpStatus.OK);
	}
	
	
	@Autowired
	public void setProductService(ProductServiceImpl productServiceImpl) {
		this.productService = productServiceImpl;
	}
	
	@Autowired
	public void setPointOfSaleService(PointOfSaleServiceImpl pointOfSaleServiceImpl) {
		this.pointOfSaleService = pointOfSaleServiceImpl;
	}

}
