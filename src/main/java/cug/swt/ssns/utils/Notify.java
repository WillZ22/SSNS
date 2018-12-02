package cug.swt.ssns.utils;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Component;

import cug.swt.ssns.model.Sensor;

@Component
public class Notify {

	public static Boolean notify(Sensor sensor, String consumerPort) throws Exception {
		Boolean success = false;
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("sensor");
		root.addElement("id").setText(sensor.getSensorid());
		root.addElement("status").setText(sensor.getStatus() != null ? sensor.getStatus() : "");
		root.addElement("changeTime").setText(sensor.getChangeTime() != null ? sensor.getStatus() : "");
		root.addElement("sosAdress").setText(sensor.getSosAdress());
		String xmlStr = doc.asXML();
		
		
		
		URL url = new URL(consumerPort);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoInput(true);
		conn.setDoOutput(true);//如果通过post提交数据，必须设置允许对外输出数据
		conn.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
		conn.connect();
		 
		DataOutputStream out = new DataOutputStream(conn.getOutputStream());
	    out.writeBytes(xmlStr); //写入请求的字符串
	    out.flush();
	    out.close();
	    int status = conn.getResponseCode();
	    if (status == 200) {
			success = true;
		}
		return success;
	}
}
