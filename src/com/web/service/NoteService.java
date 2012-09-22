package com.web.service;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import com.Util.FileUtil;

/*
 *@author:retryu 
 *@version  
 *@date:2012-9-22ÏÂÎç03:21:19
 */

public class NoteService {
	
	public  void addNote(MultipartFile  file){
		System.out.println("filename"+file.getName()+"  size:"+file.getSize()+"   originalFilename"+file.getOriginalFilename()+"  type"+file.getContentType());
		try{
		String filePath="H:\\pic\\"+file.getOriginalFilename();
		FileUtil.InputStream2File(file.getInputStream(), filePath);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
