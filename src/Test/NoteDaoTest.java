package Test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import com.Dao.impl.NoteDaoImpl;
import com.Util.HibernateUtil;
import com.model.Note;


public class NoteDaoTest {
	
	static  SessionFactory  sessionFactory;
		static NoteDaoImpl  noteDaoImpl;
	@BeforeClass
	public  static void  prepareSession(){
		sessionFactory=HibernateUtil.getSessionFactory();
		noteDaoImpl=new NoteDaoImpl();
		noteDaoImpl.sessionFactory=sessionFactory;
	}
		
		@Test
		public  void TestAddNote(){
			Note n=new  Note()	;
			n.setDate(new Date());
			n.setLatitude(12.33);
			n.setLongitude(1.00098);
			n.setUsl("https://fancyNote.com/Hsad123");
			noteDaoImpl.add(n);
			
			
		}
		
		
	
	
	

}
