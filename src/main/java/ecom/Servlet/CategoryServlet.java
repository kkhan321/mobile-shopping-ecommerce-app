package ecom.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecom.dao.Categorydao;
import ecom.pojo.Category;


@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	Category category=new Category();
	Categorydao categorydao=new Categorydao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession Session=request.getSession();
		String action=request.getParameter("action");
		if(action!=null && action.equals("delete")) {
			int id=Integer.parseInt(request.getParameter("id"));
			boolean b=categorydao.deletecategory(id);
			if(b) {
				response.sendRedirect("CategoryServlet");
			}
			else{
				response.sendRedirect("error.jsp");
			}   
		}
		else if(action!=null && action.equals("edit")){
			int id=Integer.parseInt(request.getParameter("id"));
			Category category=categorydao.SelectbyId(id);
			
			Session.setAttribute("kabeer", category);
			System.out.println("---Demo---"+id);
			response.sendRedirect("Categoryupdate.jsp");
		}
		else {
			List<Category> clist=categorydao.Selectcategory();
			Session.setAttribute("Category", clist);
			response.sendRedirect("CategoryList.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String description=request.getParameter("Description");
		String action=request.getParameter("action");
		if(action!=null && action.equals("addcategory")) {
			category.setName(name);category.setDescription(description);

			boolean result=categorydao.addcategory(category);
			if (result) {
				response.sendRedirect("index.jsp");
			}
			else {
				response.sendRedirect("error.jsp");
			}

		}
		else if(action!=null && action.equals("updatecategory")) {
			int id=Integer.parseInt(request.getParameter("id"));
			category.setId(id);
			//category.setName(name);
			//category.setDescription(description);
			boolean b=categorydao.updatecategory(category);
			if(b) {
				response.sendRedirect("CategoryServlet");
			}
			else {
				response.sendRedirect("error.jsp");
			}
		}

	}

}
