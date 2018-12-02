package cug.swt.ssns.Interface;

import java.util.List;

import cug.swt.ssns.exception.SensorNotExistException;
import cug.swt.ssns.model.Sensor;

public interface GetSenorInfo {

	/**
	 * 获取注册的传感器列表
	 * @return List<{@link Sensor}>
	 */
	List<Sensor> getSenosorList();
	
	/**
	 * 获取传感器信息
	 * @param sensorID
	 * @return {@link Sensor}
	 * @throws SensorNotExistException 
	 */
	Sensor getSensorInfo(String sensorID) throws SensorNotExistException;
	
}
