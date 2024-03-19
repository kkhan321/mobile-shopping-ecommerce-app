<%@page import="ecom.pojo.Vendor"%>
<%@page import="ecom.pojo.Customer"%>
<%@page import="ecom.dao.Productdao"%>
<%@page import="ecom.pojo.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<%
	List<Product> plist =new Productdao().getAll();
	
	%>
	<% 
	Customer customer=(Customer)session.getAttribute("customer"); 
	Vendor vendor=(Vendor)session.getAttribute("vendor");
	String admin=(String)session.getAttribute("admin");
	
	//using if else condition to update plist which is object of list<product> using productdao method calling getallbyvendorid method which is present in productdao
	//through vendor_id
	// this is first way to bring product detail
	if(vendor!=null){
		plist =new Productdao().getAllbyVendorId(vendor.getId());
	}
	%>
	
<body>
    
    <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">

	         <%
			for (Product p : plist) {
			%>
<%System.out.println(p.getImage()); %>
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="Image/<%=p.getImage()%>">
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder"><%=p.getProductName()%></h5>
                                    <!-- Product reviews-->
                                    <div class="d-flex justify-content-center small text-warning mb-2">
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                    </div>
                                    <%=p.getDescription() %>
                                    <!-- Product price-->
                                    <%=p.getPrice() %>
                                </div>
                            </div>
                            <!-- Product actions-->
	                    <%if(vendor!=null && customer==null){ %>
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<span class="text-center"><a
								class="btn btn-outline-dark mt-auto"
								href="ProductServlet?action=edit&id=<%=p.getId()%>">edit</a></span> <span
								style="padding-left: 20px;" class="text-center"><a
								class="btn btn-outline-dark mt-auto" href="ProductServlet?action=delete&id=<%=p.getId()%>">delete</a></span>

						</div>
						<%}if(customer!=null && vendor==null){ %>

						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
							
						<!-- Add to cart code	 -->
								<a class="btn btn-outline-dark mt-auto" href="CartServlet?action=addCart&pid=<%=p.getId()%>&cid=<%=customer.getId()%>">Add to cart</a>
							</div>
						</div>

						<%}if(customer==null && vendor==null){ %>

						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" href="CustLogin.jsp">Add
									to cart</a>
							</div>
						</div>
						<%} %>
                        </div>
                    </div>
                    <%}; %>
                </div>
            </div>
        </section>
        
        
	</body>
</html>