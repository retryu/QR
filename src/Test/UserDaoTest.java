package Test;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import com.Util.HibernateUtil;
import com.dao.impl.UserDaoImpl;
import com.model.User;


public class UserDaoTest {
	
	static  SessionFactory  sessionFactory;
		static UserDaoImpl  userDaoImpl;
		@BeforeClass
	public  static void  prepareSession(){
		sessionFactory=HibernateUtil.getSessionFactory();
		  userDaoImpl=new UserDaoImpl();
		userDaoImpl.sessionFactory=sessionFactory;
	}
	
	
	
		@Test
	public  void  addDao(){
		User u=new User();
		u.setE_mail("ruanchenyugood@gmail.com");
		u.setPassWord("2212118");
		userDaoImpl.addUser(u);
	}
		@Test
		public  void   deleteDao(){
			User  u=userDaoImpl.findById(1);
			userDaoImpl.deleteUser(u);
		}
		@Test
		public  void findtUser(){
			User user=userDaoImpl.findById(2);
			System.out.print(user);
		}
		
//		@Test
//		public void updateUser(){
//			User u=findUser();
//			u.setE_mail("shbanyun@163.com");
//			userDaoImpl.updateUser(u);
//		}
		
		
		
		
		
		
		
		
		
		
		
		

}
