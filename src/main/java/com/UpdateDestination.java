package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DestinationsDao;
import dto.UserCriteria;

/**
 * Servlet implementation class UpdateDestination
 */
//@WebServlet("/UpdateDestination")
public class UpdateDestination extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DestinationsDao destinationsDao;
	
	public void init() {
		destinationsDao = new DestinationsDao();
	}   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDestination() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserCriteria uc =(UserCriteria) session.getAttribute("usercriteria");
        String ud = request.getParameter("udestination");        
        destinationsDao.updateDestination(uc.getDid(), ud);
        response.sendRedirect("adminpage.jsp");
	}
}
