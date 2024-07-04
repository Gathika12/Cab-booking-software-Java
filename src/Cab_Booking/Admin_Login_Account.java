package Cab_Booking;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.util.*;

public class Admin_Login_Account extends JFrame {
	private JPanel contentpane;
	public static void main(String[] args) {
		EventQueue. invokeLater(new Runnable() {
			public void run() {

				try {
					Admin_Login_Account frame = new Admin_Login_Account();
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
}
	public Admin_Login_Account() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,100,580,350);
		setTitle("Login Account");
		setResizable(false);
		contentpane=new JPanel();
		contentpane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		
		JLabel l2=new JLabel("Login Account");
		l2.setBounds(190,30,500,50);
		l2.setFont(new Font("Airal",Font.BOLD,30));
		l2.setForeground(Color.pink);
		contentpane.add(l2);
				
		JLabel l3=new JLabel("Username :");
		l3.setBounds(120,120,150,30);
		l3.setFont(new Font("Airal",Font.BOLD,20));
		l3.setForeground(Color.ORANGE);
		contentpane.add(l3);
		
		
		JLabel l4=new JLabel("Password :");
		l4.setBounds(120,170,150,30);
		l4.setFont(new Font("Airal",Font.BOLD,20));
		l4.setForeground(Color.ORANGE);
		contentpane.add(l4);
		
		JTextField t1=new JTextField();
		t1.setBounds(320,120,150,30);
		contentpane.add(t1);
		
		JTextField t2=new JPasswordField();
		t2.setBounds(320,170,150,30);
		contentpane.add(t2);
		
		JButton b1 = new JButton("Login");
		b1.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		       
		    	 String enteredUsername =t1.getText();
		         String enteredPassword = t2.getText();
		         
		         System.out.println(enteredUsername);
		         System.out.println(enteredPassword);

		         if (enteredUsername.equals("admin") && enteredPassword.equals("admin123")) {
					  Admin_add_cab.main(new String[] {});
			            dispose();
			           
			        } else {
			            
			            JOptionPane.showMessageDialog(null, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
			        }	
		      
		    }
		});
		b1.setBackground(Color.red);
		b1.setForeground(Color.white);
		b1.setBounds(120, 240, 150, 40);
		contentpane.add(b1);
		
		JButton b2=new JButton("Next");
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Admin_add_cab.main(new String[] {});
				dispose();
				
			}
			
		});
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(320,240,150,40);
		contentpane.add(b2);
		
		JLabel l15= new JLabel();
		l15.setBounds(40,20,120,90);
		contentpane.add(l15);
		
		ImageIcon icon = new ImageIcon("lmagesn/logo.jpg");
		Image img = icon.getImage();
		Image modifiedimage = img.getScaledInstance(120, 70, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(modifiedimage);
		l15.setIcon(icon);

		
	}
}
