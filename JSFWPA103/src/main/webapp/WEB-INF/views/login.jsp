<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="../resources/layout.css" rel="stylesheet">
<link href="../resources/css/mystyle.css" rel="stylesheet">
<link href="../resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background: #121212;">
	<%@include file="header-layout.jsp" %>

	<div>
		<div class="center">

			<section class="vh-100 gradient-custom">
				<div class="container py-5 h-100">
					<div class="row d-flex justify-content-center h-100">
						<div class="col-12 col-md-8 col-lg-6 col-xl-5">
							<div class="card text-white"
								style="border-radius: 1rem; background: #2b2b2b;">
								<div class="card-body p-5">

									<div class="mb-md-2 mt-md-2 pb-2">

										<div
											style="display: flex; justify-content: center; margin-bottom: 2em;">
											<h2 class="fw-bold mb-2 text-uppercase">LOGIN FORM</h2>
										</div>

										<form:form action="${pageContext.request.contextPath}/login"
											method="post" modelAttribute="account">
											<div class="form-outline form-white mb-4">
												<label class="form-label">Email (example@gmail.com)</label>
												<form:input path="email"
													class="form-control form-control-lg"
													placeholder="Enter your email" />

												<form:errors path="email" class="text-white" />

											</div>

											<div class="form-outline form-white mb-4">
												<label class="form-label">Password</label>
												<form:input type="password" path="password"
													placeholder="Enter your password"
													class="form-control form-control-lg" />


												<form:errors path="password" class="text-white" />

											</div>
											<button class="btn btn-outline-light btn-lg px-5"
												type="submit">Login</button>
											<a href="register">
												<button class="btn btn-secondary btn-lg px-5" type="button">Register</button>
											</a>

											<c:if test="${message != null}">
												<p class="text-white mt-2">${message}</p>
											</c:if>
										</form:form>
									</div>

								</div>
							</div>
						</div>
					</div>
				</div>
			</section>

		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>