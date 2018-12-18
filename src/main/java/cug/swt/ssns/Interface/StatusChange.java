package cug.swt.ssns.Interface;

import javax.jws.WebMethod;
import javax.jws.WebService;

import cug.swt.ssns.exception.SensorNotExistException;

@WebService
public interface StatusChange {
	
	/**
	 * 传感器开始
	 * @param sensorId changeTime
	 * @return sensorId
	 * @throws SensorNotExistException 
	 * @throws Exception 
	 */
	@WebMethod
	String start(String sensorId) throws SensorNotExistException, Exception;
	
//	/**
//	 * 传感器停止
//	 * @param sensorId changetime
//	 * @return sensorId
//	 * @throws SensorNotExistException 
//	 * @throws Exception 
//	 */
//	@WebMethod
//	String stop(String sensorId) throws SensorNotExistException, Exception;
	
	/**
	 * 传感器暂停
	 * @param sensorId changetime
	 * @return sensorId
	 * @throws SensorNotExistException 
	 * @throws Exception 
	 */
	@WebMethod
	String pause(String sensorId) throws SensorNotExistException, Exception;

	/**
	 * 传感器恢复观测
	 * @param sensorId changeTime
	 * @return sensorId
	 * @throws SensorNotExistException 
	 * @throws Exception 
	 */
	@WebMethod
	String resume(String sensorId) throws SensorNotExistException, Exception;
}
