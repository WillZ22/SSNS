package cug.swt.ssns;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus; 
import org.apache.cxf.bus.spring.SpringBus; 
import org.apache.cxf.jaxws.EndpointImpl; 
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean; 
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration;

import cug.swt.ssns.Interface.FrequenceChange;
import cug.swt.ssns.Interface.GetInfo;
import cug.swt.ssns.Interface.Register;
import cug.swt.ssns.Interface.StatusChange;
import cug.swt.ssns.Interface.Subscribe;
import cug.swt.ssns.Interface.impl.FrequenceChangeImpl;
import cug.swt.ssns.Interface.impl.GetInfoImpl;
import cug.swt.ssns.Interface.impl.RegisterImpl;
import cug.swt.ssns.Interface.impl.StatusChangeImpl;
import cug.swt.ssns.Interface.impl.SubscribeImpl; 

@Configuration
public class CxfConfig {


	@Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(),"/service/*");
    }
	
	@Bean(name = Bus.DEFAULT_BUS_ID) 
	public SpringBus springBus() {
		return new SpringBus(); 
	} 

	@Bean
	public Register register() {
		return new RegisterImpl();
	}
	@Bean
	public Subscribe subscribe() {
		return new SubscribeImpl();
	}
	
	@Bean
	public StatusChange statusChange() {
		return new StatusChangeImpl();
	}
	
	@Bean
	public GetInfo getInfo() {
		return new GetInfoImpl();
	}
	
	@Bean
	public FrequenceChange frequenceChange() {
		return new FrequenceChangeImpl();
	}
	
	@Bean 
	public Endpoint endpoint1(){ 
		EndpointImpl endpoint = new EndpointImpl(springBus(), register());
		endpoint.publish("/registerservice"); 
		return endpoint; 
	}
	@Bean 
	public Endpoint endpoint2(){ 
		EndpointImpl endpoint = new EndpointImpl(springBus(), subscribe());
		endpoint.publish("/subscribeservice"); 
		return endpoint; 
	}
	@Bean 
	public Endpoint endpoint3(){ 
		EndpointImpl endpoint = new EndpointImpl(springBus(), statusChange());
		endpoint.publish("/statuschange"); 
		return endpoint; 
	}
	@Bean 
	public Endpoint endpoint4(){ 
		EndpointImpl endpoint = new EndpointImpl(springBus(), getInfo());
		endpoint.publish("/getinfo"); 
		return endpoint; 
	}
	
	@Bean 
	public Endpoint endpoint5(){ 
		EndpointImpl endpoint = new EndpointImpl(springBus(), frequenceChange());
		endpoint.publish("/frequencechange"); 
		return endpoint; 
	}

}
