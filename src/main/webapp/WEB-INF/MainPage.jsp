<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="be.walbertjossart.JavaBeans.Users"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
</head>
<body>

<% Users users =  (Users)request.getAttribute("users");%>
<%= users.getPseudo() %>
</body>
</html>