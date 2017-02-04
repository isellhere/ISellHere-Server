package org.es.project.repositories;


import org.es.project.models.Location;
import org.es.project.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Long>{
	@Query(value = "Select product from Product product where product.name=:name")
	public Product findByName(@Param("name") String name);
	
//	@Query(value = "Select product from Product product, PointOfSale pointofsale where product.pointOfSale=:pointofsale.id AND pointofsale.location=:location")
//	public Product findByLocation(@Param("location") Location location);
	
	@Query(value = "Select product from Product product where product.pointOfSale.location=:location")
	public Product findByLocation(@Param("location") Location location);
}
