<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sales</title>
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
		String query = "SELECT t1.date,t1.idgoods,t1.good, t1.Quantity,t1.Quantity*t2.price as price,t1.Customer FROM receiptsimple t1 INNER JOIN goods t2 ON t1.idgoods=t2.idgoods;";
		resultSet = statement.executeQuery(query);

	} catch (Exception e) {
		out.println("An error occurred.");
	}
	%>


	<div align="center">
		<table border="4" cellpadding="7"">
			<h1>ORDERED</h1>
			<tr>
				<th>date</th>
				<th>idgoods</th>
				<th>good</th>
				<th>Quantity</th>
				<th>price</th>
				<th>Customer</th>
			</tr>

			<%
			while (resultSet.next()) {
			%>
			<tr>
				<td><%=resultSet.getString("date")%></td>
				<td><%=resultSet.getString("idgoods")%></td>
				<td><%=resultSet.getString("good")%></td>
				<td><%=resultSet.getString("Quantity")%></td>
				<td><%=resultSet.getString("price")%></td>
				<td><%=resultSet.getString("Customer")%></td>
			</tr>
			<%
			}
			%>
		</table>
		<a href="http://localhost:8080/sanhanat_mini_report/index.html">Cancel</a>
	</div>

</body>
</html>