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
import cug.swt.ssns.repository.SensorRepository;
import cug.swt.ssns.utils.Notify;

@Service
@Transactional
public class StatusChangeService {

	@Autowired
	SensorRepository sensorRepository;
	
	@Autowired
	Notify notify;
	
	public String statueChange(String status, String sensorID, String changeTime) throws SensorNotExistException{
		Sensor sensor = null;
		sensor = sensorRepository.getSensorBysensorid(sensorID);
		if (sensor != null) {
			sensor.setStatusChangeTime(changeTime);
			sensor.setStatus(status);
			sensorRepository.save(sensor);
			sensor.getConsumers();
			
			//通知用户的xml
			Document doc = DocumentHelper.createDocument();
			Element root = doc.addElement("StatusChangeNotification");
			Element sensorElement = root.addElement("sensor");
			sensorElement.addElement("id").setText(sensor.getSensorid());
			sensorElement.addElement("status").setText(sensor.getStatus() != null ? sensor.getStatus() : "");
			sensorElement.addElement("changeTime").setText(sensor.getStatusChangeTime() != null ? sensor.getStatus() : "");
			String xmlStr = doc.asXML();
			
			
			for(Consumer consumer:sensor.getConsumers()) {
				String consumerPort = consumer.getConsumerPort();
				notify.notify(xmlStr, consumerPort);
			}
			return sensorID;
		} else {
			throw new SensorNotExistException(sensorID + " is not existed");
		}
	}
}
