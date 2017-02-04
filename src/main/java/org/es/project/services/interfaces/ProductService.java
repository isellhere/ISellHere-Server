package org.es.project.services.interfaces;


import org.es.project.models.Location;
import org.es.project.models.Product;

public interface ProductService {
	public Iterable<Product> findAll();
	public Product findById(Long id);
	public Product findByName(String name);
	public Product findByLocation(Location location);
	public Product save(Product newProduct);
	public Product delete(Long id);
	public Product update(Product product);
}
