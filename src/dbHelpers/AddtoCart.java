package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//import model.Cart;
//import model.CartItem;
import model.Product;


public class AddtoCart {
	
	private int productID; 
	private int qty; 
	private int price; 
	private String description; 
	Product product = new Product(); 
	  public Connection connection;
	private ResultSet results;
	  
	  public AddtoCart(String dbName, String uname, String pwd) {
			String url = "jdbc:mysql://localhost:3306/"+dbName + "?serverTimezone=UTC";
	  
			try {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				this.connection = DriverManager.getConnection(url, uname, pwd);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	  }
	  
	  public int getProductID(String description) {
		  
		  String query = "select productID, description, price, qty from Product where description = ? ";

		  try {
			  
			  //this needs to be an array list so we can create a for loop to populate the array list
			PreparedStatement ps = connection.prepareStatement(query);
			
			
			ps.setString(1, description);
			
			
			this.results = ps.executeQuery(); 
			this.results.next();
			
	 
		    product.setProductID(this.results.getInt(1));
		    product.setDescription(this.results.getString(2));
		    product.setPrice(this.results.getInt(3));
		    product.setQty(this.results.getInt(4));
		   
		    productID = product.getProductID();
		    price = product.getPrice();
		    description = product.getDescription(); 
		    
		    
	    
		
			}	  
		 
		  
		  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productID;		 
		  
	  }
	  
	  public int getQty(int productID) {
		  String query = "select productID, description, price, qty from Product where productID = ? ";

		  try {
			  
			  //this needs to be an array list so we can create a for loop to populate the array list
			PreparedStatement ps = connection.prepareStatement(query);
			
			
			ps.setInt(1, productID);
			
			this.results = ps.executeQuery(); 
			this.results.next();
			
	 
		    product.setProductID(this.results.getInt(1));
		    product.setDescription(this.results.getString(2));
		    product.setPrice(this.results.getInt(3));
		    product.setQty(this.results.getInt(4));
		    
		    
		    qty = product.getQty();
		    
	    
		
			}	  
		 
		  
		  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qty;		
	  }
	 
	  public int getPrice(int productID) {
		  String query = "select productID, description, price, qty from Product where productID = ? ";

		  try {
			  
			  //this needs to be an array list so we can create a for loop to populate the array list
			PreparedStatement ps = connection.prepareStatement(query);
			
			
			ps.setInt(1, productID);
			
			this.results = ps.executeQuery(); 
			this.results.next();
			
	 
		    product.setProductID(this.results.getInt(1));
		    product.setDescription(this.results.getString(2));
		    product.setPrice(this.results.getInt(3));
		    product.setQty(this.results.getInt(4));
		    
		     price = product.getPrice();
		    
	    
		
			}	  
		 
		  
		  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return price;		
	  }
	  
	  public String getDescription(int productID) {
		  String query = "select productID, description, price, qty from Product where productID = ? ";

		  try {
			  
			  //this needs to be an array list so we can create a for loop to populate the array list
			PreparedStatement ps = connection.prepareStatement(query);
			
			
			ps.setInt(1, productID);
			
			this.results = ps.executeQuery(); 
			this.results.next();
			
	 
		    product.setProductID(this.results.getInt(1));
		    product.setDescription(this.results.getString(2));
		    product.setPrice(this.results.getInt(3));
		    product.setQty(this.results.getInt(4));
		    
		     description = product.getDescription();
		    
	    
		
			}	  
		 
		  
		  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return description;		
	  }
	  
}
