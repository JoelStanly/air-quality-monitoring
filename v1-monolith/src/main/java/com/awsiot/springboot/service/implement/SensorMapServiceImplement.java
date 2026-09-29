package com.awsiot.springboot.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.awsiot.springboot.exception.ResourceNotFoundException;
import com.awsiot.springboot.model.SensorMap;
import com.awsiot.springboot.repository.SensorMapRepository;
import com.awsiot.springboot.service.SensorMapService;

@Service
public class SensorMapServiceImplement implements SensorMapService{
	
	private SensorMapRepository sensorMapRepository;
	

	public SensorMapServiceImplement(SensorMapRepository sensorMapRepository) {
		super();
		this.sensorMapRepository = sensorMapRepository;
	}


	@Override
	public SensorMap saveSensorMap(SensorMap sensorMap) {
		
		return sensorMapRepository.save(sensorMap);
		
	}


	@Override
	public List<SensorMap> getSensorMapAll() {
		return sensorMapRepository.findAll();
	}


	@Override
	public SensorMap getSensorMapById(String sensorid) {
		return sensorMapRepository.findBySensorid(sensorid).orElseThrow(()-> new ResourceNotFoundException("sensorMap", "sensorid", sensorid));
	}


	@Override
	public SensorMap updateSensorMap(SensorMap sensorMap, String sensorid) {
		SensorMap currentSensorMap = sensorMapRepository.findBySensorid(sensorid).orElseThrow(()->new ResourceNotFoundException("sensorMap","sensorid", sensorid));
		currentSensorMap.setFloor(sensorMap.getFloor());
		currentSensorMap.setRoom(sensorMap.getRoom());
		return sensorMapRepository.save(currentSensorMap);
		
	}


	@Override
	public void deleteSensorMap(String sensorid) {
		
		SensorMap sensorMap = sensorMapRepository.findBySensorid(sensorid).orElseThrow(()-> new ResourceNotFoundException("sensorMap", "sensorid", sensorid));
		long id = sensorMap.getId();
		sensorMapRepository.deleteById(id);
	}

}
