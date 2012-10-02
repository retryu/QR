package com.web.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Util.JsonDateUtil;
import com.model.Note;
import com.model.Wall;
import com.web.service.NoteService;
import com.web.service.WallService;

/*  
 *@author:retryu 
 *@version     
 *@date:2012-9-25ÏÂÎç09:51:09
 */
@Controller
public class NoteController {
	 
	
	@Resource(name="noteService")
	private NoteService  noteService;
	
	@Resource(name="wallService")
	private  WallService  wallService;
	
	
	
	@ResponseBody
	@RequestMapping(value="/addTextNote.do")
	public  String  handlerAddNote(@RequestParam("noteContent") String  noteContent
			,@RequestParam("noteTitle")String  noteTitle,
			@RequestParam("wallId")  int  wallId){
	
		System.out.print("note_content"+noteContent+"  noteTitle"+noteTitle+"  wallId"+wallId);
		Note  note=noteService.addTextNote(wallId, noteTitle,noteContent);
		JSONObject  json=JSONObject.fromObject(note);
		return  json.toString();
	}  
	@RequestMapping(value="/addImgNote.do",method=RequestMethod.POST)
	public  ModelAndView  handlerAddImgNote(@RequestParam("noteTitle")  String  noteTitle  ,@RequestParam("img")  MultipartFile   img){
		
		System.out.println("hanlerAddImgNote"+"  noteTitle:"+noteTitle+"  imgFile"+img);
		ModelAndView m=new  ModelAndView();
		if(noteService!=null)
		noteService.addImgNote(img,3);
		else{
			m.addObject("msg", "  noteservice  is null");
			m.setViewName("error");
			System.err.print("noteService is  null");
		}
		return  m;
	}
 
	
	
	
	
	@RequestMapping(value="/getNotes.do")
	public  ModelAndView  handlerGetNotes(){
		System.out.print("getNotes");
		ModelAndView  modelAndView=new  ModelAndView();
		 
		ArrayList<Note>  notes=noteService.getNotes(3);
		
		
		modelAndView.addObject("notes", notes);
		modelAndView.setViewName("info");
		return modelAndView;
	}
	
	
	
	
	
//	public  String  handlerAddNote(@RequestParam("note_content") String  note_content){
//	
//	System.out.print("note_content"+note_content);
//	
//	Wall  note=new  Wall();
//	note.setDate(new Date() );
//	note.setLatitude(1213);
//	note.setUsl("www.baidu.com");
//	JsonConfig  jsonConfig=new  JsonDateUtil().getConfigDateForm();
//	
//	ArrayList<Wall>  notes=new  ArrayList<Wall>();
//	notes.add(note);
//	JSONArray  jsonArrsy=JSONArray.fromObject(notes,jsonConfig);
//	System.out.println(jsonArrsy.toString());
//	return  jsonArrsy.toString();
//}

}
