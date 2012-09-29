package Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import com.Util.HibernateUtil;
import com.dao.impl.NoteDaoImpl;
import com.dao.impl.WallDaoImpl;
import com.model.Note;
import com.model.Wall;


public class NoteDaoTest {
	
	static  SessionFactory  sessionFactory;
		static WallDaoImpl  wallDaoImpl;
		static  NoteDaoImpl  noteDaoImpl;
	@BeforeClass
	public  static void  prepareSession(){
		sessionFactory=HibernateUtil.getSessionFactory();
		wallDaoImpl=new WallDaoImpl();
		noteDaoImpl=new NoteDaoImpl();
		wallDaoImpl.sessionFactory=sessionFactory;
		noteDaoImpl.sessionFactory=sessionFactory;
	}
		
		@Test
		public  void TestAddNote(){
			Note resource=new Note();
			resource.setId(16);
			resource.setContent("H:\\pic\\c.jpeg");
			Set<Note> resources=new  HashSet<Note>();
			resources.add(resource);
			
			Wall n=wallDaoImpl.findByid(25);
//			resource.setNote(n);
			n.setDate(new Date());
			n.setLatitude(12.33);
			n.setLongitude(1.00098);
			n.setResources(resources);
			n.setUsl("https://fancyNote.com/Hsad123");
			wallDaoImpl.add(n);
			
			
		}
		@Test
		public  void TestGet(){
			Wall note=wallDaoImpl.findByid(30);

				System.out.print(note);
			
			
		}
		@Test
		public   void  TestUpdate(){
			Wall note=wallDaoImpl.findByid(30);
 
			note.setLongitude(44);
//			noteDaoImpl.update(note);
			System.out.print(note);
		}
		@Test
		public   void  TestAddWall(){
			Wall  wall=new  Wall();
			 wallDaoImpl.add(wall);
			 System.out.println("wall_id"+wall);
		}
		@Test 
		public  void  TestAddNote2(){
			Note  note=new  Note();
		Wall  wall=new  Wall();
			 wallDaoImpl.add(wall);
			 
			 note.setWall_id(wall.getId());
			 note.setContent("asdasdas");
			noteDaoImpl.add(note);
			}
		
		
	
	
	

}
