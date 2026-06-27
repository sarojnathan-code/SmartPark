package com.airtribe.smartpark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airtribe.smartpark.entity.ParkingSpace;
import com.airtribe.smartpark.entity.ParkingTicket;
import com.airtribe.smartpark.entity.Vehicle;
import com.airtribe.smartpark.service.ParkingAllotmentService;

@RestController
@RequestMapping("/api/park")
public class ParkingAllocationController {
	
	@Autowired
	private ParkingAllotmentService parkingAllotmentService;
	
	@PostMapping("/entry")
	public ParkingSpace parkingEntry(@RequestBody Vehicle vehicle) {
		return parkingAllotmentService.allocateParking(vehicle);
		
	}
	
	@PostMapping("/exit")
	public ParkingSpace parkingExit(@RequestBody ParkingTicket parkingTicket) {
		return parkingAllotmentService.exitParking(parkingTicket);
		
	}
	

}
