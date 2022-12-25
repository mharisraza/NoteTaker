<%

  Users user = (Users) session.getAttribute("user");
  if(user==null) {
	  Message msg=new Message("Please login or register to continue.", "error", "alert-danger");
	  session.setAttribute("status", msg);
	  RequestDispatcher dispatcher = null;
	  dispatcher = request.getRequestDispatcher("Login");
	  dispatcher.forward(request, response);
  }



%>

<%@page import="com.notetaker.entitites.Message"%>
<%@page import="com.notetaker.entitites.Users"%>
<nav class="navbar navbar-expand-lg navbar-dark purple">
	<a class="navbar-brand" href="#">NoteTaker</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="home">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="addNote">Add Note</a></li>
		    <li class="nav-item"><a class="nav-link" href="showNotes">Show Notes</a></li>
			</ul>
			<%
			if(user!=null) {
				
			%>
			<ul class="navbar-nav mr-right">
			<li class="navbar-brand"><span style="color: white;" class="fa-solid fa-user">&nbsp;<%=user.getName() %>&nbsp;</span>
			<li class="nav-item"><form action="LogOut" method="POST"><button type="submit" class="btn btn btn-danger">Log Out</button></form>
			</ul>
			
			<%} %>
			
	</div>
</nav>