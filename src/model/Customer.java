package model;


public class Customer {
 int customerID;
 String fName;
 String lName; 
 String address;
 String email;
 String uname;
 String pword;
 int zipCode; 
 
 public Customer() {
	 this.customerID = 0;
	 this.fName = "No Name";
	 this.lName = "No Name";
	 this.address = "none";
	 this.email = "none";
	 this.uname = "none";
	 this.pword = "none";
 }
 
/**
 * @param customerID
 * @param fName
 * @param lName
 * @param address
 * @param email
 * @param uname
 * @param pword
 */
public Customer(int customerID, String fName, String lName, String address, String email, String uname, String pword) {
	super();
	this.customerID = customerID;
	this.fName = fName;
	this.lName = lName;
	this.address = address;
	this.email = email;
	this.uname = uname;
	this.pword = pword;
}



public Customer(int customerID, String uname, String pword) {
	super();
	this.customerID = customerID;
	this.uname = uname;
	this.pword = pword;
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
 * @return the fName
 */
public String getfName() {
	return fName;
}

/**
 * @param fName the fName to set
 */
public void setfName(String fName) {
	this.fName = fName;
}

/**
 * @return the lName
 */
public String getlName() {
	return lName;
}

/**
 * @param lName the lName to set
 */
public void setlName(String lName) {
	this.lName = lName;
}

/**
 * @return the address
 */
public String getAddress() {
	return address;
}

/**
 * @param address the address to set
 */
public void setAddress(String address) {
	this.address = address;
}

/**
 * @return the email
 */
public String getEmail() {
	return email;
}

/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}

/**
 * @return the uname
 */
public String getUname() {
	return uname;
}

/**
 * @param uname the uname to set
 */
public void setUname(String uname) {
	this.uname = uname;
}

/**
 * @return the pword
 */
public String getPword() {
	return pword;
}

/**
 * @param pword the pword to set
 */
public void setPword(String pword) {
	this.pword = pword;
}

public String getAddress(int zipCode) {
	String address = ""; 
	if(zipCode == 30338) {
		address = "Atlanta";
	}
	if(zipCode == 30601) {
		address = "Athens";
	}
	if(zipCode == 39943) {
		address = "Augusta";
	}
	if(zipCode == 30609) {
		address = "Augusta";
	}
	
	return address; 
}

public int getUserZip(int userZip) {
	int[] zipCodes = {30338, 30601, 39943, 30609}; 
	int distance = Math.abs(zipCodes[0]-userZip); 
	int inx = 0; 
	for(int i = 0; i < zipCodes.length; i++)
	{
		int cdistance = Math.abs(zipCodes[i]-userZip);
		if(cdistance < distance) {
			inx = i;
			distance = cdistance; 
		}
		
	}
	
	userZip = zipCodes[inx]; 
	
	return userZip; 
	
	

}
 
}
