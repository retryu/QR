package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.model.Resource;

/*
 *@author:retryu 
 *@version  
 *@date:2012-9-22обнГ06:39:57
 */

public interface ResourceDao {
	public  void add(Resource  resource);
	public void delete(int  id);
	public  void  upadte(Resource  resource);
	public Resource  findById(int  id);
	public  ArrayList<Resource>  findByHQL(String  hql);
}
