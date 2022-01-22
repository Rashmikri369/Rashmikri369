<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>Flyaway</title>
</head>
<body>
 <center>
  <h1>Fly Away</h1>
  <h2>Source/Destinations Management</h2>
  <h3><a href="adminpage.jsp">go to main page</a></h3>
 </center>
     <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Source/Destinations</h2></caption>
            <tr>
                <th>ID</th>
                <th>Destination</th>
            </tr>
            <c:forEach var="destination" items="${listDestinations}">
                <tr>
                    <td><c:out value="${destination.id}" /></td>
                    <td><c:out value="${destination.destination}" /></td>
                    <td>
                     <a href="EditDestination?did=<c:out value='${destination.id}' />">Edit</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
 </body>
</html>