package com.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dao.WallDao;
import com.model.Wall;

 

public class WallDaoImpl implements  WallDao {
	@Resource(name="sessionFactory")
	public  SessionFactory  sessionFactory;

	@Override
	public Wall add(Wall wall) {
		Session sesion =sessionFactory.getCurrentSession();
		try {
			sesion.beginTransaction();
			sesion.save(wall);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			sesion.getTransaction().rollback();
		}
		return   wall;
		
	}

	@Override
	public void delete(Wall wall) {
		Session sesion =sessionFactory.getCurrentSession();
		try {
			sesion.beginTransaction();
			sesion.delete(wall);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			sesion.getTransaction().rollback();
		}
	}

	@Override
	public void update(Wall wall) {
		Session sesion =sessionFactory.getCurrentSession();
		try {
			sesion.beginTransaction();
			sesion.update(wall);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			sesion.getTransaction().rollback();
		}
		
	}

	@Override
	public Wall findByid(int id) {
		Session sesion =sessionFactory.getCurrentSession();
		Wall  note=null;
		try {
			sesion.beginTransaction();
			note=(Wall) sesion.get(Wall.class, id);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			sesion.getTransaction().rollback();
		}
		return  note;
	}

	
	
	
}
