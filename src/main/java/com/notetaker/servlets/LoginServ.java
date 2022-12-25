package com.notetaker.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.apache.catalina.startup.UserConfig;

import com.notetaker.entitites.Message;
import com.notetaker.entitites.Users;
import com.notetaker.helper.UserDao;


public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServ() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpsession=request.getSession();
		
		
		
		UserDao dao=new UserDao();
		
		RequestDispatcher dispatcher = null;
		
		String email=request.getParameter("user_email");
		String password=request.getParameter("user_password");
		
		if(email.equals("") || email.isBlank()) {
			Message msg=new Message("Invalid Email or Password", "error", "alert-danger");
			httpsession.setAttribute("status", msg);
			dispatcher = request.getRequestDispatcher("Login");
			dispatcher.forward(request, response);	
			return;
		}
		
		if(password.equals("") || password.isBlank()) {
			Message msg=new Message("Invalid Email or Password", "error", "alert-danger");
			httpsession.setAttribute("status", msg);
			dispatcher = request.getRequestDispatcher("Login");
			dispatcher.forward(request, response);	
			return;
		}
		
		Users u = dao.validate(email, password);
		

		if(u==null) {			
			Message msg=new Message("Invalid Email or Password", "error", "alert-danger");
			httpsession.setAttribute("status", msg);
			dispatcher = request.getRequestDispatcher("Login");
			dispatcher.forward(request, response);
			return;
			
		}
		else {
			Message msg=new Message("Login Success! You can add your notes now.", "success", "alert-success");
			httpsession.setAttribute("user", u);
			Users user = (Users) httpsession.getAttribute("user");
			httpsession.setAttribute("userId", user.getId());
			httpsession.setAttribute("status", msg);
			dispatcher = request.getRequestDispatcher("addNote");
			dispatcher.forward(request, response);
			
			
		}
		
		
		
	}

}
