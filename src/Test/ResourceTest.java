package Test;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import com.Util.HibernateUtil;
import com.dao.impl.WallDaoImpl;
import com.dao.impl.NoteDaoImpl;
import com.model.Note;


public class ResourceTest {
	
	static  SessionFactory  sessionFactory;
		static NoteDaoImpl  resourceDaoImpl;
		static WallDaoImpl  noteDaoImpl;
	@BeforeClass
	public  static void  prepareSession(){
		sessionFactory=HibernateUtil.getSessionFactory();
		resourceDaoImpl=new NoteDaoImpl();
		noteDaoImpl=new  WallDaoImpl();
		resourceDaoImpl.sessionFactory=sessionFactory;
		noteDaoImpl.sessionFactory=sessionFactory;
	}
		
	@Test
	public  void TestAtddtGet(){
		Note resource=resourceDaoImpl.findById(26);
	 
		System.out.print(resource.toString());
		
		
	}
		@Test
		public  void TestAtddtNote(){
			Note resource=new Note();
			resource.setWall_id(30);
			resource.setType("img");
			resourceDaoImpl.add(resource);
			System.out.print(resource.toString());
			
			
		}
		
		@Test
		public  void TestAtddtUpdate(){
			Note resource=resourceDaoImpl.findById(26);
			System.out.print(resource.toString());
		}
		
		@Test
		public  void  TestFindResources(){
			ArrayList<Note>resoueces  =resourceDaoImpl.findByHQL("from  Resource  where  note_id=30");
			for ( Note resource : resoueces) {
				System.out.println(resoueces);
			}
			
			
		}
	
	
	

}
