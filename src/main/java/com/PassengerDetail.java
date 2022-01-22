package com;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.SearchCriteria;
import model.Flights;
import model.Passengers;
import dao.PassengerDao;
import dao.FlightsDao;

/**
 * Servlet implementation class PassengerDetail
 */
//@WebServlet("/PassengerDetail")
public class PassengerDetail extends HttpServlet {
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
    public PassengerDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//SearchCriteria sc = new SearchCriteria();
		HttpSession session = request.getSession();

		try {
				SearchCriteria sc =(SearchCriteria) session.getAttribute("searchcriteria");
				int nop = sc.getUpersons();
				int padded = sc.getPadded();
				if (padded==0) {
					sc.setFid(Integer.parseInt(request.getParameter("id")));
					padded++;
					sc.setPadded(padded);
					response.sendRedirect("passengerdetail.jsp");
				}
				else {
					String name = request.getParameter("name");
	    	        String email = request.getParameter("email");
	    	        String country = request.getParameter("country");
	    	        int fid = sc.getFid();
	    	        String pnr = sc.getPnr();
	    	        String sid = session.getId();
	    	        Passengers newPassengers = new Passengers(name, email, country, fid, sid, pnr);
	    	        passengerDao.saveUser(newPassengers);
	    	        padded++;
	    	        sc.setPadded(padded);
					if (padded <= nop) {
		    	        response.sendRedirect("passengerdetail.jsp");						
					} else {
						
				        List < Flights > listFlights = flightsDao.getSelectedFlight(fid);
				        request.setAttribute("listFlights", listFlights);

				        List < Passengers > listPassengers = passengerDao.getPassengerDetails(pnr);
				        request.setAttribute("listPassengers", listPassengers);

				        sc.setUticketprice(flightsDao.getFlgihtFare(fid).getTicketprice());
				        
				        sc.setTotalfare(sc.getUpersons()*sc.getUticketprice());
				        
				        RequestDispatcher dispatcher = request.getRequestDispatcher("bookingdetails.jsp");
				        dispatcher.forward(request, response);
					}
				} 
        }
	catch(Exception ex) {
        throw new ServletException(ex);
		
	}
	}

}
