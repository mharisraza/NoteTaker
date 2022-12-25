<%@page import="com.notetaker.entitites.Note"%>
<%@page import="com.notetaker.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="cdn-container.jsp"%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    
	<div class="container">
		<%@include file="navbar.jsp"%>
		<br>
		<h1>Edit Your Note</h1>
		<hr>

		<%
		int noteId = Integer.parseInt(request.getParameter("note_id").trim());
		Session s = FactoryProvider.getFactory().openSession();
		Note note = (Note) s.get(Note.class, noteId);
		%>

		<form action="editNote" method="POST">
		<input type="hidden" name="noteId" value="<%=note.getId()%>">
			<div class="form-group">
				<label for="title">Note Title</label> <input value="<%=note.getTitle() %>" name="title"
					required="required" type="text" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp"
					placeholder="Note Title">
			</div>

			<div class="form-group">
				<label for="content">Note Content</label>
				<textarea name="content" required id="content"
					placeholder="Enter your Note Content here" class="form-control"
					style="height: 300px;"><%=note.getContent() %></textarea>


			</div>
			<div class="form-check">

				<div class="container text-center">
					<button type="submit" class="btn btn-success">Save Now</button>
					

				</div>
		</form>
	</div>

</body>
</html>