package cug.swt.ssns.Interface;

import java.util.List;

import cug.swt.ssns.exception.ConsumerNotExistException;
import cug.swt.ssns.exception.SensorNotExistException;
import cug.swt.ssns.model.Consumer;

public interface Subscribe {
	
	/**
	 * 用户订阅
	 * @param sensorID
	 * @param consumerPort
	 * @return sensorIds
	 * @throws SensorNotExistException 
	 */
	List<String> subscribe(List<String> sensorIds, String consumerPort) throws SensorNotExistException;
	
	/**
	 * 取消订阅
	 * @param sensorID
	 * @return sensorIds
	 * @throws ConsumerNotExistException 
	 * @throws SensorNotExistException 
	 */
	List<String> unsubscribe(List<String> sensorIds,  String consumerPort) throws SensorNotExistException, ConsumerNotExistException;
	
	/**
	 * 获得订阅信息
	 * @param consumerPort
	 * @return {@link Consumer}
	 */
	Consumer getConsumerInfo(String consumerPort);
	
}
