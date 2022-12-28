<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"
import="be.walbertjossart.JavaBeans.Users"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
</head>
<body>
<p>Welcome on the application</p>
<%
	Users user=(Users)session.getAttribute("user");
%>
<%="Hello "+user.getPseudo() %>

<a href="LogOutServlet">Log Out</a>
<a href="TestServlet"">Recuperer all</a>
</body>
</html>