package cug.swt.ssns.service;

import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cug.swt.ssns.exception.ConsumerNotExistException;
import cug.swt.ssns.exception.SensorNotExistException;
import cug.swt.ssns.model.Consumer;
import cug.swt.ssns.model.Sensor;
import cug.swt.ssns.repository.ConsumerRepository;
import cug.swt.ssns.repository.SensorRepository;

@Service
@Transactional
public class SubscribeService {
	
	@Autowired
	SensorRepository sensorRepository;
	
	@Autowired
	ConsumerRepository consumerRepository;

	public List<String> subscribe(List<String> sensorids, String consumerPort) throws SensorNotExistException {
		for(String sensorid:sensorids) {
			Sensor sensor = null;
			sensor = sensorRepository.getSensorBysensorid(sensorid);
			if (sensor == null) {
				throw new SensorNotExistException(sensorid + " is not exist");
			} else {
				Consumer consumer = null;
				consumer = consumerRepository.getConsumerByconsumerPort(consumerPort);
				if (consumer == null) {
					consumer = new Consumer();
					consumer.setConsumerPort(consumerPort);
					consumer.getSubscribedSensor().add(sensor);
					sensor.getConsumers().add(consumer);
					sensorRepository.save(sensor);
					consumerRepository.save(consumer);
				} else {
					consumer.getSubscribedSensor().add(sensor);
					sensor.getConsumers().add(consumer);
					consumerRepository.save(consumer);
					sensorRepository.save(sensor);
				}

			}
		}
		return sensorids;
	}
	
	public List<String> unsubscribe(List<String> sensorids, String consumerPort) throws SensorNotExistException, ConsumerNotExistException {
		for(String sensorid:sensorids) {
			Sensor sensor = null;
			sensor = sensorRepository.getSensorBysensorid(sensorid);
			if (sensor == null) {
				throw new SensorNotExistException(sensorid + " is not exist");
			} else {
				Consumer consumer = null;
				consumer = consumerRepository.getConsumerByconsumerPort(consumerPort);
				if (consumer == null) {
					throw new ConsumerNotExistException(consumerPort + "is not exist");
				} else {
					consumer.getSubscribedSensor().remove(sensor);
					sensor.getConsumers().remove(consumer);
				}
			}
		}
		return sensorids;
	}
	
	public Consumer getConsumer(String consumerPort) {
		Consumer consumer = consumerRepository.getConsumerByconsumerPort(consumerPort);
		return consumer;
	}
}
