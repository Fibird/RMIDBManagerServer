package cc.chaoyangliu.rmiprac.test;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import cc.chaoyangliu.rmiprac.service.DBManager;

public class DBmanagerTest {

	public DBmanagerTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String usr = "root", pwd = "root", dbn = "rmijdbc";
		DBManager dbm = new DBManager(usr, pwd, dbn); 
		String [] tbs = {"t1", "t2", "t3"};
		String tbn = "grade";
		if (dbm.connDataBase(usr, pwd, dbn)) {
			JOptionPane.showMessageDialog(null, "Connection Success!");
		}
		if (dbm.createTable(tbn)) {
			JOptionPane.showMessageDialog(null, "Table Creation Success!");
		}
		if (dbm.addGrade(tbn, "Mike", "2014012537", 98)) {
			JOptionPane.showMessageDialog(null, "Data Insertion Success!");
		}
		
		int data;
		
		if ((data = dbm.queryGrade(tbn, "2014012537")) != -1) {
			JOptionPane.showMessageDialog(null, "The grade is : " + data);
		}
		
		for (int i = 0; i < tbs.length; i++) {
			dbm.createTable(tbs[i]);
		}
		ArrayList<String> a = dbm.getTables();

		for (int i = 0; i < a.size(); i++) {
			//System.out.println(i + " " + a.get(i));
			JOptionPane.showMessageDialog(null, "Table " + i + ": " + a.get(i));
		}
		
		if (dbm.disConn()) {
			JOptionPane.showMessageDialog(null, "Disconnection Success");
		}
	}

}
