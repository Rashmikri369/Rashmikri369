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
  <h2>Flights Management</h2>

<div align="center">
   <form action="UpdateFlight" method="post">
        <table border="1" cellpadding="5">
            <caption>
             <h2>Edit Flight Details</h2>
            </caption>
           <input type="hidden" name="id" value="<c:out value='${listFlights.id}' />" />
            <tr>
                <th>Flight: </th>
                <td>
                 <input type="text" name="flight" size="45" value="<c:out value='${listFlights.flight}' />" />
                </td>
            </tr>
            <tr>
                <th>Flight Date: </th>
                <td>
                 <input type="date" name="date" size="45" value="<c:out value='${listFlights.date}' />"  />
                </td>
            </tr>
            <tr>
                <th>Source: </th>
                <td>
                 <input type="text" name="source" size="45" value="<c:out value='${listFlights.source}' />" />
                </td>
            </tr>
            <tr>
                <th>Destination: </th>
                <td>
                 <input type="text" name="destination" size="15" value="<c:out value='${listFlights.destination}' />" />
                </td>
            </tr>
            <tr>
                <th>Fare: </th>
                <td>
                 <input type="number" name="ticketprice" size="15" value="<c:out value='${listFlights.ticketprice}' />" />
                </td>
            </tr>
            <tr>
             <td colspan="2" align="center">
              <input type="submit" value="Update" />
             </td>
            </tr>
        </table>
        </form>
    </div> 
</body>
</html>