<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>Fly Away</title>
</head>
<body>
 <center>
  <h1>Fly Away</h1>
  <h2>Add Passenger Details</h2>
 </center>
  <div align="center">
   <form action="PassengerDetail" method="post">
        <table border="1" cellpadding="5">
            <tr>
                <th>Passenger Name: </th>
                <td>
                 <input type="text" name="name" size="45"
                   value="<c:out value='${passengers.name}' />"
                  />
                </td>
            </tr>
            <tr>
                <th>Passenger Email: </th>
                <td>
                 <input type="text" name="email" size="45"
                   value="<c:out value='${passengers.email}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Country: </th>
                <td>
                 <input type="text" name="country" size="15"
                   value="<c:out value='${passengers.country}' />"
                 />
                </td>
            </tr>
            <tr>
             <td colspan="2" align="center">
              <input type="submit" value="Add" />
             </td>
            </tr>
        </table>
        </form>
    </div> 
</body>
</html>