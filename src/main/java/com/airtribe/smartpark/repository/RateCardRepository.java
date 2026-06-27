package com.airtribe.smartpark.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airtribe.smartpark.entity.RateCard;
import com.airtribe.smartpark.entity.VehicleType;

@Repository
public interface RateCardRepository extends JpaRepository<RateCard, Long>{
	
	Optional<RateCard> findByVehicleType(VehicleType vehicleType);
}
