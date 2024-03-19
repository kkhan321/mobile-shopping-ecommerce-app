<%@page import="ecom.pojo.Vendor"%>
<%@page import="ecom.pojo.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop Homepage - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="Resources/assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="Resources/css/styles.css" rel="stylesheet" />
   
<%
Customer customer=(Customer)session.getAttribute("customer"); 
Vendor vendor=(Vendor)session.getAttribute("vendor");
String admin=(String)session.getAttribute("admin");
%>
</head>
<body>


	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container px-4 px-lg-5">
		<%if(customer!=null ){ %>
			<a class="navbar-brand" href="#!"><span style="color:red;">welcome <%=customer.getName()%></span></a>
			<%}if( vendor!=null){ %>
				<a class="navbar-brand" href="#!"><span style="color:red;">welcome <%=vendor.getName()%></span></a>
				<%}if( admin!=null){ %>
						<a class="navbar-brand" href="#!">Welcome Admin</a>
				<%}if(customer==null && vendor==null && admin==null){ %>
						<a class="navbar-brand" href="">KABEER SHOP</a>
						<%}%>
			
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.jsp">Home</a></li>
						
							<!-- viewers -->
							<!-- if everything is null then only productlist will be fetch when if there's no data is present in 
							if we will login through vendor we will get to see our product only -->
						<%if(customer==null && vendor==null && admin==null){ %>
					<li class="nav-item"><a class="nav-link" href="ProductServlet">ProductList</a></li>
					<%} %>
						<!-- Customer  login -->
	                    <%if(customer!=null){ %>
					
					<li class="nav-item"><a class="nav-link" href="CustomerServlet?action=edit&id=<%=customer.getId()%>">EditProfile</a></li>
				   <li class="nav-item"><a class="nav-link" href="ProductServlet">ProductList</a></li>
				  <li class="nav-item"><a class="nav-link" href="CartServlet">cartList</a></li>
					
					
						<%} if(customer==null && admin==null && vendor==null) {%>

                              <!-- customer not  login -->
					
					<li class="nav-item"><a class="nav-link" href="addUser.jsp">Register</a></li>
					<li class="nav-item"><a class="nav-link" href="CustLogin.jsp">Login</a></li>
					
					<%}; %>
					
						<!-- Admin login -->
	                    
	                    <%if(admin!=null){ %>
	                    
	               <li class="nav-item"><a class="nav-link" href="CategoryServlet">Categorylist</a></li>     
					<li class="nav-item"><a class="nav-link" href="ProductServlet?action=List2">ProductList2</a></li>
					<li class="nav-item"><a class="nav-link" href="VendorServlet">vendorlist</a></li>
					<li class="nav-item"><a class="nav-link" href="CustomerServlet">Customerlist</a></li>
					<li class="nav-item"><a class="nav-link" href="AddVendor.jsp">AddVendor</a></li>
					<!--  <li class="nav-item"><a class="nav-link" href="#!">About</a></li> -->
						
						<%}; %>
						
							<!-- Vendors Login -->
	                        <%if(vendor!=null){ %>
	                        
	    		   <li class="nav-item"><a class="nav-link" href="ProductServlet?action=byvendor&id=<%=vendor.getId()%>">Searchproduct</a></li>	                         
				   <li class="nav-item"><a class="nav-link" href="CategoryServlet">Categorylist</a></li>     								
					<li class="nav-item"><a class="nav-link" href="Addcategory.jsp">AddCategory</a></li>
					<li class="nav-item"><a class="nav-link" href="ProductServlet?action=addProduct">AddProduct</a></li>
                              
                            <%}if(customer!=null || admin!=null || vendor!=null){ %>
                    
                    <li class="nav-item"><a class="nav-link" href="LoginServlet?action=logout">Logout</a></li>
                              	
                              	<%}; %>
                              	
                              
				</ul>
				<form class="d-flex">
					<button class="btn btn-outline-dark" type="submit">
						<i><a href="seller.jsp">Become vendor</a></i>  
					</button>
				</form>
			</div>
		</div>
	</nav>
</head>
<body>
</body>
</html>