package com.airtribe.smartpark.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue
	private Long transactionId;
	
	private Customer customer;
	
	private Double cost;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Transaction(Long transactionId, Customer customer, Double cost) {
		super();
		this.transactionId = transactionId;
		this.customer = customer;
		this.cost = cost;
	}

	public Transaction() {
		super();
	}
	
	

}
