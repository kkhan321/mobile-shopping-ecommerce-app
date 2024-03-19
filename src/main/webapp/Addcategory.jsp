<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
	<h1>Category</h1>
	<form action=CategoryServlet method=post>
	<input type=hidden name=action value=addcategory>
		<table border=1 cellspacing=10px cellpadding=10px>
		<tr>
		<td>Name</td>
		<td><input type=text Name=name></td>
		</tr>
		<tr>
		<td>Description</td>
		<td><textarea name=Description rows=5 cols=20></textarea></td>
		</tr>
		
		
        <tr>
		<td><input type=submit value=submit></td>
		<td><input type=reset value=value></td>
		</tr>
		

		</table>
	</form>
	<h2><a href=index.jsp>Home</a></h2>
</div>

</body>
</html>