<%--
  Created by IntelliJ IDEA.
  User: Bap
  Date: 4/1/2024
  Time: 10:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add new student</title>
    <link rel="stylesheet" href="./asset/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <form action="home?action=addition" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email address</label>
            <input type="email" class="form-control" id="email" name="email">
        </div>
        <div class="mb-3">
            <label for="birth" class="form-label">Date of birth</label>
            <input type="text" class="form-control" id="birth" name="birth">
        </div>
        <div class="mb-3">
            <label for="address" class="form-label">Address</label>
            <input type="text" class="form-control" id="address" name="address">
        </div>
        <div class="mb-3">
            <label for="phone" class="form-label">Phone number</label>
            <input type="text" class="form-control" id="phone">
        </div>
        <div class="mb-3">
            <label for="class" class="form-label">Class</label>
            <select id="class" class="form-select" name="class">
                <option></option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
<script src="./asset/js/bootstrap.bundle.min.js"></script>
</html>
