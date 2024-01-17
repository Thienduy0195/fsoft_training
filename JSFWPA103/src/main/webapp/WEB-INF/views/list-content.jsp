<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

    <link rel="stylesheet" href="../resources/layout.css">

</head>
<body>
<%@include file="header-layout.jsp" %>
<%@include file="user.jsp" %>
<div>
    <div class="main-container">
        <%@include file="left-sidebar.jsp" %>

        <div class="main-body">
            <h3>View content list</h3>
            <div class="table-container">
                <div class="mb3">
                    <table>
                        <tr>
                            <th id="first-column">#</th>
                            <th id="title-column">Title</th>
                            <th id="brief-column">Brief</th>
                            <th id="date-column">Create Date</th>
                            <th></th>
                        </tr>
                        <c:forEach items="${contents}" var="item" varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td>${item.title}</td>
                                <td>${item.brief}</td>
                                <td>${item.createDate}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/user/edit/${item.id}">
                                        <i class="fa-regular fa-pen-to-square"></i>
                                    </a>
                                    <a href="${pageContext.request.contextPath}/user/delete/${item.id}">
                                        <i class="fa-solid fa-trash-can"></i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>