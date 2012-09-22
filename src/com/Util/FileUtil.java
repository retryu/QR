package com.Util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/*
 *@author:retryu 
 *@version  
 *@date:2012-9-22обнГ02:53:25
 */

public class FileUtil {
	public  static void InputStream2File(InputStream inputStream,String  file){
		System.out.println("file:"+file);
		byte  buff[]=new  byte[1024];
		try {
		FileOutputStream  fileOutputStream=new FileOutputStream(file);
			while(inputStream.read(buff)!=-1){
				fileOutputStream.write(buff);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
