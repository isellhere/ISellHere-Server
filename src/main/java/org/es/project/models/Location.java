package org.es.project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location {
	@Id
	@GeneratedValue
	private Long id;
	
	private double longitude;
	private double latitude;
	
	public Location(double longitude, double latitude){
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getLatitude() {
		return latitude;
	}
	public Long getId(){
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Location)){
			return false;
		}
		Location other = (Location) obj;
		if(Double.doubleToLongBits(longitude) == Double.doubleToLongBits(other.getLongitude()) && 
				Double.doubleToLongBits(latitude) == Double.doubleToLongBits(other.getLatitude())){
			return true;
		}else{
			return false;
		}
	}

}
