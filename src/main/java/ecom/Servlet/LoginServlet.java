package ecom.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecom.dao.Customerdao;
import ecom.pojo.Customer;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	Customerdao customerdao=new Customerdao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession  session=request.getSession();
		String action=request.getParameter("action");
		if(action!=null && action.equals("logout") ) {
			session.invalidate();
			response.sendRedirect("index.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		String action=request.getParameter("action");
		
		if( uname!=null && password!=null &&  uname.equals("admin@gmail.com") && password.equals("123")){
			session.setAttribute("admin", "admin");
			response.sendRedirect("index.jsp");
		}

		else {
			Customer customer=customerdao.CustomerLogin(uname, password);
			if(customer!=null) {
				session.setAttribute("customer",customer);
				response.sendRedirect("index.jsp");
			}
			else {
				request.setAttribute("c","Password and Uname is invalid");
				RequestDispatcher rd=request.getRequestDispatcher("CustLogin.jsp");
				rd.include(request, response);
			}
		}
	}

}
