<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>view unit</title>
    <style>
        table {
            width: 50%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

<h2>Unit is Here</h2>

<table>
    <tr>
        <th>Sr.no</th>
        <th>Name</th>
    </tr>
    <% int count=0; %>
    <c:forEach var="u" items="${stkList}">
        <tr>
            <td><%= ++count %></td>
            <td>${u.getUnitName()}</td>
        </tr>
    </c:forEach>
     <%count=0; %>
</table>

</body>
</html>
