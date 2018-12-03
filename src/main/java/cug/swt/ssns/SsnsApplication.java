package cug.swt.ssns;

import javax.xml.ws.Endpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import cug.swt.ssns.Interface.impl.RegisterImpl;

@SpringBootApplication
public class SsnsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsnsApplication.class, args);
	}
}
