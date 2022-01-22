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
  <h2>User Management</h2>
  <h3><a href="adminpage.jsp">go to main page</a></h3>
 </center>
     <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Select</th>
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td>
                     <a href="ResetPassword?id=<c:out value='${user.id}' />">Reset Password</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
 </body>
</html>