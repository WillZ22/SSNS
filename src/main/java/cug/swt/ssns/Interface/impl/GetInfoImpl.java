package cug.swt.ssns.Interface.impl;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import cug.swt.ssns.Interface.GetInfo;
import cug.swt.ssns.exception.ConsumerNotExistException;
import cug.swt.ssns.exception.SensorNotExistException;
import cug.swt.ssns.model.Sensor;
import cug.swt.ssns.repository.SensorRepository;
import cug.swt.ssns.service.GetSensorInfoService;

@WebService(name = "getinfo",endpointInterface = "cug.swt.ssns.Interface.GetInfo")
public class GetInfoImpl implements GetInfo{

	@Autowired
	GetSensorInfoService getSensorInfoService;
	
	@Override
	@WebMethod 
	public List<Sensor> getSenosorList() {
		// TODO Auto-generated method stub
		return getSensorInfoService.getAllSensor();
	}

	@Override
	@WebMethod 
	public Sensor getSensorInfo(String sensorid) throws SensorNotExistException {
		// TODO Auto-generated method stub
		return getSensorInfoService.getSensorInfo(sensorid);
	}

	@Override
	@WebMethod
	public List<Sensor> getSubscribedSensor(String consumerPort) throws ConsumerNotExistException {
		// TODO Auto-generated method stub
		return getSensorInfoService.getSubscribedSensors(consumerPort);
	}

	
}
