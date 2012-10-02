package com.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.web.service.NoteService;

@Controller
public class FileUploadController {
	
	
	@Resource(name="noteService")
	private NoteService  noteService;
 
	
	@RequestMapping(value="/upload2.do")
	public void  handleFormUpload(@RequestParam("name") String name){
		System.out.print("name:"+name);
		 
	}      
		@RequestMapping(value="/upload.do",method=RequestMethod.POST)
		public ModelAndView  handleFormUpload(@RequestParam("noteTitle") String noteTitle, @RequestParam("img")  MultipartFile  img){
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
//		@RequestMapping(value="/addNote.do")
//		public  void  handleAddNote(@RequestParam("note_content")String  note_content){
//			
//			    
//		}
	  
	

}
