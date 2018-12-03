package cug.swt.ssns.Interface;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import cug.swt.ssns.exception.SensorNotExistException;
import cug.swt.ssns.model.Sensor;

@WebService
public interface GetSenorInfo {

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
	Sensor getSensorInfo(String sensorID) throws SensorNotExistException;
	
}
