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

import ecom.dao.Productdao;
import ecom.dao.VendorDao;
import ecom.pojo.Product;
import ecom.pojo.Vendor;


@WebServlet("/VendorServlet")
public class VendorServlet extends HttpServlet {
	Vendor vendor=new Vendor();
	VendorDao vanDao=new VendorDao();
	Productdao productdao=new Productdao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String action=request.getParameter("action");
		if(action!=null && action.equals("delete")) {
			int id=Integer.parseInt(request.getParameter("id"));
			boolean b=vanDao.deleteVendor(id);
			if (b) {
				response.sendRedirect("VendorServlet");
			}
			else {
				response.sendRedirect("error.jsp");
			}
		}
		else if(action!=null && action.equals("edit")) {
			int id=Integer.parseInt(request.getParameter("id"));
          Vendor vendor=vanDao.selectByid(id);
          session.setAttribute("vendor", vendor);
          response.sendRedirect("updateVendor.jsp");
		}
		else {
			List<Vendor> vlist=vanDao.selectAll();
			session.setAttribute("vlist", vlist);
			response.sendRedirect("Vendorlist.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String action=request.getParameter("action");
		String name=request.getParameter("name");
		String contact=request.getParameter("contact");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		  
		// for login fetching details from vendorlogin
		// String uname=request.getParameter("uname");
		/// String password1=request.getParameter("password");
		
		vendor.setName(name);vendor.setContact(contact);
		vendor.setEmail(email);vendor.setPassword(password);
		if(action!=null && action.equals("addVendor")) {
			boolean b=vanDao.CheckIfExist(email, contact);
			if(b) {
				request.setAttribute("message","email and contact already exist");
				RequestDispatcher rd=request.getRequestDispatcher("AddVendor.jsp");
				rd.include(request, response);
			}
			else {
				boolean result=vanDao.addVendor(vendor);
				if(result) {
					request.setAttribute("rmsg", "registeration done Succesfully");
					RequestDispatcher rd=request.getRequestDispatcher("AddVendor.jsp");
					rd.forward(request, response);

				}
				else {
					response.sendRedirect("error.jsp");
				}

			}
		}
		else if(action!=null && action.equals("updateVendor")) {
			int id=Integer.parseInt(request.getParameter("id"));
			vendor.setId(id);
			boolean b=vanDao.updateVendor(vendor);
			if(b) {
				response.sendRedirect("VendorServlet");
			}
			else {
				response.sendRedirect("error.jsp");
			}
		}
		else if(action!=null && action.equals("vendorLogin")) {
			Vendor v= vanDao.vendorLogin(email,password);
			if(v!=null && email.equals(v.getEmail()) && password.equals(v.getPassword())) {
				//when vendor is logging in he should see his produt only so fetching data
				//from product where vendor_id is present so just after vendor login ,(the prodcure starting from here)
				List<Product> plist=productdao.getAllbyVendorId(v.getId());
				session.setAttribute("product", plist);
				session.setAttribute("vendor", v);
				response.sendRedirect("index.jsp");
			}
			else {
				request.setAttribute("message", "uname and password is invalid");
				RequestDispatcher rd=request.getRequestDispatcher("vendorlogin.jsp");
				rd.include(request, response);
				
			}
		}


	}

}
