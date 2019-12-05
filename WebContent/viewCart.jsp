<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.Cart" %>
 
 <%Cart cart = (Cart) session.getAttribute("cart"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Viewing a Customer's Cart (their purchases and the quantity of purchases that they made)</title>
<link  rel="stylesheet" type="text/css" href="style.css"> 
</head>
<body>
<h1>Shopping Cart</h1>
<div class = "nav">
    <ul>
          <li><a href="index.jsp">home</a></li>
          <li><a href="Products.html">product gallery</a></li>
          <li><a href="location.html">store locator</a></li>
          <li><a href="contact.html">contact us</a></li>
          <li style="float:right"><a href="viewCart.jsp"><img src = "images/shopping-cart-of-checkered-design_318-50865.jpg"/></a></li>
          <li style="float:right">		
          		<form name=register action=register.jsp method=get>
				<input type="submit" name="submit" value="Register" />
				</form>
			</li>
			<li style="float:right">	
				<form name=login action=login.jsp method=get>
		<input type="submit" name="submit" value="Login" />
</form>
		</li>
    </ul>
</div>

 <%= cart.getTable() %>
 
 Click <a href=index.jsp>here</a> to go home.

<form name=makePurchase action=makePurchase method=get>
<input type="submit" name="submit" value="Buy" />

</form>

<br/>
<div class ="bottom">
<p>Hunting Haven Established 2018</p>
</div>
</body>

</html>