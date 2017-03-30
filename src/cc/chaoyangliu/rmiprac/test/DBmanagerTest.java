package cc.chaoyangliu.rmiprac.test;

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
		if (dbm.connDataBase(usr, pwd, dbn)) {
			JOptionPane.showMessageDialog(null, "Connection Success!");
		}
		if (dbm.createTable("grade")) {
			JOptionPane.showMessageDialog(null, "Table Creation Success!");
		}
		if (dbm.addGrade("Mike", "2014012537", 98)) {
			JOptionPane.showMessageDialog(null, "Data Insertion Success!");
		}
		
		int data;
		
		if ((data = dbm.queryGrade("2014012537")) != -1) {
			JOptionPane.showMessageDialog(null, "The grade is : " + data);
		}
		
		if (dbm.disConn()) {
			JOptionPane.showMessageDialog(null, "Disconnection Success");
		}
	}

}
