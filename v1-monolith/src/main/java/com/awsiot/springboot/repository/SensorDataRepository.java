package com.awsiot.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awsiot.springboot.model.Sensor;

public interface SensorDataRepository extends JpaRepository<Sensor, Long>{

}
