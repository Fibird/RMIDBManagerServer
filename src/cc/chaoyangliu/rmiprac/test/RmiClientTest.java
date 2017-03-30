/**
 * 
 */
package cc.chaoyangliu.rmiprac.test;

import java.rmi.*;
import java.util.*;

import cc.chaoyangliu.rmiprac.service.DataService;

/**
 * @author bird
 *
 */
public class RmiClientTest {

	/**
	 * 
	 */
	public RmiClientTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int port = 1235;
		// Test Data
		String [] ns = {"Mary", "Mike", "Tony"};
		String [] ids = {"201401", "201402", "201403"};
		int [] gs = {98, 86, 78};
		int grade = 0;
		DataService ds;
		
		ArrayList<Student> ss = new ArrayList<Student>();
		for (int i = 0; i < 3; i++)
		{
			ss.add(new Student(ns[i], ids[i], gs[i]));
		}
		
		try {
			ds = (DataService) Naming.lookup("//localhost:" + port + "/ds");
			ds.connDataBase("root", "root", "rmijdbc");
			System.out.println("---------Test of Creating Table---------");
			System.out.println("Creating...");
			ds.createTable("grade");
			
			System.out.println("Table Creation Sucess!\n");
			
			System.out.println("---------Test of inserting Data---------");
			System.out.println("Inserting...");
			for (Student s : ss)
			{
				ds.addGrade(s.getName(), s.getId(), s.getGrade());
			}	
			System.out.println("Insert these data:");
			for (Student s : ss)
				System.out.println(s);
			
			System.out.println();
			System.out.println("---------Test of Querying Data---------");
			System.out.println("Querying...");
			for (Student s : ss)
			{
				grade = ds.queryGrade(s.getId());
				System.out.println("The grade of " + s.getId() + "is " + grade);
			}
			System.out.println("Data Query Success!\n");
			System.out.println("Nice! Everything is well!");
			ds.free();
		} catch (Exception e) {
			e.printStackTrace();
		} 
			
	}

}
