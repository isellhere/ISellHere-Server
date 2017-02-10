package org.es.project.services.implementations;

import org.es.project.models.Location;
import org.es.project.models.PointOfSale;
import org.es.project.repositories.PointOfSaleRepository;
import org.es.project.services.interfaces.PointOfSaleService;
import org.springframework.beans.factory.annotation.Autowired;

public class PointOfSaleServiceImpl implements PointOfSaleService{
	
	private PointOfSaleRepository pointOfSaleRepository;
	
	@Autowired
	public void setPointOfSaleRepository(PointOfSaleRepository repository){
		this.pointOfSaleRepository = repository;
	}
	
	@Override
	public Iterable<PointOfSale> findAll() {
		return pointOfSaleRepository.findAll();
	}

	@Override
	public PointOfSale findById(Long id) {
		return pointOfSaleRepository.findOne(id);
	}

	@Override
	public PointOfSale findByName(String name) {
		return pointOfSaleRepository.findByName(name);
	}

	@Override
	public PointOfSale findByLocation(Location location) {
		return pointOfSaleRepository.findByLocation(location);
	}

	@Override
	public PointOfSale save(PointOfSale pointOfSale) {
		return pointOfSaleRepository.save(pointOfSale);
	}

	@Override
	public PointOfSale delete(Long id) {
		PointOfSale deletedPointOfSale = findById(id);
		pointOfSaleRepository.delete(id);
		return deletedPointOfSale;
	}

	@Override
	public PointOfSale update(PointOfSale pointOfSale) {
		PointOfSale result = null;
		if(pointOfSaleRepository.findOne(pointOfSale.getId()) != null){
			result = pointOfSaleRepository.save(pointOfSale);
		}
		return result;
	}

	@Override
	public PointOfSale findByNameNLocation(Location location, String name) {
		return pointOfSaleRepository.findByNameNLocation(location, name);
	}

}
