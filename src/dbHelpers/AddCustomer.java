package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Customer;

public class AddCustomer {
	  public Connection connection;
	  
	  public AddCustomer(String dbName, String uname, String pwd) {
			String url = "jdbc:mysql://localhost:3306/"+dbName + "?serverTimezone=UTC";
	  
			try {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				this.connection = DriverManager.getConnection(url, uname, pwd);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	  }
	  
	  
	  public void doAdd(Customer customer) {
		  String query = "insert into Customer_Account ( fName, lName, address, email, uname, pword) values (?,?,?,?,?,?)";
		  
		  try {
			PreparedStatement ps = connection.prepareStatement(query);
		
			ps.setString(1, customer.getfName());
			ps.setString(2, customer.getlName());
			ps.setString(3, customer.getAddress());
			ps.setString(4, customer.getEmail());
			ps.setString(5, customer.getUname()); 
			ps.setString(6, customer.getPword()); 
			
			ps.executeUpdate(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 
	  }
}
