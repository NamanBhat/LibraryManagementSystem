import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.RowFilter;

import java.awt.Color;
import javax.swing.JButton;

import net.proteanit.sql.DbUtils;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Searchbook {

	JFrame frame;
	private JTextField textField;
	private JButton btnNewButton;
	private JTable table;
    DefaultTableModel dm;
	/**
	 * Launch the application.
	 */
	public static Connection connection=null;
	private JButton btnShowAll;
	private JToolBar toolBar_1;
	private JLabel lblNewLabel;
	private JButton btnBack;
	/**
	 * Create the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Searchbook window = new Searchbook();
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
	public Searchbook() {
		connection=database.dbconnector();
		initialize();
	}
	void filter(String d){
		
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 1166, 612);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 125, 1058, 409);
		frame.getContentPane().add(scrollPane);
		Image img= new ImageIcon(this.getClass().getResource("/search-icon (1).png")).getImage();
		
		
		
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
		
		btnShowAll = new JButton("Show all");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PreparedStatement pst1;
				try {
					pst1 = connection.prepareStatement("Select * from book;");
				ResultSet rs2=pst1.executeQuery();
				table=new JTable();
				scrollPane.setViewportView(table);
				table.setModel(DbUtils.resultSetToTableModel(rs2));
				
				} 
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
				textField.setText(null);
			}
		});
		btnShowAll.setBounds(994, 87, 97, 25);
		frame.getContentPane().add(btnShowAll);
		
		toolBar_1 = new JToolBar();
		toolBar_1.setBackground(Color.BLUE);
		toolBar_1.setBounds(0, 0, 1148, 31);
		frame.getContentPane().add(toolBar_1);
		
		btnBack = new JButton("");

		Image img2= new ImageIcon(this.getClass().getResource("/frame-back-icon.png")).getImage();
		btnBack.setIcon(new ImageIcon(img2));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mai.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnBack.setBackground(Color.BLUE);
		toolBar_1.add(btnBack);
		
		lblNewLabel = new JLabel("  Search Window");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLUE);
		toolBar_1.add(lblNewLabel);
		btnNewButton = new JButton("");
		btnNewButton.setBounds(10, 31, 55, 55);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(img));
		
		textField = new JTextField();
		textField.setBackground(new Color(175, 238, 238));
		textField.setBounds(68, 42, 1020, 31);
		frame.getContentPane().add(textField);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(!textField.getText().isEmpty()){
					PreparedStatement pst1;
					try {
						pst1 = connection.prepareStatement("Select * from book;");
					ResultSet rs2=pst1.executeQuery();
					table=new JTable();
					scrollPane.setViewportView(table);
					table.setModel(DbUtils.resultSetToTableModel(rs2));
					
					} 
					catch (SQLException e1) 
					{
						e1.printStackTrace();
					}
				}
				if(!textField.getText().isEmpty())
				{  PreparedStatement  pst1;
				String s=textField.getText().toLowerCase();
					try {
						pst1 = connection.prepareStatement("Select * from book where lower(Book_Id) like \'%"+s+"%\' or lower(Title) like \'%"+s+"%\' or lower(Publisher_name) like \'%"+s+"%\' or lower(Author_name) like \'%"+s+"%\' or lower(Section) like \'%"+s+"%\' ;");
					ResultSet rs2=pst1.executeQuery();
					table=new JTable();
					scrollPane.setViewportView(table);
					table.setModel(DbUtils.resultSetToTableModel(rs2));
					
					} 
					catch (SQLException e1) 
					{
						e1.printStackTrace();
					}
				}
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(10);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField, btnNewButton}));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
	}
}
