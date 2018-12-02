package cug.swt.ssns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cug.swt.ssns.exception.SensorAlreadyExistException;
import cug.swt.ssns.exception.SensorNotExistException;
import cug.swt.ssns.model.Sensor;
import cug.swt.ssns.repository.SensorRepository;

@Transactional
@Service
public class RegisterService {
	
	@Autowired
	SensorRepository sensorRepository;
	
	/**
	 * 
	 * @param sensorID
	 * @param sosAdress
	 * @return sensorID
	 * @throws Exception 
	 */
	public String register(String sensorID, String sosAdress) throws Exception {
		if (sensorRepository.getSensorBysensorid(sensorID) != null) {
			throw new SensorAlreadyExistException(sensorID + "  is already exist");
		}else {
			Sensor sensor = new Sensor();
			sensor.setSosAdress(sosAdress);
			sensor.setSensorid(sensorID);
			sensorRepository.save(sensor);
			return sensorID;
		}
	}
	
	/**
	 * 
	 * @param sensorID
	 * @return sensorID
	 * @throws Exception
	 */
	public String unregister(String sensorid) throws Exception {
		if (sensorRepository.getSensorBysensorid(sensorid) == null) {
			throw new SensorNotExistException(sensorid + "  is not exist");
		} else {
			Sensor sensor = sensorRepository.getSensorBysensorid(sensorid);
			sensorRepository.delete(sensor);
			return sensorid;
		}
	};
}
