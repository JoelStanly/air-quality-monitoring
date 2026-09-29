package com.awsiot.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awsiot.springboot.model.Sensor;
import com.awsiot.springboot.service.SensorService;
import com.awsiot.springboot.util.FileUtil;

@RestController
@RequestMapping("/api/sensor")
public class SensorController {
	
	Logger logger = FileUtil.getLogger(SensorController.class);
	
	private SensorService sensorservice;

	public SensorController(SensorService sensorservice) {
		super();
		this.sensorservice = sensorservice;
	}
	
	// Posting The data stream
	@PostMapping("post")
	public ResponseEntity<Sensor> saveSensor(@RequestBody Sensor sensor){
		logger.info("Sensor is being saved with data:\n" + sensor);
		return new ResponseEntity<Sensor>(sensorservice.saveSensor(sensor),HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public List<Sensor> getSensorAllControl(){
		logger.info("Getting all sensor data");
		return sensorservice.getSensorDataAll();
	}
	
	@GetMapping("/find/{id}")
	public Sensor getSensorUsingIdControl(@PathVariable("id") long id) {
		logger.info("Getting sensor data for the sensor id:" + id);
		return sensorservice.getSensorDataById(id);
	}
	
	@PutMapping("/update/{id}")
	public Sensor updateSensorControl(@RequestBody Sensor sensor,@PathVariable("id") long id) {
		logger.info("Updating the sensor data for the id:" + id +" with sensor data:\n"+sensor);
		return sensorservice.updateSensorData(sensor, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteSensorControl(@PathVariable long id) {
		logger.info("Deleting the sensor data for the id:" + id);
		sensorservice.deleteSensorData(id);
	}
	
}
