package Cab_Booking;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.sql.*;
import java.util.*;

public class SignUp extends JFrame {
	private JPanel contentpane;
	public static void main(String[] args) {
		EventQueue. invokeLater(new Runnable() {
			public void run() {

				try {
					SignUp frame = new SignUp ();
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	
}
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400,150,600,380);
		setTitle("Create New Account");
		setResizable(false);
		contentpane=new JPanel();
		contentpane.setBorder(new EmptyBorder(5,5,5,5));
		contentpane.setBackground(Color.LIGHT_GRAY);
		setContentPane(contentpane);
		contentpane.setLayout(null);
		
		
		JLabel l1=new JLabel("Username");
		l1.setFont(new Font("Times new Roman",Font.PLAIN,20));
		l1.setBounds(40,30,100,30);
		contentpane.add(l1);
		
		JLabel l2=new JLabel("Name");
		l2.setFont(new Font("Times new Roman",Font.PLAIN,20));
		l2.setBounds(40,90,100,30);
		contentpane.add(l2);
		
		JLabel l3=new JLabel("Password");
		l3.setFont(new Font("Times new Roman",Font.PLAIN,20));
		l3.setBounds(40,150,100,30);
		contentpane.add(l3);
		
		JLabel l4=new JLabel("Phone No");
		l4.setFont(new Font("Times new Roman",Font.PLAIN,20));
		l4.setBounds(40,210,100,30);
		contentpane.add(l4);
		
		JTextField t1=new JTextField();
		t1.setBounds(180,30,150,30);
		contentpane.add(t1);
		
		JTextField t2=new JTextField();
		t2.setBounds(180,90,150,30);
		contentpane.add(t2);
		
		JPasswordField t3=new JPasswordField();
		t3.setBounds(180,150,150,30);
		contentpane.add(t3);
		
		JTextField t4=new JTextField();
		t4.setBounds(180,210,150,30);
		contentpane.add(t4);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource(""));
		Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l5 = new JLabel(i3);
		l5.setBounds(350,70,150,150);
		contentpane.add(l5);
		
		JButton b1=new JButton("SignUp");
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username=t1.getText();
				String name=t2.getText();
				String password=t3.getText();
				String phone=t4.getText();
				
				
				System.out.println(username);
				System.out.println(name);
				System.out.println(password);
				System.out.println(phone);
				
				int len=phone.length();
				if(len != 10) {
					JOptionPane.showMessageDialog(b1, "Enter a vaild mobile number");
				}else {
					String jdbcUrl="jdbc:mysql://localhost:3306/cab2_management";
					String dbusername="root";
					String dbpassword="";
				
					
					try {
						Connection connection=DriverManager.getConnection(jdbcUrl,dbusername,dbpassword);
						Statement statement=connection.createStatement();
						
						String insertQuery="INSERT INTO Signup(username,name,password,phone)VALUES(?,?,?,?)";
						PreparedStatement insertStatement=connection.prepareStatement(insertQuery);
						
						
						insertStatement.setString(1,username);
						insertStatement.setString(2,name);
						insertStatement.setString(3,password);
						insertStatement.setString(4,phone);
						int ret=insertStatement.executeUpdate();
						  JOptionPane.showMessageDialog(b1, "New record added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
						
					}catch(SQLException ex) {
						ex.printStackTrace();
						
						 JOptionPane.showMessageDialog(b1, "Error adding record: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
								
			}
			
		});
		b1.setBackground(Color.red);
		b1.setForeground(Color.white);
		b1.setBounds(40,280,120,30);
		contentpane.add(b1);
		
		JButton b2=new JButton("Back");
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Loginin.main(new String[] {});
				dispose();
				
			}
			
		});
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(210,280,120,30);
		contentpane.add(b2);
		
		JLabel l15= new JLabel();
		l15.setBounds(370,100,300,100);
		contentpane.add(l15);
		
		ImageIcon icon = new ImageIcon("lmagesn/99.png");
		Image img = icon.getImage();
		Image modifiedimage = img.getScaledInstance(200, 150, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(modifiedimage);
		l15.setIcon(icon);
			
		
	}
		
	}

