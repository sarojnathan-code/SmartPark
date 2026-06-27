package com.airtribe.smartpark.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class ParkingSpace {
	
	@EmbeddedId
	private ParkingSpaceId parkingSpaceId;
	
	private boolean occupied;
	
	private VehicleType parkingType;
	
	@OneToOne
	private Vehicle vehicle;

	public ParkingSpaceId getParkingSpaceId() {
		return parkingSpaceId;
	}

	public void setParkingSpaceId(ParkingSpaceId parkingSpaceId) {
		this.parkingSpaceId = parkingSpaceId;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public VehicleType getParkingType() {
		return parkingType;
	}

	public void setParkingType(VehicleType parkingType) {
		this.parkingType = parkingType;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public ParkingSpace(ParkingSpaceId parkingSpaceId, boolean occupied, VehicleType parkingType, Vehicle vehicle) {
		super();
		this.parkingSpaceId = parkingSpaceId;
		this.occupied = occupied;
		this.parkingType = parkingType;
		this.vehicle = vehicle;
	}

	public ParkingSpace() {
		super();
	}
	
	

}
