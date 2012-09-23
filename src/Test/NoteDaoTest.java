package Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import com.Util.HibernateUtil;
import com.dao.impl.NoteDaoImpl;
import com.model.Note;
import com.model.Resource;


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
			Resource resource=new Resource();
			resource.setId(16);
			resource.setContent("H:\\pic\\c.jpeg");
			Set<Resource> resources=new  HashSet<Resource>();
			resources.add(resource);
			
			Note n=noteDaoImpl.findByid(25);
//			resource.setNote(n);
			n.setDate(new Date());
			n.setLatitude(12.33);
			n.setLongitude(1.00098);
			n.setResources(resources);
			n.setUsl("https://fancyNote.com/Hsad123");
			noteDaoImpl.add(n);
			
			
		}
		@Test
		public  void TestGet(){
			Note note=noteDaoImpl.findByid(30);

				System.out.print(note);
			
			
		}
		@Test
		public   void  TestUpdate(){
			Note note=noteDaoImpl.findByid(30);
 
			note.setLongitude(44);
//			noteDaoImpl.update(note);
			System.out.print(note);
		}
		@Test
		public   void  TestAdd(){
			Note  note=noteDaoImpl.findByid(33);
			noteDaoImpl.delete(note);
		}
		
		
	
	
	

}
