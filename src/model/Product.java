package model;

public class Product {
 int productID;
 String description;
 int price;
 String name; 
 int qty;
 
 public Product() {
		
	} 
 
 
 
/**
 * @param productID
 * @param description
 * @param price
 */
public Product(int productID, String description, int price, int qty) {
	super();
	this.productID = productID;
	this.description = description;
	this.price = price;
	this.qty = qty; 
}

@Override
public String toString() {
	 
	 return "product with product id = " + productID + " description = " + description + " qty = " + qty;
}


/**
 * @return the productID
 */
public int getProductID() {
	return productID;
}



public String getName() {
	return name; 
}


/**
 * @param productID the productID to set
 */
public void setProductID(int productID) {
	this.productID = productID;
}



/**
 * @return the description
 */
public String getDescription() {
	return description;
}



/**
 * @param description the description to set
 */
public void setDescription(String description) {
	this.description = description;
}



/**
 * @return the price
 */
public int getPrice() {
	return price;
}



/**
 * @param price the price to set
 */
public void setPrice(int price) {
	this.price = price;
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

 
}
