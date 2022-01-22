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
 * Servlet implementation class AddFlight
 */
//@WebServlet("/AddFlight")
public class AddFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FlightsDao flightsDao;
    public void init() {
        flightsDao = new FlightsDao();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String flight = request.getParameter("nflightcode");
	        String source = request.getParameter("nsource");
	        String destination = request.getParameter("ndestination");
	    	String dateStr = request.getParameter("ndate");
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        Date udt =sdf.parse(dateStr);
	        int tp = Integer.parseInt(request.getParameter("nticketprice"));
	        
	        Flights fl = new Flights(flight, source, destination, udt, tp);
	        flightsDao.addFlight(fl);
	        response.sendRedirect("adminpage.jsp");
        } catch(Exception ex) {
        throw new ServletException(ex);
		
        }
	}
}
