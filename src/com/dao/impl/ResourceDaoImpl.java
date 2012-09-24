package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dao.ResourceDao;
import com.model.Resource;

public class ResourceDaoImpl implements ResourceDao{

	@javax.annotation.Resource(name="sessionFactory")
	public  SessionFactory  sessionFactory;
	
	
	@Override
	public void add(Resource resource) {
		Session session=sessionFactory.getCurrentSession();
		try{
			session.beginTransaction();
			session.save(resource);
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

	@Override
	public void delete(int id) {
		Session  session=sessionFactory.getCurrentSession();
		try{
			session.beginTransaction();
			Resource  resource=new Resource();
			resource.setId(id);
			session.delete(resource);
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		
	}

	@Override
	public void upadte(Resource resource) {

		Session  session=sessionFactory.getCurrentSession();
		try{
			session.beginTransaction();
			session.update(resource);
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

	@Override
	public Resource findById(int id) {
		Session  session=sessionFactory.openSession();
		Resource  resource=null;
		try{
			session.beginTransaction();
			resource=	(Resource) session.get(Resource.class, id);
			session.getTransaction().commit();
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return  resource;
	}

	@Override
	public ArrayList<Resource> findByHQL(String hql) {
		Session  session=sessionFactory.openSession();
		ArrayList<Resource> resources=new  ArrayList<Resource>();
		try{
			session.beginTransaction();
			 Query q=		session.createQuery(hql);
			 		resources=(ArrayList<Resource>) q.list();
			session.getTransaction().commit();
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return  resources;
	}
 
 
	

}
