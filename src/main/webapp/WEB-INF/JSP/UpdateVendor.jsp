<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>vendor update</title>
<link href="<c:url value='/resources/CSS/UpdateVendor.css'/>" rel="stylesheet">
</head>
<body>             
      <div class="update-form">
	<h1>Update Vendor</h1>
	<form name="updateform" action="updateVendForm">
	   <input type="hidden" name="id" value="${vend.getId()}">
	   <span>Name:</span>
	   <input type="text" name="name" value="${vend.getName()}">
	   <span>Email:</span>
	   <input type="text" name="email" value="${vend.getEmail()}">
	   <span>Contact:</span>
	   <input type="text" name="contact" value="${vend.getContact()}">
	   <span>ShopName:</span>
	   <input type="text" name="shopname" value="${vend.getShopname()}">
	   <button>Update</button>
	   <h3>${msg}</h3>
	</form>
	</div>
</body>
</html>