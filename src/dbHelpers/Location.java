package dbHelpers;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import model.Customer;





public class Location {
  public Connection connection;
	  
	  public Location(String dbName, String uname, String pwd) {
			String url = "jdbc:mysql://localhost:3306/"+dbName + "?serverTimezone=UTC";
	  
			try {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				this.connection = DriverManager.getConnection(url, uname, pwd);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	  }
	  
	  public int findLocation(int zipCode) {
		  String query = "select city, storeID from store where zipcode = ?";
		
		  try {
			PreparedStatement ps = connection.prepareStatement(query);
	
//			//ps.setInt(1, cart.getPurchaseID());
//			ps.setInt(1, p.getCustomerID());
//			ps.setInt(2, p.getStoreID());
			
			Customer cust = new Customer();
			  
			ps.setInt(1, cust.getUserZip(zipCode));
			
		    ps.executeUpdate(); 
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		  
		  return zipCode; 
		  
	  }
	  
}