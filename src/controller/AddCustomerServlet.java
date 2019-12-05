package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.AddCustomer;
import model.Customer;


/**
 * Servlet implementation class AddCustomerServlet
 */
@WebServlet("/registerCustomer")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerServlet() {
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
		//int customerID = Integer.parseInt(request.getParameter("customerID"));
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String uname = request.getParameter("uname");
		String pword = request.getParameter("pword");
		
		Customer customer = new Customer(); 

		customer.setfName(fName);
		customer.setlName(lName);
		customer.setAddress(address);
		customer.setEmail(email);
		customer.setUname(uname);
		customer.setPword(pword);
		
	
		AddCustomer ac = new AddCustomer("hunting", "root", "H@rryP0ter");
		ac.doAdd(customer);
		
		String url = "/index.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request,response); 
	
	}

}
