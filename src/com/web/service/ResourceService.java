package com.web.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.multipart.MultipartFile;

import com.Util.FileUtil;
import com.dao.NoteDao;
import com.dao.ResourceDao;

/*
 *@author:retryu 
 *@version  
 *@date:2012-9-22ÏÂÎç03:21:19
 */

public class ResourceService {
	@Resource(name="noteDaoImple")
	NoteDao  noteDao;
	@Resource(name="resourceDaoImpl")
	ResourceDao  resourceDao;
	
	public  void addNote(MultipartFile  file,int  id){
		try{
		com.model.Resource  resource=new  com.model.Resource();

		String filePath="H:\\pic\\"+file.getOriginalFilename();
		resource.setType(file.getContentType());
		resource.setNote_id(id);
		resourceDao.add(resource);
		 
		FileUtil.InputStream2File(file.getInputStream(), filePath);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<com.model.Resource> getResoueces(int id){
		ArrayList<com.model.Resource> resources=new  ArrayList<com.model.Resource>();
		resources=resourceDao.findByHQL("from  Resources  where  note_id="+id);
		return  resources;
		
	}
	

}
