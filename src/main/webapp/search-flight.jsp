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
  <h2>Available Flights</h2>
 </center>
    <div align="center">
     <form action="PassengerDetail" method="post">
        <table border="1" cellpadding="5">
            <caption><h2>List of available flights</h2></caption>
            <tr>
                <th>Flight</th>
                <th>Source</th>
                <th>Destination</th>
                <th>Date</th>
                <th>Ticket Price</th>
                <th>Select Flight</th>
            </tr>
            <c:forEach var="flights" items="${listFlights}">
                <tr>
                    <td><c:out value="${flights.flight}" /></td>
                    <td><c:out value="${flights.source}" /></td>
                    <td><c:out value="${flights.destination}" /></td>
                    <td><c:out value="${flights.date}" /></td>
                    <td><c:out value="${flights.ticketprice}" /></td>
                    <td>
                     <a href="PassengerDetail?id=<c:out value='${flights.id}' />">Select</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        </form>
    </div> 
</body>
</html>