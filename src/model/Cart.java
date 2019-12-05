package model;


import java.util.ArrayList;

import dbHelpers.ReadProduct;




public class Cart {
	int customerID;
	int storeID; 
	int purchaseID; 
	int productID; 
	int quantity; 
    //arrayList of cartItem objects for each customer 
	ArrayList<CartItem> cartItems  = new ArrayList<CartItem>();
	
	public Cart(int customerID) {
		this.customerID = customerID;
	}
	
	public Cart() {
	
	}
	public int getCustomerID() {
		return customerID;
	}

    public void addItem(CartItem item) {
    	cartItems.add(item);
    }
    
    public ArrayList<CartItem> getItems() {
    	return cartItems;
    }
    
    public void clearItems() {
    	cartItems.clear();
    }
    
    @SuppressWarnings("unused")
	public void removeItem() {
    	Cart cart = new Cart(); 
    	for(int i = 0; i < cartItems.size(); i++) {
    		cartItems.remove(i);
    		break; 
    	}
    }
   
    
    @Override
    public String toString() {
    	String result = "Cart with items:\n";
    	for (CartItem x : cartItems) {
    		result += x.toString() + "\n";
    	}
    	return result;
    }
    
    

	/**
	 * @return the purchaseID
	 */
	public int getPurchaseID() {
		return purchaseID;
	}

	/**
	 * @param purchaseID the purchaseID to set
	 */
	public void setPurchaseID(int purchaseID) {
		this.purchaseID = purchaseID;
	}

	/**
	 * @return the storeID
	 */
	public int getStoreID() {
		return storeID;
	}

	/**
	 * @param storeID the storeID to set
	 */
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}

	/**
	 * @param customerID the customerID to set
	 */
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	/**
	 * @return the productID
	 */
	public int getProductID(int productID) {
		return productID;
	}

	/**
	 * @param productID the productID to set
	 */
	public void setProductID(int productID) {
		this.productID = productID;
	}

	public void setQuantity(int int1) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	public String getTable() {
		String table = "";
		table += "<table border= 1>"; 
		for(int i = 0; i< cartItems.size(); i++) {
			Cart cart = new Cart(); 
    		table +="<tr>";
    		table +="<td>";
		    table += cartItems.get(i); 
			table +="</td>"; 
			table +="<td>";
			table += "<a href=delete?qty=" + cart.getQuantity() + ">delete</a>";
			table +="</td>";
			table +="</tr>";
    	}
		return table; 
	}
	
	

//public String getTable() {
//		String table = "";
//		table += "<table border= 1>"; 
//		table +="<tr>";
//		table +="<th>";
//		table +="Product";
//		table +="</th>";  
//		table +="<th>";
//		table +="Product ID";
//		table +="</th>"; 
//		table +="<th>";
//		table +="Price";
//		table +="</th>"; 
//		table +="<th>";
//		table +="Quantity";
//		table +="</th>"; 
//		table +="</tr>";
//		
//		for(int i = 0; i< cartItems.size(); i++) {
//			Cart cart = new Cart(); 
//    		
//    		table +="<tr>";
//    		table +="<td>";
//		   // table += add something to get the product name 
//			table +="</td>";
//    		table +="<td>";
//		    table += cart.getProductID(i); 
//			table +="</td>";
//			table +="<td>";
//			   // table += add something to get the price
//				table +="</td>";
//			table +="<td>";
//		    table += cart.getQuantity(); 
//			table +="</td>";
//    		table +="<td>";
//		    table += cartItems.get(i); //we might not need this anymore
//			table +="</td>"; 
//			table +="<td>";
//			table += "<a href=update?qty=" + cart.getQuantity() + ">update</a>  <a href=delete?qty=" + cart.getQuantity() + ">delete</a>";
//			table +="</td>";
//			table +="</tr>";
//    	}
//		return table; 
//	}

	
	   public String createTable() {
		   Cart cart = new Cart(); 
	
	    	String table = ""; 
	    	table += "<table border= 1>"; 
	    	// loop through the arraylist of cartItems
	    	for(int i = 0; i< cartItems.size(); i++) {
	    		table +="<tr>";
	    		table +="<td>";
			    table += cartItems.get(i); 
				table +="</td>"; 
				table +="<td>";
				table += "<a href=delete?qty=" + cart.getQuantity() + ">delete</a>";
				table +="</td>";
				table +="</tr>";
	    	}
	    	
	    	  // query the database to get the product info using productid
	    	ReadProduct rp = new ReadProduct("hunting", "root", "H@rryP0ter");
	    	Product product = rp.readProduct(cart.getProductID(productID)); // pass the productid
//	    	  // add the product info and fields of the cartITem as a table row
//	    	 
	    	 
	    	table +="<tr>";
	    	
			table +="<td>";
			table += product.getDescription(); 
			table +="</td>"; 
			table +="<td>";
			table += product.getPrice(); 
			table +="</td>";
		

			table +="</tr>";
	    	
	    	  // add other items to row - like remove button, update quantity
	
	    	
	    	
	    	return table; 
	    }
	    
	
	
}
	


