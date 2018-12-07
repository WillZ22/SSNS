package cug.swt.ssns.Interface;

import javax.jws.WebMethod;
import javax.jws.WebService;

import cug.swt.ssns.exception.SensorNotExistException;

@WebService
public interface FrequenceChange {
	
	@WebMethod
	public String frequenceChange(String sensorid, String frequence) throws SensorNotExistException;
}
