<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>guest-saler</title>
</head>
<body>
	<div>
		<h1>guest saler</h1>

		<form method="post" action="guestinsert.jsp">
		DATE:<br> 
		<input type="text" name="date"> <br> 
		IDGOODS:<br>
		<input type="text" name="id"> <br> 
		GOODS:<br> 
		<input type="text" name="good"> <br> 
		Quantity:<br> 
		<input type="text" name="Quantity"> <br>
		<br><br>
		<button style="background-color:yellow;">
			<input type="submit" value="submit" style="border:none; background-color:yellow;">
		</button>
		<br><br>
		<a href="http://localhost:8080/1Sales/Goods.jsp">Cancel</a>
		</form>
	</div>
	
	
</body>
</html>