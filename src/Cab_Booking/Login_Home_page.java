package Cab_Booking;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.util.*;

public class Login_Home_page extends JFrame {
	private JPanel contentpane;
	public static void main(String[] args) {
		EventQueue. invokeLater(new Runnable() {
			public void run() {

				try {
					Login_Home_page frame = new Login_Home_page();
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	public Login_Home_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100,700,300);
		setTitle("Home Page");
		setResizable(false);
		contentpane=new JPanel();
		contentpane.setBackground(Color.LIGHT_GRAY);
		contentpane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		
		JLabel l1=new JLabel("Cab Booking Management");
		l1.setFont(new Font("Times new Roman",Font.PLAIN,35));
		l1.setBounds(190,20,650,50);
		contentpane.add(l1);
		
		JLabel l2= new JLabel("Admin Login");
		l2.setFont(new Font("Times new Roman",Font.PLAIN,20));
		l2.setBounds(250,100,120,30);
		contentpane.add(l2);
		
		JLabel l3= new JLabel("Customer Login");
		l3.setFont(new Font("Times new Roman",Font.PLAIN,20));
		l3.setBounds(250,180,150,30);
		contentpane.add(l3);
		
		JButton b1 = new JButton("Login");
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Admin_Login_Account.main(new String[] {});
				dispose();
				
			}
			
		});
		b1.setFont(new Font("Times new Roman",Font.PLAIN,20));
		b1.setBounds(450,90,200,50);
		contentpane.add(b1);
		
		JButton b2 = new JButton("Login");
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Loginin.main(new String[] {});
				dispose();
				
			}
			
		});
		b2.setFont(new Font("Times new Roman",Font.PLAIN,20));
		b2.setBounds(450,170,200,50);
		contentpane.add(b2);
		
		JLabel l15= new JLabel();
		l15.setBounds(20,90,200,120);
		contentpane.add(l15);
		
		ImageIcon icon = new ImageIcon("lmagesn/120.jpg");
		Image img = icon.getImage();
		Image modifiedimage = img.getScaledInstance(200, 120, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(modifiedimage);
		l15.setIcon(icon);
		
		
	}

}
