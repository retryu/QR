package com.Dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Dao.UserDao;
import com.model.User;

public class UserDaoImpl implements UserDao {
	public SessionFactory sessionFactory;

	@Override
	public void addUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		try{
		session.beginTransaction();
		session.save(user); 
		session.getTransaction().commit();
		
		}  
		catch (Exception e) {
			session.getTransaction().rollback();
		}
		 
		
	}

	@Override
	public void deleteUser(User user) {

		Session session=sessionFactory.getCurrentSession();
		try{
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
		
		}
		catch (Exception e) {
			session.getTransaction().rollback();
		}
	}

	@Override
	public void updateUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		try{
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		
		}
		catch (Exception e) {
			session.getTransaction().rollback();
		}

	}

	@Override
	public User findById(int i) {
		Session session=sessionFactory.getCurrentSession();
		User user=null;
		try{
		session.beginTransaction();
		user=(User) session.get(User.class, i);
		session.getTransaction().commit();
		
		}
		catch (Exception e) {
			session.getTransaction().rollback();
		}
		return user;
	}

}
