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
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWFwPtgFTxbJ8NT4GN1R8p"
            crossorigin="anonymous"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">

    <link href="../resources/layout.css" rel="stylesheet">

</head>
<body>
<%@include file="Header.jsp" %>
<%@include file="headerForm.jsp" %>
<div>
    <div class="main-container">
        <%@include file="leftContent.jsp" %>

        <div class="header-body" style="display: block" id="edit-profile">
            <h1>Edit Profile</h1>
            <hr>
            <div class="main-body">
                <h3>Profile Form Element</h3>
                <form:form method="post" action="${pageContext.request.contextPath}/user" modelAttribute="member">

                    <div class="mb-3">
                        <input name="id" type="hidden" value=${member.id}>
                        <input name="username" type="hidden" value=${member.username}>
                        <input name="password" type="hidden" value=${member.password}>
                        <label for="first-name" class="form-label">First
                            name</label>
                        <input type="text" class="form-control" name="firstname" id="first-name" required minlength="2"
                               value="${member.firstname }"
                                       aria-describedby="firstNameHelp">
                    </div>

                    <div class="mb-3">
                        <label for="last-name" class="form-label">Last
                            name</label>
                        <input type="text"
                               class="form-control"
                               id="last-name"
                               name="lastname"
                               value="${member.lastname}"
                                       required minlength="2"
                               aria-describedby="lastNameHelp">
                    </div>

                    <div class="mb-3">
                        <label for="createDate" class="form-label">Create
                            Date</label>
                        <input type="date" class="form-control" id="createDate"
                               name="createDate"
                               readonly
                               aria-describedby="phoneHelp"
                               value=${member.createDate}
                        >
                    </div>

                    <div class="mb-3">
                        <label for="email-id" class="form-label">Email</label>
                        <input type="text" class="form-control" id="email-id"
                               name="email" readonly
                               aria-describedby="emailHelp"
                               value=${member.email }>
                    </div>
                    <div class="mb-3">
                        <label for="description" class="form-label">Description</label>

                        <textarea id="description"
                                  name="description"
                                  class="field-text-area">${member.description}</textarea>
                    </div>
                    <div class="mb-3">
                        <button type="reset" class="submit-button">Reset Button</button>

                        <button type="submit" class="submit-button">Submit
                            Button
                        </button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
<%@include file="Footer.jsp" %>
</body>
</html>