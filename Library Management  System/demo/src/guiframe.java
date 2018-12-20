import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JToolBar;



public class guiframe {

	static JFrame frame;
	JLabel lbl;
    JPasswordField passwordField;
	JButton lblm;
	public static String t;
	static Connection co;
	static String userid=null;
	static String un=null;
	static String ph=null;
	static String pa=null;
	static String em=null;

	/**
	 * Launch the application.
	 * 
	 */
	private static String password="1555";
	private static String username="Naman";
    JTextField textField;
	private JLabel lblJv;
	private JButton btnLogIn;
	private JButton btnBack;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiframe window = new guiframe(t);
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
	public guiframe(String s) {

		co=database.dbconnector();
		t=new String(s);
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 632, 292);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		lbl = new JLabel("Password");
		lbl.setFont(new Font("Sylfaen", Font.BOLD, 13));
		lbl.setBounds(38, 107, 120, 22);
		frame.getContentPane().add(lbl);
		
		passwordField = new JPasswordField();
		

		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    
			    

				
					
				
			}
		});
		passwordField.setBounds(195, 105, 344, 22);
		frame.getContentPane().add(passwordField);
		
		JLabel lbl2 = new JLabel(t+" Id");
		lbl2.setFont(new Font("Sylfaen", Font.BOLD, 13));
		lbl2.setBounds(38, 77, 136, 16);
		frame.getContentPane().add(lbl2);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
              
				
			}
		});
		textField.setBounds(195, 72, 344, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblJv = new JLabel(t);
		lblJv.setForeground(Color.RED);
		lblJv.setFont(new Font("Bernard MT Condensed", Font.BOLD, 20));
		lblJv.setBounds(197, 18, 289, 41);
		frame.getContentPane().add(lblJv);
		
		btnLogIn = new JButton("Log in");

		Image img= new ImageIcon(this.getClass().getResource("/secrecy-icon.png")).getImage();
		btnLogIn.setIcon(new ImageIcon(img));
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(t.equals("Librarian"))
				{
					boolean u=false;boolean v=false;
					try
					{   if(textField.getText().isEmpty())
						throw new Exception();
					
						if(textField.getText().equals(username))u=true;
						try
						{   if(new String(passwordField.getPassword()).isEmpty())
							throw new Exception();
							if(new String(passwordField.getPassword()).equals(password))v=true;
							 if(u&v)
								    
								    	try {
								    		frame.setVisible(false);
											Librarian window = new Librarian();
											window.frame.setVisible(true);
										} catch (Exception e) {
											e.printStackTrace();
										}
								    else  {
								    	JOptionPane.showMessageDialog(null, "INCORRECT PASSWORD OR USERNAME");
								    
								    }
						}
						catch(Exception e)
						{
					    	JOptionPane.showMessageDialog(null, "Password field empty");
							
						}
					}
					catch(Exception e)
					{
				    	JOptionPane.showMessageDialog(null, "User name field empty");
						
					}
					textField.setText(null);
					passwordField.setText(null);
				}
				if(t.equals("Administrator"))
				{
					boolean u=false;boolean v=false;
					try
					{   if(textField.getText().isEmpty())
						throw new Exception();
					
						if(textField.getText().equals(username))u=true;
						try
						{   if(new String(passwordField.getPassword()).isEmpty())
							throw new Exception();
							if(new String(passwordField.getPassword()).equals(password))v=true;
							 if(u&v)
								 try {  
									 frame.setVisible(false);
										database window = new database();
										window.frame.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								    	
								    else  {
								    	JOptionPane.showMessageDialog(null, "INCORRECT PASSWORD OR USERNAME");
								    
								    }
						}
						catch(Exception e)
						{
					    	JOptionPane.showMessageDialog(null, "Password field empty");
							
						}
					}
					catch(Exception e)
					{
				    	JOptionPane.showMessageDialog(null, "User name field empty");
						
					}
					textField.setText(null);
					passwordField.setText(null);
				}
				if(t.equals("User")){
					
					try
					{   if(textField.getText().isEmpty())throw new Exception();
						try {
							String query="Select* from user where User_Id=\""+textField.getText()+"\" and password=\""+new String(passwordField.getPassword())+"\" ; ";
							PreparedStatement pst = co.prepareStatement(query);
							ResultSet rs=pst.executeQuery();

							try
							{   if(new String(passwordField.getPassword()).isEmpty()){
								throw new Exception();}
                                
								
								
								 try
									 {
									   if(!rs.next())throw new Exception();
									   try {
										    frame.setVisible(false);
											user window = new user(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
											window.frame.setVisible(true);
										} catch (Exception e) {
											e.printStackTrace();
										}}
									    catch(Exception lo)  {
									    	JOptionPane.showMessageDialog(null, "INCORRECT PASSWORD OR USERNAME");
									    
									    }
							}
							catch(Exception e)
							{
						    	JOptionPane.showMessageDialog(null,"Password Field is empty");
								
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					catch(Exception e)
					{
				    	JOptionPane.showMessageDialog(null, "User name field empty");
						
					}
					textField.setText(null);
					passwordField.setText(null);
				}
				
					
			   
			   
				
			}
		});
		btnLogIn.setBounds(203, 197, 168, 35);
		frame.getContentPane().add(btnLogIn);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(Color.LIGHT_GRAY);
		toolBar.setBounds(0, 0, 614, 25);
		frame.getContentPane().add(toolBar);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 13));
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.BLUE);
		toolBar.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mai.frame.setVisible(true);
				frame.dispose();
			}
		});
	}
}
