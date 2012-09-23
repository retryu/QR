package com.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.FetchMode;

@Entity
public class Note {
	private  int id;
	private String source;
	private String  usl;
	private Date  date;
	private double  longitude;
	private double  latitude;
	private  Set<Resource> resources=new HashSet<Resource>();
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getUsl() {
		return usl;
	}
	public void setUsl(String usl) {
		this.usl = usl;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	@OneToMany(mappedBy="note_id",cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	public Set<Resource> getResources() {
		return resources;
	}
	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}
	@Override
	public String toString() {
		return "Note [id=" + id + ", source=" + source + ", usl=" + usl
				+ ", date=" + date + ", longitude=" + longitude + ", latitude="
				+ latitude + ", resources=" + resources + "]";
	}
	
	
	
	
	

}
