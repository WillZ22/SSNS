package cug.swt.ssns.Interface.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import cug.swt.ssns.Interface.Register;
import cug.swt.ssns.service.RegisterService;

@WebService(name = "registerservice",endpointInterface = "cug.swt.ssns.Interface.Register")
public class RegisterImpl implements Register{
	
	@Autowired
	RegisterService registerService;

	@Override
	public String register(String sensorId, String sosAdress) throws Exception {
		// TODO Auto-generated method stub
		return registerService.register(sensorId, sosAdress);
	}

	@Override
	public String unregister(String sensorsID) throws Exception {
		// TODO Auto-generated method stub
		return registerService.unregister(sensorsID);
	}

}
