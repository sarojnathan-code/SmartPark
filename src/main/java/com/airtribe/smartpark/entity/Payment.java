package com.airtribe.smartpark.entity;

import java.time.LocalDateTime;

import com.airtribe.smartpark.utility.PaymentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue
	private Long paymentId;
	
	private ParkingTicket parkingTicket;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	
	private LocalDateTime paymentDate;

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public ParkingTicket getParkingTicket() {
		return parkingTicket;
	}

	public void setParkingTicket(ParkingTicket parkingTicket) {
		this.parkingTicket = parkingTicket;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	
	
	
	

}
