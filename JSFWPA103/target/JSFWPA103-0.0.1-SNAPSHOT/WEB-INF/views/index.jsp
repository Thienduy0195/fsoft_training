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
</head>
<body>
	<%@include file="Header.jsp"%>
	<div>
		<div class="center">

			<section class="vh-100 gradient-custom">
				<div class="container py-5 h-100">
					<div
						class="row d-flex justify-content-center h-100">
						<div class="col-12 col-md-8 col-lg-6 col-xl-5">
							<div class="card bg-dark text-white" style="border-radius: 1rem;">
								<div class="card-body p-5">

									<div class="mb-md-5 mt-md-4 pb-5">

										<h2 class="fw-bold mb-2 text-uppercase">Login</h2>
										<p>email suggest: ktraice1@answers.com, pass: fE6we32KDM</p>
										<form:form action="${pageContext.request.contextPath}/login" method="post" modelAttribute="account">
											<div class="form-outline form-white mb-4">
												<form:input path="email"
													class="form-control form-control-lg" />


												<form:label path="email" class="form-label">Email</form:label>

												<form:errors path="email" style="color: red" />


											</div>

											<div class="form-outline form-white mb-4">
												<form:password  path="password"
													class="form-control form-control-lg" />

												<form:label path="password" class="form-label">Password</form:label>
												<form:errors path="password" style="color: red" />

											</div>
											<button class="btn btn-outline-light btn-lg px-5"
												type="submit">Login</button>
											<a href="register">
												<button class="btn btn-success btn-lg px-5" type="button">Register</button>
											</a>

											<c:if test="${message != null}">
												<p style="color: red;">${message}</p>
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
	<%@include file="Footer.jsp"%>
</body>
</html>