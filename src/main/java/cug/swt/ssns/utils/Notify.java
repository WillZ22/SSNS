package cug.swt.ssns.utils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.MalformedInputException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Component;

import cug.swt.ssns.model.Sensor;

@Component
public class Notify {

	public static Boolean notify(String xmlStr, String consumerPort) {
		Boolean success = false;
		
		
		try {
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
		} catch (ProtocolException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (MalformedInputException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return success;
	}
}
