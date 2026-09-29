package com.awsiot.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awsiot.springboot.model.SensorMap;

public interface SensorMapRepository extends JpaRepository<SensorMap, Long>{
	Optional<SensorMap> findBySensorid(String sensorid);

}
