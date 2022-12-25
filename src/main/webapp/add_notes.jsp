

<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.notetaker.entitites.Users"%>
<%@page import="com.notetaker.entitites.Message"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
<%@include file="cdn-container.jsp"%>
<meta charset="UTF-8">
<title>NoteTaker | Add Notes</title>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>

		<br>
		<h1>Add Note</h1>
		<hr>

		<!-- Error/Success Message -->

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
		<!-- Form -->
		<form action="SaveNote" method="POST">

			<div class="form-group">
				<label for="title">Note Title</label> <input name="title"
					required="required" type="text" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp"
					placeholder="Note Title">
			</div>

			<div class="form-group">
				<label for="content">Note Content</label>
				<textarea name="content" required id="content"
					placeholder="Enter your Note Content here" class="form-control"
					style="height: 300px;"></textarea>


			</div>
			<div class="form-check">

				<div class="container text-center">
					<button type="submit" class="btn btn-primary">Add Now</button>

				</div>
			</div>
		</form>
</body>
</html>