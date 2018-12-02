package cug.swt.ssns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cug.swt.ssns.exception.SensorNotExistException;
import cug.swt.ssns.model.Sensor;
import cug.swt.ssns.repository.SensorRepository;

@Service
@Transactional
public class GetSensorInfoService {

	@Autowired
	SensorRepository sensorRepository;
	
	public Sensor getSensorInfo(String sensorid) throws SensorNotExistException {
		Sensor sensor = sensorRepository.getSensorBysensorid(sensorid);
		if (sensor == null) {
			throw new SensorNotExistException(sensorid + " is not exist");
		}else {
			sensor = sensorRepository.getSensorBysensorid(sensorid);
			return sensor;
		}
	}
	
	public List<Sensor> getAllSensor(){
		List<Sensor> sensors = sensorRepository.findAll();
		return sensors;
	}
}
