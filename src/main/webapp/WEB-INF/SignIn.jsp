<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign In Page</title>
</head>
<body>
	<a href="/Project_PresentList_Client/HomePageServlet">Home Page</a>
	<form action="SignInServlet" method="POST">
			<table border="1" cellspacing="0" cellpadding="5">
				<tr>
					<td>Login : </td>
					<td>
						<input type="text" name="pseudo" id="pseudo" value="" size="20"/>
					</td>
				</tr>
				<tr>
	    			<td>Password: </td>
	    			<td>
	    				<input type="text" name="password" id="password" value="" size="20"/>
	   				</td>
	 			</tr>
	 			<tr>
	    			<td>Email: </td>
	    			<td>
	    				<input type="email" name="email" id="email" value="" size="20"/>
	   				</td>
	 			</tr>
	 			<tr>
	 			<tr>
	 				<td colspan="2" align="center">
	 					<input type="submit" name="submit" id="submit" value="Register"/>
					</td>
				</tr>
			</table>
		</form>
</body>
</html>