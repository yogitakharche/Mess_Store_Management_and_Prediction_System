<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Invoice</title>
<link href="<c:url value='/resources/CSS/ViewPurchaseBill.css'/>"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css" />
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- DataTables JS -->
<script
	src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
<script src="<c:url value='/resources/JS/pagination.js' />"></script>
<!-- Adjust if needed -->
</head>
<body>
	<div class="wrap-invoice-container">
		<form name="frm" action="viewinvoice">
			<c:forEach var="entry" items="${orderListMap}">
				<div class="invoice-container">

					<div class="invoice-header">
						<h1>INVOICE</h1>
					</div>

					<!-- Invoice Details -->
					<div class="invoice-details">
						<div>
							<strong>List Name:</strong> <span>Richard Sanchez</span></br> 
							<strong>Vendor Name:</strong> <span>abc</span>
						</div>
						<div class="invoice-details-right">
							<span><strong>Invoice No:</strong> 01234</span></br> 
							<span><strong>Date:</strong>11.02.2030</span>
						</div>
					</div>

					<!-- Invoice Table -->
					<table>
						<thead>
							<tr>
								<th>Sr.No</th>
								<th>Product</th>
								<th>Qty</th>
								<th>Total</th>
							</tr>
						</thead>
						<tbody>
							<%
							int count = 0;
							%>
							<c:forEach var="remainingstk" items="${remainstock}">
								<tr>
									<td><%=++count%></td>
									<td>potato</td>
									<td>2 kg</td>
									<td>$200</td>
								</tr>
							</c:forEach>
							<%
							count = 0;
							%>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="3" style="text-align: right;"><strong>Grand
										Total:</strong></td>
								<td><strong>$300</strong></td>
							</tr>
						</tfoot>
					</table>

					<a href="#" class="print-button" onclick="window.print()">Print Invoice</a>

				</div>
			</c:forEach>
		</form>

	</div>
	<script src="<c:url value='/resources/JS/ViewPurchaseBill.js' />"></script>

</body>
</html>
