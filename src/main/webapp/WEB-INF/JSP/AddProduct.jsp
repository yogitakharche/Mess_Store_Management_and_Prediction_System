<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
<link href="<c:url value='/resources/CSS/AddProduct.css'/>" rel="stylesheet">

</head>
<body>
<h1>Product Section</h1>
	<div class="product-wrapper-container">
		
		<div class="add-product-form">
			<h3>Add Product</h3>
			<form name="frm" action="addproduct" method="post">
			
				<span>Name:</span> 
				<input class="ipt" type="text" name="prodName">
				
				<input class="submit-btnn" type="submit" name="submit" value="Save">
				
			</form>
		</div>
	</div>
</body>
</html>