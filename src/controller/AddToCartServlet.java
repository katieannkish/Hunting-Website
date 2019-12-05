package controller;

import java.io.IOException;

//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Enumeration;
//import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.AddtoCart;
import model.Cart;
import model.CartItem;
import model.Customer;



/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		  
	    Customer cust = (Customer) session.getAttribute("customer"); 
		int customerID = cust.getCustomerID();
		
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart == null) {
			cart = new Cart(customerID);
		}
				
		int qty = Integer.parseInt(request.getParameter("quantity"));
		String  p1 = request.getParameter("Skinny Pak");
		String  p2 = request.getParameter("Half-A-Man");
     	String  p3 = request.getParameter("Single Jake");
     	String  p4 = request.getParameter("Sneak-E-Tom");
		String  p5 = request.getParameter("Tom Foolery");
		
		
		String[] items = new String[] {p1, p2, p3, p4, p5};

		
		AddtoCart ac = new AddtoCart("hunting", "root", "H@rryP0ter");
		String description = null; 
		int price = 0; 
		
		
		for(int i =0; i < items.length; i++) {
			if(items[i] != null) {
				description = items[i];			
			}	
		}
		  int productID = ac.getProductID(description); 
		  price = ac.getPrice(productID);
		  description = ac.getDescription(productID); 
		 
		  
		   
		  //System.out.println("in addtocartservlet - productid=" + productID);
			String url = ""; 
				
			if(qty <= ac.getQty(productID))
			{				
				CartItem ci = new CartItem(productID, description, price, qty);
				cart.addItem(ci);			
				System.out.print(ci.toString());
			    url = "/viewCart.jsp";
			}
			else
			{
				 url = "/notAvailable.jsp"; 
			}
			
			
	

		    
		    session.setAttribute("cart", cart);
		    
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		    dispatcher.forward(request,response);

	
		}
	
}
	


