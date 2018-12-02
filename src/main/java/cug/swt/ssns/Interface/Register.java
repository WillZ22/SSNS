package cug.swt.ssns.Interface;

import javax.jws.WebMethod;
import javax.jws.WebService;


public interface Register {

	/**
	 * 传感器注册
	 * @param sensorID
	 * @param sosAdress
	 * @return sensorId
	 * @throws Exception 
	 */
	String register(String sensorID, String sosAdress) throws Exception;
	
	/**
	 * 注销传感器
	 * @param sensorsID
	 * @return sensorId
	 * @throws Exception 
	 */
	String unregister(String sensorsID) throws Exception;
}
