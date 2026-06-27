package com.airtribe.smartpark.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airtribe.smartpark.entity.ParkingSpace;
import com.airtribe.smartpark.entity.RateCard;
import com.airtribe.smartpark.entity.Vehicle;
import com.airtribe.smartpark.repository.ParkingSpaceRepository;
import com.airtribe.smartpark.repository.RateCardRepository;

@Service
public class ParkingAllotmentService {
	
	@Autowired
	private ParkingSpaceRepository parkingSpaceRepository;
	
	@Autowired
	private RateCardRepository rateCardRepository;
	
	private void checkin(Vehicle vehicle) {
		vehicle.setStartTime(LocalDateTime.now());
	}
	
	private void checkOut(Vehicle vehicle) {
		vehicle.setEndTime(LocalDateTime.now());
	}
	
	public ParkingSpace allocateParking(Vehicle vehicle) {
		checkin(vehicle);
		Optional<ParkingSpace> parkingSpace = parkingSpaceRepository.findByParkingTypeAndOccupiedFalse(vehicle.getVehicleType());
		ParkingSpace returnedParkingSpace = parkingSpace.get();
		returnedParkingSpace.setVehicle(vehicle);
		returnedParkingSpace.setOccupied(true);
		
		parkingSpaceRepository.save(returnedParkingSpace);
		
		return returnedParkingSpace;
		
	}
	

	public ParkingSpace exitParking(Vehicle vehicle) {
		checkOut(vehicle);
		calculateFees(vehicle);
		Optional<ParkingSpace> parkingSpace = parkingSpaceRepository.findByVehicle(vehicle);
		ParkingSpace returnedParkingSpace = parkingSpace.get();
		returnedParkingSpace.setVehicle(null);
		returnedParkingSpace.setOccupied(false);

		parkingSpaceRepository.save(returnedParkingSpace);
		
		return returnedParkingSpace;
		
	}
	
	private double calculateFees(Vehicle vehicle) {
		
		Double ratePerHour = rateCardRepository
		        .findByVehicleType(vehicle.getVehicleType())
		        .map(RateCard::getRatePerHour)
		        .orElseThrow(() ->
		            new RuntimeException("Rate card not found"));
		
		return Duration.between(vehicle.getStartTime(), vehicle.getEndTime()).toHours() * ratePerHour;
	}
	
	

}
