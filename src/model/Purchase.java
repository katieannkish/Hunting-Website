package model;

public class Purchase {
 int purchaseID; 
 int customerID;
 int storeID;
/**
 * 
 */
public Purchase() {
	super();
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
 * @return the customerID
 */
public int getCustomerID() {
	return customerID;
}
/**
 * @param customerID the customerID to set
 */
public void setCustomerID(int customerID) {
	this.customerID = customerID;
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
 
 

}
