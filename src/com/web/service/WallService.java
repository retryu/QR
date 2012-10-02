package com.web.service;

import javax.annotation.Resource;

import com.dao.WallDao;
import com.model.Wall;
/*
 *@author:retryu 
 *@version  
 *@date:2012-9-29обнГ11:17:45
 */

public class WallService {
	  
	@Resource(name="wallDaoImpl")
	WallDao  wallDao;
	
	
		public  Wall  getWall(int  id){
		Wall  wall=wallDao.findByid(id);
		return wall;
	}


}
