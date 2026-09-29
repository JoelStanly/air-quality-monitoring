package com.awsiot.springboot.util;

import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public final class FileUtil {
	

	public static Random rd = new Random();

	private FileUtil() {
	}
	
	public static String generateSensorID() {
		String uuid=UUID.randomUUID().toString();
		return uuid;
	}
	
	@SuppressWarnings("rawtypes")
	public static Logger getLogger(Class clas) {
		Logger logger = LoggerFactory.getLogger(clas);
		return logger;
	}
	
	
	public static double randomLongValue() {
		return Math.random()*(100-50+1)+50;
	}
	

}
