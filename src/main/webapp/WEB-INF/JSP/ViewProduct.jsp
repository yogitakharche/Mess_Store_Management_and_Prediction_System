<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Products</title>
<link href="<c:url value='/resources/CSS/ViewProduct.css'/>" rel="stylesheet">
<script src="<c:url value='/resources/JS/ViewProduct.js'/>" defer></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css" />
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- DataTables JS -->
<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

</head>
<body>
<h2>Product Section</h2>
<div class="view-product-table">
    <h1>All Products</h1>
    <table id="ProdTable" class="product-table">
        <thead>
            <tr>
                <th>Sr.No</th>
                <th>Name</th>
                <th>Delete</th>
                <th>Update</th>
            </tr>
        </thead>
        <tbody>
            <% int count = 0; %>
            <c:forEach var="product" items="${prodList}">
                <tr>
                    <td><%= ++count %></td>
                    <td>${product.getProdName()}</td>
                    <td>
                        <a href="deleteproduct?dpid=${product.getProdId()}" class="icon-btn delete-btn" title="Delete">
                            <i class="fas fa-trash-alt"></i>
                        </a>
                    </td>
                    <td>
                        <a href="updateproduct?upid=${product.getProdId()}&prodName=${product.getProdName()}" 
                           class="icon-btn update-btn" title="Update" 
                           data-name="${product.getProdName()}">
                            <i class="fas fa-edit"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<!-- Update Popup -->
<div class="popup-overlay"></div>

<!-- Delete Confirmation Popup -->
<div id="confirmationPopup" class="confirmation-popup">
    <div class="confirmation-content">
        <p>Are you sure you want to delete this product?</p>
        <div class="confirmation-buttons">
            <button id="confirmYes">Yes</button>
            <button id="confirmNo">No</button>
        </div>
    </div>
</div>


</body>
</html>

