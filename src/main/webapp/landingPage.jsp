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
            <form class="d-flex" action="home?action=search" method="get">
                <input type="hidden" name="action" value="search">
                <input class="form-control me-2" type="search" placeholder="Search" name="searchWord">
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
                        <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                                data-bs-target="#exampleModal${student.studentId}">Remove
                        </button>
                        <div class="modal fade" id="exampleModal${student.studentId}" tabindex="-1"
                             aria-labelledby="exampleModalLabel"
                             aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="exampleModalLabel">Confirm delete</h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                    aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            Would you really want to delete this student?
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                                Close
                                            </button>
                                            <button type="submit" class="btn btn-primary">Delete</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
<script src="./asset/js/bootstrap.bundle.min.js"></script>
</html>
