<%--
  Created by IntelliJ IDEA.
  User: Bap
  Date: 4/1/2024
  Time: 9:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Landing Page</title>
    <link rel="stylesheet" href="./asset/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-secondary">
    <div class="container-fluid">
        <a class="btn btn-primary" href="home?action=addition">Add</a>
        <div class="collapse navbar-collapse d-flex justify-content-end" id="navbarSupportedContent">
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<table class="table table-primary table-striped">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">DateOfBirth</th>
        <th scope="col">Email</th>
        <th scope="col">Address</th>
        <th scope="col">Phone</th>
        <th scope="col">Classroom</th>
        <th scope="col">Acction</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${studentList}" var="student">
        <tr>
            <td>${student.studentId}</td>
            <td>${student.studentName}</td>
            <td>${student.birth}</td>
            <td>${student.email}</td>
            <td>${student.address}</td>
            <td>${student.phone}</td>
            <td>${student.className}</td>
            <td colspan="2" class="d-flex">
                <div class="me-5">
                    <form action="home?action=edit" method="post">
                        <input type="hidden" value="${student.studentId}" name="id">
                        <button class="btn btn-warning">Edit</button>
                    </form>
                </div>
                <div>
                    <form action="home?action=delete" method="post">
                        <input type="hidden" value="${student.studentId}" name="id">
                        <button class="btn btn-danger">Remove</button>
                    </form>
                </div>


            </td>
        </tr>
    </c:forEach>


    <%--<tr>
        <td>1</td>
        <td>Nguyen Van A</td>
        <td>10/10/2010</td>
        <td>@mdo</td>
        <td>HA NOI</td>
        <td>09173786234</td>
        <td>C1123G1</td>
        <td colspan="2">
            <a class="btn btn-warning me-5">Edit</a>
            <a class="btn btn-danger">Remove</a>
        </td>
    </tr>--%>
    </tbody>
</table>
</body>
<script src="./asset/js/bootstrap.bundle.min.js"></script>
</html>
