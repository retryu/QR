package Test;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import com.Util.HibernateUtil;
import com.dao.impl.NoteDaoImpl;
import com.dao.impl.ResourceDaoImpl;
import com.model.Resource;


public class ResourceTest {
	
	static  SessionFactory  sessionFactory;
		static ResourceDaoImpl  resourceDaoImpl;
		static NoteDaoImpl  noteDaoImpl;
	@BeforeClass
	public  static void  prepareSession(){
		sessionFactory=HibernateUtil.getSessionFactory();
		resourceDaoImpl=new ResourceDaoImpl();
		noteDaoImpl=new  NoteDaoImpl();
		resourceDaoImpl.sessionFactory=sessionFactory;
		noteDaoImpl.sessionFactory=sessionFactory;
	}
		
	@Test
	public  void TestAtddtGet(){
		Resource resource=resourceDaoImpl.findById(26);
	 
		System.out.print(resource.toString());
		
		
	}
		@Test
		public  void TestAtddtNote(){
			Resource resource=new Resource();
			resource.setNote_id(30);
			resource.setType("img");
			resourceDaoImpl.add(resource);
			System.out.print(resource.toString());
			
			
		}
		
		@Test
		public  void TestAtddtUpdate(){
			Resource resource=resourceDaoImpl.findById(26);
			System.out.print(resource.toString());
		}
		
		@Test
		public  void  TestFindResources(){
			ArrayList<Resource>resoueces  =resourceDaoImpl.findByHQL("from  Resource  where  note_id=30");
			for ( Resource resource : resoueces) {
				System.out.println(resoueces);
			}
			
			
		}
	
	
	

}
