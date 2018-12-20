import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JToolBar;


public class Librarian {

	JFrame frame;
	String[] users;
	String[] books;
	String[] retusers;
	String[] retbooks={""};
	String[] fs;
	JLabel lblNewLabel_5 = new JLabel("  "), lblNewLabel_6 = new JLabel(""), lblNewLabel_7 = new JLabel("") , lblNewLabel_8 = new JLabel("") , lblNewLabel_12 = new JLabel("") , lblNewLabel_13 = new JLabel("") , lblNewLabel_14 = new JLabel("") ;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Librarian window = new Librarian();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Librarian() {
	    avuab();
	    ret();
	    colfine();
		initialize();
	}
    void avuab(){
    	List <String>items=new ArrayList<String>();
		List <String>item=new ArrayList<String>();
		String query1="Select User_Id from user where User_Id not in (select User_Id from borrow where Return_date is null group by User_Id having count(Book_Id)>=2); ";
		String query2="Select Book_Id from book where Book_Id not in (select Book_Id from borrow where Return_date is null); ";
		PreparedStatement pst;
		try {
			pst = guiframe.co.prepareStatement(query1);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
				{items.add(rs.getString(1));
				}
			users=items.toArray(new String[items.size()]);
			pst = guiframe.co.prepareStatement(query2);
			ResultSet rs2=pst.executeQuery();
			while(rs2.next())
				{item.add(rs2.getString(1));
				}
			books=item.toArray(new String[item.size()]);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    void ret(){
    	List <String>items=new ArrayList<String>();
		String query1="select distinct User_Id from borrow where Return_date is null ; ";
		PreparedStatement pst;
		try {
			pst = guiframe.co.prepareStatement(query1);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
				{items.add(rs.getString(1));
				}
			retusers=items.toArray(new String[items.size()]);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    void colfine(){
    	List <String>items=new ArrayList<String>();
		String query1="select Transaction_Id from borrow where Return_date is not null and Fine is not null and Fine_Status=\"PENDING\"; ";
		PreparedStatement pst;
		try {
			pst = guiframe.co.prepareStatement(query1);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
				{items.add(rs.getString(1));
				}
			fs=items.toArray(new String[items.size()]);
			
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
		frame.setBounds(100, 100, 1241, 754);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(38, 94, 1136, 583);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Issue Book", null, panel, null);
		panel.setLayout(null);
		final JComboBox comboBox_4 = new JComboBox(fs);
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
                	if(comboBox_4.getSelectedIndex()==-1)  
			          throw new Exception ();
                	String query2="Select * from borrow where Transaction_Id=\""+comboBox_4.getItemAt(comboBox_4.getSelectedIndex())+ "\";";
				PreparedStatement pst1;
				String a = null,b = null,c = null,d = null,e = null,f = null,g = null;
				try {
					pst1 = guiframe.co.prepareStatement(query2);
				ResultSet rs3=pst1.executeQuery();
	            rs3.first();{
					
					a=new String(rs3.getString(2));
					b=new String(rs3.getString(3));
					c=new String(rs3.getString(4));
					d=new String(rs3.getString(5));
					e=new String(rs3.getString(6));
					f=new String(rs3.getString(7));
					g=new String(rs3.getString(8));
				};
				lblNewLabel_5.setText(a);
				lblNewLabel_5.setBounds(188, 144, 112, 20);
				
				
				lblNewLabel_6.setText(b);
				lblNewLabel_6.setBounds(188, 206, 112, 20);
				
				
				lblNewLabel_7.setText(c);
				lblNewLabel_7.setBounds(188, 273, 112, 20);
				
				
				lblNewLabel_8.setText(d);
				lblNewLabel_8.setBounds(740, 74, 112, 20);
				
				lblNewLabel_12.setText(e);
				lblNewLabel_12.setBounds(740, 144, 112, 20);
		
				
				lblNewLabel_13.setText("Rs "+f);
				lblNewLabel_13.setBounds(740, 206, 112, 20);
				
				
				lblNewLabel_14.setText(g);
				lblNewLabel_14.setBounds(740, 273, 112, 20);
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
                catch(Exception e)
                {
                	JOptionPane.showMessageDialog(null,"No Transaction Selected");
                }
				
			}
		});
		comboBox_4.setBounds(188, 71, 81, 22);
		final JComboBox comboBox = new JComboBox(users);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query2="Select User_Id,User_Name,phone,email from user where User_Id=\""+comboBox.getItemAt(comboBox.getSelectedIndex())+ "\";";
				PreparedStatement pst1;
				try {
					pst1 = guiframe.co.prepareStatement(query2);
				ResultSet rs2=pst1.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs2));
				
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		comboBox.setBounds(175, 35, 134, 22);
		panel.add(comboBox);
		final JComboBox comboBox_3 = new JComboBox(retbooks);
		comboBox_3.setBounds(675, 53, 202, 22);
		
		final JComboBox comboBox_2 = new JComboBox(retusers);
		comboBox_2.setBounds(148, 53, 202, 22);
		
		final JComboBox comboBox_1 = new JComboBox(books);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.removeAll();
				table_1.removeAll();
				String query2="Select * from book where Book_Id=\""+comboBox_1.getItemAt(comboBox_1.getSelectedIndex())+ "\";";
				PreparedStatement pst1;
				try {
					pst1 = guiframe.co.prepareStatement(query2);
				ResultSet rs2=pst1.executeQuery();
				table_1.setModel(DbUtils.resultSetToTableModel(rs2));
			
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		comboBox_1.setBounds(823, 35, 149, 22);
		panel.add(comboBox_1);
		
		JLabel lblUserid = new JLabel("User-Id");
		lblUserid.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblUserid.setBounds(86, 38, 77, 16);
		panel.add(lblUserid);
		
		JLabel lblBookid = new JLabel("Book-Id");
		lblBookid.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblBookid.setBounds(730, 36, 77, 16);
		panel.add(lblBookid);
		
		JButton btnIssue = new JButton("Issue");
		btnIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                try{
                	if(comboBox.getSelectedIndex()==-1||comboBox_1.getSelectedIndex()==-1)  
			          throw new Exception ();
				Statement pst;
				try {    
					PreparedStatement pst4 = guiframe.co.prepareStatement("Select * from borrow;");
					ResultSet rs3=pst4.executeQuery();
					int count=0;
					while(rs3.next())count++;
					String ins="insert into borrow values (\"t"+String.format("%04d",count)+"\",\""+comboBox.getItemAt(comboBox.getSelectedIndex())+"\",\""+comboBox_1.getItemAt(comboBox_1.getSelectedIndex())+"\",sysdate(),null,null,null,null); ";
					 DefaultTableModel mo= (DefaultTableModel) table.getModel();
				     mo.setRowCount(0);
				     DefaultTableModel mo2= (DefaultTableModel) table_1.getModel();
				     mo2.setRowCount(0);
					pst = guiframe.co.createStatement();
					pst.executeUpdate(ins);
					String query2="Select Transaction_Id,User_Id,Book_Id,Issue_date,Due_date from borrow where Return_date is null and User_Id=\""+comboBox.getItemAt(comboBox.getSelectedIndex())+ "\" and Book_Id=\""+comboBox_1.getItemAt(comboBox_1.getSelectedIndex())+"\";";
					PreparedStatement pst1;
					try {
						pst1 = guiframe.co.prepareStatement(query2);
					ResultSet rs2=pst1.executeQuery();
					table_2.setModel(DbUtils.resultSetToTableModel(rs2));
					}
					catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					users=null;
					books=null;
					avuab();
					retusers=null;
					ret();
					fs=null;
					colfine();
					DefaultComboBoxModel mode =new DefaultComboBoxModel(fs);
					comboBox_4.setModel(mode);
					DefaultComboBoxModel model =new DefaultComboBoxModel(retusers);
					comboBox_2.setModel(model);
					DefaultComboBoxModel model2 =new DefaultComboBoxModel(retbooks);
					comboBox_3.setModel(model2);
					DefaultComboBoxModel model3 =new DefaultComboBoxModel(users);
					comboBox.setModel(model3);
					DefaultComboBoxModel model4 =new DefaultComboBoxModel(books);
					comboBox_1.setModel(model4);
					
				} catch (Exception e) {
					
					JOptionPane.showMessageDialog(null,e.toString());
					
				}
                }
                catch(Exception e)
                {
                	if(comboBox.getSelectedIndex()==-1)JOptionPane.showMessageDialog(null,"No Valid issuer");
					if(comboBox_1.getSelectedIndex()==-1)JOptionPane.showMessageDialog(null,"All books issued");
                }
			}
		});
		btnIssue.setBounds(505, 501, 97, 25);
		panel.add(btnIssue);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 98, 525, 117);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(table);
   
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(555, 98, 516, 117);
		panel.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 268, 839, 127);
		panel.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		JLabel lblNewLabel_15 = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/200w (1).gif")).getImage();
		lblNewLabel_15.setIcon(new ImageIcon(img));
		lblNewLabel_15.setBounds(852, 268, 200, 134);
		panel.add(lblNewLabel_15);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Return book", null, panel_1, null);
		panel_1.setLayout(null);
		panel_1.add(comboBox_3);panel_1.add(comboBox_2);
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List <String>items=new ArrayList<String>();
				String query1="select Book_Id from borrow where Return_date is null and User_Id=\""+comboBox_2.getItemAt(comboBox_2.getSelectedIndex())+"\"; ";
				PreparedStatement pst;
				try {
					pst = guiframe.co.prepareStatement(query1);
					ResultSet rs=pst.executeQuery();
					while(rs.next())
						{items.add(rs.getString(1));
						}
					retbooks=items.toArray(new String[items.size()]);
					DefaultComboBoxModel model2 =new DefaultComboBoxModel(retbooks);
					comboBox_3.setModel(model2);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
			}
		});
		
		
		
		
		DefaultComboBoxModel model =new DefaultComboBoxModel(retusers);
		comboBox_2.setModel(model);
		
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
                	if(comboBox_2.getSelectedIndex()==-1||comboBox_3.getSelectedIndex()==-1)  
			          throw new Exception ();
				Statement pst;
				try {  
					
					
					String ins="update borrow set Return_date=sysdate() where User_Id= \""+comboBox_2.getItemAt(comboBox_2.getSelectedIndex())+"\" and Book_Id=\""+comboBox_3.getItemAt(comboBox_3.getSelectedIndex())+"\"; ";
				 
					pst = guiframe.co.createStatement();
					pst.executeUpdate(ins);
					String query2="Select * from borrow where User_Id=\""+comboBox_2.getItemAt(comboBox_2.getSelectedIndex())+ "\" and Book_Id=\""+comboBox_3.getItemAt(comboBox_3.getSelectedIndex())+"\";";
					PreparedStatement pst1;
					try {
						pst1 = guiframe.co.prepareStatement(query2);
					ResultSet rs2=pst1.executeQuery();
					table_3.setModel(DbUtils.resultSetToTableModel(rs2));
					}
					catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					retusers=null;
					
					List <String>items=new ArrayList<String>();
					String query1="select Book_Id from borrow where Return_date is null and User_Id=\""+comboBox_2.getItemAt(comboBox_2.getSelectedIndex())+"\"; ";
					PreparedStatement ps;
					try {
						ps = guiframe.co.prepareStatement(query1);
						ResultSet rs=ps.executeQuery();
						while(rs.next())
							{items.add(rs.getString(1));
							}
						retbooks=items.toArray(new String[items.size()]);
						DefaultComboBoxModel model2 =new DefaultComboBoxModel(retbooks);
						comboBox_3.setModel(model2);
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ret();
					users=null;
					books=null;
					avuab();
					fs=null;
					colfine();
					DefaultComboBoxModel mode =new DefaultComboBoxModel(fs);
					comboBox_4.setModel(mode);
					DefaultComboBoxModel model =new DefaultComboBoxModel(retusers);
					comboBox_2.setModel(model);
					DefaultComboBoxModel model2 =new DefaultComboBoxModel(retbooks);
					comboBox_3.setModel(model2);
					DefaultComboBoxModel model3 =new DefaultComboBoxModel(users);
					comboBox.setModel(model3);
					DefaultComboBoxModel model4 =new DefaultComboBoxModel(books);
					comboBox_1.setModel(model4);
					
				} catch (Exception e) {
					
					JOptionPane.showMessageDialog(null,e.toString());
					
				}
                }
                catch(Exception e)
                {
                	JOptionPane.showMessageDialog(null,"All books returned");
                }
				
			}
		});
		btnReturn.setBounds(485, 458, 97, 25);
		panel_1.add(btnReturn);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(109, 212, 840, 88);
		panel_1.add(scrollPane_3);
		
		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);
		
		JLabel label = new JLabel("User-Id");
		label.setFont(new Font("Verdana", Font.PLAIN, 16));
		label.setBounds(69, 54, 77, 16);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Book-Id");
		label_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		label_1.setBounds(596, 56, 77, 16);
		panel_1.add(label_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Collect Fine", null, panel_2, null);
		panel_2.setLayout(null);
		
		
		panel_2.add(comboBox_4);
		
		JLabel lblNewLabel = new JLabel("Transaction Id");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblNewLabel.setBounds(68, 74, 108, 16);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Id");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(68, 144, 56, 16);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Book Id");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(68, 206, 81, 16);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Issue Date");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(68, 273, 108, 16);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Due Date");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(623, 74, 97, 16);
		panel_2.add(lblNewLabel_4);
		lblNewLabel_5.setLocation(185, 137);
		lblNewLabel_5.setSize(97, 22);
		
		panel_2.add(lblNewLabel_5);
		
		panel_2.add(lblNewLabel_6);
		
	    panel_2.add(lblNewLabel_7);
		
		panel_2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Return Date");
		lblNewLabel_9.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblNewLabel_9.setBounds(623, 144, 97, 16);
		panel_2.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Fine");
		lblNewLabel_10.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblNewLabel_10.setBounds(623, 206, 56, 16);
		panel_2.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Fine Status");
		lblNewLabel_11.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		lblNewLabel_11.setBounds(623, 273, 97, 16);
		panel_2.add(lblNewLabel_11);
		
		
		panel_2.add(lblNewLabel_12);
		
		
		panel_2.add(lblNewLabel_13);
		
		
		panel_2.add(lblNewLabel_14);
		
		JButton btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
                	if(comboBox_4.getSelectedIndex()==-1)  
			          throw new Exception ();
				Statement pst;
				try { 
					String ins="update borrow set Fine_Status=\"PAID\" where Transaction_Id= \""+comboBox_4.getItemAt(comboBox_4.getSelectedIndex())+"\"; ";
				   pst = guiframe.co.createStatement();
					pst.executeUpdate(ins);
					lblNewLabel_14.setText("PAID");
					JOptionPane.showMessageDialog(null,"Fine paid successfully");
					fs=null;
					colfine();
					DefaultComboBoxModel mode =new DefaultComboBoxModel(fs);
					comboBox_4.setModel(mode);
					lblNewLabel_5.setText(null);
					lblNewLabel_6.setText(null);
					lblNewLabel_7.setText(null);
					lblNewLabel_8.setText(null);
					lblNewLabel_12.setText(null);
					lblNewLabel_13.setText(null);
					lblNewLabel_14.setText(null);
				} catch (Exception e) {
					
					JOptionPane.showMessageDialog(null,e.toString());
					
				}
                }
                catch(Exception e)
                {
                	JOptionPane.showMessageDialog(null,"No Transaction Selected");
                }
				
			
			}
		});
		btnPay.setBounds(845, 491, 97, 25);
		panel_2.add(btnPay);
		
		JLabel label_2 = new JLabel("");
		Image im= new ImageIcon(this.getClass().getResource("/1uJ9.gif")).getImage();
		label_2.setIcon(new ImageIcon(im));
		label_2.setBounds(766, 242, 260, 281);
		panel_2.add(label_2);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 1223, 32);
		frame.getContentPane().add(toolBar);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guiframe.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		toolBar.add(btnNewButton);
	}
}
