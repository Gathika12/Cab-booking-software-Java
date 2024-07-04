package Cab_Booking;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class view_book_cab extends JFrame {
	private JPanel contentpane;
	 private JTable table; // Declare the JTable here

	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                	view_book_cab frame = new view_book_cab();
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }

	    public view_book_cab() {
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(180, 20, 1000, 700); // Adjust the frame size
	        setTitle("View book Cab");
	        setResizable(false);
	        contentpane = new JPanel();
	        contentpane.setBackground(Color.LIGHT_GRAY);
	        contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentpane);
	        contentpane.setLayout(null);
	        
	        JButton b2 = new JButton("Back");
			b2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					 Admin_add_cab.main(new String[] {});
					dispose();
					
				}
				
			});
			b2.setBackground(Color.black);
			b2.setForeground(Color.white);
			b2.setFont(new Font("Times new Roman",Font.PLAIN,20));
			b2.setBounds(650,500,200,50);
			contentpane.add(b2);

	        // Create a DefaultTableModel to hold the data
	        DefaultTableModel model = new DefaultTableModel();

	        // Define database connection parameters
	        String jdbcUrl = "jdbc:mysql://localhost:3306/cab2_management";
	        String dbusername = "root";
	        String dbpassword = "";

	        // Define the SQL SELECT statement to retrieve data
	        String sqlSelect = "SELECT vehicle_id,username,destination_to,destination_from,cab_number,cab_type,owner_id FROM admin_add_cab";

	        try {
	            // Establish a database connection
	            Connection connection = DriverManager.getConnection(jdbcUrl, dbusername, dbpassword);

	            // Create a PreparedStatement to execute the SQL SELECT statement
	            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelect);

	            // Execute the SELECT statement and retrieve the result set
	            ResultSet resultSet = preparedStatement.executeQuery();

	            // Get the column names from the ResultSet
	            int columnCount = resultSet.getMetaData().getColumnCount();
	            for (int i = 1; i <= columnCount; i++) {
	                model.addColumn(resultSet.getMetaData().getColumnName(i));
	            }

	            // Add rows to the table model from the result set
	            while (resultSet.next()) {
	                Object[] row = new Object[columnCount];
	                for (int i = 0; i < columnCount; i++) {
	                    row[i] = resultSet.getObject(i + 1);
	                }
	                model.addRow(row);
	            }

	            // Close the resources
	            resultSet.close();
	            preparedStatement.close();
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        // Create the JTable with the model and add it to a JScrollPane
	        table = new JTable(model);
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(0, 0, 1000, 700);
	        contentpane.add(scrollPane);
	    }
	}


