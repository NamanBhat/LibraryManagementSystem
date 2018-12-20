import java.awt.EventQueue;
import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class user {

	JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	
	static String ui1;
	static String un1;
	static String ph1;
	static String pa1;
	static String em1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user window = new user(ui1,un1,pa1,ph1,em1);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param t 
	 */
	public user(String a,String b,String c,String d,String e) {
		ui1=a;un1=b;pa1=c;ph1=d;em1=e;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private JTable table_1;
	private JTable table_2;
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(211, 211, 211));
		frame.setBounds(100, 100, 999, 701);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 219, 959, 411);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Edit profile", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewPhoneNo = new JLabel("New Phone no.");
		lblNewPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewPhoneNo.setBounds(111, 80, 168, 30);
		panel_1.add(lblNewPhoneNo);
		
		textField = new JTextField(ph1);
		textField.setBounds(262, 86, 289, 22);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewEmailId = new JLabel("New E-mail Id");
		lblNewEmailId.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewEmailId.setBounds(111, 137, 168, 30);
		panel_1.add(lblNewEmailId);
		
		textField_1 = new JTextField(em1);
		textField_1.setColumns(10);
		textField_1.setBounds(262, 143, 289, 22);
		panel_1.add(textField_1);
		
	
		
		JPanel panel_2 = new JPanel();
		panel_2.setToolTipText("");
		tabbedPane.addTab("Fine", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 13, 911, 334);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		String query2="Select Book_Id,Issue_date,Due_date,Return_date,Fine,Fine_Status from borrow where User_Id=\""+ui1+ "\";";
		PreparedStatement pst1;
		try {
			pst1 = guiframe.co.prepareStatement(query2);
		ResultSet rs2=pst1.executeQuery();
		table_1.setModel(DbUtils.resultSetToTableModel(rs2));
		
		JLabel lblTotalFinePending = new JLabel("Total fine pending                                                                 :");
		lblTotalFinePending.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		lblTotalFinePending.setBounds(56, 352, 495, 29);
		panel_2.add(lblTotalFinePending);
		String query3="select sum(Fine) from borrow where Fine_Status=\"PENDING\" and User_Id=\""+ui1+ "\";";
		pst1 = guiframe.co.prepareStatement(query3);
		ResultSet r=pst1.executeQuery();
		String ll="0";
		if(r.next())ll=r.getString(1);
		JLabel lblNewLabel_6 = new JLabel(ll);
		lblNewLabel_6.setBounds(628, 358, 120, 16);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblRs = new JLabel("Rs");
		lblRs.setBounds(592, 358, 56, 16);
		panel_2.add(lblRs);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Books Returned", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 782, 355);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		try{
			String query="Select Book_Id,Title,Author_name,Publisher_name,Issue_date,Return_date from borrow natural join book where Return_date is not null and User_Id=\""+ui1+ "\";";
			PreparedStatement pst=guiframe.co.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			JLabel lblName = new JLabel("Name         ");
			lblName.setFont(new Font("Verdana", Font.BOLD, 16));
			lblName.setBounds(12, 37, 151, 16);
			frame.getContentPane().add(lblName);
			
			JLabel lblNewLabel = new JLabel("User Id      ");
			lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 16));
			lblNewLabel.setBounds(12, 78, 140, 16);
			frame.getContentPane().add(lblNewLabel);
			
			JLabel lblPhoneNo = new JLabel("Phone no.  ");
			lblPhoneNo.setFont(new Font("Verdana", Font.BOLD, 16));
			lblPhoneNo.setBounds(12, 120, 140, 16);
			frame.getContentPane().add(lblPhoneNo);
			
			JLabel lblNewLabel_1 = new JLabel("E-mail Id    ");
			lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 16));
			lblNewLabel_1.setBounds(12, 164, 140, 16);
			frame.getContentPane().add(lblNewLabel_1);
			
			 JLabel lblNewLabel_2 = new JLabel(un1);
			lblNewLabel_2.setBounds(162, 39, 288, 16);
			frame.getContentPane().add(lblNewLabel_2);
			
			 JLabel lblNewLabel_3 = new JLabel(ui1);
			lblNewLabel_3.setBounds(162, 80, 318, 16);
			frame.getContentPane().add(lblNewLabel_3);
			
		    final JLabel lblNewLabel_4 = new JLabel(ph1);
			lblNewLabel_4.setBounds(164, 122, 318, 16);
			frame.getContentPane().add(lblNewLabel_4);
			
			final JLabel lblNewLabel_5 = new JLabel(em1);
			lblNewLabel_5.setBounds(164, 166, 288, 16);
			frame.getContentPane().add(lblNewLabel_5);
			JButton btnApply = new JButton("Apply");
			btnApply.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try{
						if(textField_1.getText().isEmpty()||textField.getText().isEmpty())
							throw new Exception();
						ph1=textField.getText();
						lblNewLabel_4.setText(ph1);
						em1=textField_1.getText();
						lblNewLabel_5.setText(em1);
						String ins="update user set phone =\""+ph1+"\" where User_Id=\""+ui1+"\"" ;
						String ins2="update user set email =\""+em1+"\" where User_Id=\""+ui1+"\"" ;
						Statement pst;
						try {
							pst = guiframe.co.createStatement();
							pst.executeUpdate(ins);pst.executeUpdate(ins2);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null, " Field empty ");
					}
				   
				}
			});
			btnApply.setBounds(262, 297, 97, 25);
			panel_1.add(btnApply);
			
			JPanel panel_3 = new JPanel();
			tabbedPane.addTab("Recently borrowed", null, panel_3, null);
			panel_3.setLayout(null);
			
			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(12, 13, 788, 343);
			panel_3.add(scrollPane_2);
			
			table_2 = new JTable();
			scrollPane_2.setViewportView(table_2);
			String qu="Select Book_Id,Title,Author_name,Publisher_name,Issue_date,Due_date from borrow natural join book where Return_date is null and User_Id=\""+ui1+ "\";";
			PreparedStatement pt=guiframe.co.prepareStatement(qu);
			ResultSet tr=pt.executeQuery();
			table_2.setModel(DbUtils.resultSetToTableModel(tr));
			
			JButton btnLogOut = new JButton("Log Out");
			btnLogOut.setBackground(new Color(255, 255, 255));
			btnLogOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					guiframe.frame.setVisible(true);
					frame.dispose();
				}
			});
			btnLogOut.setBounds(0, 0, 97, 25);
			frame.getContentPane().add(btnLogOut);
			
			JLabel label = new JLabel("");
			if(this.getClass().getResource("/"+ui1+".jpg")!=null)
			{Image img= new ImageIcon(this.getClass().getResource("/"+ui1+".jpg")).getImage();
			label.setIcon(new ImageIcon(img));}
			if(this.getClass().getResource("/"+ui1+".png")!=null)
			{Image img= new ImageIcon(this.getClass().getResource("/"+ui1+".png")).getImage();
			label.setIcon(new ImageIcon(img));}
			label.setBounds(734, 0, 201, 224);
			frame.getContentPane().add(label);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
