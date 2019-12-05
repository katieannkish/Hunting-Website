package dbHelpers;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import model.CartItem;
import model.Product;
import model.Purchase;



public class MakePurchase {
  public Connection connection;
	  
	  public MakePurchase(String dbName, String uname, String pwd) {
			String url = "jdbc:mysql://localhost:3306/"+dbName + "?serverTimezone=UTC";
	  
			try {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				this.connection = DriverManager.getConnection(url, uname, pwd);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	  }
	  
	  public void doAdd(Purchase p) {
		  String query = "insert into Purchase (customerID, storeID) values (?,?)";
		
		  try {
			PreparedStatement ps = connection.prepareStatement(query);
	
			//ps.setInt(1, cart.getPurchaseID());
			ps.setInt(1, p.getCustomerID());
			ps.setInt(2, p.getStoreID());
			
			
			
			ps.executeUpdate(); 
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	  }
	  
	  public void updateInventory(Product pr) {
		  String query = "update Product set qty = qty - ? WHERE productID = ?";
		 
		  try {
				PreparedStatement ps = connection.prepareStatement(query);
				CartItem ci = new CartItem(); 
				ps.setInt(1, ci.getQty());
				ps.setInt(2, pr.getProductID()); 
				//System.out.println(ps + toString());
				
				ps.executeUpdate(); 
			
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
				  
	  }
}

