package cug.swt.ssns.Interface;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import cug.swt.ssns.exception.ConsumerNotExistException;
import cug.swt.ssns.exception.SensorNotExistException;
import cug.swt.ssns.model.Sensor;

@WebService
public interface GetInfo {

	/**
	 * 获取注册的传感器列表
	 * @return List<{@link Sensor}>
	 */
	@WebMethod
	List<Sensor> getSenosorList();
	
	/**
	 * 获取传感器信息
	 * @param sensorID
	 * @return {@link Sensor}
	 * @throws SensorNotExistException 
	 */
	@WebMethod
	Sensor getSensorInfo(@WebParam(name = "sensorid")String sensorid) throws SensorNotExistException;
	
	@WebMethod
	List<Sensor> getSubscribedSensor(@WebParam(name = "consumerPort")String consumerPort) throws ConsumerNotExistException;
	
}
