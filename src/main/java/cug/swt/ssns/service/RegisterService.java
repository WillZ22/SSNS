package cug.swt.ssns.service;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cug.swt.ssns.exception.SensorAlreadyExistException;
import cug.swt.ssns.exception.SensorNotExistException;
import cug.swt.ssns.model.Consumer;
import cug.swt.ssns.model.Sensor;
import cug.swt.ssns.repository.ConsumerRepository;
import cug.swt.ssns.repository.SensorRepository;
import cug.swt.ssns.utils.Notify;

@Transactional
@Service
public class RegisterService {
	
	@Autowired
	SensorRepository sensorRepository;
	
	@Autowired
	ConsumerRepository consumerRepository;
	
	@Autowired
	Notify notify;
	
	/**
	 * 
	 * @param sensorID
	 * @param sosAdress
	 * @param frequence
	 * @return sensorID
	 * @throws Exception 
	 */
	public String register(String sensorID, String sosAdress, String frequence) throws Exception {
		if (sensorRepository.getSensorBysensorid(sensorID) != null) {
			throw new SensorAlreadyExistException(sensorID + "  is already exist");
		}else {
			Sensor sensor = new Sensor();
			sensor.setSosAdress(sosAdress);
			sensor.setSensorid(sensorID);
			sensor.setFrequence(frequence);
			sensorRepository.save(sensor);
			
//			//通知用户的xml
//			Document doc = DocumentHelper.createDocument();
//			Element root = doc.addElement("sensor");
//			root.addElement("id").setText(sensorID);
//			root.addElement("sosAdress").setText(sosAdress);
//			root.addElement("frequence").setText(frequence);
//			String xmlStr = doc.asXML();
//			
//			
//			List<Consumer> consumers = consumerRepository.findAll();
//			
//			for(Consumer consumer:consumers) {
//				String consumerPort = consumer.getConsumerPort();
//				notify.notify(xmlStr, consumerPort);
//			}	
			
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
			
			Document doc = DocumentHelper.createDocument();
			Element root = doc.addElement("UnregisterNotification");
			root.addElement("id").setText(sensorid);
			String xmlStr = doc.asXML();
			
			for(Consumer con:sensor.getConsumers()) {
				Notify.notify(xmlStr, con.getConsumerPort());
				con.getSubscribedSensor().remove(sensor);
			}
			sensorRepository.delete(sensor);
			return sensorid;
		}
	};
}
