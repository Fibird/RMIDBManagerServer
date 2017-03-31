/**
 * 
 */
package cc.chaoyangliu.rmiprac.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author ¡ı≥Ø—Û
 *
 */
public interface DataService extends Remote {
	public Boolean connDataBase(String usr, String pwd, String dbn) throws RemoteException ; 
	public Boolean createTable(String tn) throws RemoteException ; 
	public int queryGrade(String tn, String id) throws RemoteException ;
	public Boolean addGrade(String tn, String n, String id, int g) throws RemoteException ;
	public ArrayList<String> showTables() throws RemoteException ;
	public void free() throws RemoteException ;
}
