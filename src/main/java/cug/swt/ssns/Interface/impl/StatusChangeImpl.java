package cug.swt.ssns.Interface.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import cug.swt.ssns.Interface.StatusChange;
import cug.swt.ssns.exception.SensorNotExistException;
import cug.swt.ssns.service.StatusChangeService;
import cug.swt.ssns.utils.Notify;

@WebService
public class StatusChangeImpl implements StatusChange{

	@Autowired
	StatusChangeService statusChangeService;

	
	@Override
	@WebMethod
	public String start(String sensorId) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String changeTime = sdf.format(date);
		statusChangeService.statueChange("start", sensorId, changeTime);
		return sensorId;
	}

	@Override
	@WebMethod
	public String stop(String sensorId) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String changeTime = sdf.format(date);
		statusChangeService.statueChange("stop", sensorId, changeTime);
		return sensorId;
	}

	@Override
	@WebMethod
	public String pause(String sensorId) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String changeTime = sdf.format(date);
		statusChangeService.statueChange("pause", sensorId, changeTime);
		return sensorId;
	}

	@Override
	@WebMethod
	public String resume(String sensorId) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String changeTime = sdf.format(date);
		statusChangeService.statueChange("resume", sensorId, changeTime);
		return sensorId;
	}
	

	
}
