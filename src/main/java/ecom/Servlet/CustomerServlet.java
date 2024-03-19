package ecom.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecom.dao.*;
import ecom.pojo.Customer;
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	Customer Customer=new Customer();
	Customerdao Customerdao= new Customerdao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String action=request.getParameter("action");
		if(action!=null&& action.equals("delete")) {
			int id=Integer.parseInt(request.getParameter("id"));
			boolean b=Customerdao.deleteCustomer(id);
			if(b) {
				response.sendRedirect("CustomerServlet");

			}
			else {
				response.sendRedirect("error.jsp");
			}

		}
		else if(action!=null&& action.equals("edit")) {
			int id=Integer.parseInt(request.getParameter("id"));
			Customer customer=Customerdao.getCustomer(id);
			session.setAttribute("Customer1", customer);
			//  System.out.println(customer);
			response.sendRedirect("Customerupdate.jsp");


		}
		else {
			List<Customer> clist=Customerdao.selectCustomer();
			session.setAttribute("Customer", clist);
			response.sendRedirect("Customerlist.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String name=request.getParameter("name");
		String contact=request.getParameter("contact");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		Customer.setName(name);Customer.setContact(contact);Customer.setEmail(email);
		Customer.setPassword(password);
		
		String action=request.getParameter("action");
		
		if(action!=null && action.equals("addcustomer")) {
			
			boolean b=Customerdao.checkCustomerifExist(email, contact);
			if(b) {
				request.setAttribute("message", "email & contact already present");
				RequestDispatcher rd=request.getRequestDispatcher("addUser.jsp");
				rd.include(request, response);

			}
			else {
				boolean result=Customerdao.AddCustomer(Customer);
				if(result) {
					response.sendRedirect("index.jsp");
				}
				else {
					response.sendRedirect("error.jsp");
				}
			}
		}
		else if(action!=null && action.equals("updatecustomer")) {
			int id=Integer.parseInt(request.getParameter("id"));
			Customer.setId(id);
			boolean b=Customerdao.updateCustomer(Customer);
			if(b) {
				response.sendRedirect("index.jsp");
			}
			else {
				response.sendRedirect("error.jsp");
			}
		}

	}

}
