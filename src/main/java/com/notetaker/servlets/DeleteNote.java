package com.notetaker.servlets;

import java.io.IOException;

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
 * Servlet implementation class DeleteNote
 */
public class DeleteNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			RequestDispatcher dispatcher = null;
			HttpSession httpsession=request.getSession();
			
			int noteId=Integer.parseInt(request.getParameter("note_id").trim());
			
			Session s= FactoryProvider.getFactory().openSession();
			Transaction tx=s.beginTransaction();
			
			Note note=(Note)s.get(Note.class, noteId);
			
			s.delete(note);
			
			
			tx.commit();
			if(note!=null) {
				Message msg=new Message("Note Deleted Successfully!", "success", "alert-success");
				httpsession.setAttribute("status", msg);
				dispatcher = request.getRequestDispatcher("showNotes");
				dispatcher.forward(request, response);

			}
			else {
				Message msg=new Message("Note Cannot Be Delete", "error", "alert-danger");
				httpsession.setAttribute("status", msg);
				dispatcher = request.getRequestDispatcher("showNotes");
				dispatcher.forward(request, response);

				
			}
			s.close();
			

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
