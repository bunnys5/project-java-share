<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ORDERED</title>
</head>
<body>

	<%
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	try {
		Class.forName("org.mariadb.jdbc.Driver").newInstance();
		connection = DriverManager.getConnection("jdbc:mariadb://202.28.34.205:3306/db64011211075", "64011211075",
		"64011211075");
		statement = connection.createStatement();
		String query = "  SELECT * FROM ORDERED;";
		resultSet = statement.executeQuery(query);

	} catch (Exception e) {
		out.println("An error occurred.");
	}
	%>


	<div align="center">
		<table border="4" cellpadding="7"">
			<h1>ORDERED</h1>
			<tr>
				<th>supplier</th>
				<th>idgoods</th>
				<th>good</th>
				<th>quantity</th>
				<th>OrderDate</th>
				<th>ReceiveDate</th>
			</tr>

			<%
			while (resultSet.next()) {
			%>
			<tr>
				<td><%=resultSet.getString("supplier")%></td>
				<td><%=resultSet.getString("idgoods")%></td>
				<td><%=resultSet.getString("good")%></td>
				<td><%=resultSet.getString("quantity")%></td>
				<td><%=resultSet.getString("OrderDate")%></td>
				<td><%=resultSet.getString("ReceiveDate")%></td>
			</tr>
			<%
			}
			%>
		</table>
		<a href="http://localhost:8080/sanhanat_mini_report/index.html">Cancel</a>
	</div>
</body>
</html>