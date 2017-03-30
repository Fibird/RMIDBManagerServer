/**
 * 
 */
package cc.chaoyangliu.rmiprac.service;

import java.rmi.server.*;
import java.rmi.*;

/**
 * @author bird
 *
 */
public class DataServiceImpl extends UnicastRemoteObject implements DataService {
	private DBManager dbm;
	/**
	 * @throws RemoteException 
	 * 
	 */
	public DataServiceImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
		super();
		dbm = new DBManager();		
	}

	@Override
	public Boolean connDataBase(String usr, String pwd, String dbn) throws RemoteException {
		// TODO Auto-generated method stub
		return dbm.connDataBase(usr, pwd, dbn);
	}
	/* (non-Javadoc)
	 * @see cc.chaoyangliu.rmiprac.service.DataService#CreateTable()
	 */
	@Override
	public Boolean createTable(String tn) throws RemoteException {
		// TODO Auto-generated method stub
		return dbm.createTable(tn);
	}

	/* (non-Javadoc)
	 * @see cc.chaoyangliu.rmiprac.service.DataService#QueryGrade(java.lang.String)
	 */
	@Override
	public int queryGrade(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return dbm.queryGrade(id);
	}

	/* (non-Javadoc)
	 * @see cc.chaoyangliu.rmiprac.service.DataService#addGrade(java.lang.String, java.lang.String, int)
	 */
	@Override
	public Boolean addGrade(String n, String id, int g) throws RemoteException {
		// TODO Auto-generated method stub
		return dbm.addGrade(n, id, g);
	}

	/* (non-Javadoc)
	 * @see cc.chaoyangliu.rmiprac.service.DataService#free()
	 */
	@Override
	public void free() throws RemoteException {
		// TODO Auto-generated method stub
		dbm.disConn();
	}

}
