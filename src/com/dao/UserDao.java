package com.dao;

import com.model.User;

public interface UserDao {
	
	public  void addUser( User user);
	public 	void  deleteUser(User user);
	public  void  updateUser(User user);
	public  User findById(int i);

}
