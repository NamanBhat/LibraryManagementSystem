import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;



public class mai {

	static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mai window = new mai();
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
	public mai() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 778, 651);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Librarian");
		btnNewButton.setBounds(194, 287, 123, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				try {
					guiframe window = new guiframe("Librarian");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("User");
		btnNewButton_1.setBounds(194, 320, 123, 25);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				try {
					guiframe window = new guiframe("User");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Search books");
		btnNewButton_2.setBounds(194, 396, 123, 25);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				try {
					Searchbook window = new Searchbook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel label = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/200w.gif")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(355, 240, 375, 222);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		Image img2= new ImageIcon(this.getClass().getResource("/sc.png")).getImage();
		label_1.setIcon(new ImageIcon(img2));
		label_1.setBounds(112, 39, 123, 118);
		frame.getContentPane().add(label_1);
		
		JLabel lblLnetajiSubhashinstituteOf = new JLabel("NETAJI SUBHASH UNIVERSITY");
		lblLnetajiSubhashinstituteOf.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblLnetajiSubhashinstituteOf.setForeground(Color.RED);
		lblLnetajiSubhashinstituteOf.setBounds(246, 37, 465, 72);
		frame.getContentPane().add(lblLnetajiSubhashinstituteOf);
		
		JLabel lblOfTechnology = new JLabel("OF TECHNOLOGY");
		lblOfTechnology.setForeground(Color.RED);
		lblOfTechnology.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblOfTechnology.setBounds(323, 89, 230, 31);
		frame.getContentPane().add(lblOfTechnology);
		
		JLabel lblLibrarymanagementSystem = new JLabel("            Library-Management System");
		lblLibrarymanagementSystem.setForeground(Color.BLUE);
		lblLibrarymanagementSystem.setBounds(295, 130, 348, 16);
		frame.getContentPane().add(lblLibrarymanagementSystem);
		
		JButton btnNewButton_3 = new JButton("Administrator");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				try {
					guiframe window = new guiframe("Administrator");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(194, 358, 123, 25);
		frame.getContentPane().add(btnNewButton_3);
	}
}
