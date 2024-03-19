package ecom.Servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import ecom.dao.Categorydao;
import ecom.dao.Productdao;
import ecom.dao.VendorDao;
import ecom.pojo.Category;
import ecom.pojo.Product;
import ecom.pojo.Vendor;

@MultipartConfig
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	Categorydao categorydao=new Categorydao();
	VendorDao vendao=new VendorDao();
	Product product=new Product();
	Productdao productdao=new Productdao();
	Vendor v= new Vendor();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String action=request.getParameter("action");
		if(action!=null && action.equals("addProduct")) {
			System.out.println("--------");
			List<Category> cateogorylist=categorydao.Selectcategory();
			List<Vendor> vendorlist=vendao.selectAll();
			session.setAttribute("cateogorylist",cateogorylist);
			session.setAttribute("vendorlist",vendorlist);			
			response.sendRedirect("AddProduct.jsp");
		}
		else if(action!=null && action.equals("List2")) {
			System.out.println("succes1");
			List<Product> plist=productdao.getAllbyObject();
			session.setAttribute("products", plist);
			response.sendRedirect("Productlist2.jsp");
			System.out.println("succes3");
		} 
		else if(action!=null && action.equals("delete")) {
		int id=Integer.parseInt(request.getParameter("id"));
		boolean b=productdao.deleteProduct(id);
		if(b) {
			response.sendRedirect("ProductServlet");
		}
		else {
			response.sendRedirect("error.jsp");
		}

		}
		
		else if(action!=null && action.equals("edit")) {
	    int id=Integer.parseInt(request.getParameter("id"));	
	   Product p=productdao.getAllbyObjectThroughId(id);
	   System.out.println(p);
	   session.setAttribute("p",p);
	   List<Category> clist=categorydao.Selectcategory();
	   session.setAttribute("Category", clist);
	   List<Vendor> vlist=vendao.selectAll();
	   session.setAttribute("vendorlist", vlist);
	   
	   response.sendRedirect("updateProduct.jsp");
		}
		
		else if(action!=null && action.equals("byvendor")) {
		  int id=Integer.parseInt(request.getParameter("id"));	
		  List<Product> plist=productdao.getAllbyVendorId(id);
			session.setAttribute("product", plist);
			response.sendRedirect("ProductList.jsp");

		}

		else {
			List<Product> plist=productdao.getAll();
			session.setAttribute("product", plist);
			System.out.println(plist);
			response.sendRedirect("ProductList.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String action=request.getParameter("action");
		String name=request.getParameter("name");
		
		if(action!=null && action.equals("addProduct")) {
			double price=Double.parseDouble(request.getParameter("Price"));
			String Description=request.getParameter("description");
			int category_id=Integer.parseInt(request.getParameter("category_id"));
			int vendor_id=Integer.parseInt(request.getParameter("vendor_id"));
			product.setProductName(name);product.setCategory_id(category_id);
			product.setDescription(Description);product.setPrice(price);
			product.setVendor_id(vendor_id);
			
			//writing code for adding image
			Part file=request.getPart("image");//adding file in part
			String imagefileName=file.getSubmittedFileName();//then fetching in string variable//get select image file name
			product.setImage(imagefileName);
			//uploading in image file fetching that through its properties//upload path where we have to upload our actual image
			String uploadpath="C:/Users/kabee/OneDrive/Desktop/kabeer java/kabeer/E-commerce-website/src/main/webapp/Image/"+imagefileName;
			
			//for reading file of uploadpath we have to write file handling code(like reading the file)//
			//uploading our selected image into image folder
			try {
			FileOutputStream fos=new FileOutputStream(uploadpath);
			InputStream is=file.getInputStream();
			
			//converting the data into byte and making it through read and then write then closing the file
			byte[] data=new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
			}catch (Exception e) {
				e.printStackTrace();// 
			}
			boolean b=productdao.addProduct(product);
			if(b) {
				response.sendRedirect("index.jsp");
			}
			else {
				response.sendRedirect("error.jsp");
			}
		}
		else if(action!=null && action.equals("searchProduct1")) {
			String searchproduct=request.getParameter("search");
			//System.out.println(searchproduct);
			List<Product> plist=productdao.searchProduct(searchproduct);
			//System.out.println(plist);
			session.setAttribute("product", plist);
			List<Category> clist=categorydao.Selectcategory();
			session.setAttribute("categories", clist);
			response.sendRedirect("ProductList.jsp");
		}
		else if(action!=null && action.equals("searchProduct")) {
			String searchproduct=request.getParameter("search");
			int vendor_id=Integer.parseInt(request.getParameter("vendorId"));
			product.setVendor_id(vendor_id);
			System.out.println(searchproduct);
			System.out.println(vendor_id);
			List<Product> plist=productdao.searchProductthroughvendor(searchproduct,vendor_id);
			System.out.println(plist);
			session.setAttribute("product", plist);
			List<Category> clist=categorydao.Selectcategory();
			session.setAttribute("categories", clist);
			List<Vendor> vlist=vendao.selectAll();
			session.setAttribute("vendories", vlist);
			response.sendRedirect("ProductList.jsp");
		}
		else if(action!=null && action.equals("updateProduct")) {
			double price=Double.parseDouble(request.getParameter("Price"));
			String Description=request.getParameter("description");
			int category_id=Integer.parseInt(request.getParameter("category_id"));
			int vendor_id=Integer.parseInt(request.getParameter("vendorId"));
			int id=Integer.parseInt(request.getParameter("id"));
			product.setId(id);
			product.setProductName(name);product.setCategory_id(category_id);
			product.setDescription(Description);product.setPrice(price);
			product.setVendor_id(vendor_id);
			
			//writing code for adding image
			Part file=request.getPart("image");//adding file in part
			String imagefileName=file.getSubmittedFileName();//then fetching in string variable//get select image file name
			product.setImage(imagefileName);
			//uploading in image file fetching that through its properties//upload path where we have to upload our actual image
			String uploadpath="C:/Users/kabee/OneDrive/Desktop/kabeer java/kabeer/E-commerce-website/src/main/webapp/Image/"+imagefileName;
			
			//for reading file of uploadpath we have to write file handling code(like reading the file)//
			//uploading our selected image into image folder
			try {
			FileOutputStream fos=new FileOutputStream(uploadpath);
			InputStream is=file.getInputStream();
			
			//converting the data into byte and making it through read and then write then closing the file
			byte[] data=new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
			}catch (Exception e) {
				e.printStackTrace();// 
			}

			
			boolean b=productdao.updateProduct(product);
			if(b) {
				response.sendRedirect("index.jsp");
			}
			else {
				response.sendRedirect("error.jsp");
			}
		}



	}


}
