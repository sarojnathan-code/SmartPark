package com.airtribe.smartpark.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class RateCard {
	
	@Id
	@GeneratedValue
	private Long rateCardId;
	
	private VehicleType vehicleType;
	
	private Double ratePerHour;

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Double getRatePerHour() {
		return ratePerHour;
	}

	public void setRatePerHour(Double ratePerHour) {
		this.ratePerHour = ratePerHour;
	}

	public RateCard(VehicleType vehicleType, Double ratePerHour) {
		super();
		this.vehicleType = vehicleType;
		this.ratePerHour = ratePerHour;
	}

	public RateCard() {
		super();
	}
	
	
	

}
