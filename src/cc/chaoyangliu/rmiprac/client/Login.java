package cc.chaoyangliu.rmiprac.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JDialog {
	private JTextField textField;
	private JPasswordField passwordField;
	private JPanel panel;
	private JLabel lblPassword;
	private JButton okButton;
	private JButton cancelButton;
	private JPanel buttonPane;
	private String userName;
	private String password;
	public ReturnValues rtV;
	Boolean test;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		ReturnValues value = new ReturnValues();
//		Login dialog = new Login();
//		try {
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setModal(true);
//			value = dialog.showDialog();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println(value.btnValue);
//	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		rtV = new ReturnValues();
		setTitle("Login");
		setBounds(100, 100, 342, 298);
		getContentPane().setLayout(new BorderLayout());
		{
			buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				okButton = new JButton("Log in");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rtV.usr = textField.getText();
						rtV.pwd = passwordField.getPassword().toString();
						rtV.btnValue = true;
						setVisible(false);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rtV.btnValue = false;
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblUserName = new JLabel("User:");
			lblUserName.setBounds(75, 57, 30, 23);
			panel.add(lblUserName);
			
			textField = new JTextField();
			textField.setBounds(115, 58, 116, 21);
			panel.add(textField);
			textField.setColumns(10);
			
			lblPassword = new JLabel("password:");
			lblPassword.setBounds(51, 105, 54, 23);
			panel.add(lblPassword);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(115, 106, 116, 21);
			panel.add(passwordField);
		}
	}
	ReturnValues showDialog() {
		setVisible(true);
		return rtV;
	}
}
