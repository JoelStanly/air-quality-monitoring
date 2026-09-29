package com.awsiot.springboot.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsiot.springboot.exception.ResourceNotFoundException;
import com.awsiot.springboot.model.Sensor;
import com.awsiot.springboot.repository.SensorDataRepository;
import com.awsiot.springboot.service.SensorService;

@Service
public class SensorServiceImplementation implements SensorService{
	
	private SensorDataRepository sensorDataRepository;
	
	

	public SensorServiceImplementation(SensorDataRepository sensorDataRepository) {
		super();
		this.sensorDataRepository = sensorDataRepository;
	}



	@Override
	public Sensor saveSensor(Sensor sensor) {
		return sensorDataRepository.save(sensor);
	}



	@Override
	public List<Sensor> getSensorDataAll() {
		return sensorDataRepository.findAll();
	}



	@Override
	public Sensor getSensorDataById(long id) {
		return sensorDataRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("sensor", "id", id));
	}



	@Override
	public Sensor updateSensorData(Sensor sensor, long id) {
		Sensor currentSensor = sensorDataRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("sensor", "id", id));
		currentSensor.setC(sensor.getC());
		currentSensor.setCo(sensor.getCo());
		currentSensor.setCo2(sensor.getCo2());
		currentSensor.setO2(sensor.getO2());
		currentSensor.setSo2(sensor.getSo2());
		currentSensor.setSafe(sensor.isSafe());
		return sensorDataRepository.save(currentSensor);
	}



	@Override
	public void deleteSensorData(long id) {
		sensorDataRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("sensorMap", "id", id));
		sensorDataRepository.deleteById(id);
	}



}
