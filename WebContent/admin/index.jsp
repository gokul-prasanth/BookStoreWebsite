<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Evergreen BookStore Administration</title>
</head>
<body>

	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<h2>Administrative Dashboard</h2>
	</div>

	<div align="center">
	<hr width="60%" />
		<h2>Quick Actions:</h2>
		<b>
		<a href="new_book">New Book</a> &nbsp; 
		<a href="new_user">New User</a> &nbsp; 
		<a href="new_category">New Category</a> &nbsp; 
		<a href="new_customer">New Customer</a>
		</b>
	</div>

    <div align="center">
        <hr width="60%" />
		<h2>Recent Sales:</h2>
	</div>
	
	<div align="center">
	    <hr width="60%" />
		<h2>Recent Reviews:</h2>
	</div>
	
	<div align="center">
	    <hr width="60%" />
		<h2>Statistics</h2>
		<hr width="60%" />
	</div>
	<jsp:directive.include file="footer.jsp" />

</body>
</html>