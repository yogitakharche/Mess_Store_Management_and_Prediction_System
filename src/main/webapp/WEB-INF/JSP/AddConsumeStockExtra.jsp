<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Consume Stock</title>
<link href="<c:url value='/resources/CSS/AddConsumeStock.css'/>" rel="stylesheet"> 
</head>
<body>
<div class="wrapper-containers">
<h3 class="h3-text">Stock Section</h3>
   <div class="container">
	<h1>Consume Stock </h1>
		<%-- <form name="frm" action="addconsumestock" method="post">
			<div class="form-group">
				<label for="firstSelect">Product:</label> 
				<select name="prodId">
					<option>Select Product</option>
					<c:forEach var="ollist" items="${StockList}">
						<option value="${ollist.getProdId()}">${ollist.getProdName()}</option>
					</c:forEach>
				</select>
			</div>

			<div class="side-by-side">
				<div class="form-group">
					<label for="secondInput">Quantity:</label> <input type="text"
						id="secondInput" name="consumeStockQuantity" placeholder="Enter quantity">
				</div>

				<div class="form-group">
					<label for="secondSelect">Unit:</label> 
					<select name="unitId">
						<option>Select Unit</option>
						<c:forEach var="sltunt" items="${stkList}">
							<option value="${sltunt.getUnitId()}">${sltunt.getUnitName()}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<button type="submit" class="submit-button">Submit</button>
		</form> --%>
		
		
	</div>
	</div>
</body>
</html>