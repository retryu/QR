package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.model.Note;

/*
 *@author:retryu 
 *@version  
 *@date:2012-9-22обнГ06:39:57
 */

public interface NoteDao {
	public  void add(Note  resource);
	public void delete(int  id);
	public  void  upadte(Note  resource);
	public Note  findById(int  id);
	public  ArrayList<Note>  findByHQL(String  hql);
}
