package Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.junit.Test;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import com.Util.JsonDateUtil;
import com.model.Wall;


public class JsonTest {
	
	
	/*
	 * ≤‚ ‘josn ø‚
	 */
	@Test
	public void  TestJtsonLib(){
		Wall  note=new  Wall();
		note.setDate(new Date() );
		note.setLatitude(1213);
		note.setUsl("www.baidu.com");
		JsonConfig  jsonConfig=new  JsonDateUtil().getConfigDateForm();
		JSONObject  j=new  JSONObject().fromObject(note,jsonConfig);
		
		System.out.println(j.toString());
		
	}
	@Test
	public  void  TestJsonArray(){
		try{
		Wall  note=new  Wall();
		note.setDate(new Date() );
		note.setLatitude(1213);
		note.setUsl("www.baidu.com");
		JsonConfig  jsonConfig=new  JsonDateUtil().getConfigDateForm();
		
		ArrayList<Wall>  notes=new  ArrayList<Wall>();
		notes.add(note);
		
		
		
		JSONArray  jsonArrsy=JSONArray.fromObject(notes,jsonConfig);
		System.out.println(jsonArrsy.toString());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

}
