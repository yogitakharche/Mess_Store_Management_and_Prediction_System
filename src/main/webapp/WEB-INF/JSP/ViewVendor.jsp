<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Vendors</title>
<link href="<c:url value='/resources/CSS/ViewVendor.css'/>"
	rel="stylesheet">
<script src="<c:url value='/resources/JS/ViewVendor.js'/>" defer></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css" />
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- DataTables JS -->
<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

</head>
<body>


<div id="confirmationPopup" class="confirmation-popup">
    <div class="popup-content">
        <span class="popup-close">&times;</span>
        <h3>Are you sure you want to delete this vendor?</h3>
        <button id="confirmYes">Yes</button>
        <button class="cancel" id="confirmNo">No</button>
    </div>
</div>

	<div class="vendor-section-view">
	      <h1>Vendor Section</h1>
		<div class="view-vendor-table">
			<h2>All Vendors</h2>
			<table id="vendorTable" class="vendor-table display">
				<thead>
					<tr>
						<th>Sr.No</th>
						<th>Name</th>
						<th>Email</th>
						<th>Contact</th>
						<th>Shop Name</th>
						<th>Action</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<%
					int count = 0;
					%>
					<c:forEach var="vendor" items="${vlist}">
						<tr>
							<td><%=++count%></td>
							<td>${vendor.name}</td>
							<td>${vendor.email}</td>
							<td>${vendor.contact}</td>
							<td>${vendor.shopname}</td>
							<td><a href="deletevendor?vdid=${vendor.id}" class="delete-btn"><i class="fas fa-trash-alt"></i></a></td>
							<td>
							
							<a href="#" class="update-btn" data-name="${vendor.name}" data-email="${vendor.email}" 
                               data-contact="${vendor.contact}" data-shopname="${vendor.shopname}"><i class="fas fa-edit"></i></a></td>

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
		$('#vendorTable').DataTable({
			"paging": true,
			"searching": true,
			"ordering": true,
			"info": true,
			"pageLength": 10,
			"columnDefs": [{
				"orderable": true,
				"targets": [0, 1, 2, 3, 4]
			}, {
				"orderable": false,
				"targets": [5, 6] 
			}],
			"order": [[0, 'asc']] 
		});
	});
	</script>
</body>
</html>