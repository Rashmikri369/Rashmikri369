package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FlightsDao;
import dto.UserCriteria;
import model.Flights;


/**
 * Servlet implementation class EditFlight
 */
//@WebServlet("/EditFlight")
public class EditFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FlightsDao flightsDao;
    public void init() {
        flightsDao = new FlightsDao();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserCriteria uc =(UserCriteria) session.getAttribute("usercriteria");
		uc.setFid(Integer.parseInt(request.getParameter("fid")));
		Flights listFlights = flightsDao.getFlgihtFare(uc.getFid()); 
		System.out.println(listFlights.getDestination());
        request.setAttribute("listFlights", listFlights);
        session.setAttribute("usercriteria", uc);
        RequestDispatcher dispatcher = request.getRequestDispatcher("flight-form.jsp");
        dispatcher.forward(request, response);
	}
}
