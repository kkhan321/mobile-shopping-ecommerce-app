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
<body>
    <!-- nav bar -->
    <jsp:include page="Navbar.jsp"></jsp:include>
     
	<%
	List<Product> plist =(List<Product>)session.getAttribute("products");
	System.out.println("succes4");
	%>
	<div align=center>
		<table border=1 cellspacing=10px cellpadding=10px>
			<tr>
				<th>id</th>
				<th>Productname</th>
				<th>Price</th>
				<th>description</th>
				<th>vendorName</th>
				<th>vendorEmail</th>
				<th>vendorContact</th>
				<th>CategoryName</th>
				<th>categoryDescrition</th>

				<th colspan=3>Action</th>

			</tr>
			<%
			for (Product p:plist) {
			%>
			<tr>
		        
			   <td><%=p.getId()%></td>
				<td><%=p.getProductName()%></td>
				<td><%=p.getPrice()%></td>
				<td><%=p.getDescription()%></td>
				<td><%=p.getVendor().getName()%></td>
				<td><%=p.getVendor().getEmail()%></td>
				<td><%=p.getVendor().getContact()%></td>
				

				<td><%=p.getCategory().getName()%></td>
				<td><%=p.getCategory().getDescription()%></td>
				
			   <td><a href="">Delete</a></td>
				<td><a href="">edit</a></td>

			</tr>
			<%
			}
			%>

		</table>

	</div>
</body>
</html>