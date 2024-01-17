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
    <style type="text/css">
    </style>
 </head>
<body>
<%@include file="Header.jsp" %>
<%@include file="headerForm.jsp" %>
<div>
    <div class="main-container">
        <%@include file="leftContent.jsp" %>
        <div class="header-body">
            <h1>Add content</h1>
            <hr>
            <div class="main-body">
                <h3>Content Form Element</h3>
                <form:form action="${pageContext.request.contextPath}/user/content" method="post" modelAttribute="content">
                    <div class="mb-3">
                        <label for="title-content" class="form-label">Title</label>
                        <form:errors path="title" style="color: red"/>
                        <input type="hidden" name="id" value="${content.id}">
                        <input
                                type="text" class="form-control" name="title" value="${content.title}"
                                id="title-content" aria-describedby="firstNameHelp">

                    </div>
                    <input type="hidden" name="action" value="addContent">
                    <div class="mb-3">
                        <label for="brief" class="form-label">Brief</label>
                        <form:errors path="brief" style="color: red"/>
                        <textarea id="brief" name="brief" class="field-text-area">${content.brief}</textarea>
                    </div>

                    <div class="mb-3">
                        <label for="description-view" class="form-label">Description</label>
                        <form:errors path="description" style="color: red"/>
                        <textarea id="description-view" name="description"
                                  class="field-text-area">${content.description}</textarea>


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