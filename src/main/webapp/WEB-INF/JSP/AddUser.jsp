<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
<link href="<c:url value='/resources/CSS/AddUser.css'/>"
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

	<div class="user-wrapper-container">
		<div class="h3-text">
			<h3>Staff Section</h3>
		</div>

		<div class="user-container">
			<div class="add-user-form">
				<h1>Add Staff</h1>
				<form name="frm" action="adduser" method="post">
					<span>Name:</span> <input class="ipt" type="text" name="name">
					<span>Email:</span> <input class="ipt" type="email" name="email">
					<span>Contact:</span> <input class="ipt" type="text" name="contact">
					<span>Username:</span> <input class="ipt" type="text"
						name="username"> <span>Password:</span> <input class="ipt"
						type="password" name="password"> <input
						class="submit-btnn" type="submit" name="submit" value="Save">
					<p class="massage">${msg}</p>
				</form>
			</div>
			<!-- ==========================  view user =========================================== -->
			<div class="view-user-table">
				<h1>All User</h1>
				<form name="frm" action="viewuser" method="GET">
					<table id="MessStoreDataTable">
					<thead>
						<tr>
							<th>Sr.No</th>
							<th>Name</th>
							<th>Email</th>
							<th>Contact</th>
							<th>UserName</th>
							<th>Role</th>
							<th>Password</th>
							<th>Delete</th>
							<th>Update</th>
						</tr>
						</thead>
						<c:set var="count" value="0" />
						<tbody>
						<c:forEach var="user" items="${ulist}" varStatus="status">
							<tr>
								<td>${status.index + 1}</td>
								<td>${user.getName()}</td>
								<td>${user.getEmail()}</td>
								<td>${user.getContact()}</td>
								<td><a href="deleteuser?id=${user.getId()}">Delete</a></td>
								<td><a
									href="updateuser?uid=${user.getId()}&name=${user.getName()}&email=${user.getEmail()}&contact=${user.getContact()}">Update</a></td>
							</tr>
						</c:forEach>
						</tbody>
						<c:set var="count" value="0" />
					</table>
				</form>
			</div>
		</div>

	</div>
	<!-- <script>
		$(document).ready(function() {
			$('#UsrTable').DataTable({
				"paging" : true, "searching" : true,"ordering" : true,"info" : true,
				"pageLength" : 1,"columnDefs" : [ {"orderable" : true,"targets" : [ 0, 1 ]
				}, // Enable sorting only on ID (0) and Name (1)
				{
					"orderable" : false,"targets" : [ 2 ]
				} // Disable sorting on the Actions column (2)
				],
				"order" : [ [ 0, 'asc' ] ]
			// Default sort by ID column
			});
		});
	</script> -->
</body>
</html>
 --%>