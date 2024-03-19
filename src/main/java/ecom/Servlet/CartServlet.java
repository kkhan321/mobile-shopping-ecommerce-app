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

import ecom.dao.Cartdao;
import ecom.dao.Orderdao;
import ecom.pojo.Cart;
import ecom.pojo.Customer;
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	Cartdao cartdao=new Cartdao();
	Orderdao orderdao=new Orderdao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Customer customer=(Customer)session.getAttribute("customer"); 

		String action=request.getParameter("action");
		if(action!=null && action.equals("addCart")) {
			int pid=Integer.parseInt(request.getParameter("pid"));
			int cid=Integer.parseInt(request.getParameter("cid"));
			boolean b= cartdao.addCart(pid,cid);			
			if(b) {
				response.sendRedirect("index.jsp");
			}
			else {
				response.sendRedirect("error.jsp");

			}

		}
		else {
			List<Cart> clist=cartdao.getAllCartbyCustomer(customer.getId());
			session.setAttribute("cartList", clist);
			response.sendRedirect("CartList.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*double totalprice=Double.parseDouble(request.getParameter("totalPrice"));
		System.out.println("----->"+totalprice);*/

		HttpSession session=request.getSession();
        Customer customer=(Customer) session.getAttribute("customer");
		String price[]=request.getParameterValues("Price");
		String quantity[]=request.getParameterValues("qty");
		double totalprice=0;
		for(int i=0;i<price.length;i++) {
			totalprice=totalprice+(Double.parseDouble(price[i])*Integer.parseInt(quantity[i]));

		}
		System.out.println("----->"+totalprice);	
		boolean b=orderdao.PlaceOrder(totalprice,customer.getId());
		if(b) {
			boolean d=cartdao.clearCart(customer.getId());
			if(d) {
				String msg="order Place Succesfully";
				request.setAttribute("msg", msg);
				RequestDispatcher rd =request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
		}
		}
		else {
			response.sendRedirect("error.jsp");
		}
	}

}
