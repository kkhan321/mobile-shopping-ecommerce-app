<%@page import="ecom.pojo.Category"%>
<%@page import="ecom.pojo.Vendor"%>
<%@page import="ecom.pojo.Customer"%>
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
	List<Product> plist = (List<Product>) session.getAttribute("product");
    List<Category> clist=( List<Category>) session.getAttribute("categories");
    List<Vendor> vlist=(List<Vendor>) session.getAttribute("vendories");
 %>
    <% 
	Customer customer=(Customer)session.getAttribute("customer"); 
	Vendor vendor=(Vendor)session.getAttribute("vendor");
	String admin=(String)session.getAttribute("admin");

	%>
<body>
	<!-- nav bar -->
	<jsp:include page="Navbar.jsp"></jsp:include>
	<!-- making search -->
	<%if(vendor!=null && customer==null && customer!=null){ %>
	     <div align="left">
     <form action="ProductServlet" method="post">
     <input type="hidden" name="action" value="searchProduct">
     <input type="hidden" name="vendorId" value="<%=vendor.getId()%>">
     <table cellspacing=10px cellpadding=10px>
				<tr>
					<td><textarea rows="1" cols="40" name=search></textarea></td>
					<td><input type="submit" value="SEARCH"></td>
				</tr>
			</table>
     
     </form>
     </div>
	<%}else{ %>
	     <div align="left">
     <form action="ProductServlet" method="post">
     <input type="hidden" name="action" value="searchProduct1">
     <table cellspacing=10px cellpadding=10px>
				<tr>
					<td><textarea rows="1" cols="40" name="search"></textarea></td>
					<td><input type="submit" value="SEARCH"></td>
				</tr>
			</table>
     
     </form>
     </div>
		<%} %>
	

	<section class="py-5">
		<div class="container px-4 px-lg-5 mt-5">
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">

			<%
			for (Product p : plist) {
			%>
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Product image-->
						<img class="card-img-top"
							src="Image/<%=p.getImage()%>">
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder"><%=p.getProductName()%></h5>
								<!-- Product reviews-->
								<div
									class="d-flex justify-content-center small text-warning mb-2">
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
								<a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a>
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
				<%} %>
			</div>
		</div>
	</section>
	<!-- Footer-->
	<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>