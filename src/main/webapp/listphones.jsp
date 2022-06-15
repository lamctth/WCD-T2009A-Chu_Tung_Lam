<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Phones</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">List of Phone</h3>
        <hr>
        <div class="container text-center">

            <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Phone</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Brand</th>
                <th>Price</th>
                <th>Description</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="phone" items="${listPhone}">

                <tr>
                    <td>
                        <c:out value="${phone.id}"/>
                    </td>
                    <td>
                        <c:out value="${phone.name}"/>
                    </td>
                    <td>
                        <c:out value="${phone.brand}"/>
                    </td>
                    <td>
                        <c:out value="${phone.price}"/>
                    </td>
                    <td>
                        <c:out value="${phone.description}"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
