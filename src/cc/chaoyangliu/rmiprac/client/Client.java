package cc.chaoyangliu.rmiprac.client;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Launch the application.
 */
public class Client {

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReturnValues value = new ReturnValues();
		Login lg = new Login();
		try {
			lg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			lg.setModal(true);
			value = lg.showDialog();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (value.btnValue) {
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GradeManager frame = new GradeManager();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} else {
			JOptionPane.showConfirmDialog(null, "确定要退出吗？");
		}
	}

}
