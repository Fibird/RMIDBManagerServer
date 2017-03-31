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
			// 创建远程对象
			DataServiceImpl ds = new DataServiceImpl();

			// 启动注册服务,如果没有这个语句，需要手工启动：开始菜单--运行--rmiregistry，默认端口1099
			LocateRegistry.createRegistry(1235);   //这里，服务端口号可任意指定
			
			// 远程对象绑定到服务
			Naming.rebind("//localhost:1235/ds", ds);

			System.out.println("RMI Server Running ...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
