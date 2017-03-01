package org.es.project.util.search;

import java.util.ArrayList;
import java.util.List;

import org.es.project.beans.modelbeans.ProductBean;
import org.es.project.models.Location;
import org.es.project.models.PointOfSale;
import org.es.project.models.Product;
import org.es.project.services.interfaces.PointOfSaleService;
import org.es.project.services.interfaces.ProductService;

public class SearchTool {
	
	
	
	public static List<PointOfSale> searchPointOfSale(String name, Location location, Integer ray, PointOfSaleService pointOfSaleService){
		List<PointOfSale> result = new ArrayList<>();
		Iterable<PointOfSale> allPoints = pointOfSaleService.findAll();
		for(PointOfSale point: allPoints){
			if(distance(location.getLatitude(), location.getLongitude(), point.getLatitude(), point.getLongitude()) <= ray){
				String searchingName = name.toLowerCase();
				String pointName = point.getName().toLowerCase();
				if(pointName.contains(searchingName)){
					result.add(point);
				}
			}
		}
		return result;
	}
	
	public static List<ProductBean> searchProductInPoint(PointOfSale point, String name){
		List<ProductBean> result = new ArrayList<>();
		List<Product> productsInPoint = point.getProducts();
		for(Product product : productsInPoint){
			String searchingName = name.toLowerCase();
			String productName = product.getName().toLowerCase();
			if(productName.contains(searchingName)){
				result.add(product.createBean());
			}
		}
		return result;
	}
	
	public static List<Product> searchProductGeneral(String name, Location location, Integer ray, ProductService productService){
		List<Product> result = new ArrayList<>();
		Iterable<Product> allProducts = productService.findAll();
		for(Product product : allProducts){
			if(distance(location.getLatitude(), location.getLongitude(), product.getPointOfSale().getLatitude(), product.getPointOfSale().getLongitude()) <= ray){
				String searchingName = name.toLowerCase();
				String productName = product.getName().toLowerCase();
				if(productName.contains(searchingName)){
					result.add(product);
				}
			}
		}
		return result;
	}
	
	
	//http://www.geodatasource.com/developers/java
	
	private static double distance(double lat1, double lon1, double lat2, double lon2) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		dist = dist * 1.609344; //Convert to KM
		return (dist);
	}
	
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::	This function converts decimal degrees to radians						 :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::	This function converts radians to decimal degrees						 :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}

}
