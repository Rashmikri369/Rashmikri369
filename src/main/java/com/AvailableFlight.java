package com;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Flights;
import dao.FlightsDao;

import dto.SearchCriteria;

/**
 * Servlet implementation class AvailableFlight
 */

public class AvailableFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FlightsDao flightsDao;
    public void init() {
        flightsDao = new FlightsDao();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AvailableFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SearchCriteria sc = new SearchCriteria();
		HttpSession session = request.getSession();

		try {
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyhhmmss");
				sc.setPnr(formatter.format(date));
            	String dateStr = request.getParameter("udate");
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            sc.setUdate(sdf.parse(dateStr));
				sc.setUsource(request.getParameter("usource"));
				sc.setUdestination(request.getParameter("udestination"));
				sc.setUpersons(Integer.parseInt(request.getParameter("upersons")));
				session.setAttribute("searchcriteria", sc);

				List < Flights > listFlights = flightsDao.getFlights(sc.getUsource(), sc.getUdestination(), sc.getUdate());
		        request.setAttribute("listFlights", listFlights);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("search-flight.jsp");
		        dispatcher.forward(request, response);
            }
		catch(Exception ex) {
            throw new ServletException(ex);
			
		}
	}

}
