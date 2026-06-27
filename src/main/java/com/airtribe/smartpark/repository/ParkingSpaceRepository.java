package com.airtribe.smartpark.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airtribe.smartpark.entity.ParkingSpace;
import com.airtribe.smartpark.entity.ParkingSpaceId;
import com.airtribe.smartpark.entity.Vehicle;
import com.airtribe.smartpark.entity.VehicleType;

@Repository
public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, ParkingSpaceId>{
	
	Optional<ParkingSpace> findByParkingTypeAndOccupiedFalse(VehicleType parkingType);
	
	Optional<ParkingSpace> findByVehicle(Vehicle vehicle);


}
