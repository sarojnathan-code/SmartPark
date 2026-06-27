package com.airtribe.smartpark.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airtribe.smartpark.entity.ParkingSpace;
import com.airtribe.smartpark.entity.ParkingTicket;
import com.airtribe.smartpark.entity.Payment;
import com.airtribe.smartpark.entity.RateCard;
import com.airtribe.smartpark.entity.Vehicle;
import com.airtribe.smartpark.repository.ParkingSpaceRepository;
import com.airtribe.smartpark.repository.PaymentRepository;
import com.airtribe.smartpark.repository.RateCardRepository;
import com.airtribe.smartpark.utility.PaymentStatus;

@Service
public class ParkingAllotmentService {
	
	@Autowired
	private ParkingSpaceRepository parkingSpaceRepository;
	
	@Autowired
	private RateCardRepository rateCardRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	private void checkin(ParkingTicket parkingTicket) {
		parkingTicket.setStartTime(LocalDateTime.now());
	}
	
	private void checkOut(ParkingTicket parkingTicket) {
		parkingTicket.setEndTime(LocalDateTime.now());
	}
	
	public ParkingSpace allocateParking(Vehicle vehicle) {
		
		Optional<ParkingSpace> parkingSpace = parkingSpaceRepository.findByParkingTypeAndOccupiedFalse(vehicle.getVehicleType());
		ParkingSpace returnedParkingSpace = parkingSpace.get();
		returnedParkingSpace.setVehicle(vehicle);
		returnedParkingSpace.setOccupied(true);
		
		parkingSpaceRepository.save(returnedParkingSpace);
		
		ParkingTicket parkingTicket = new ParkingTicket();
		parkingTicket.setVehicle(vehicle);
		parkingTicket.setParkingSpace(returnedParkingSpace);
		checkin(parkingTicket);
		return returnedParkingSpace;
		
	}
	

	public ParkingSpace exitParking(ParkingTicket parkingTicket) {
		
		checkOut(parkingTicket);
		calculateFees(parkingTicket);
		payFees(parkingTicket);
		Optional<ParkingSpace> parkingSpace = parkingSpaceRepository.findByVehicle(parkingTicket.getVehicle());
		ParkingSpace returnedParkingSpace = parkingSpace.get();
		returnedParkingSpace.setVehicle(null);
		returnedParkingSpace.setOccupied(false);

		parkingSpaceRepository.save(returnedParkingSpace);
		
		return returnedParkingSpace;
		
	}
	
	private double calculateFees(ParkingTicket parkingTicket) {
		
		Double ratePerHour = rateCardRepository
		        .findByVehicleType(parkingTicket.getVehicle().getVehicleType())
		        .map(RateCard::getRatePerHour)
		        .orElseThrow(() ->
		            new RuntimeException("Rate card not found"));
		
		return Duration.between(parkingTicket.getStartTime(), parkingTicket.getEndTime()).toHours() * ratePerHour;
	}
	
	private boolean payFees(ParkingTicket parkingTicket) {
		parkingTicket.setCost(calculateFees(parkingTicket));
		
		Payment payment = new Payment();
		payment.setParkingTicket(parkingTicket);
		payment.setPaymentStatus(PaymentStatus.PAID);
		payment.setPaymentDate(LocalDateTime.now());
		
		paymentRepository.save(payment);
			
		return true;
	}

}
