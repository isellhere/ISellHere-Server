package org.es.project.controllers;

import java.util.List;

import javax.servlet.ServletException;

import org.es.project.beans.AddNDeleteProductBean;
import org.es.project.beans.AddNDeleteProductEvaluationBean;
import org.es.project.beans.DeleteProductBean;
import org.es.project.beans.EditProductBean;
import org.es.project.beans.GetProductBean;
import org.es.project.exceptions.ExceptionHandler;
import org.es.project.exceptions.InvalidDataException;
import org.es.project.exceptions.NotCreatorException;
import org.es.project.exceptions.Validator;
import org.es.project.models.Evaluation;
import org.es.project.models.Location;
import org.es.project.models.PointOfSale;
import org.es.project.models.Product;
import org.es.project.models.User;
import org.es.project.services.implementations.PointOfSaleServiceImpl;
import org.es.project.services.implementations.ProductServiceImpl;
import org.es.project.services.implementations.UserServiceImpl;
import org.es.project.services.interfaces.PointOfSaleService;
import org.es.project.services.interfaces.ProductService;
import org.es.project.services.interfaces.UserService;
import org.es.project.util.ServerConstants;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(ServerConstants.PRODUCT_REQUEST)
public class ProductController {

	private ProductService productService;
	private PointOfSaleService pointOfSaleService;
	private UserService userService;
	
	@RequestMapping(value = "/new", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> createProduct(@RequestBody AddNDeleteProductBean requestBody){
		User creator = userService.findByUsername(requestBody.getCreator());
		PointOfSale point = pointOfSaleService.findByName(requestBody.getPointOfSale());
		if(Validator.isEmpty(point)){
			throw new RuntimeException("Invalid point of sale");
		}
		if(Validator.isEmpty(creator)){
			throw new RuntimeException("Invalid Username");
		}
		
		for(Product product: point.getProducts()){
			if(product.getName().equals(requestBody.getProductName())){
				throw new RuntimeException("There is already a product with this name at this point of sale");
			}
		}
		Product newProduct = point.addProduct(creator, requestBody.getProductName(), requestBody.getProductPrice(), requestBody.getProductComment(), requestBody.getProductImage());
		
		productService.save(newProduct);
		
		return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/get",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProduct(@RequestBody GetProductBean requestBody){
		
		PointOfSale point = pointOfSaleService.findByName(requestBody.getPointName());
		for(Product product : point.getProducts()){
			if (product.getName().equals(requestBody.getProductName())){
				return new ResponseEntity<>(product, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}


	@RequestMapping(value = "/edit",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> editProduct(@RequestBody EditProductBean requestBody) throws ServletException{
		try{
			
			Product product = productService.findByName(requestBody.getSelectedProduct());
			if(Validator.isEmpty(product)){
				throw new RuntimeException("Invalid point");
			}
			
			User requester = userService.findByUsername(requestBody.getRequester());
			if(Validator.isEmpty(requester)){
				throw new RuntimeException("Invalid Username");
			}
			
			
			ExceptionHandler.checkEditProductBody(requestBody, requester, product);
			if(!product.getName().equals(requestBody.getProductName())){
				product.setName(requestBody.getProductName());
			}
			
			if(!product.getComment().equals(requestBody.getProductComment())){
				product.setComment(requestBody.getProductComment());
			}
			
			if(product.getPrice() != requestBody.getProductPrice()){
				product.setPrice(requestBody.getProductPrice());
			}
			
			if(!product.getImage().equals(requestBody.getProductImage())){
				product.setImage(requestBody.getProductImage());
			}
			
			Product updatedProduct = productService.update(product);
			
			if(updatedProduct == null){
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
			
		} catch(InvalidDataException ide){
			throw new ServletException("An error has occurred: " +ide.getMessage());
			
		}catch(NotCreatorException nce){
			throw new ServletException("An error has occurred: " +nce.getMessage());
			
		}catch(DataAccessException dae){
			throw new ServletException("An error has occurred: " + dae.getMessage());
		}  
	}
	
	@RequestMapping(value = "/delete",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> deleteProduct (@RequestBody DeleteProductBean requestBody) throws ServletException{
		try{
			
			Product productToBeDeleted = productService.findByName(requestBody.getProductName());
			if(Validator.isEmpty(productToBeDeleted)){
				throw new RuntimeException("Invalid point");
			}
			
			User requester = userService.findByUsername(requestBody.getRequester());
			if(Validator.isEmpty(requester)){
				throw new RuntimeException("Invalid Username");
			}
			
			if(!(requester.equals(productToBeDeleted.getCreator()) || requester.equals(productToBeDeleted.getPointOfSale().getCreator()))){
				throw new NotCreatorException();
			}
			
			productToBeDeleted.getPointOfSale().deleteProduct(productToBeDeleted.getName());
			Product deletedProduct = productService.delete(productToBeDeleted.getId());
			if(Validator.isEmpty(deletedProduct)){
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}else{
				return new ResponseEntity<>(deletedProduct, HttpStatus.OK);
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
	public ResponseEntity<Product> evaluateProduct(@RequestBody AddNDeleteProductEvaluationBean requestBody){
		
		User creator = userService.findByUsername(requestBody.getUser());
		Product product = productService.findByName(requestBody.getProduct());
		
		if(Validator.isEmpty(product)){
			throw new RuntimeException("Invalid Product");
		}
		if(Validator.isEmpty(creator)){
			throw new RuntimeException("Invalid Username");
		}
		if(requestBody.getComment().equals("")){
			product.addEvaluation(requestBody.getGrade(), requestBody.getUser());
		
		}else{
			product.addEvaluation(requestBody.getGrade(), requestBody.getComment(), requestBody.getUser());
		}
		return new ResponseEntity<>(product, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value = "/getEvaluations/{name}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Evaluation>> getEvaluation(@PathVariable String name){
		Product product = productService.findByName(name);
		
		if(Validator.isEmpty(product)){
			throw new RuntimeException("Invalid Product");
		}
		
		List<Evaluation> evaluations = product.getEvaluations();
		
		return new ResponseEntity<List<Evaluation>>(evaluations, HttpStatus.OK);
		
	}
	
	@Autowired
	public void setProductService(ProductServiceImpl productServiceImpl){
		this.productService = productServiceImpl;
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
