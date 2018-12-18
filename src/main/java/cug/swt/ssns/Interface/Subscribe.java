package cug.swt.ssns.Interface;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import cug.swt.ssns.exception.ConsumerNotExistException;
import cug.swt.ssns.exception.SensorNotExistException;
import cug.swt.ssns.model.Consumer;

@WebService
public interface Subscribe {
	
	/**
	 * 用户订阅
	 * @param sensorID
	 * @param consumerPort
	 * @return sensorIds
	 * @throws SensorNotExistException 
	 */
	@WebMethod
	List<String> subscribe(@WebParam(name = "sensorid")List<String> sensorids, @WebParam(name = "consumerPort")String consumerPort) throws SensorNotExistException;
	
	/**
	 * 取消订阅
	 * @param sensorID
	 * @return sensorIds
	 * @throws ConsumerNotExistException 
	 * @throws SensorNotExistException 
	 */
	@WebMethod
	List<String> unsubscribe(@WebParam(name = "sensorid")List<String> sensorids,  @WebParam(name = "consumerPort")String consumerPort) throws SensorNotExistException, ConsumerNotExistException;
	
	/**
	 * 获得订阅信息
	 * @param consumerPort
	 * @return {@link Consumer}
	 */
	@WebMethod
	Consumer getConsumerInfo(@WebParam(name = "consumerPort")String consumerPort);
	
}
