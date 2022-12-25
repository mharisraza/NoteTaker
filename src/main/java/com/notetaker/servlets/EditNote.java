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

public class EditNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public EditNote() {
        super();
        
    }

	
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			Session s=FactoryProvider.getFactory().openSession();
			HttpSession httpsession=request.getSession();
			RequestDispatcher dispatcher = null;
			
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			int noteId=Integer.parseInt(request.getParameter("noteId").trim());
			
			Transaction tx=s.beginTransaction();
			Note note=s.get(Note.class, noteId);
			
			note.setTitle(title);
			note.setContent(content);
			note.setAddedDate(new Date());
			
			s.update(note);
			tx.commit();
			
			if(note!=null) {
				Message msg=new Message("Congratulations, Your Note Edited Successfully!", "success", "alert-success");
				httpsession.setAttribute("status", msg);
				dispatcher = request.getRequestDispatcher("showNotes");
				dispatcher.forward(request, response);
				
			}else {
				Message msg=new Message("Sorry, Unable to Edit your Note!", "error", "alert-danger");
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
