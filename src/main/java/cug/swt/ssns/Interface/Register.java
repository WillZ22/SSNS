package cug.swt.ssns.Interface;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

@WebService
public interface Register {

	/**
	 * 传感器注册
	 * @param sensorID
	 * @param sosAdress
	 * @return sensorId
	 * @throws Exception 
	 */
	@WebMethod
	String register(@WebParam(name = "sensorid")String sensorID, @WebParam(name = "sosAdress")String sosAdress, @WebParam(name = "frequence")String frequence) throws Exception;
	
	/**
	 * 注销传感器
	 * @param sensorsID
	 * @return sensorId
	 * @throws Exception 
	 */
	@WebMethod
	String unregister(@WebParam(name = "sensorid")String sensorsID) throws Exception;
}
