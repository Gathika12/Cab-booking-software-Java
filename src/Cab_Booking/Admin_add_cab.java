package Cab_Booking;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.util.*;

public class Admin_add_cab extends JFrame {
	private JPanel contentpane;
	public static void main(String[] args) {
		EventQueue. invokeLater(new Runnable() {
			public void run() {

				try {
					 Admin_add_cab frame = new  Admin_add_cab ();
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
public  Admin_add_cab() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(200,20,900,700);
	setTitle("Add cab");
	setResizable(false);
	contentpane=new JPanel();
	contentpane.setBackground(Color.LIGHT_GRAY);
	contentpane.setBorder(new EmptyBorder(5,5,5,5));
	setContentPane(contentpane);
	contentpane.setLayout(null);
	
	JLabel l1=new JLabel("Book Cab");
	l1.setFont(new Font("Times new Roman",Font.PLAIN,45));
	l1.setBounds(350,20,650,50);
	contentpane.add(l1);
	
	
	JLabel l2= new JLabel(" Vehicle Id");
	l2.setFont(new Font("Times new Roman",Font.PLAIN,20));
	l2.setBounds(400,100,120,30);
	contentpane.add(l2);
	
	JLabel l3= new JLabel("Username");
	l3.setFont(new Font("Times new Roman",Font.PLAIN,20));
	l3.setBounds(400,170,120,30);
	contentpane.add(l3);
	
	JLabel l4= new JLabel("Destination to");
	l4.setFont(new Font("Times new Roman",Font.PLAIN,20));
	l4.setBounds(400,240,150,30);
	contentpane.add(l4);
	
	JLabel l5= new JLabel("Destination from");
	l5.setFont(new Font("Times new Roman",Font.PLAIN,20));
	l5.setBounds(400,310,150,30);
	contentpane.add(l5);
	
	JLabel l6= new JLabel("Cab Number");
	l6.setFont(new Font("Times new Roman",Font.PLAIN,20));
	l6.setBounds(400,380,120,30);
	contentpane.add(l6);
	
	JLabel l7= new JLabel("Cab type");
	l7.setFont(new Font("Times new Roman",Font.PLAIN,20));
	l7.setBounds(400,450,120,30);
	contentpane.add(l7);
	
	JLabel l8= new JLabel("Owner Id");
	l8.setFont(new Font("Times new Roman",Font.PLAIN,20));
	l8.setBounds(400,520,150,30);
	contentpane.add(l8);

	
	JTextField t1 =new JTextField();
	t1.setBounds(650,100,200,30);
	contentpane.add(t1);
	
	
	JTextField t2 =new JTextField();
	t2.setBounds(650,170,200,30);
	contentpane.add(t2);
	
	JTextField t3 =new JTextField();
	t3.setBounds(650,240,200,30);
	contentpane.add(t3);
	
	JTextField t4 =new JTextField();
	t4.setBounds(650,310,200,30);
	contentpane.add(t4);
	
	JTextField t5 =new JTextField();
	t5.setBounds(650,380,200,30);
	contentpane.add(t5);
	
	JTextField t6 =new JTextField();
	t6.setBounds(650,450,200,30);
	contentpane.add(t6);
	
	JTextField t7 =new JTextField();
	t7.setBounds(650,520,200,30);
	contentpane.add(t7);
	
	JButton b1 = new JButton("Add Cab");
	b1.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			String vehicle_id = t1.getText();
			String username = t2.getText();
			String destination_to = t3.getText();
			String destination_from = t4.getText();
			String cab_number = t5.getText();
			String cab_type = t6.getText();
			String owner_id = t7.getText();
			
			
			System.out.println(vehicle_id);
			System.out.println(username);
			System.out.println(destination_to);
			System.out.println(destination_from);
			System.out.println(cab_number);
			System.out.println(cab_type);
			System.out.println(owner_id);
			

			String jdbcUrl="jdbc:mysql://localhost:3306/cab2_management";
			String dbusername="root";
			String dbpassword="";
			
			try {
				Connection connection=DriverManager.getConnection(jdbcUrl,dbusername,dbpassword);
				Statement statement=connection.createStatement();
				
				String insertQuery="INSERT INTO admin_add_cab  (vehicle_id,username,destination_to,destination_from,cab_number,cab_type,owner_id)VALUES(?,?,?,?,?,?,?)";
				PreparedStatement insertStatement=connection.prepareStatement(insertQuery);
				
				insertStatement.setString(1,vehicle_id);
				insertStatement.setString(2,username);
				insertStatement.setString(3,destination_to);
				insertStatement.setString(4,destination_from);
				insertStatement.setString(5,cab_number);
				insertStatement.setString(6,cab_type);
				insertStatement.setString(7,owner_id);
				int ret=insertStatement.executeUpdate();
				JOptionPane.showMessageDialog(b1, "Details Successfully Inserted", "Message", JOptionPane.INFORMATION_MESSAGE);
			}catch(SQLException ex)
			{
				ex.printStackTrace();
				JOptionPane.showMessageDialog(b1, "Error adding record: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
	});
	b1.setBackground(Color.orange);
	b1.setForeground(Color.black);
	b1.setFont(new Font("Times new Roman",Font.PLAIN,20));
	b1.setBounds(400,580,200,50);
	contentpane.add(b1);
	
	JButton b2 = new JButton("Next");
	b2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			View_Customer_details.main(new String[] {});
			dispose();
			
		}
		
	});
	b2.setBackground(Color.red);
	b2.setForeground(Color.white);
	b2.setFont(new Font("Times new Roman",Font.PLAIN,20));
	b2.setBounds(650,580,200,50);
	contentpane.add(b2);
	
	JButton b3 = new JButton("Back to Login home page ");
	b3.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Login_Home_page.main(new String[] {});
			dispose();
			
		}
		
	});
	b3.setBackground(Color.black);
	b3.setForeground(Color.white);
	b3.setFont(new Font("Times new Roman",Font.PLAIN,20));
	b3.setBounds(120,580,250,50);
	contentpane.add(b3);
	
	JLabel l15= new JLabel();
	l15.setBounds(60,330,300,200);
	contentpane.add(l15);
	
	ImageIcon icon = new ImageIcon("lmagesn/ed.jpg");
	Image img = icon.getImage();
	Image modifiedimage = img.getScaledInstance(310, 210, java.awt.Image.SCALE_SMOOTH);
	icon = new ImageIcon(modifiedimage);
	l15.setIcon(icon);
	
	JLabel l16= new JLabel();
	l16.setBounds(60,90,300,200);
	contentpane.add(l16);
	
	ImageIcon icon1 = new ImageIcon("lmagesn/190.jpg");
	Image img1 = icon1.getImage();
	Image modifiedimage1 = img1.getScaledInstance(300, 180, java.awt.Image.SCALE_SMOOTH);
	icon1 = new ImageIcon(modifiedimage1);
	l16.setIcon(icon1);
	
	
}
}
