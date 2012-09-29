package com.web.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.web.multipart.MultipartFile;

import com.Util.FileUtil;
import com.dao.NoteDao;
import com.dao.WallDao;
import com.model.Note;
import com.model.Wall;

/*
 *@author:retryu 
 *@version  
 *@date:2012-9-22ÏÂÎç03:21:19
 */

public class NoteService {
	@Resource(name="wallDaoImpl")
	WallDao  wallDao;
	@Resource(name="noteDaoImpl")
	NoteDao  NoteDao;
	
	
	public  void  addTextNote(int  wallId,String  text){
		Wall  wall=wallDao.findByid(wallId);
		if(wall==null){
		wall=wallDao.add(new  Wall());
		}
		Note  note =new  Note();
		note.setWall_id(wall.getId());
		note.setContent(text);
		NoteDao.add(note);
	 
	}
	
	
	public  void addImgNote(MultipartFile  file,int  id){
		try{
		Note  note=new  Note();

		String filePath="H:\\pic\\"+file.getOriginalFilename();
		note.setType(file.getContentType());
		note.setWall_id(id);
		NoteDao.add(note);
		 
		FileUtil.InputStream2File(file.getInputStream(), filePath);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Note> getResoueces(int id){
		ArrayList<Note> resources=new  ArrayList<Note>();
		resources=NoteDao.findByHQL("from  Note  where  wall_id="+id);
		return  resources;
	}
	

}
