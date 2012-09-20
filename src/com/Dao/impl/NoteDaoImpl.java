package com.Dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Dao.NoteDao;
import com.model.Note;

 

public class NoteDaoImpl implements  NoteDao {
	public  SessionFactory  sessionFactory;

	@Override
	public void add(Note note) {
		Session sesion =sessionFactory.getCurrentSession();
		try {
			sesion.beginTransaction();
			sesion.save(note);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			sesion.getTransaction().rollback();
		}
		
	}

	@Override
	public void delete(Note note) {
		Session sesion =sessionFactory.getCurrentSession();
		try {
			sesion.beginTransaction();
			sesion.delete(note);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			sesion.getTransaction().rollback();
		}
	}

	@Override
	public void update(Note note) {
		Session sesion =sessionFactory.getCurrentSession();
		try {
			sesion.beginTransaction();
			sesion.update(note);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			sesion.getTransaction().rollback();
		}
		
	}

	@Override
	public Note findByid(int id) {
		Session sesion =sessionFactory.getCurrentSession();
		Note  note=null;
		try {
			sesion.beginTransaction();
			sesion.get(Note.class, id);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			sesion.getTransaction().rollback();
		}
		return  note;
	}

	
	
	
}
