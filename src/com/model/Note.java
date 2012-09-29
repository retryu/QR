package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Note {

	private  int id;
	private  String  type;
	private  String  content;
	private  int  wall_id;
	private  String  note_title;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getWall_id() {
		return wall_id;
	}
	public void setWall_id(int note_id) {
		this.wall_id = note_id;
	}
	
	public String getNote_title() {
		return note_title;
	}
	public void setNote_title(String note_title) {
		this.note_title = note_title;
	}
	@Override
	public String toString() {
		return "Note [id=" + id + ", type=" + type + ", content=" + content
				+ ", wall_id=" + wall_id + "]";
	}
 
	
	
	
	
}
