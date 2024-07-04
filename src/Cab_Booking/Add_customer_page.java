package Cab_Booking;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.util.*;

public class Add_customer_page extends JFrame {
	private JPanel contentpane;
	public static void main(String[] args) {
		EventQueue. invokeLater(new Runnable() {
			public void run()
			{
				try {
					Add_customer_page frame = new Add_customer_page();
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Add_customer_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100,1014,597);
		setTitle("Add Employee");
		setResizable(false);
		contentpane=new JPanel();
		contentpane.setBackground(Color.LIGHT_GRAY);
		contentpane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		
		
		JLabel l1=new JLabel("New Customer Register");
		l1.setFont(new Font("Times new Roman",Font.PLAIN,45));
		l1.setBounds(300,52,650,50);
		contentpane.add(l1);
		
		JLabel l2= new JLabel("User Id");
		l2.setFont(new Font("Times new Roman",Font.PLAIN,20));
		l2.setBounds(60,150,120,30);
		contentpane.add(l2);
		
		JLabel l3= new JLabel("Age");
		l3.setFont(new Font("Times new Roman",Font.PLAIN,20));
		l3.setBounds(60,200,120,30);
		contentpane.add(l3);
		
		JLabel l4= new JLabel("Address");
		l4.setFont(new Font("Times new Roman",Font.PLAIN,20));
		l4.setBounds(60,250,120,30);
		contentpane.add(l4);
		
		JLabel l5= new JLabel("Email Id");
		l5.setFont(new Font("Times new Roman",Font.PLAIN,20));
		l5.setBounds(60,300,120,30);
		contentpane.add(l5);
		
		JLabel l6= new JLabel("Gender");
		l6.setFont(new Font("Times new Roman",Font.PLAIN,20));
		l6.setBounds(60,350,120,30);
		contentpane.add(l6);
		
		JLabel l7= new JLabel("Name");
		l7.setFont(new Font("Times new Roman",Font.PLAIN,20));
		l7.setBounds(500,150,120,30);
		contentpane.add(l7);
		
		JLabel l8= new JLabel("Date Of Birth");
		l8.setFont(new Font("Times new Roman",Font.PLAIN,20));
		l8.setBounds(500,200,120,30);
		contentpane.add(l8);
		
		JLabel l9= new JLabel("Phone");
		l9.setFont(new Font("Times new Roman",Font.PLAIN,20));
		l9.setBounds(500,250,120,30);
		contentpane.add(l9);
		
		JLabel l10= new JLabel("Country");
		l10.setFont(new Font("Times new Roman",Font.PLAIN,20));
		l10.setBounds(500,300,120,30);
		contentpane.add(l10);
		
		JLabel l11= new JLabel("City");
		l11.setFont(new Font("Times new Roman",Font.PLAIN,20));
		l11.setBounds(500,350,120,30);
		contentpane.add(l11);
		
		JTextField t1 =new JTextField();
		t1.setBounds(220,150,150,30);
		contentpane.add(t1);
		
		JTextField t2 =new JTextField();
		t2.setBounds(220,200,150,30);
		contentpane.add(t2);
		
		JTextField t3 =new JTextField();
		t3.setBounds(220,250,150,30);
		contentpane.add(t3);
		
		JTextField t4 =new JTextField();
		t4.setBounds(220,300,150,30);
		contentpane.add(t4);
		
		JTextField t5 =new JTextField();
		t5.setBounds(220,350,150,30);
		contentpane.add(t5);
		
		JTextField t6 =new JTextField();
		t6.setBounds(660,150,150,30);
		contentpane.add(t6);
		
		JTextField t7 =new JTextField();
		t7.setBounds(660,200,150,30);
		contentpane.add(t7);
		
		JTextField t8 =new JTextField();
		t8.setBounds(660,250,150,30);
		contentpane.add(t8);
		
		JTextField t9 =new JTextField();
		t9.setBounds(660,300,150,30);
		contentpane.add(t9);
		
		JTextField t10 =new JTextField();
		t10.setBounds(660,350,150,30);
		contentpane.add(t10);
		
		JButton b1 = new JButton("Submit");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				Integer userid =Integer.parseInt(t1.getText()); 
				Integer Age = Integer.parseInt(t2.getText());
				String Address = t3.getText();
				String Emailid  = t4.getText();
				String Gender = t5.getText();
				String Name = t6.getText();
				String Dateofbirth = t7.getText();
				String Phone  = t8.getText();
				String Country = t9.getText();
				String city = t10.getText();
				
				
				System.out.println(userid);
				System.out.println(Age);
				System.out.println(Address);
				System.out.println(Emailid);
				System.out.println(Gender);
				System.out.println(Name);
				System.out.println(Dateofbirth);
				System.out.println( Phone );
				System.out.println(Country);
				System.out.println(city);
				
				int len=Phone.length();
				if(len != 10) {
					JOptionPane.showMessageDialog(b1, "Enter a vaild mobile number");
				}
				else {
					String jdbcUrl="jdbc:mysql://localhost:3306/cab2_management";
					String dbusername="root";
					String dbpassword="";
					
					try
					{
						Connection connection=DriverManager.getConnection(jdbcUrl,dbusername,dbpassword);
						Statement statement=connection.createStatement();
						
						String insertQuery="INSERT INTO add_customer(userid,Age,Address,Emailid,Gender,Name,Dateofbirth,Phone,Country,city)VALUES(?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement insertStatement=connection.prepareStatement(insertQuery);
						
						
						insertStatement.setInt(1,userid);
						insertStatement.setInt(2,Age);
						insertStatement.setString(3,Address);
						insertStatement.setString(4,Emailid);
						insertStatement.setString(5,Gender);
						insertStatement.setString(6,Name);
						insertStatement.setString(7,Dateofbirth);
						insertStatement.setString(8, Phone );
						insertStatement.setString(9,Country);
						insertStatement.setString(10,city);
						int ret=insertStatement.executeUpdate();
						
						  JOptionPane.showMessageDialog(b1, "Details Successfully Inserted", "Message", JOptionPane.INFORMATION_MESSAGE);
					}catch(SQLException ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(b1, "Error adding record: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
			}
		});
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setFont(new Font("Times new Roman",Font.PLAIN,20));
		b1.setBounds(250,450,200,50);
		contentpane.add(b1);
		
		JButton b2 = new JButton("Back");
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Home_Page.main(new String[] {});
				dispose();
				
			}
			
		});
		b2.setBackground(Color.red);
		b2.setForeground(Color.white);
		b2.setFont(new Font("Times new Roman",Font.PLAIN,20));
		b2.setBounds(530,450,200,50);
		contentpane.add(b2);
		
		JLabel l15= new JLabel();
		l15.setBounds(40,20,300,100);
		contentpane.add(l15);
		
		ImageIcon icon = new ImageIcon("lmagesn/customers.jpg");
		Image img = icon.getImage();
		Image modifiedimage = img.getScaledInstance(180, 120, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(modifiedimage);
		l15.setIcon(icon);
		
		JLabel l16= new JLabel();
		l16.setBounds(750,20,300,100);
		contentpane.add(l16);
		
		ImageIcon icon1 = new ImageIcon("lmagesn/345.png");
		Image img1 = icon1.getImage();
		Image modifiedimage1 = img1.getScaledInstance(180, 120, java.awt.Image.SCALE_SMOOTH);
		icon1 = new ImageIcon(modifiedimage1);
		l16.setIcon(icon1);
		
	}
	

}
