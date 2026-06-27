package com.airtribe.smartpark.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class ParkingSpaceId {
	
	private Long parkingSpaceNumber;
	
	private Long floorNumber;

}
