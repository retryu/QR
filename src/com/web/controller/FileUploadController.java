package com.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.web.service.ResourceService;

@Controller
public class FileUploadController {
	
	
	@Resource(name="ResourceService")
	private ResourceService  noteService;
 
	
	@RequestMapping(value="/upload2.do")
	public void  handleFormUpload(@RequestParam("name") String name){
		System.out.print("name:"+name);
		
	}      
	
		@RequestMapping(value="/upload.do",method=RequestMethod.POST)
		public ModelAndView  handleFormUpload(@RequestParam("name") String name, @RequestParam("file")  MultipartFile  file){
			ModelAndView m=new  ModelAndView();
  
			if(noteService!=null)
			noteService.addNote(file,30);
			else{
				m.addObject("msg", "  noteservice  is null");
				m.setViewName("error");
				System.err.print("noteService is  null");
			}
			return  m;
		}
	  
	

}
