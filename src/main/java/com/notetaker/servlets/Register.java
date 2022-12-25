package com.notetaker.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.notetaker.entitites.Message;
import com.notetaker.entitites.Users;
import com.notetaker.helper.UserDao;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDao dao=new UserDao();
		HttpSession httpsession = request.getSession();
		RequestDispatcher dispatcher = null;
		
		
		String username=request.getParameter("user_name");
		String email=request.getParameter("user_email");
		String password=request.getParameter("user_password");
		String rpt_pwd=request.getParameter("user_confirm_pwd");
		
		if(username.equals("") || username.isBlank()) {
			Message msg=new Message("Username cannot be blank.", "error", "alert-danger");
			httpsession.setAttribute("status", msg);
			dispatcher = request.getRequestDispatcher("Register");
			dispatcher.forward(request, response);
			return;
		}
		
		if(email.equals("") || email.isBlank()) {
			Message msg=new Message("Email cannot be blank.", "error", "alert-danger");
			httpsession.setAttribute("status", msg);
			dispatcher = request.getRequestDispatcher("Register");
			dispatcher.forward(request, response);
			return;
		}
		
		if(password.equals("") || password.isBlank()) {
			Message msg=new Message("Password cannot be blank.", "error", "alert-danger");
			httpsession.setAttribute("status", msg);
			dispatcher = request.getRequestDispatcher("Register");
			dispatcher.forward(request, response);
			return;
		}
		
		if(!rpt_pwd.equals(password)) {
			Message msg=new Message("Passwords do not matches.", "error", "alert-danger");
			httpsession.setAttribute("status", msg);
			dispatcher = request.getRequestDispatcher("Register");
			dispatcher.forward(request, response);
			return;
		}
		
		Users user=new Users(username, email, password);
		
		if(dao.saveUser(user)) {
			Message msg=new Message("Registered Successfully! You can login now.", "success", "alert-success");
			httpsession.setAttribute("status", msg);
			dispatcher = request.getRequestDispatcher("Login");
			dispatcher.forward(request, response);
		}
		else {
			Message msg=new Message("An Error has occurred!", "error", "alert-danger");
			httpsession.setAttribute("status", msg);
			dispatcher = request.getRequestDispatcher("Register");
			dispatcher.forward(request, response);
			
		}
		
		
		
		
	}

}
