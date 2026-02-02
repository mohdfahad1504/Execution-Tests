<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="addstudent" method="post">
	<h2>${success}</h2>
	<h2>${error}</h2>
	Sid : <input type="number" placeholder="Enter Id" name="sid" required /> <br>
	Name : <input type="text" placeholder="Enter Name" name="sname" required /> <br>
	Email : <input type="email" placeholder="Enter Email" name="semail" required /> <br>
	Phone : <input type="number" placeholder="Enter Phone" name="sphone" required /> <br>
	Std : <input type="text" placeholder="Enter Std" name="sstd" required /> <br>
	Address : <input type="text" placeholder="Enter Address" name="sadd" required /> <br>
	<input type="submit" value="Submit"> <br>
	<a href="list.jsp">Students List</a>
	</form>
</body>
</html>