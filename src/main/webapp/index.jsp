<!DOCTYPE html>
<html lang="en">
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
    </head>
    <body>
    <!-- nav bar -->
    <jsp:include page="Navbar.jsp"></jsp:include>
        <!-- banner-->
        <jsp:include page="banner.jsp"></jsp:include>
                <!-- Section-->
                <%
                String msg=(String) request.getAttribute("msg");
                if(msg!=null){
                %>
                <h2 style="color: aqua;" align="center"><%=msg %></h2>
                <%} %>
              <jsp:include page="products.jsp"></jsp:include>
                <!-- Footer-->
        <jsp:include page="footer.jsp"></jsp:include>
        
    </body>
</html>
