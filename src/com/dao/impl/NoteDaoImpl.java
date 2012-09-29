package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dao.NoteDao;
import com.model.Note;

public class NoteDaoImpl implements NoteDao{

	@javax.annotation.Resource(name="sessionFactory")
	public  SessionFactory  sessionFactory;
	
	
	@Override
	public void add(Note resource) {
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
			Note  resource=new Note();
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
	public void upadte(Note resource) {

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
	public Note findById(int id) {
		Session  session=sessionFactory.openSession();
		Note  resource=null;
		try{
			session.beginTransaction();
			resource=	(Note) session.get(Note.class, id);
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
	public ArrayList<Note> findByHQL(String hql) {
		Session  session=sessionFactory.openSession();
		ArrayList<Note> resources=new  ArrayList<Note>();
		try{
			session.beginTransaction();
			 Query q=		session.createQuery(hql);
			 		resources=(ArrayList<Note>) q.list();
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
