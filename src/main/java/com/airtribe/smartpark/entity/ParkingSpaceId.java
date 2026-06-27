package com.airtribe.smartpark.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class ParkingSpaceId {
	
	private Long parkingSpaceNumber;
	
	private Long floorNumber;

	public Long getParkingSpaceNumber() {
		return parkingSpaceNumber;
	}

	public void setParkingSpaceNumber(Long parkingSpaceNumber) {
		this.parkingSpaceNumber = parkingSpaceNumber;
	}

	public Long getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(Long floorNumber) {
		this.floorNumber = floorNumber;
	}
	
	

}
