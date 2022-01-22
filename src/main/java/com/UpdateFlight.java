package com;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FlightsDao;
import model.Flights;

/**
 * Servlet implementation class UpdateFlight
 */
//@WebServlet("/UpdateFlight")
public class UpdateFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FlightsDao flightsDao;
    public void init() {
        flightsDao = new FlightsDao();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int fid = Integer.parseInt(request.getParameter("id"));
	        String flight = request.getParameter("flight");
	        String source = request.getParameter("source");
	        String destination = request.getParameter("destination");
	    	String dateStr = request.getParameter("date");
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	        Date udt =sdf.parse(dateStr);
	        int tp = Integer.parseInt(request.getParameter("ticketprice"));
	        
	        Flights flightinfo = new Flights(fid, flight, source, destination, udt, tp);
	        flightsDao.updateFlight(flightinfo);
	        response.sendRedirect("adminpage.jsp");
        } catch(Exception ex) {
        throw new ServletException(ex);
		
        }
	}
}
