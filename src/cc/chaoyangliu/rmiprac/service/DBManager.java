/**
 * 
 */
package cc.chaoyangliu.rmiprac.service;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cc.chaoyangliu.rmiprac.test.DBmanagerTest;

/**
 * @author ������
 * @time 2017-3-30
 */
/**
 * @author bird
 *
 */
public class DBManager {
	private String driver;		// Name of Driver
	private String user;		// Name of user
	private String url;
	private String password;
	private Connection conn;
	private String tableName;
	Statement stCreateTable;
	/**
	 * �������������úͳ�ʼ��
	 * �������û��������롢���ݿ���
	 */
	public DBManager() {
		driver = "com.mysql.jdbc.Driver";
		user = null;
		password = null;
		url = null;	
		tableName = null;
		stCreateTable = null;
	}
	
	public DBManager(String usr, String pwd, String dbn) {
		driver = "com.mysql.jdbc.Driver";
		user = usr;
		password = pwd;
		url = "jdbc:mysql://localhost:3306/" + dbn;
		tableName = null;
		stCreateTable = null;
	}
	
	/*
	 * �������ݿ�
	 * ��������
	 */
	public Boolean connDataBase(String usr, String pwd, String dbn) {
		user = usr;
		password = pwd;
		url = "jdbc:mysql://localhost:3306/" + dbn;	
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			
			if (!conn.isClosed())
				return true;
				//JOptionPane.showMessageDialog(null, "Connection Success!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/*
	 * �������
	 * ������������������
	 */
	public Boolean createTable(String tn)
	{
		tableName = tn;
		String CreateTablesql = "create table " + tableName + "(name char(20) not null, id char(12) primary key, grade int(4))";
		
		try {		
			stCreateTable = conn.createStatement();
			stCreateTable.executeUpdate(CreateTablesql);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			//DBManager.freeRsSt(null, stCreateTable);
		}
		return true;
	}
	
	/*
	 * ¼��ɼ�
	 * ������������ѧ�š��ɼ�
	 */
	public Boolean addGrade(String tn, String n, String id, int g) {
		String addSql = "insert into " + tn + " values (?, ?, ?)";
		PreparedStatement psAdd = null;
		try {
			psAdd = conn.prepareStatement(addSql);
			//psAdd.setString(1, tn);
			psAdd.setString(1, n);
			psAdd.setString(2, id);
			psAdd.setInt(3, g);
			psAdd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			DBManager.freeRsSt(null, psAdd);
		}
		return true;
	}
	
	/*
	 * ��ѯ�ɼ�
	 * ������ѧ��
	 */
	public int queryGrade(String tn, String id)
	{
		int grade = 0;
		String Querysql = "select grade from " + tn +" where id=?";
		PreparedStatement psQuery = null;
		ResultSet rs = null;
		try {
			psQuery = conn.prepareStatement(Querysql);
			//psQuery.setString(1, tn);
			psQuery.setString(1, id);
			rs = psQuery.executeQuery();
			if (rs.next())
				grade = rs.getInt(1);
			return grade;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} finally {
			DBManager.freeRsSt(rs, psQuery);
		}
	}
	
	public ArrayList<String> getTables() {
		String showTablesSql = "show tables";
		ResultSet rs = null;
		ArrayList<String> tables = new ArrayList<>();
		try {
			Statement showTables = conn.createStatement();
			rs = showTables.executeQuery(showTablesSql);
			
			while (rs.next()) {
				tables.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return tables;
	}
	/*
	 * �ͷŽ���������Ԥ����������
	 * ��������
	 */
	public static void freeRsSt(ResultSet rs, Statement st) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (st != null) {
					try {
						st.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
			}
		}
	}
	
	/*
	 * �����ݿ�Ͽ�����
	 * ��������
	 */
	public Boolean disConn() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
}
