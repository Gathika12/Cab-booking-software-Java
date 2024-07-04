package Cab_Booking;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.util.*;

public class Home_Page extends JFrame{
	private JPanel contentpane1;
	public static void main(String[] args) {
		EventQueue. invokeLater(new Runnable() {
			public void run() {

				try {
					Home_Page frame1 = new Home_Page ();
					frame1.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});

}
	public Home_Page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100,1000,600);
		setTitle("Cab Booking Home Page");
		setResizable(false);
		contentpane1=new JPanel();
		contentpane1.setBackground(Color.LIGHT_GRAY);
		contentpane1.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentpane1);
		contentpane1.setLayout(null);
		
		JLabel l1=new JLabel("DASH BOARD");
		l1.setFont(new Font("Times new Roman",Font.PLAIN,50));
		l1.setBackground(Color.red);
		l1.setForeground(Color.red);
		l1.setBounds(350,20,650,50);
		contentpane1.add(l1);
		
		JButton b1 = new JButton("Add Customer");
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Add_customer_page .main(new String[] {});
				dispose();
				
			}
			
		});
		b1.setBackground(Color.orange);
		b1.setForeground(Color.black);
		b1.setFont(new Font("Times new Roman",Font.PLAIN,20));
		b1.setBounds(100,100,200,50);
		contentpane1.add(b1);
		
		JButton b2 = new JButton("View Add,Update,Delete Details");
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				View_Data .main(new String[] {});
				dispose();
				
			}
			
		});
		b2.setBackground(Color.orange);
		b2.setForeground(Color.black);
		b2.setFont(new Font("Times new Roman",Font.PLAIN,20));
		b2.setBounds(350,100,300,50);
		contentpane1.add(b2);
		
		JButton b3 = new JButton("Update Customer");
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				update_details .main(new String[] {});
				dispose();
				
			}
			
		});
		b3.setBackground(Color.orange);
		b3.setForeground(Color.black);
		b3.setFont(new Font("Times new Roman",Font.PLAIN,20));
		b3.setBounds(700,100,200,50);
		contentpane1.add(b3);
		

		JButton b4 = new JButton("Delete Customer");
		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Delete .main(new String[] {});
				dispose();
				
			}
			
		});
		b4.setBackground(Color.orange);
		b4.setForeground(Color.black);
		b4.setFont(new Font("Times new Roman",Font.PLAIN,20));
		b4.setBounds(100,190,200,50);
		contentpane1.add(b4);
		
		JButton b5 = new JButton(" Book Intracity Cab");
		b5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Book_Intracity_Cab .main(new String[] {});
				dispose();
				
			}
			
		});
		b5.setBackground(Color.orange);
		b5.setForeground(Color.black);
		b5.setFont(new Font("Times new Roman",Font.PLAIN,20));
		b5.setBounds(360,190,250,50);
		contentpane1.add(b5);
		
		JButton b6 = new JButton("View intracity Cab Details");
		b6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				View_Intracity_Cab .main(new String[] {});
				dispose();
				
			}
			
		});
		b6.setBackground(Color.orange);
		b6.setForeground(Color.black);
		b6.setFont(new Font("Times new Roman",Font.PLAIN,20));
		b6.setBounds(660,190,250,50);
		contentpane1.add(b6);
		
		JButton b7 = new JButton("Book intercity Cab");
		b7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Book_Intercity_Cab .main(new String[] {});
				dispose();
				
			}
			
		});
		b7.setBackground(Color.orange);
		b7.setForeground(Color.black);
		b7.setFont(new Font("Times new Roman",Font.PLAIN,20));
		b7.setBounds(100,280,250,50);
		contentpane1.add(b7);
		
		JButton b8 = new JButton("View intercity Cab Details");
		b8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 View_Intercity_Cab .main(new String[] {});
				dispose();
				
			}
			
		});
		b8.setBackground(Color.orange);
		b8.setForeground(Color.black);
		b8.setFont(new Font("Times new Roman",Font.PLAIN,20));
		b8.setBounds(380,280,250,50);
		contentpane1.add(b8);
		
		JButton b9 = new JButton("Back to Login Home Page ");
		b9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login_Home_page .main(new String[] {});
				dispose();
				
			}
			
		});
		b9.setBackground(Color.orange);
		b9.setForeground(Color.black);
		b9.setFont(new Font("Times new Roman",Font.PLAIN,20));
		b9.setBounds(660,280,250,50);
		contentpane1.add(b9);
		
		JLabel l15= new JLabel();
		l15.setBounds(100,360,350,200);
		contentpane1.add(l15);
		
		ImageIcon icon = new ImageIcon("lmagesn/200.jpg");
		Image img = icon.getImage();
		Image modifiedimage = img.getScaledInstance(300, 180, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(modifiedimage);
		l15.setIcon(icon);
		
		
		JLabel l16= new JLabel();
		l16.setBounds(560,360,350,200);
		contentpane1.add(l16);
		
		ImageIcon icon1 = new ImageIcon("lmagesn/290.jpg");
		Image img1 = icon1.getImage();
		Image modifiedimage1 = img1.getScaledInstance(300, 180, java.awt.Image.SCALE_SMOOTH);
		icon1 = new ImageIcon(modifiedimage1);
		l16.setIcon(icon1);
		
		
		
		
		
		
		
	}
	
}
