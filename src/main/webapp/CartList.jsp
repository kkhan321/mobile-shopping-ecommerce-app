<!DOCTYPE html>
<%@page import="ecom.pojo.Cart"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Shop Homepage - Start Bootstrap Template</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="Resources/assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="Resources/css/styles.css" rel="stylesheet" />
</head>
<%List<Cart> cl=(List<Cart>) session.getAttribute("cartList");
double totalamount=0;
for(Cart c:cl){
	totalamount=totalamount+c.getPrice();
}
%>
<body>
	<!-- nav bar -->
	<jsp:include page="Navbar.jsp"></jsp:include>
	<!-- banner-->
	<jsp:include page="banner.jsp"></jsp:include>
	<!-- Section-->
	<br>
	<br>
	<div align="center">
	<form action="CartServlet" method=post>
		<table  class="table table-dark table-hover">
			<tr>
				<th>id</th>
				<th>name</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>description</th>
			   <th>sub-total</th>
				
			</tr>
			<tr>
			<%for(Cart c:cl){ %>
			<td><%=c.getId()%></td>
			<td><%=c.getName()%></td>
			<td><%=c.getPrice()%><input type="hidden" name="Price" value="<%=c.getPrice()%>"></td>
			<td><input type="number" value=1 name=qty></td>
		    <td><%=c.getDescription()%></td>
		   	<td><%=c.getPrice()%></td><!-- needs updation here we have to use js for subtotal -->
		    
			</tr>
			<%} %>
			<tr>
			<td colspan=3 ><input colspan=3 type="submit" value=placeOrder></td>
			<td colspan=3 ><span>Total Amount:<%=totalamount%><input type="hidden" value="<%=totalamount%>" name="totalPrice"></span></td>
			
			</tr>
		</table>
		</form>
	</div>
	<br><br>
	<!-- Footer-->
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
