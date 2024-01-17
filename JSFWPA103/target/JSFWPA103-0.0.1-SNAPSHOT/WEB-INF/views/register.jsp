<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous">
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
            crossorigin="anonymous"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>
    <link href="../resources/layout.css" rel="stylesheet">
    <style type="text/css">
    </style>

</head>
<body>
<%@include file="Header.jsp" %>
<div>
    <div class="center">
        <section class="vh-100 gradient-custom">
            <div class="container py-5 h-100">
                <div
                        class="row d-flex justify-content-center h-100">
                    <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                        <div class="card bg-dark text-white" style="border-radius: 1rem;">
                            <div class="card-body p-5 ">

                                <div class="mb-md-1 mt-md-1">

                                    <h2 class="fw-bold mb-2 text-uppercase">Register</h2>

                                </div>
                                <form:form action="${pageContext.request.contextPath}/register" method="post"
                                           modelAttribute="register">
                                <div class="form-outline form-white mb-4">
                                    <form:input path="username" class="form-control form-control-lg"/>

                                    <form:label path="username" class="form-label">Username</form:label>

                                    <form:errors path="username" style="color: red"/>
                                </div>
                                <div class="form-outline form-white mb-4">
                                    <form:input path="email" class="form-control form-control-lg"/>

                                    <form:label path="email" class="form-label">Email</form:label>

                                    <form:errors path="email" style="color: red"/>
                                </div>
                                <div class="form-outline form-white mb-4">
                                    <form:input path="password"
                                                class="form-control form-control-lg"/>

                                    <form:label path="password" class="form-label">Password</form:label>
                                    <form:errors path="password" style="color: red"/>

                                </div>
                                <div class="form-outline form-white mb-4">
                                    <form:input path="repassword"
                                                class="form-control form-control-lg"/>
                                    <form:label path="repassword" class="date">RePassword</form:label>
                                    <form:errors path="repassword" style="color: red"/>
                                    <c:if test="${error != null}">
                                        <span style="color: #ff0000;">${error}</span>
                                    </c:if>
                                </div>
                                <button class="btn btn-outline-light btn-lg px-5" type="submit">Register</button>
                                <a href="login">
                                    <button class="btn btn-success btn-lg px-5" type="button">Login</button>
                                </a>

                                <c:if test="${message != null}">
                                    <p style="color: red;">${message}</p>
                                </c:if>

                            </div>
                            </form:form>
                        </div>
                    </div>

                </div>
            </div>
        </section>
    </div>
</div>

<%@include file="Footer.jsp" %>

</body>


</html>


