package cug.swt.ssns.Interface.impl;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import cug.swt.ssns.Interface.Subscribe;
import cug.swt.ssns.exception.ConsumerNotExistException;
import cug.swt.ssns.exception.SensorNotExistException;
import cug.swt.ssns.model.Consumer;
import cug.swt.ssns.service.SubscribeService;

@WebService
public class SubscribeImpl implements Subscribe{

	@Autowired
	SubscribeService subscribeService;
	
	@Override
	@WebMethod
	public List<String> subscribe(List<String> sensorIds, String consumerPort) throws SensorNotExistException {
		// TODO Auto-generated method stub
		return subscribeService.subscribe(sensorIds, consumerPort);
	}

	@Override
	public List<String> unsubscribe(List<String> sensorIds, String consumerPort) throws SensorNotExistException, ConsumerNotExistException {
		// TODO Auto-generated method stub
		return subscribeService.unsubscribe(sensorIds, consumerPort);
	}

	@Override
	public Consumer getConsumerInfo(String consumerPort) {
		// TODO Auto-generated method stub
		return subscribeService.getConsumer(consumerPort);
	}

	
}
