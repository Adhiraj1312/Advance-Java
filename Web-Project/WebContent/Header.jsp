<%@page import="com.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	UserBean userbean = (UserBean) session.getAttribute("User");
	%>

	<%
	if (userbean != null) {
	%>

	<h3><%="Hii, " + userbean.getFirstName()%></h3>
	<a href="LoginCtl?opration=logout">Logout</a> |
	<a href="UserCtl">Add User</a> |
	<a href="UserLsitViewCtl">User List</a>
	<%
	} else {
	%>

	<h3>Hii, Guest</h3>
	<a href="LoginCtl">Login</a> |
	<a href="WelcomeCtl">Welcome</a>

	<%
	}
	%>
	<hr>
</body>
</html>