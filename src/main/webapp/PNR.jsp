<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="dto.SearchCriteria" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% SearchCriteria sc =(SearchCriteria) session.getAttribute("searchcriteria"); %>
<html>
<head>
 <title>Fly Away</title>
</head>
<body>
 <center>
  <h1>Fly Away</h1>
  <h2>Booking Details</h2>
 </center>
    <div align="center">
     <form action="payment.html" method="post">
        <table border="1" cellpadding="5">
            <caption><h2>Your Booking is Confirmed</h2></caption>
            <caption><h3>PNR # <% out.print(sc.getPnr()); %> </h3></caption>
            <tr>
                <th>Flight</th>
                <th>Source</th>
                <th>Destination</th>
                <th>Date</th>
                <th>Ticket Price</th>
            </tr>
            <c:forEach var="flights" items="${listFlights}">
                <tr>
                    <td><c:out value="${flights.flight}" /></td>
                    <td><c:out value="${flights.source}" /></td>
                    <td><c:out value="${flights.destination}" /></td>
                    <td><c:out value="${flights.date}" /></td>
                    <td><c:out value="${flights.ticketprice}" /></td>
                </tr>
            </c:forEach>
        </table>
        <table border="1" cellpadding="5">
            <caption><h2>Passengers details</h2></caption>
            <tr>
                <th>Passenger Name</th>
                <th>Email</th>
                <th>Country</th>
            </tr>
            <c:forEach var="passengers" items="${listPassengers}">
                <tr>
                    <td><c:out value="${passengers.name}" /></td>
                    <td><c:out value="${passengers.email}" /></td>
                    <td><c:out value="${passengers.country}" /></td>
                </tr>
            </c:forEach>
        </table>
        <table border="1" cellpadding="5">
        <caption><h2>Fare Details</h2></caption>
			<tr><td>Flight Fare Per Passenger</td>
					<td>
					<%
					out.print(sc.getUticketprice());
					%>
					</td>
			</tr>
        	<tr>
        		<td>No of Passengers</td>
        		<td>
                    <%
                    //SearchCriteria sc =(SearchCriteria) session.getAttribute("searchcriteria");
                    //out.print(request.getParameter("upersons"));
                    out.print(sc.getUpersons());
                    int x = sc.getUpersons();
                    %>
                 </td>
			</tr>
			<tr>
				<td>Total Fare</td>				
					<td>
					<%
					out.print(sc.getTotalfare());
					%>
					</td>
			</tr>
			<tr>
				<td>Paid Amount</td>				
					<td>
					<%
					out.print(sc.getTotalfare());
					%>
					</td>
			</tr>
			<tr>
				<td>Balance</td>				
					<td>0</td>
			</tr>
		</table>
        </form>
    </div> 
</body>
</html>