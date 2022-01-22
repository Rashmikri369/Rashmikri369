package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class ValidateUser
 */
//@WebServlet("/ValidateUser")
public class ValidateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	
	public void init() {
		userDao = new UserDao();
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();
		try {
			System.out.println("validate user servlet");
			String un=request.getParameter("username");
			String up=request.getParameter("userpassword");
			boolean result = userDao.getSelectedUser(un, up);
			System.out.println(result);
			if (result) {
				response.sendRedirect("adminpage.jsp");
			} else {
				response.sendRedirect("invalidlogin.html");
			}
		} catch (Exception e) {
			throw new ServletException(e);
            //e.printStackTrace();
        }
	}
}
