package com.airtribe.smartpark.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class ParkingTicket {
	
	@Id
	@GeneratedValue
	private Long ticketId;
	
	@OneToOne
	private ParkingSpace parkingSpace;
	
	@OneToOne
	private Vehicle vehicle;
	
	private Double cost;
	
	private LocalDateTime startTime;
	
	private LocalDateTime endTime;

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	

	public ParkingSpace getParkingSpace() {
		return parkingSpace;
	}

	public void setParkingSpace(ParkingSpace parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
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

	
	public ParkingTicket(Long ticketId, ParkingSpace parkingSpace, Vehicle vehicle, Double cost,
			LocalDateTime startTime, LocalDateTime endTime) {
		super();
		this.ticketId = ticketId;
		this.parkingSpace = parkingSpace;
		this.vehicle = vehicle;
		this.cost = cost;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public ParkingTicket() {
		super();
	}

	
	

}
