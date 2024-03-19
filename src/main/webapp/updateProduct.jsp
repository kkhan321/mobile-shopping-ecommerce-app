<%@page import="ecom.pojo.Product"%>
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
<%List<Category> categorylist = (List<Category>) session.getAttribute("Category"); 
System.out.println(categorylist);
%>
<%List<Vendor> vendorlist=(List<Vendor>)session.getAttribute("vendorlist"); %>
<%Product p=(Product)session.getAttribute("p"); %>
<%System.out.println(p); %>
<%Vendor vendor=(Vendor)session.getAttribute("vendor");
 %>
	<div align=center>


		<form action="ProductServlet" method="post" enctype="multipart/form-data">
			<input type=hidden name=action value=updateProduct>
			<table border=1 cellspacing=10px cellpadding=10px>
			    <tr>
					<td>id</td>
					<td><input type=text Name=id value=<%=p.getId() %> required=required></td>
				</tr>
			
				<tr>
					<td>Name</td>
					<td><input type=text Name=name value=<%=p.getProductName() %> required=required></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input type=Number Name=Price value=<%=p.getPrice() %> required=required></td>
				</tr>
				<tr>
					<td>Description</td>
				<td><textarea rows="3" cols="30" Name="description"  required="required"><%=p.getDescription()%></textarea></td>
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
				<tr>
				<td>Addimage</td>
				 <td><input type="file" name="image" value=<%=p.getImage()%>></td>
				</tr>

				
				<input type="hidden" name="vendorId" value="<%=vendor.getId()%>">
				
				
				<tr>
					<td><input type=submit value=submit></td>
					<td><input type=reset value=reset></td>
				</tr>


			</table>
		</form>
			</div>

</body>
</html>