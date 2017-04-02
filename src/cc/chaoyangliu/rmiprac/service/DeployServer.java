/**
 * Author: Chaoyang Liu
 * E-main: chaoyanglius@outlook.com
 *
 * Software License Agreement (GPL License)
 * A example using RMI & JDBC to operate remote database: Server Side
 * Copyright (c) 2017, Chaoyang Liu
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ************************************************************************/
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
