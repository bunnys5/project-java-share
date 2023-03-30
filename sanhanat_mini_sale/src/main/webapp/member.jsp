<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member-saler</title>
</head>
<body>
	<div>
		<h1>member saler</h1>

		<form method="post" action="mumberinsert.jsp">
		DATE:<br> 
		<input type="text" name="date"> <br> 
		IDGOODS:<br>
		<input type="text" name="id"> <br> 
		GOODS:<br> 
		<input type="text" name="good"> <br> 
		Quantity:<br> 
		<input type="text" name="Quantity"> <br>
		member:<br> 
		<input type="text" name="Customer"> <br>
		<br><br>
		<input type="submit" value="submit">
		<br><br>
		<a href="http://localhost:8080/sanhanat_mini_sale/Goods.jsp">Cancel</a>
		</form>
	</div>
	
	

</body>
</html>