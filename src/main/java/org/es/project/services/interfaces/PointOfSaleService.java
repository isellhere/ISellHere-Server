package org.es.project.services.interfaces;

import org.es.project.models.Location;
import org.es.project.models.PointOfSale;

public interface PointOfSaleService {
	public Iterable<PointOfSale> findAll();
	public PointOfSale findById(Long id);
	public PointOfSale findByName(String name);
	public PointOfSale findByLocation(Location location);
	public PointOfSale save(PointOfSale pointOfSale);
	public PointOfSale delete(Long id);
	public PointOfSale update(PointOfSale pointOfSale);

}
