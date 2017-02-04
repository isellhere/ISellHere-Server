package org.es.project.services.implementations;

import org.es.project.models.Location;
import org.es.project.models.Product;
import org.es.project.repositories.ProductRepository;
import org.es.project.services.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;
	
	@Autowired
	public void setProductRepository(ProductRepository repository){
		this.productRepository = repository;
	}

	@Override
	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findById(Long id) {
		return productRepository.findOne(id);
	}

	@Override
	public Product findByName(String name) {
		return productRepository.findByName(name);
	}

	@Override
	public Product findByLocation(Location location) {
		return productRepository.findByLocation(location);
	}

	@Override
	public Product save(Product newProduct) {
		return productRepository.save(newProduct);
	}

	@Override
	public Product delete(Long id) {
		Product deletedProduct = findById(id);
		productRepository.delete(id);
		return deletedProduct;
	}

	@Override
	public Product update(Product product) {
		Product result = null;
		if(productRepository.findOne(product.getId()) != null){
			result = productRepository.save(product);
		}
		return result;
	}

}
