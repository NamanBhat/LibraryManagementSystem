import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JToolBar;

public class database {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					database window = new database();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
public static Connection connection=null;
private JTable table;
private JTable table_1;
private JTextField textField;
private JTextField textField_1;
private JTextField textField_2;
private JTextField textField_3;
private JTextField textField_4;
private JTextField textField_5;
private JTextField textField_6;
private JTextField textField_7;
private JTextField textField_8;
private JTextField textField_9;
private JTextField textField_10;
String[] bd;String[] ud;
private JTextField textField_11;
private JTextField textField_12;
private JTextField textField_13;
private JTextField textField_14;
private JTextField textField_15;
private JTextField textField_16;
private JTextField textField_17;
private JTextField textField_18;
private JTextField textField_19;
	/**
	 * Create the application.
	 */
public static Connection dbconnector(){
	try {
		Class.forName ("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/a?autoReconnect=true&useSSL=false","root","password"); 
	    return conn;
	} catch (ClassNotFoundException e1) {
		
		e1.printStackTrace();
		return null;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	 
	
}
	public database() {
		connection=dbconnector();
		delusers();
		initialize();
		
	}
	void delusers(){
		ud=null;bd=null;
		List <String>items=new ArrayList<String>();
		String query="Select* from book; ";
		PreparedStatement pst;
		try {
			pst = connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next())items.add(rs.getString(1));
			bd=items.toArray(new String[items.size()]);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List <String>item=new ArrayList<String>();
		String quer="Select* from user; ";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(quer);
			ResultSet rs=ps.executeQuery();
			while(rs.next())item.add(rs.getString(1));
			ud=item.toArray(new String[item.size()]);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 1457, 638);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.CYAN);
		tabbedPane.setBounds(0, 38, 1439, 553);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Books", null, panel, null);
		panel.setLayout(null);
		
		final JScrollPane scrollPane = new JScrollPane();
	
