<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Goods</title>
</head>
<body>
	<%  
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
            try {
                Class.forName("org.mariadb.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection("jdbc:mariadb://202.28.34.205:3306/db64011211075", 
                        "64011211075", "64011211075");
                statement = connection.createStatement();
                String query = "  SELECT * FROM goods;";
                resultSet = statement.executeQuery(query);

            } 
            catch (Exception e) 
            {
                out.println("An error occurred.");
            }
        %>


	<div>
		<table border="2" cellpadding="5"">
			<h1>Store</h1>
			<tr style="background-color:green; color:white;">
				<th>id</th>
				<th>name</th>
				<th>Description</th>
				<th>price</th>
				<th>stock</th>
			</tr>

			<%while(resultSet.next()){ %>
				<tr>
				    <td><%=resultSet.getString("idgoods")%></td>
					<td><%=resultSet.getString("name")%></td>
					<td><%=resultSet.getString("Description")%></td>
					<td><%=resultSet.getString("price")%></td>
					<td><%=resultSet.getString("stock")%></td>
				</tr>
			<%} %>
		</table>
		</br>
		</br>
		<button style="border-radious:6px; border:5px;background-color:blue; color:white; padding:10px;">
			<a href="http://localhost:8080/1Sales/guest.jsp" style="border-radious:6px; border:5px;background-color:blue; color:white;">บุคคลทั่วไป</a></br>
		</button>
		</br>
		<button style="border-radious:10px; border:5px;background-color:blue; color:white; margin-top:10px; padding:10px;">
			<a href="http://localhost:8080/1Sales/member.jsp" style="border-radious:6px; border:5px;background-color:blue; color:white;">สมาชิก</a></br>
		</button>
		</br>
		<button style="border-radious:6px; border:5px;background-color:blue; color:white; margin-top:10px; padding:10px;">
			<a href="http://localhost:8080/1Sales/index.html" style="border-radious:6px; border:10px;background-color:blue; color:white;">Cancel</a>
		</button>
	</div>
</body>
</html>