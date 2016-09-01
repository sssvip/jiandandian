package com.jdd.until;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/*
 *@author:David admin@dxscx.com
 *@Version: 1.0
 *@Description:  What do you want to do?
 *@Time:2016-6-19  下午1:14:53
 */
public class MessageUtil {
	static String httpUrl = "http://apis.baidu.com/kingtto_media/106sms/106sms";
	
	public static String sendMassage(String phone,String code ){
		String httpArg="mobile="+phone+"&content=%e3%80%90%e7%ae%80%e5%8d%95%e7%82%b9%e3%80%91%e6%82%a8%e7%9a%84%e9%aa%8c%e8%af%81%e7%a0%81%e6%98%af"+code+"%ef%bc%8c%e6%9c%89%e6%95%88%e6%97%b6%e9%97%b45%e5%88%86%e9%92%9f%ef%bc%8c%e8%af%b7%e4%b8%8d%e8%a6%81%e5%91%8a%e8%af%89%e4%bb%96%e4%ba%ba!";
		//String temp="mobile="+phone+"&content=【简单点】您的验证码是"+code+"，有效时间5分钟，请不要告诉他人";
		String jsonResult=request(httpUrl,httpArg);
		return jsonResult;
	}
	public static String request(String httpUrl, String httpArg) {
	    BufferedReader reader = null;
	    String result = null;
	    StringBuffer sbf = new StringBuffer();
	    httpUrl = httpUrl + "?" + httpArg;

	    try {
	        URL url = new URL(httpUrl);
	        HttpURLConnection connection = (HttpURLConnection) url
	                .openConnection();
	        connection.setRequestMethod("GET");
	        // 填入apikey到HTTP header
	        connection.setRequestProperty("apikey",  "d3f3c097bbd5c015acb241b832a7212a");
	        connection.connect();
	        InputStream is = connection.getInputStream();
	        reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        String strRead = null;
	        while ((strRead = reader.readLine()) != null) {
	            sbf.append(strRead);
	            sbf.append("\r\n");
	        }
	        reader.close();
	        result = sbf.toString();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}
}
