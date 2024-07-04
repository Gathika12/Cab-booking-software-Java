package Cab_Booking;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.util.*;

public class Delete extends JFrame {
	private JPanel contentpane;
	public static void main(String[] args) {
		EventQueue. invokeLater(new Runnable() {
			public void run() {

				try {
					Delete frame = new Delete();
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	public Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,10,900,700);
		setTitle("Delete Customer");
		setResizable(false);
		contentpane=new JPanel();
		contentpane.setBackground(Color.LIGHT_GRAY);
		contentpane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentpane);
		contentpane.setLayout(null);
		
		JLabel l1=new JLabel("Delete Customer");
		l1.setFont(new Font("Times new Roman",Font.PLAIN,45));
		l1.setBounds(350,20,650,50);
		contentpane.add(l1);
		
		JLabel l2= new JLabel("User Id");
		l2.setFont(new Font("Times new Roman",Font.PLAIN,20));
		l2.setBounds(400,100,120,30);
		contentpane.add(l2);
		
		JLabel l3= new JLabel("Name");
		l3.setFont(new Font("Times new Roman",Font.PLAIN,20));
		l3.setBounds(400,150,120,30);
		contentpane.add(l3);
		
		JLabel l4= new JLabel("Age");
		l4.setFont(new Font("Times new Roman",Font.PLAIN,20));
		l4.setBounds(400,200,120,30);
		contentpane.add(l4);
		
		JLabel l5= new JLabel("Date of birth");
		l5.setFont(new Font("Times new Roman",Font.PLAIN,20));
		l5.setBounds(400,250,120,30);
		contentpane.add(l5);
		
		JLabel l6= new JLabel("Address");
		l6.setFont(new Font("Times new Roman",Font.PLAIN,20));
		l6.setBounds(400,300,120,30);
		contentpane.add(l6);
		
		JLabel l7= new JLabel("Phone");
		l7.setFont(new Font("Times new Roman",Font.PLAIN,20));
		l7.setBounds(400,350,120,30);
		contentpane.add(l7);
		
		JLabel l8= new JLabel("Email");
		l8.setFont(new Font("Times new Roman",Font.PLAIN,20));
		l8.setBounds(400,400,120,30);
		contentpane.add(l8);
		
		JLabel l9= new JLabel("Country");
		l9.setFont(new Font("Times new Roman",Font.PLAIN,20));
		l9.setBounds(400,450,120,30);
		contentpane.add(l9);
		
		JLabel l10= new JLabel("Gender");
		l10.setFont(new Font("Times new Roman",Font.PLAIN,20));
		l10.setBounds(400,500,120,30);
		contentpane.add(l10);
		
		JLabel l11= new JLabel("City");
		l11.setFont(new Font("Times new Roman",Font.PLAIN,20));
		l11.setBounds(400,550,120,30);
		contentpane.add(l11);
		
		JTextField t10 = new JTextField();
		t10.setBounds(520,100,150,30);
		contentpane.add(t10);
		
		JTextField t1 =new JTextField();
		t1.setBounds(650,150,200,30);
		contentpane.add(t1);
		
		JTextField t2 =new JTextField();
		t2.setBounds(650,200,200,30);
		contentpane.add(t2);
		
		JTextField t3 =new JTextField();
		t3.setBounds(650,250,200,30);
		contentpane.add(t3);
		
		JTextField t4 =new JTextField();
		t4.setBounds(650,300,200,30);
		contentpane.add(t4);
		
		JTextField t5 =new JTextField();
		t5.setBounds(650,350,200,30);
		contentpane.add(t5);
		
		JTextField t6 =new JTextField();
		t6.setBounds(650,400,200,30);
		contentpane.add(t6);
		
		JTextField t7 =new JTextField();
		t7.setBounds(650,450,200,30);
		contentpane.add(t7);
		
		JTextField t8 =new JTextField();
		t8.setBounds(650,500,200,30);
		contentpane.add(t8);
		
		JTextField t9 =new JTextField();
		t9.setBounds(650,550,200,30);
		contentpane.add(t9);
				
		
		JButton b1 = new JButton("Delete Data");
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Integer userid =Integer.parseInt(t10.getText()); 

	                System.out.println("Deleting product with code: " + userid);

					String jdbcUrl="jdbc:mysql://localhost:3306/cab2_management";
					String dbusername="root";
					String dbpassword="";
					
					try {
						   Connection connection = DriverManager.getConnection(jdbcUrl, dbusername, dbpassword);
		                    String deleteQuery = "DELETE FROM add_customer WHERE userid=?";
		                    PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
		                    
		                    deleteStatement.setInt(1, userid);
		                    
		                    int rowsDeleted = deleteStatement.executeUpdate();

		                    deleteStatement.close();
		                    connection.close();
		                    
		                    if (rowsDeleted > 0) {
		                        // Data deleted successfully, show a message box
		                        JOptionPane.showMessageDialog(b1, "Data Deleted Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		                        // Clear text fields after deletion
		                        t1.setText("");
		                        t2.setText("");
		                        t3.setText("");
		                        t4.setText("");
		                        t5.setText("");
		                        t6.setText("");
		                        t8.setText("");
		                        t9.setText("");
		                        t10.setText("");
		                    } else {
		                        JOptionPane.showMessageDialog(b1, "No data deleted. Product code not found.", "Error", JOptionPane.ERROR_MESSAGE);
		                    }
		                } catch (Exception e1) {
		                    e1.printStackTrace();

					}
				
				
			}
			
		});
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setFont(new Font("Times new Roman",Font.PLAIN,20));
		b1.setBounds(400,600,200,50);
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
		b2.setBounds(650,600,200,50);
		contentpane.add(b2);
		
		JButton b3 = new JButton("Search");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer userid =Integer.parseInt(t10.getText());
				
				System.out.println("Searching for customer username: "+userid);
				
				String jdbcUrl="jdbc:mysql://localhost:3306/cab2_management";
				String dbusername="root";
				String dbpassword="";
				
				try
				{
					Connection connection=DriverManager.getConnection(jdbcUrl,dbusername,dbpassword);
				    String sql = "SELECT * FROM add_customer WHERE userid=?";
				    PreparedStatement preparedStatement = connection.prepareStatement(sql);
				    preparedStatement.setInt(1, userid);
				    
				    
				    ResultSet resultSet = preparedStatement.executeQuery();
				    
				    if (resultSet.next()) {
				    	 t1.setText(resultSet.getString("Name"));
				    	 t2.setText(resultSet.getString("Age"));
				    	 t3.setText(resultSet.getString("Dateofbirth"));
				    	 t4.setText(resultSet.getString("Address"));
				    	 t5.setText(resultSet.getString("Phone"));
				    	 t6.setText(resultSet.getString("Emailid"));
				    	 t7.setText(resultSet.getString("Country"));
				    	 t8.setText(resultSet.getString("Gender"));
				    	 t9.setText(resultSet.getString("city"));
				    	 
				    	 
				    }else {
				    	   JOptionPane.showMessageDialog(null, "Seach with username " + userid + " not found.");
				    }
				    resultSet.close();
		            preparedStatement.close();
		            connection.close();
				    
				}catch(Exception ex)
				{
					ex.printStackTrace();
					 JOptionPane.showMessageDialog(null, "Database connection error.");
				}
			}
		});
		b3.setBackground(Color.red);
		b3.setForeground(Color.white);
		b3.setFont(new Font("Times new Roman",Font.PLAIN,20));
		b3.setBounds(680,100,200,30);
		contentpane.add(b3);
		
		JLabel l15= new JLabel();
		l15.setBounds(60,340,300,200);
		contentpane.add(l15);
		
		ImageIcon icon = new ImageIcon("lmagesn/28.jpg");
		Image img = icon.getImage();
		Image modifiedimage = img.getScaledInstance(300, 200, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(modifiedimage);
		l15.setIcon(icon);
		
		JLabel l16= new JLabel();
		l16.setBounds(60,100,300,200);
		contentpane.add(l16);
		
		ImageIcon icon1 = new ImageIcon("lmagesn/590.jpeg");
		Image img1 = icon1.getImage();
		Image modifiedimage1 = img1.getScaledInstance(300, 180, java.awt.Image.SCALE_SMOOTH);
		icon1 = new ImageIcon(modifiedimage1);
		l16.setIcon(icon1);
	}

}

