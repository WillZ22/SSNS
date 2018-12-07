package cug.swt.ssns.Interface.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import cug.swt.ssns.Interface.FrequenceChange;
import cug.swt.ssns.exception.SensorNotExistException;
import cug.swt.ssns.service.FrequenceChangeService;

@WebService(name = "changefrequence",endpointInterface = "cug.swt.ssns.Interface.FrequenceChange")
public class FrequenceChangeImpl implements FrequenceChange{
	
	@Autowired
	FrequenceChangeService frequenceChangeService;

	@Override
	@WebMethod
	public String frequenceChange(String sensorid, String frequence) throws SensorNotExistException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String changeTime = sdf.format(date);
		frequenceChangeService.changeFrequence(sensorid, frequence, changeTime);
		return sensorid;
	}

}
