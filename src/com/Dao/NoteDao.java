package com.Dao;

import com.model.Note;

public interface NoteDao {
	public  void  add(Note  note);
	public  void  delete(Note  note);
	public  void  update(Note  note);
	public  Note  findByid(int id);

}
  