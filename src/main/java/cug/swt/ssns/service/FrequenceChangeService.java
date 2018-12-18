package cug.swt.ssns.service;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cug.swt.ssns.exception.SensorNotExistException;
import cug.swt.ssns.model.Consumer;
import cug.swt.ssns.model.Sensor;
import cug.swt.ssns.repository.ConsumerRepository;
import cug.swt.ssns.repository.SensorRepository;
import cug.swt.ssns.utils.Notify;

@Service
@Transactional
public class FrequenceChangeService {

	@Autowired
	SensorRepository sensorRepository;
	
	@Autowired 
	Notify notify;
	
	public String changeFrequence(String sensorid, String frequence,String changeTime) throws SensorNotExistException {
		
		Sensor sensor = null;
		sensor = sensorRepository.getSensorBysensorid(sensorid);

		if (sensor != null) {
			sensor.setFrequenceChangeTime(changeTime);
			sensor.setFrequence(frequence);
			sensorRepository.save(sensor);
			sensor.getConsumers();
			
			//通知用户的xml
			Document doc = DocumentHelper.createDocument();
			Element root = doc.addElement("FrequenceChangeNotification");
			Element sensoreleElement= root.addElement("sensor");
			sensoreleElement.addElement("id").setText(sensor.getSensorid());
			sensoreleElement.addElement("frequence").setText(sensor.getFrequence());
			sensoreleElement.addElement("changeTime").setText(sensor.getFrequenceChangeTime() != null ? sensor.getFrequenceChangeTime() : "");
			String xmlStr = doc.asXML();
			
			
			for(Consumer consumer:sensor.getConsumers()) {
				String consumerPort = consumer.getConsumerPort();
				Notify.notify(xmlStr, consumerPort);
			}
			return sensorid;
		} else {
			throw new SensorNotExistException(sensorid + " is not existed");
		}
		
	}

}
