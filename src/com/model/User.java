package com.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class User {

	private  int id;
	private  String  password;
	private  String  Email;
	
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
	public String getPassWord() {
		return password;
	}
	public void setPassWord(String passWord) {
		this.password = passWord;
	}
	public String getE_mail() {
		return Email;
	}
	public void setE_mail(String e_mail) {
		this.Email = e_mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", Email=" + Email
				+ "]";
	}
	
	
	
	
}
