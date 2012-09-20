package Test;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import com.Util.HibernateUtil;


public class UserDaoTest {
	
	static  SessionFactory  sessionFactory;
	
	@BeforeClass
	public  static void  prepareSession(){
		sessionFactory=HibernateUtil.getSessionFactory();
		
	}
	
	
	
	@Test
	public  void  TestDao(){
		
		
	}

}
