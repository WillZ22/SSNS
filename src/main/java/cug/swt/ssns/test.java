package cug.swt.ssns;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.mapping.Subclass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cug.swt.ssns.model.Consumer;
import cug.swt.ssns.model.Sensor;
import cug.swt.ssns.repository.ConsumerRepository;
import cug.swt.ssns.service.GetSensorInfoService;
import cug.swt.ssns.service.RegisterService;
import cug.swt.ssns.service.StatusChangeService;
import cug.swt.ssns.service.SubscribeService;
import cug.swt.ssns.utils.Notify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test {

//	@Autowired
//	GetSensorInfoService getSensorInfoService;
//	
//	@Autowired
//	RegisterService registerService;
	
	@Autowired
	StatusChangeService statusChangeService;
	
	@Autowired
	SubscribeService subscribeService;
	
	@Autowired
	Notify notify;
	
	
	@Test
	public void test() throws Exception {
		
	}
}
