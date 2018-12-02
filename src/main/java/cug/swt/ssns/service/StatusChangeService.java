package cug.swt.ssns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cug.swt.ssns.exception.SensorNotExistException;
import cug.swt.ssns.model.Consumer;
import cug.swt.ssns.model.Sensor;
import cug.swt.ssns.repository.SensorRepository;
import cug.swt.ssns.utils.Notify;

@Service
@Transactional
public class StatusChangeService {

	@Autowired
	SensorRepository sensorRepository;
	
	@Autowired
	Notify notify;
	
	public String statueChange(String status, String sensorID, String changeTime) throws Exception {
		Sensor sensor = null;
		sensor = sensorRepository.getSensorBysensorid(sensorID);
		if (sensor != null) {
			sensor.setChangeTime(changeTime);
			sensor.setStatus(status);
			sensorRepository.save(sensor);
			sensor.getConsumers();
			for(Consumer consumer:sensor.getConsumers()) {
				String consumerPort = consumer.getConsumerPort();
				notify.notify(sensor, consumerPort);
			}
			return sensorID;
		} else {
			throw new SensorNotExistException(sensorID + " is not existed");
		}
	}
}
