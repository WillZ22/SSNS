package cug.swt.ssns.Interface;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import cug.swt.ssns.exception.SensorNotExistException;

@WebService
public interface FrequenceChange {
	
	@WebMethod
	public String frequenceChange(@WebParam(name = "sensorid")String sensorid, @WebParam(name = "frequence")String frequence) throws SensorNotExistException;
}
