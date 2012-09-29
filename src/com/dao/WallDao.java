package com.dao;

import com.model.Wall;

public interface WallDao {
	public  Wall  add(Wall  wall);
	public  void  delete(Wall  wall);
	public  void  update(Wall  wall);
	public  Wall  findByid(int id);

}
  