package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.Product;

public class ReadProduct {
	private Connection connection;
	private ResultSet results; 
	
	public ReadProduct(String dbName, String uname, String pwd) {
		String url = "jdbc:mysql://localhost:3306/"+dbName + "?serverTimezone=UTC";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	public Product readProduct(int productID) {
		
	String query = "select description from Product where productID = ? ";
	Product product = new Product(); 
	
	
	try {
		PreparedStatement ps = connection.prepareStatement(query);
		System.out.println("productID = "+productID);
		ps.setInt(1, productID);
		this.results.next();
		product.setProductID(this.results.getInt(1));
		product.setDescription(this.results.getString(2));

		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return product; 
}


	

}
