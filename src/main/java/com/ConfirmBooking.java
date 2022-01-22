package com;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FlightsDao;
import dao.PassengerDao;
import dto.SearchCriteria;
import model.Flights;
import model.Passengers;

/**
 * Servlet implementation class ConfirmBooking
 */
//@WebServlet("/ConfirmBooking")
public class ConfirmBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PassengerDao passengerDao;
	private FlightsDao flightsDao;
	
    public void init() {
        passengerDao = new PassengerDao();
        flightsDao = new FlightsDao();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		try {
				SearchCriteria sc =(SearchCriteria) session.getAttribute("searchcriteria");

	    	        int fid = sc.getFid();
	    	        String pnr = sc.getPnr();
					
				        List < Flights > listFlights = flightsDao.getSelectedFlight(fid);
				        request.setAttribute("listFlights", listFlights);

				        List < Passengers > listPassengers = passengerDao.getPassengerDetails(pnr);
				        request.setAttribute("listPassengers", listPassengers);

				        sc.setUticketprice(flightsDao.getFlgihtFare(fid).getTicketprice());
				        
				        sc.setTotalfare(sc.getUpersons()*sc.getUticketprice());
				        
				        RequestDispatcher dispatcher = request.getRequestDispatcher("PNR.jsp");
				        dispatcher.forward(request, response);
        } catch(Exception ex) {
        throw new ServletException(ex);	
        }
	}
}
