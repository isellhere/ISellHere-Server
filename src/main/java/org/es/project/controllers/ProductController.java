package org.es.project.controllers;

import org.es.project.beans.AddNDeleteProductBean;
import org.es.project.beans.EditProductBean;
import org.es.project.beans.SearchProductBean;
import org.es.project.exceptions.Validator;
import org.es.project.models.Product;
import org.es.project.services.implementations.ProductServiceImpl;
import org.es.project.services.interfaces.ProductService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/server/products")

public class ProductController {

	private ProductService productService;
	
	@RequestMapping(value = "/new", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> createProduct(@RequestBody AddNDeleteProductBean requestBody){
		Product newProduct = new Product(requestBody.getCreator(), requestBody.getPointOfSale(), requestBody.getProductName(),
				requestBody.getProductPrice(), requestBody.getProductComment(), requestBody.getProductImage());
		
		productService.save(newProduct);
		
		return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/get",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProductByName(@RequestBody SearchProductBean requestBody){
		
		Product product = productService.findByNameNLocation(requestBody.getLocation(), requestBody.getProductName());
		
		if(Validator.isEmpty(product)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		}else{
			return new ResponseEntity<>(product, HttpStatus.OK);
		}
	}


	@RequestMapping(value = "/edit",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> editProduct(@RequestBody EditProductBean requestBody){
		Product updatedProduct = productService.update(new Product(requestBody.getCreator(), requestBody.getPointOfSale(), requestBody.getProductName(),
				requestBody.getProductPrice(), requestBody.getProductComment(), requestBody.getProductImage()));
		
		if(updatedProduct == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> deleteProduct (@PathVariable Long id){
		Product deletedProduct = productService.delete(id);
		if(Validator.isEmpty(deletedProduct)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}else{
			return new ResponseEntity<>(deletedProduct, HttpStatus.OK);
		}
	}
	
	@Autowired
	public void setProductService(ProductServiceImpl productServiceImpl){
		this.productService = productServiceImpl;
	}
	
}
