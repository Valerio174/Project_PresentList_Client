<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create List</title>
</head>
<body>
<form action="CreateListServlet" method="POST">
			<table border="1" cellspacing="0" cellpadding="5">
				<tr>
					<td>Limit Date : </td>
					<td>
						<input type="date" name="limit_date" id="limit_date" value="" size="20"/>
					</td>
				</tr>
				<tr>
	    			<td>Occasion: </td>
	    			<td>
	    				<input type="text" name="occasion" id="occasion" value="" size="20"/>
	   				</td>
	 			</tr>

	 			<tr>
	    			<td>Id User: </td>
	    			<td>
	    				<input type="number" name="id_user" id="id_user" value="" size="20"/>
	   				</td>
	 			</tr>
	 			
	 			<tr>
	 				<td colspan="2" align="center">
	 					<input type="submit" name="submit" id="submit" value="Log In"/>
					</td>
				</tr>
			</table>
		</form>
</body>
</html>