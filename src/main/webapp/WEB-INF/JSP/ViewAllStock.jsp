<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Stock</title>
<link href="<c:url value='/resources/CSS/ViewAllStock.css'/>" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script>$(document).ready(function() {$('table').DataTable({paging : true,searching : true,ordering : true});});</script>
</head>
<body>

	<div class="page-heading">Stock Section</div>

	<div class="table-container">
		<div class="table-heading">All Stock</div>

		<table id="ProdListLst">
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
			<% int count=0; %>
				<c:forEach var="stock" items="${StockList}">
					<tr>
					    <td><%= ++count %></td>
						<td>${stock.getProdName()}</td>
						<td>${stock.getConsumeStockQuantity()} &nbsp; ${stock.getUnitName()}</td>
						<td>${stock.getLastUpdateDate()}</td>
						<td><a href="#deletestockproduct"><i class="fas fa-trash-alt"></i></a></td>
					</tr>
				</c:forEach>
				 <% count=0; %>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5">Footer Information</td>
				</tr>
			</tfoot>
		</table>
	</div>

</body>
</html>
