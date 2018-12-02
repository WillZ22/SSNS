package cug.swt.ssns.Interface.impl;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cug.swt.ssns.Interface.Register;
import cug.swt.ssns.service.RegisterService;

@Component
public class RegisterImpl implements Register{
	
	@Autowired
	RegisterService registerService;

	@Override
	@WebMethod
	public String register(String sensorId, String sosAdress) throws Exception {
		// TODO Auto-generated method stub
		return registerService.register(sensorId, sosAdress);
	}

	@Override
	@WebMethod
	public String unregister(String sensorsID) throws Exception {
		// TODO Auto-generated method stub
		return registerService.unregister(sensorsID);
	}

}
