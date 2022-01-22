<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flyaway</title>
</head>
<body>
	<h1>Fly Away</h1>
	<h2>Admin Page</h2>
    <div align="left">
        <table border="1" cellpadding="5">
            <tr>
            	<td>Manage Users</td>
            	<td><a href="ListUsers">View List</a></td>
            	<td><a href="add-user.html">Add New</a></td>
            </tr>
            <tr>
            	<td>Manage Flights</td>
            	<td><a href="ListFlights">View List</a></td>
            	<td><a href="add-flight.html">Add New</a></td>
            </tr>
            <tr>
            	<td>Manage Source/Destinations</td>
            	<td><a href="ListDestinations">View List</a></td>
            	<td><a href="add-destination.html">Add New</a></td>
            </tr>
		</table>
	</div>
</body>
</html>