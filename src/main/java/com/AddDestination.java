package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DestinationsDao;
import model.Destinations;

/**
 * Servlet implementation class AddDestination
 */
//@WebServlet("/AddDestination")
public class AddDestination extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DestinationsDao destinationsDao;
	
	public void init() {
		destinationsDao = new DestinationsDao();
	}  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDestination() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nd = request.getParameter("ndestination");
		Destinations destination = new Destinations(nd);
		destinationsDao.addDestination(destination);
		response.sendRedirect("adminpage.jsp");
	}
}
