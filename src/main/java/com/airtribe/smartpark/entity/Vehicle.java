package com.airtribe.smartpark.entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Vehicle {
	
	@Id
	private String vehicleRegistrationNumber;
	
	private LocalDateTime startTime;
	
	private LocalDateTime endTime;
	
	@OneToOne
	private Customer customer;
	
	@Enumerated(EnumType.STRING)
	private VehicleType vehicleType;

	public String getVehicleRegistrationNumber() {
		return vehicleRegistrationNumber;
	}

	public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
		this.vehicleRegistrationNumber = vehicleRegistrationNumber;
	}

	
	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}


	public Vehicle(String vehicleRegistrationNumber, LocalDateTime startTime, LocalDateTime endTime, Customer customer,
			VehicleType vehicleType) {
		super();
		this.vehicleRegistrationNumber = vehicleRegistrationNumber;
		this.startTime = startTime;
		this.endTime = endTime;
		this.customer = customer;
		this.vehicleType = vehicleType;
	}

	public Vehicle() {
		super();
	}
	
	

}