		scrollPane.setBounds(32, 23, 725, 499);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		PreparedStatement pst1;
		try {
			pst1 = connection.prepareStatement("Select * from book;");
		ResultSet rs2=pst1.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs2));
		
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(779, 25, 427, 499);
		panel.add(tabbedPane_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane_1.addTab("Insert", null, panel_2, null);
		panel_2.setLayout(null);
		
		textField_5 = new JTextField();
		textField_5.setBounds(140, 25, 267, 22);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(140, 83, 267, 22);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(140, 145, 267, 22);
		panel_2.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(140, 214, 267, 22);
		panel_2.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(140, 287, 267, 22);
		panel_2.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(140, 360, 267, 22);
		panel_2.add(textField_10);
		textField_10.setColumns(10);
		final JComboBox comboBox = new JComboBox(bd);
		comboBox.setBounds(88, 53, 213, 22);
		final JComboBox comboBox_2 = new JComboBox(bd);
		JButton btnInsert_1 = new JButton("Insert");
		btnInsert_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(textField_5.getText().isEmpty()||textField_6.getText().isEmpty()||textField_7.getText().isEmpty()||textField_5.getText().isEmpty()||textField_6.getText().isEmpty()||textField_7.getText().isEmpty())
						throw new Exception();
				String query="insert into book values(\""+textField_5.getText()+"\",\""+textField_6.getText()+"\",\""+textField_7.getText()+"\",\""+textField_8.getText()+"\",\""+textField_9.getText()+"\",\""+textField_10.getText()+"\",null); ";
				String query2="select * from book;"; 
				try {
					Statement ps = connection.createStatement();
					ps.executeUpdate(query);
					table=new JTable();
					scrollPane.setViewportView(table);
					PreparedStatement pst = connection.prepareStatement(query2);
				    ResultSet rs=pst.executeQuery();
				    table.setModel(DbUtils.resultSetToTableModel(rs));
				    textField_5.setText(null);textField_6.setText(null);textField_7.setText(null);textField_8.setText(null);textField_9.setText(null);textField_10.setText(null);
				    delusers();
					DefaultComboBoxModel mode =new DefaultComboBoxModel(bd);
					comboBox.setModel(mode);
					
					DefaultComboBoxModel mod =new DefaultComboBoxModel(bd);
					comboBox_2.setModel(mod);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.toString());
				}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Fill all compulsary fields");
				}
				
				
			}
		});
		btnInsert_1.setBounds(310, 431, 97, 25);
		panel_2.add(btnInsert_1);
		
		JLabel lblBookId_1 = new JLabel("Book Id*");
		lblBookId_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblBookId_1.setBounds(12, 27, 77, 16);
		panel_2.add(lblBookId_1);
		
		JLabel lblTitle = new JLabel("Title*");
		lblTitle.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblTitle.setBounds(12, 85, 77, 16);
		panel_2.add(lblTitle);
		
		JLabel lblPublisherName = new JLabel("Publisher name*");
		lblPublisherName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblPublisherName.setBounds(12, 147, 131, 16);
		panel_2.add(lblPublisherName);
		
		JLabel lblAuthorName = new JLabel("Author name*");
		lblAuthorName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblAuthorName.setBounds(12, 216, 116, 16);
		panel_2.add(lblAuthorName);
		
		JLabel lblSection = new JLabel("Section*");
		lblSection.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblSection.setBounds(12, 289, 77, 16);
		panel_2.add(lblSection);
		
		JLabel lblAvailability = new JLabel("Location*");
		lblAvailability.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblAvailability.setBounds(12, 362, 116, 16);
		panel_2.add(lblAvailability);
		
		JPanel panel_3 = new JPanel();
		tabbedPane_1.addTab("Delete", null, panel_3, null);
		panel_3.setLayout(null);
		
		panel_3.add(comboBox);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try { 
					String ins="delete from book where Book_Id=\""+comboBox.getItemAt(comboBox.getSelectedIndex())+"\""+"; ";
				
				    Statement pst;
					pst = connection.createStatement();
				    pst.executeUpdate(ins);
				    try{
				    	table=new JTable();
						scrollPane.setViewportView(table);
						PreparedStatement pst2 = connection.prepareStatement("select * from book;");
					    ResultSet rs=pst2.executeQuery();
					    table.setModel(DbUtils.resultSetToTableModel(rs));
				
						delusers();
						DefaultComboBoxModel mode =new DefaultComboBoxModel(bd);
						comboBox.setModel(mode);
						
						DefaultComboBoxModel mod =new DefaultComboBoxModel(bd);
						comboBox_2.setModel(mod);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				} catch (SQLException e) {
			    	JOptionPane.showMessageDialog(null,e.toString());
				}
			}
		});
		btnNewButton.setBounds(313, 52, 97, 25);
		panel_3.add(btnNewButton);
		
		JLabel lblBookId = new JLabel("Book Id");
		lblBookId.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblBookId.setBounds(12, 56, 64, 16);
		panel_3.add(lblBookId);
		
		JPanel panel_4 = new JPanel();
		tabbedPane_1.addTab("Update", null, panel_4, null);
		panel_4.setLayout(null);
		
		
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String query="Select* from book where Book_Id=\""+comboBox_2.getItemAt(comboBox_2.getSelectedIndex())+"\"; ";
				PreparedStatement pst;
				try {
					pst = database.connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					rs.first();
					textField_11.setText(rs.getString(2));
					textField_12.setText(rs.getString(3));
					textField_13.setText(rs.getString(4));
					textField_14.setText(rs.getString(5));
					textField_15.setText(rs.getString(6));
				
					
					}
					
				
				catch (SQLException e) {
			    	JOptionPane.showMessageDialog(null,e.toString());
				
				}
				
				
				
				
				
			}
		});
		comboBox_2.setBounds(139, 31, 169, 22);
		panel_4.add(comboBox_2);
		
		textField_11 = new JTextField();
		textField_11.setBounds(139, 97, 169, 22);
		panel_4.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(139, 157, 169, 22);
		panel_4.add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(139, 218, 169, 22);
		panel_4.add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setBounds(139, 283, 169, 22);
		panel_4.add(textField_14);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setBounds(139, 354, 176, 22);
		panel_4.add(textField_15);
		textField_15.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(textField_11.getText().isEmpty()||textField_12.getText().isEmpty()||textField_13.getText().isEmpty()||textField_14.getText().isEmpty()||textField_15.getText().isEmpty())
						throw new Exception();
					String ins="update book  set Title=\""+textField_11.getText()+"\",Publisher_name=\""+textField_12.getText()+"\",Author_name=\""+textField_13.getText()+"\",Section=\""+textField_14.getText()+"\",Location=\""+textField_15.getText()+"\"   where Book_Id=\""+comboBox_2.getItemAt(comboBox_2.getSelectedIndex())+"\"; ";
                 try{Statement pst;
					    pst = connection.createStatement();
					    pst.executeUpdate(ins);
					    table=new JTable();
						scrollPane.setViewportView(table);
						PreparedStatement ps = connection.prepareStatement("select* from book;");
					    ResultSet rs=ps.executeQuery();
					    table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					
				
				catch (SQLException e) {
			    	JOptionPane.showMessageDialog(null,e.toString());
				}} 
				catch(Exception e)
					{
					  JOptionPane.showMessageDialog(null,"Fill all compulsary fields");
					}
			}
		});
		btnUpdate.setBounds(290, 431, 97, 25);
		panel_4.add(btnUpdate);
		
		JLabel label = new JLabel("Book Id*");
		label.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		label.setBounds(12, 33, 77, 16);
		panel_4.add(label);
		
		JLabel lblTitle_1 = new JLabel("Title*");
		lblTitle_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblTitle_1.setBounds(12, 99, 77, 16);
		panel_4.add(lblTitle_1);
		
		JLabel lblPublisherName_1 = new JLabel("Publisher name*");
		lblPublisherName_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblPublisherName_1.setBounds(12, 159, 128, 16);
		panel_4.add(lblPublisherName_1);
		
		JLabel lblAuthorName_1 = new JLabel("Author name*");
		lblAuthorName_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblAuthorName_1.setBounds(12, 220, 115, 16);
		panel_4.add(lblAuthorName_1);
		
		JLabel lblSection_1 = new JLabel("Section*");
		lblSection_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblSection_1.setBounds(12, 285, 77, 16);
		panel_4.add(lblSection_1);
		
		JLabel lblLocation = new JLabel("Location*");
		lblLocation.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblLocation.setBounds(12, 356, 77, 16);
		panel_4.add(lblLocation);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("User", null, panel_1, null);
		panel_1.setLayout(null);
		
		final JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 13, 753, 509);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		PreparedStatement pst2;
		try {
			pst2 = connection.prepareStatement("Select * from user;");
		ResultSet rs2=pst2.executeQuery();
		table_1.setModel(DbUtils.resultSetToTableModel(rs2));
		
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBounds(774, 13, 421, 509);
		panel_1.add(tabbedPane_2);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_2.addTab("Insert", null, panel_5, null);
		panel_5.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(114, 34, 228, 22);
		panel_5.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(114, 101, 228, 22);
		panel_5.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(114, 174, 228, 22);
		panel_5.add(textField_2);
		textField_2.setColumns(10);
        final JComboBox comboBox_3 = new JComboBox(ud);
        comboBox_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		String query="Select* from user where User_Id=\""+comboBox_3.getItemAt(comboBox_3.getSelectedIndex())+"\"; ";
				PreparedStatement pst;
				try {
					pst = database.connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					rs.first();
					textField_16.setText(rs.getString(2));
					textField_17.setText(rs.getString(3));
					textField_18.setText(rs.getString(4));
					textField_19.setText(rs.getString(5));
					
				
					
					}
					
				
				catch (SQLException e) {
			    	JOptionPane.showMessageDialog(null,e.toString());
				
				}
        	}
        });
		final JComboBox comboBox_1 = new JComboBox(ud);
		comboBox_1.setBounds(108, 31, 174, 22);
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(textField.getText().isEmpty()||textField_1.getText().isEmpty()||textField_2.getText().isEmpty())
						throw new Exception();
				String query="insert into user values(\""+textField.getText()+"\",\""+textField_1.getText()+"\",\""+textField_2.getText()+"\",\""+textField_3.getText()+"\",\""+textField_4.getText()+"\"); ";
				String query2="select * from user;"; 
				try {
					Statement ps = connection.createStatement();
					ps.executeUpdate(query);
					table_1=new JTable();
					scrollPane_1.setViewportView(table_1);
					PreparedStatement pst = connection.prepareStatement(query2);
				    ResultSet rs=pst.executeQuery();
				    table_1.setModel(DbUtils.resultSetToTableModel(rs));
				    
				    textField.setText(null);textField_1.setText(null);textField_4.setText(null);textField_2.setText(null);textField_3.setText(null);
				    delusers();
				    DefaultComboBoxModel mode =new DefaultComboBoxModel(ud);
					comboBox_1.setModel(mode);
					DefaultComboBoxModel model =new DefaultComboBoxModel(ud);
					comboBox_3.setModel(model);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.toString());
				}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Fill all compulsary fields");
				}
				
				
			
				
			}
		});
		btnInsert.setBounds(281, 425, 97, 25);
		panel_5.add(btnInsert);
		
		textField_3 = new JTextField();
		textField_3.setBounds(114, 246, 228, 22);
		panel_5.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(114, 316, 228, 22);
		panel_5.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User Id*");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblNewLabel.setBounds(25, 37, 77, 16);
		panel_5.add(lblNewLabel);
		
		JLabel lblUserName = new JLabel("User name*");
		lblUserName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblUserName.setBounds(25, 104, 88, 16);
		panel_5.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password*");
		lblPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblPassword.setBounds(25, 176, 88, 16);
		panel_5.add(lblPassword);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblPhone.setBounds(25, 248, 56, 16);
		panel_5.add(lblPhone);
		
		JLabel lblEmailId = new JLabel("E-mail Id");
		lblEmailId.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblEmailId.setBounds(25, 319, 77, 16);
		panel_5.add(lblEmailId);
		
		JPanel panel_6 = new JPanel();
		tabbedPane_2.addTab("Delete", null, panel_6, null);
		panel_6.setLayout(null);
		
		panel_6.add(comboBox_1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try { 
					String ins="delete from user where User_Id=\""+comboBox_1.getItemAt(comboBox_1.getSelectedIndex())+"\""+"; ";
				
				    Statement pst;
					pst = connection.createStatement();
				    pst.executeUpdate(ins);
				    try{
				    	table_1=new JTable();
						scrollPane_1.setViewportView(table_1);
						PreparedStatement pst2 = connection.prepareStatement("select * from user;");
					    ResultSet rs=pst2.executeQuery();
					    table_1.setModel(DbUtils.resultSetToTableModel(rs));
				
						delusers();
						DefaultComboBoxModel mode =new DefaultComboBoxModel(ud);
						comboBox_1.setModel(mode);
						DefaultComboBoxModel model =new DefaultComboBoxModel(ud);
						comboBox_3.setModel(model);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				} catch (SQLException e) {
			    	JOptionPane.showMessageDialog(null,e.toString());
				}
			}
		});
		btnDelete.setBounds(294, 30, 97, 25);
		panel_6.add(btnDelete);
		
		JLabel lblUserId = new JLabel("User Id");
		lblUserId.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblUserId.setBounds(23, 34, 86, 16);
		panel_6.add(lblUserId);
		
		JPanel panel_7 = new JPanel();
		tabbedPane_2.addTab("Update", null, panel_7, null);
		panel_7.setLayout(null);
		
		
		comboBox_3.setBounds(112, 38, 214, 22);
		panel_7.add(comboBox_3);
		
		textField_16 = new JTextField();
		textField_16.setBounds(112, 109, 214, 22);
		panel_7.add(textField_16);
		textField_16.setColumns(10);
		
		textField_17 = new JTextField();
		textField_17.setBounds(112, 171, 214, 22);
		panel_7.add(textField_17);
		textField_17.setColumns(10);
		
		textField_18 = new JTextField();
		textField_18.setBounds(112, 242, 214, 22);
		panel_7.add(textField_18);
		textField_18.setColumns(10);
		
		textField_19 = new JTextField();
		textField_19.setBounds(112, 315, 214, 22);
		panel_7.add(textField_19);
		textField_19.setColumns(10);
		
		JLabel label_1 = new JLabel("User Id*");
		label_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		label_1.setBounds(12, 40, 77, 16);
		panel_7.add(label_1);
		
		JLabel label_2 = new JLabel("User name*");
		label_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		label_2.setBounds(12, 112, 88, 16);
		panel_7.add(label_2);
		
		JLabel label_3 = new JLabel("Password*");
		label_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		label_3.setBounds(12, 174, 88, 16);
		panel_7.add(label_3);
		
		JLabel label_4 = new JLabel("Phone");
		label_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		label_4.setBounds(12, 245, 56, 16);
		panel_7.add(label_4);
		
		JLabel label_5 = new JLabel("E-mail Id");
		label_5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		label_5.setBounds(12, 317, 77, 16);
		panel_7.add(label_5);
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(textField_16.getText().isEmpty()||textField_17.getText().isEmpty())
						throw new Exception();
					String ins="update user  set User_name=\""+textField_16.getText()+"\",password=\""+textField_17.getText()+"\",phone=\""+textField_18.getText()+"\",email=\""+textField_19.getText()+"\"   where User_Id=\""+comboBox_3.getItemAt(comboBox_3.getSelectedIndex())+"\"; ";
                 try{Statement pst;
					    pst = connection.createStatement();
					    pst.executeUpdate(ins);
					    table_1=new JTable();
						scrollPane_1.setViewportView(table_1);
						PreparedStatement ps = connection.prepareStatement("select* from user;");
					    ResultSet rs=ps.executeQuery();
					    table_1.setModel(DbUtils.resultSetToTableModel(rs));
					}
					
				
				catch (SQLException e) {
			    	JOptionPane.showMessageDialog(null,e.toString());
				}} 
				catch(Exception e)
					{
					  JOptionPane.showMessageDialog(null,"Fill all compulsary fields");
					}
			}
		});
		btnUpdate_1.setBounds(307, 441, 97, 25);
		panel_7.add(btnUpdate_1);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(Color.BLUE);
		toolBar.setBounds(0, 0, 1439, 43);
		frame.getContentPane().add(toolBar);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guiframe.frame.setVisible(true);
				frame.dispose();
			}
		});
		Image img2= new ImageIcon(this.getClass().getResource("/frame-back-icon.png")).getImage();
		button.setIcon(new ImageIcon(img2));
		toolBar.add(button);
		button.setBackground(Color.BLUE);
		
		JLabel lblAdministratorWindow = new JLabel("Administrator Window");
		lblAdministratorWindow.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		toolBar.add(lblAdministratorWindow);
		lblAdministratorWindow.setForeground(Color.WHITE);
		lblAdministratorWindow.setBackground(Color.BLUE);
	}
}
