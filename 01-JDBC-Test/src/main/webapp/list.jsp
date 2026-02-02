<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  import="com.tyss.Pool.ConnectionPool" %> 
<%@ page import="java.sql.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Students List</h1>
	<table border="1" style="border-collapse: collapse;">
		<thead>
		<tr>
		<th>sid</th>	
		<th>name</th>	
		<th>email</th>	
		<th>phone</th>	
		<th>std</th>	
		<th>address</th>	
		</tr>
		</thead>	
		<tbody>
		<%
		Connection con = ConnectionPool.giveConnection();
		PreparedStatement stm = null;
		try {
			String fetch = "SELECT * FROM students";
			stm = con.prepareStatement(fetch);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				out.println("<tr>"
					+"<td>"+rs.getInt(1)+"</td>"
					+"<td>"+rs.getString(2)+"</td>"
					+"<td>"+rs.getString(3)+"</td>"
					+"<td>"+rs.getLong(4)+"</td>"
					+"<td>"+rs.getString(5)+"</td>"
					+"<td>"+rs.getString(6)+"</td>"
					+"</tr");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.submitConnection(con);
			stm.close();
		}
		%>
		</tbody>
	</table>
	
	<form action="deleteStudent" method="post">
	<h2>${success}</h2>
	<h2>${error}</h2>
	<label for="sid"> Delete Student Record</label> <br>
	<input type="number" name="sid" placeholder="Enter Id" required> <br>
	<input type="submit" value="Delete">
	</form>
	
</body>
</html>