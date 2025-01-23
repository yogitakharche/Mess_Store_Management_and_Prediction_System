<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Product</title>
<link href="<c:url value='/resources/CSS/AddProduct.css'/>" rel="stylesheet">
 </head>
<body>

  
     <div class="update-form">
	<h1>Update Product</h1>
	<form name="updateform" action="updateProd" method="get"  >
	   <input type="hidden" name="prodId" value="${temp.getProdId()}">
	   <span>Name:</span>
	   <input type="text" name="prodName" value="${temp.getProdName()}">
	   <button>Update</button>
	   <h3>${msg}</h3>
	</form>
	</div>
</body>
</html>