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
		//int port = 1235;

		try {
			// ����Զ�̶���
			DataServiceImpl ds = new DataServiceImpl();

			// ����ע�����,���û�������䣬��Ҫ�ֹ���������ʼ�˵�--����--rmiregistry��Ĭ�϶˿�1099
			LocateRegistry.createRegistry(1235);   //�������˿ںſ�����ָ��
			
			// Զ�̶���󶨵�����
			Naming.rebind("//localhost:1235/ds", ds);

			System.out.println("RMI Server Running ...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
