


<%@page import="org.hibernate.Query"%>
<%@page import="com.notetaker.entitites.Users"%>
<%@page import="com.notetaker.entitites.Message"%>
<%@page import="com.notetaker.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.notetaker.entitites.Note"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
<head>
<title>NoteTaker | All Notes</title>
<meta charset="UTF-8">
<%@include file="cdn-container.jsp"%>

</head>
<body>

	<div class="container">
		<%@include file="navbar.jsp"%>
		<br>
		<h1 class="text-uppercase">
			All Notes&nbsp;<img style="max-width: 40px;" src="img/notepad.png">
		</h1>
		<hr>
		<%
		Message message = (Message) session.getAttribute("status");
		if (message != null) {
		}
		%>

		<div class="alert <%=message != null ? message.getCssClass() : ""%>"
			role="<%=message != null ? message.getType() : ""%>">
			<%=message != null ? message.getContent() : ""%>
		</div>
		<%
		session.removeAttribute("status");
		%>

		<div class="row">

			<div class="col-12">

				<%
				Session s = FactoryProvider.getFactory().openSession();
				Query q = s.createQuery("from Note");
				List<Note> list = q.list();
					for (Note notes : list) {
						if(user.getId()==notes.getUser_id()) {
				%>

				<div class="card">
					<div class="card-body">
						<h5 class="card-title"><%=notes != null ? notes.getTitle(): ""%></h5>
						<hr>
						<p class="card-text"><%=notes != null ? notes.getContent(): ""%></p>
						<hr>
						<p>
							<b class="text-primary">Last Updated: <%=notes != null ? notes.getAddedDate(): ""%></b>
						</p>
						<hr>
						<div class="container text-center">
							<a href="editNotes?note_id=<%=notes != null ? notes.getId(): ""%>"
								class="btn btn-primary">Edit</a> <a
								href="deleteNote?note_id=<%=notes != null ? notes.getId(): ""%>"
								class="btn btn-danger">Delete</a>

						</div>
					</div>
				</div>


				<%
				}
				}
					
				s.close();
				%>





			</div>


		</div>


	</div>

</body>
</html>