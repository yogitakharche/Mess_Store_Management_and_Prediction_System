<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link href="<c:url value='/resources/CSS/AddUser.css'/>" rel="stylesheet">
</head>
<body>
          <jsp:include page="AddUser.jsp"/> 

    <div class="update-form">
	<h1>Update User</h1>
	<form name="updateform" action="updateForm">
	   <input type="hidden" name="id" value="${temp.getId()}">
	   <span>Name:</span>
	   <input type="text" name="name" value="${temp.getName()}">
	   <span>Email:</span>
	   <input type="text" name="email" value="${temp.getEmail()}">
	   <span>Contact:</span>
	   <input type="text" name="contact" value="${temp.getContact()}">
	   <button>Update</button>
	   <h3>${msg}</h3>
	</form>
	</div>
	
	
</body>
</html>