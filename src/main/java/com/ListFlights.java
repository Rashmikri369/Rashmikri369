package com;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FlightsDao;
import model.Flights;

/**
 * Servlet implementation class ListFlights
 */
//@WebServlet("/ListFlights")
public class ListFlights extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FlightsDao flightsDao;
    public void init() {
        flightsDao = new FlightsDao();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListFlights() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List < Flights > listFlights = flightsDao.getAllFlights();
        request.setAttribute("listFlights", listFlights);
        RequestDispatcher dispatcher = request.getRequestDispatcher("flightlist.jsp");
        dispatcher.forward(request, response);
	}
}
