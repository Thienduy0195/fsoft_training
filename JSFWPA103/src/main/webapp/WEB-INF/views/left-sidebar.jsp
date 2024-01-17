<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<div class="wrap-item-navbar">
    <div class="input-group" style="display: flex">
        <form:form action="${pageContext.request.contextPath}/user/search" method="get">
            <input type="search" class="rounded" name="title" style="padding: 5px 0 "
                   placeholder="Search" aria-label="Search"
                   aria-describedby="search-addon"/>
            <span style="padding: 5px 0 ">
                <button type="submit" class="btn btn-outline-primary">
				<i class="fa-solid fa-magnifying-glass"></i>
			    </button>
            </span>
        </form:form>
    </div>


    <div class="item-1 list-choice">
        <a href="${pageContext.request.contextPath}/user/listContent"> <i class="fa-regular fa-calendar-days"> <span>View
						contents</span></i>
        </a>
    </div>

    <div class="item-2 list-choice">
        <a href="${pageContext.request.contextPath}/user/form"> <i class="fa-solid fa-file-pen"> <span>Form
						contents</span>
        </i>
        </a>
    </div>
</div>
</body>
</html>