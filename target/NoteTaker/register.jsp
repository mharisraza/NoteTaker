<%@page import="com.notetaker.entitites.Message"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>NoteTaker | Register</title>
</head>
<body>

	<section class="vh-100" style="background-color: #eee;">
		<div class="container h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-lg-12 col-xl-11">
					<div class="card text-black" style="border-radius: 25px;">
						<div class="card-body p-md-5">
							<div class="row justify-content-center">
								<div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

									<p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign
										up</p>

									<form action="RegisterServ" method="POST" class="mx-1 mx-md-4">

										<%
										Message message = (Message) session.getAttribute("status");
										if (message != null) {
										}
										%>
										<div
											class="alert <%=message != null ? message.getCssClass() : ""%>"
											role="<%=message != null ? message.getType() : ""%>">
											<%=message != null ? message.getContent() : ""%>
										</div>
										<%
										session.removeAttribute("status");
										%>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-user fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input name="user_name" required type="text"
													id="form3Example1c" class="form-control" /> <label
													class="form-label" for="form3Example1c">Username</label>
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input name="user_email" required type="email"
													id="form3Example3c" class="form-control" /> <label
													class="form-label" for="form3Example3c">Your Email</label>
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-lock fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input name="user_password" required type="password"
													id="form3Example4c" class="form-control" /> <label
													class="form-label" for="form3Example4c">Password</label>
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-key fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input name="user_confirm_pwd" required type="password"
													id="form3Example4cd" class="form-control" /> <label
													class="form-label" for="form3Example4cd">Confirm
													Password</label>
											</div>
										</div>

										<div class="form-check d-flex justify-content-center mb-5">
											<input required class="form-check-input me-2" type="checkbox"
												value="" id="form2Example3c" /> <label
												class="form-check-label" for="form2Example3"> I
												agree all statements in <a href="#!">Terms of service</a>
											</label>
										</div>

										<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
											<button type="submit" class="btn btn-primary btn-lg">Register
												Now</button>
										</div>

									</form>

								</div>
								<div
									class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

									<img
										src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
										class="img-fluid" alt="Sample image">

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>
</html>