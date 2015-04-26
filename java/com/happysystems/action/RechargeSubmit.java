package com.happysystems.action;

import java.net.URL;
import java.io.*;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Iterator;

public class RechargeSubmit	{
	public static final String BALANCE = "http://rclive.info/balance.php";
	public static final String PREPAID = "http://rclive.info/mobile.php";
	public static final String DTH = "http://rclive.info/dth.php";
	public static final String DATACARD = "http://rclive.info/datacard.php";
	public static final String LASTRC = "http://rclive.info/lastrecharge.php";
	public static final String DISPUTE = "http://rclive.info/dispute.php";

	private static final HashMap<String, String> URLS;

	static	{
		URLS = new HashMap<String,String>();
		URLS.put("", BALANCE);
		URLS.put("prepaid", PREPAID);
		URLS.put("dth", DTH);
		URLS.put("data", DATACARD);
		URLS.put("lastrc", LASTRC);
		URLS.put("dispute", DISPUTE);
	}
	

	public static String submit(String type, HashMap<String,String> map)	{
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(URLS.get(type));
		NameValuePair [] params = new NameValuePair[map.size()];
		Set entries = map.entrySet();
		int i=0;
		for(Iterator it=entries.iterator(); it.hasNext();i++)	{
			Entry entry = (Entry)it.next();
			params[i] = new NameValuePair((String)entry.getKey(), (String)entry.getValue());
		}
		method.setQueryString(params);

		try	{
			client.executeMethod(method);
			byte [] b = method.getResponseBody();
			return new String(b);
		}
		catch(Exception e)	{
				return e.getMessage();
		}
		finally	{
			method.releaseConnection();
		}
	}
}
