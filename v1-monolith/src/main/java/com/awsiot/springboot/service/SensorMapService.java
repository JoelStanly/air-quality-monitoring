package com.awsiot.springboot.service;

import java.util.List;

import com.awsiot.springboot.model.SensorMap;

public interface SensorMapService {
	
	SensorMap saveSensorMap(SensorMap sensorMap);
	List<SensorMap> getSensorMapAll();
	SensorMap getSensorMapById(String sensorid);
	SensorMap updateSensorMap(SensorMap sensorMap,String sensorid);
	void deleteSensorMap(String sensorid);
}
