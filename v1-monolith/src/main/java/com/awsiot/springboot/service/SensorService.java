package com.awsiot.springboot.service;

import java.util.List;

import com.awsiot.springboot.model.Sensor;

public interface SensorService {
	
	Sensor saveSensor(Sensor sensor);
	List<Sensor> getSensorDataAll();
	Sensor getSensorDataById(long id);
	Sensor updateSensorData(Sensor sensor,long id);
	void deleteSensorData(long id);
}
