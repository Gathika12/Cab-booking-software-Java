package Cab_Booking;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.util.*;


public class Loginin extends JFrame {
	private JPanel contentpane;
	public static void main(String[] args) {
		EventQueue. invokeLater(new Runnable() {
			public void run() {

				try {
					Loginin frame = new Loginin();
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});

}
	public Loginin() {
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
		l2.setFont(new Font("Airal",Font.BOLD,35));
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
		
		JButton b1=new JButton("Login");
		b1.addActionListener(new ActionListener() {

			 public void actionPerformed(ActionEvent e) {
			  
				    String username =t1.getText();
			        String password = t2.getText(); 
			        

					String jdbcUrl="jdbc:mysql://localhost:3306/cab2_management";
					String dbusername="root";
					String dbpassword="";
					   try {
				            Connection connection = DriverManager.getConnection(jdbcUrl,dbusername,dbpassword );

				            String selectQuery = "SELECT * FROM Signup WHERE username = ? AND password = ?";
				            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
				            selectStatement.setString(1, username);
				            selectStatement.setString(2, password);

				            ResultSet resultSet = selectStatement.executeQuery();
				            selectStatement.close();
				            connection.close();
				                
				                Home_Page.main(new String[] {});
					            dispose();
				       
				        } catch (Exception ex) {
				            ex.printStackTrace();
				         
				        }
			        
			 
			    }
			
		});
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(120,240,150,40);
		contentpane.add(b1);
		
		JButton b2=new JButton("SignUp");
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SignUp.main(new String[] {});
				dispose();
				
			}
			
		});
		b2.setBackground(Color.RED);
		b2.setForeground(Color.white);
		b2.setBounds(320,240,150,40);
		contentpane.add(b2);
		
		JLabel l15= new JLabel();
		l15.setBounds(40,20,300,100);
		contentpane.add(l15);
		
		ImageIcon icon = new ImageIcon("lmagesn/ui.jpg");
		Image img = icon.getImage();
		Image modifiedimage = img.getScaledInstance(100, 90, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(modifiedimage);
		l15.setIcon(icon);
		
		
	}
}
