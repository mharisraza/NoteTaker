package com.notetaker.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.notetaker.entitites.Message;
import com.notetaker.entitites.Note;
import com.notetaker.helper.FactoryProvider;

/**
 * Servlet implementation class SaveNote
 */
public class SaveNote extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaveNote() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			response.setContentType("text/html");
            RequestDispatcher dispatcher = null;
            HttpSession httpsession=request.getSession();

            
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int userId = (Integer) httpsession.getAttribute("userId");
			
			Note note = new Note(userId, title, content, new Date());
			
			
			// trying to save database via Hibernate
			
			
			Session s=FactoryProvider.getFactory().openSession();
			Transaction tx=s.beginTransaction();
			
			s.save(note);
			
			
			tx.commit();
			
			if(s.save(note)!=null) {

				Message msg=new Message("Note is Added Successfully!", "success", "alert-success");
				httpsession.setAttribute("status", msg);
				dispatcher = request.getRequestDispatcher("addNote");
				dispatcher.forward(request, response);
			}
			else {
				Message msg=new Message("An Error has occurred!", "error", "alert-danger");
				httpsession.setAttribute("status", msg);
				dispatcher = request.getRequestDispatcher("addNote");
				dispatcher.forward(request, response);
			}
			
			s.close();
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
