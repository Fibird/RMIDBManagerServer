package cc.chaoyangliu.rmiprac.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.net.MalformedURLException;
import java.rmi.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cc.chaoyangliu.rmiprac.service.DataService;
import cc.chaoyangliu.rmiprac.service.DataServiceImpl;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GradeManager extends JFrame {

	private JPanel contentPane;
	public DataService ds; 
	private JTextField TableNameTextField;
	private JTextField SIDTextField;
	private JTextField SnameTextField;
	private JList Tableslist2;
	private JList SIDList;
	private JLabel lblTables2;
	private JLabel lblStudentId2;
	private JButton btnQueryIt;
	private JSeparator QuerySeparator;
	private JButton btnAddIt;
	private JSeparator AddSeparator;
	private JLabel lblStudentId;
	private JLabel lblStudentName;
	private JList TablesList;
	private JLabel lblTables;
	private JSeparator CreateTableSeparator;
	private JButton CreateTableButton;
	private JLabel TableNameLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	public GradeManager() {
		setTitle("Grade Manager");
		try {
			ds = new DataServiceImpl();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TableNameLabel = new JLabel("Table Name:");
		TableNameLabel.setBounds(115, 32, 72, 24);
		contentPane.add(TableNameLabel);
		
		TableNameTextField = new JTextField();
		TableNameTextField.setBounds(203, 34, 112, 21);
		contentPane.add(TableNameTextField);
		TableNameTextField.setColumns(10);
		
		CreateTableButton = new JButton("Create Table");
		CreateTableButton.setBounds(149, 88, 136, 23);
		contentPane.add(CreateTableButton);
		
		CreateTableSeparator = new JSeparator();
		CreateTableSeparator.setBounds(10, 10, 414, 122);
		contentPane.add(CreateTableSeparator);
		
		lblTables = new JLabel("Tables:");
		lblTables.setBounds(133, 172, 54, 24);
		contentPane.add(lblTables);
		
		TablesList = new JList();
		TablesList.setBounds(203, 177, 112, 19);
		contentPane.add(TablesList);
		
		lblStudentId = new JLabel("Student ID:");
		lblStudentId.setBounds(115, 227, 72, 24);
		contentPane.add(lblStudentId);
		
		btnAddIt = new JButton("Add It!");
		btnAddIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddIt.setBounds(149, 338, 136, 23);
		contentPane.add(btnAddIt);
		
		AddSeparator = new JSeparator();
		AddSeparator.setBounds(10, 142, 414, 240);
		contentPane.add(AddSeparator);
		
		SIDTextField = new JTextField();
		SIDTextField.setBounds(203, 229, 112, 21);
		contentPane.add(SIDTextField);
		SIDTextField.setColumns(10);
		
		lblStudentName = new JLabel("Student Name:");
		lblStudentName.setBounds(109, 286, 78, 24);
		contentPane.add(lblStudentName);
		
		SnameTextField = new JTextField();
		SnameTextField.setBounds(203, 289, 112, 21);
		contentPane.add(SnameTextField);
		SnameTextField.setColumns(10);
		
		lblTables2 = new JLabel("Tables:");
		lblTables2.setBounds(133, 422, 54, 21);
		contentPane.add(lblTables2);
		
		Tableslist2 = new JList();
		Tableslist2.setBounds(203, 422, 112, 21);
		contentPane.add(Tableslist2);
		
		lblStudentId2 = new JLabel("Student ID:");
		lblStudentId2.setBounds(115, 486, 72, 24);
		contentPane.add(lblStudentId2);
		
		SIDList = new JList();
		SIDList.setBounds(203, 486, 112, 24);
		contentPane.add(SIDList);
		
		btnQueryIt = new JButton("Query It!");
		btnQueryIt.setBounds(149, 553, 136, 23);
		contentPane.add(btnQueryIt);
		
		QuerySeparator = new JSeparator();
		QuerySeparator.setBounds(10, 392, 414, 199);
		contentPane.add(QuerySeparator);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(82, 611, 93, 23);
		contentPane.add(btnExit);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(257, 611, 93, 23);
		contentPane.add(btnHelp);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 601, 414, 42);
		contentPane.add(separator_1);
	}
	
	public void setDs(String u, String p, String d) {
		try {
			ds.connDataBase(u, p, d);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ds = (DataService) Naming.lookup("//localhost:1235/ds");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
