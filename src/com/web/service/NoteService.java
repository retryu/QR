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
	
	
	public  Note  addTextNote(int  wallId,String  noteTitle,String  noteText){
		Wall  wall=wallDao.findByid(wallId);
		if(wall==null){
		wall=wallDao.add(new  Wall());
		}
		Note  note =new  Note();
		note.setWall_id(wall.getId());
		note.setNote_title(noteTitle);
		note.setContent(noteText);
		NoteDao.add(note);
		return  note;
	 
	}
	
	
	public  void addImgNote(MultipartFile  file,int  wallId){
		try{
		Note  note=new  Note();

		String filePath="H:\\pic\\"+file.getOriginalFilename();
		note.setType(file.getContentType());
		note.setWall_id(wallId);
		note.setContent(filePath);
		
		NoteDao.add(note);
		 
		FileUtil.InputStream2File(file.getInputStream(), filePath);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Note> getNotes(int id){
		ArrayList<Note> resources=new  ArrayList<Note>();
		resources=NoteDao.findByHQL("from  Note  where  wall_id="+id);
		return  resources;
	}
	

}
