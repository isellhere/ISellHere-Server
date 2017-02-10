package org.es.project.repositories;


import org.es.project.models.Location;
import org.es.project.models.PointOfSale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PointOfSaleRepository extends CrudRepository<PointOfSale, Long>{
	
	@Query(value = "Select pointofsale from PointOfSale pointofsale where pointofsale.name=:name")
	public PointOfSale findByName(@Param("name") String name);
	
	@Query(value = "Select pointofsale from PointOfSale pointofsale where pointofsale.location=:location")
	public PointOfSale findByLocation(@Param("location") Location location);

	@Query(value = "Select pointofsale from PointOfSale pointofsale where pointofsale.name =: name"
			+ " and pointofsale.location =: location")
	public PointOfSale findByNameNLocation(@Param ("location") Location location, @Param ("name") String name);
}
