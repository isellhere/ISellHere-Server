package org.es.project.controllers;

import java.util.List;

import javax.servlet.ServletException;

import org.es.project.beans.GeneralSearchBean;
import org.es.project.beans.modelbeans.PointOfSaleBean;
import org.es.project.beans.modelbeans.ProductBean;
import org.es.project.models.Location;
import org.es.project.models.PointOfSale;
import org.es.project.services.implementations.PointOfSaleServiceImpl;
import org.es.project.services.implementations.ProductServiceImpl;
import org.es.project.services.interfaces.PointOfSaleService;
import org.es.project.services.interfaces.ProductService;
import org.es.project.util.ServerConstants;
import org.es.project.util.search.SearchTool;
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
@RequestMapping(ServerConstants.SEARCH_REQUEST)
public class SearchController {
	
	private ProductService productService;
	private PointOfSaleService pointOfSaleService;
	
	
	@RequestMapping(value = "/searchpoint", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PointOfSaleBean>> searchPointOfSale(@RequestBody GeneralSearchBean requestBody){
		Location currentLocation = new Location(requestBody.getLongitude(), requestBody.getLatitude());
		List<PointOfSaleBean> points = SearchTool.searchPointOfSale(requestBody.getName(), currentLocation, requestBody.getRay(), pointOfSaleService.findAll());
		return new ResponseEntity<List<PointOfSaleBean>>(points, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/searchproductinpoint", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductBean>> searchProductInPoint(@PathVariable String productname, @PathVariable String pointname) throws ServletException{
		try{
			PointOfSale point = pointOfSaleService.findByName(pointname);
			List<ProductBean> products = SearchTool.searchProductInPoint(point, productname);
			return new ResponseEntity<List<ProductBean>>(products, HttpStatus.OK);
		}catch(DataAccessException dae){
			throw new ServletException("An error has occurred: " +dae.getMessage());
		}
		
	}
	
	@RequestMapping(value = "/searchproductgeneral", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductBean>> searchProductGeneral(@RequestBody GeneralSearchBean requestBody){
		Location currentLocation = new Location(requestBody.getLongitude(), requestBody.getLatitude());
		List<ProductBean> points = SearchTool.searchProductGeneral(requestBody.getName(), currentLocation, requestBody.getRay(), productService.findAll(), pointOfSaleService);
		return new ResponseEntity<List<ProductBean>>(points, HttpStatus.OK);
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
