package com.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import com.model.Wall;
import com.model.User;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
/*
 *@author:retryu 
 *@version  
 *@date:2012-9-26ÏÂÎç01:37:21
 */
import net.sf.json.util.JSONUtils;

public class JsonDateUtil {
	static  JsonConfig  jsonConfig=new  JsonConfig();
	public  static  JsonConfig  getConfigDateForm(){
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonValueProcessorImpl());
//		Note  note=new  Note();
//			note.setDate(new Date() );
//			note.setLatitude(1213);
//			note.setUsl("www.baidu.com");
//			JSONObject  s=JSONObject.fromObject(note, jsonConfig);
//			System.out.print(s.toString());
//			
//			String  j=s.toString();
//			JSONObject  note2=JSONObject.fromObject(j);
//		System.out.print(note2.get("date"));
		return  jsonConfig;
	}

}
