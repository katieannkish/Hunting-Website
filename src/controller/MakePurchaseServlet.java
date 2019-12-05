package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.MakePurchase;
import model.Cart;
import model.Customer;
import model.Product;
import model.Purchase;


/**
 * Servlet implementation class MakePurchaseServlet
 */
@WebServlet("/makePurchase")
public class MakePurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakePurchaseServlet() {
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
		String url = ""; 
		
		int storeID = 0;
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		int customerID = customer.getCustomerID();
         
		
		Purchase p = new Purchase();
		p.setCustomerID(customerID);
		p.setStoreID(storeID);
		Product pr = new Product(); 	
		
		MakePurchase mp = new MakePurchase("hunting", "root", "H@rryP0ter");
		mp.doAdd(p);
		mp.updateInventory(pr);
		Cart cart = (Cart) session.getAttribute("cart");
		cart.clearItems();
		url = "/purchase.jsp";
		
	
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request,response); 
		
	}

}
