package com.airtribe.smartpark.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String phoneNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Customer(Long id, String name, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public Customer() {
		super();
	}
	
	

}
