<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
	String id=request.getParameter("id");
	String date=request.getParameter("date");
	String good=request.getParameter("good");
	String Quantity=request.getParameter("Quantity");
	String Customer=request.getParameter("Customer");

	try{
	Class.forName("org.mariadb.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mariadb://202.28.34.205:3306/db64011211075", "64011211075", "64011211075");
           Statement st=conn.createStatement();
           String into = "insert into receiptsimple values('"+date+"','"
           +id+"','"
           +good+"','"
           +Quantity+"','"
           +Customer+"')";
           st.executeUpdate(into);

           
           
           
	}catch(Exception e){
	System.out.print(e);
	e.printStackTrace();
	}
	%>
	<a href="http://localhost:8080/sanhanat_mini_sale/member.jsp">Cancel</a></br>

</body>
</html>