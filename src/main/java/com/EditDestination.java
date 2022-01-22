package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DestinationsDao;
import dto.UserCriteria;
import model.Destinations;

/**
 * Servlet implementation class EditDestination
 */
//@WebServlet("/EditDestination")
public class EditDestination extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DestinationsDao destinationsDao;
	
	public void init() {
		destinationsDao = new DestinationsDao();
	}   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDestination() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserCriteria uc =(UserCriteria) session.getAttribute("usercriteria");
		uc.setDid(Integer.parseInt(request.getParameter("did")));
		Destinations listDestinations = destinationsDao.getDestination(uc.getDid()); 
        request.setAttribute("listDestinations", listDestinations);
        session.setAttribute("usercriteria", uc);
        RequestDispatcher dispatcher = request.getRequestDispatcher("destination-form.jsp");
        dispatcher.forward(request, response);
	}
}
