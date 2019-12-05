package model;

public class CartItem {
	  int productID;
	  int customerID; 
	  int storeID;
	  int qty;
	  String date;
	  String description; 
	  int price; 
	   
	  
	  public CartItem() {

			
		}
	/**
	 * @param productID
	 * @param qty
	 * @param data
	 */
	public CartItem(int productID, int customerID, int storeID, int qty, String date) {
		super();
		this.productID = productID;
		this.customerID = customerID; 
		this.storeID = storeID; 
		this.qty = qty;
		this.date = date;
	}
	
	@Override
	public String toString() {
		Product product = new Product(productID, description, price, qty);
		return "Cart item with productID = " + productID + " name = " + product.getDescription() + " quantity = " + qty + " and price " + product.getPrice();
	}
	
	
	public CartItem(int productID, String description, int price, int qty) {
		super();
		this.productID = productID;
		this.description = description; 
		this.price = price; 
		this.qty = qty;
	
	}
	/**
	 * @return the productID
	 */
	public int getProductID() {
		return productID;
	}
	/**
	 * @param productID the productID to set
	 */
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	
	public int getCustomerID() {
		return customerID; 
	}
	
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	public void setStoreID(int storeID) {
		this.storeID = storeID; 
	}
	
	public int getStoreID() {
		return storeID; 
	}
	
	/**
	 * @return the qty
	 */
	public int getQty() {
		return qty;
	}
	/**
	 * @param qty the qty to set
	 */
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	
	}
	
}
