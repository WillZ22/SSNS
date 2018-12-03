package cug.swt.ssns.Interface;

import javax.jws.WebMethod;
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
	String register(String sensorID, String sosAdress) throws Exception;
	
	/**
	 * 注销传感器
	 * @param sensorsID
	 * @return sensorId
	 * @throws Exception 
	 */
	@WebMethod
	String unregister(String sensorsID) throws Exception;
}
