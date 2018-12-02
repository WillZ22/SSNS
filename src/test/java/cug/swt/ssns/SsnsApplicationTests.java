package cug.swt.ssns;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cug.swt.ssns.Interface.impl.RegisterImpl;
import cug.swt.ssns.service.RegisterService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SsnsApplicationTests {


	@Autowired
	RegisterImpl registerImpl;

	@Test
	public void contextLoads() throws Exception {
		registerImpl.register("s", "s");
	}

}
