package com.awsiot.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awsiot.springboot.model.SensorMap;
import com.awsiot.springboot.service.SensorMapService;
import com.awsiot.springboot.util.FileUtil;

@RestController
@RequestMapping("/api/sensormap")
public class SensorMapController {
	
	Logger logger = FileUtil.getLogger(SensorMapController.class);
	
	
	private SensorMapService sensorMapService;

	
	public SensorMapController(SensorMapService sensorMapService) {
		super();
		this.sensorMapService = sensorMapService;
	}

	// Posting Sensor Mapping Data
	@PostMapping("/post")
	public SensorMap saveSensorMapControl(@RequestBody SensorMap sensorMap) {
		String sensorid = FileUtil.generateSensorID();
		logger.info("Sensor ID has been generated");
		sensorMap.setSensorid(sensorid);
		logger.info("Sensor Details is being saved with data:\n" + sensorMap);
		return sensorMapService.saveSensorMap(sensorMap);
	}
	
	@GetMapping("/all")
	public List<SensorMap> getSensorMapAllControl(){
		logger.info("Getting all Sensor Details");
		return sensorMapService.getSensorMapAll();
	}
	
	@GetMapping("/find/{sensorid}")
	public SensorMap getSensorMapUsingIdControl(@PathVariable("sensorid") String sensorid) {
		logger.info("Getting the sensor details of the sensor with id: "+sensorid);
		return sensorMapService.getSensorMapById(sensorid);
	}
	
	@PutMapping("/update/{sensorid}")
	public SensorMap updateSensorMapControl(@RequestBody SensorMap sensorMap,@PathVariable("sensorid") String sensorid) {
		logger.info("Updating the sensor details for the sensorid: " + sensorid + " with data:\n" + sensorMap);
		return sensorMapService.updateSensorMap(sensorMap, sensorid);
	}
	
	@DeleteMapping("/delete/{sensorid}")
	public void deleteSensorMapControl(@PathVariable String sensorid) {
		logger.info("Deleting the Sensor from the map which had an id of " + sensorid);
		sensorMapService.deleteSensorMap(sensorid);
	}
	
	
}
