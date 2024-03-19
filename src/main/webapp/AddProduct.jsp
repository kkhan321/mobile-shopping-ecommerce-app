<%@page import="ecom.pojo.Vendor"%>
<%@page import="ecom.pojo.Category"%>
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
	  <%List<Category> categorylist=(List<Category>)session.getAttribute("cateogorylist"); 
      System.out.println(categorylist);
      %>
	<%List<Vendor> vendorlist=(List<Vendor>)session.getAttribute("vendorlist"); %>
	<%	
	Vendor vendor=(Vendor)session.getAttribute("vendor");
    %>
	<div align=center>

<!-- starting adding image in product -->
		<form action="ProductServlet" method="post" enctype="multipart/form-data">
			<input type=hidden name=action value=addProduct>
			<table border=1 cellspacing=10px cellpadding=10px>
				<tr>
					<td>Name</td>
					<td><input type=text Name=name required=required></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input type=Number Name=Price required=required></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><textarea rows="3" cols="30" Name=description
							required="required"></textarea></td>
				</tr>
				<tr>
					<td>Category</td>
					<td><select name="category_id">
							<option value="0">------select-------</option>
							<%for(Category c:categorylist){ %>
							<option value=<%=c.getId()%>><%=c.getName()%></option>
							<%} %>
					</select></td>
				</tr>
	<!-- passing the vendorid hidden so that the vendor who has logged in shouldnt be seen his name or other names -->
				<input type="hidden" name="vendor_id" value="<%=vendor.getId() %>">
				
				<tr>
				<td>Addimage</td>
				 <td><input type="file" name="image"></td>
				</tr>

				<tr>
					<td><input type=submit value=submit></td>
					<td><input type=reset value=reset></td>
				</tr>


			</table>
		</form>
		<h2>
			<a href=index.jsp>Home</a>
		</h2>
	</div>

</body>
</html>