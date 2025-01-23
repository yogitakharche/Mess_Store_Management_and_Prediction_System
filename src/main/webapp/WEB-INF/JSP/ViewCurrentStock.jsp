<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Current Stock</title>
<link href="<c:url value='/resources/CSS/ViewCurrentStock.css'/>"
	rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css" />
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- DataTables JS -->
<script
	src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>

</head>
<body>
    <div class="wrapper-table-container">
    <h3 class="h3-text">Stock Section</h3>
	<div class="table-container">
		<h1>Current Stock</h1>
		<table id="CurrentStock" class="current-stock-table">
			<thead>
				<tr>
					<th>Sr.No</th>
					<th>Product Name</th>
					<th>Quantity</th>
					<th>Date</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				int count = 0;
				%>
				<c:forEach var="curstk" items="${curStkList}">
					<tr>
						<td><%=++count%></td>
						<td>${curstk.getProdName()}</td>
						<td>${curstk.getCurrentStockQuantity()}
							${curstk.getUnitName()}</td>
						<td>${curstk.getLastUpdateDate()}</td>
						<td><a href="#">Delete</a></td>
					</tr>
				</c:forEach>
				<%
				count = 0;
				%>
			</tbody>
		</table>
	</div>
	</div>
	<script>
		$(document).ready(function() {
			$('#CurrentStock').DataTable({
				"paging" : true,
				"searching" : true,
				"ordering" : true,
				"info" : true,
				"pageLength" : 7,
				"columnDefs" : [ {
					"orderable" : true,
					"targets" : [ 0, 1 ]
				}, // Enable sorting only on ID (0) and Name (1)
				{
					"orderable" : false,
					"targets" : [ 2 ]
				} // Disable sorting on the Actions column (2)
				],
				"order" : [ [ 0, 'asc' ] ]
			// Default sort by ID column
			});
		});
	</script>
</body>
</html>