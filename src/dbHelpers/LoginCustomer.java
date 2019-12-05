package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.Customer;




public class LoginCustomer {
  public Connection connection;
  //private ResultSet results; 
  
	private PreparedStatement authenticateUserStatement;
  
	  public LoginCustomer(String dbName, String uname, String pwd) {
			String url = "jdbc:mysql://localhost:3306/"+dbName + "?serverTimezone=UTC";
	  
			try {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				this.connection = DriverManager.getConnection(url, uname, pwd);
			authenticateUserStatement = connection.prepareStatement("select * from Customer_Account where uname=? and pword=?");
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
	  }
	  
		public Customer authenticateUser(String uname, String pword) {
			Customer customer = null;
			try {
				//Add parameters to the ?'s in the preparedstatement and execute
				authenticateUserStatement.setString(1, uname);
				authenticateUserStatement.setString(2, pword);
				ResultSet rs = authenticateUserStatement.executeQuery();
				
				//if we've returned a row, turn that row into a new user object
				if (rs.next()) {
					customer = new Customer(rs.getInt("customerID"), rs.getString("uname"), rs.getString("pword"));
				}
				
			} catch (SQLException e) {
				System.out.println(e.getClass().getName() + ": " + e.getMessage());
			}
			return customer;
			
		}

}
