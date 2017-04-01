/**
 * 
 */
package cc.chaoyangliu.rmiprac.service;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * @author bird
 *
 */
public class DeployServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Config cfg = new Config("config/config.properties");
		String url = cfg.getProperty("url");
		String tp = cfg.getProperty("port");
		
		if (url == null) {
			url = "localhost";
		}
		if (tp == null) {
			tp = "1235";
		}
		int port = Integer.parseInt(tp);
		try {
			// ����Զ�̶���
			DataServiceImpl ds = new DataServiceImpl();

			// ����ע�����,���û�������䣬��Ҫ�ֹ���������ʼ�˵�--����--rmiregistry��Ĭ�϶˿�1099
			LocateRegistry.createRegistry(port);   //�������˿ںſ�����ָ��
			
			// Զ�̶���󶨵�����
			Naming.rebind("//" + url + ":" + port + "/ds", ds);
			System.out.println("Starting RMI Server...");
			System.out.println("The URL of Server is " + url + ".");
			System.out.println("The port of Server is " + port + ".");
			System.out.println("RMI Server is Running ...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
