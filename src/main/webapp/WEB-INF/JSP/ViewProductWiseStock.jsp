<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Product Stock</title>

<!-- Link to custom CSS -->
<link href="<c:url value='/resources/CSS/ViewProductWiseStock.css' />" rel="stylesheet">
<!-- Link to DataTables CSS -->
<link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css">

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- DataTables JS -->
<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>

</head>
<body>
    <div class="wrapper-table-container">
        
        <div class="container">
            <h1 class="heading">Product-Wise Stock</h1>
            <div class="table-wrapper">
                <table id="productStockTable" class="product-stock-table display">
                    <thead>
                        <tr>
                            <th>Sr.No</th>
                            <th>Product Name</th>
                            <th>Stock Quantity</th>
                        </tr>
                    </thead>
                    <tbody>
                    <% int count = 0; %>
                        <c:forEach var="product" items="${prodwisestock}">
                            <tr>
                                <td><%= ++count %></td>
                                <td>${product.getProdName()}</td>
                                <td>${product.getCurrentStockQuantity()} ${product.getUnitName()}</td>
                            </tr>
                        </c:forEach>
                        <% count = 0; %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

   
    <script>
    $(document).ready(function() {
        $('#productStockTable').DataTable({
            "paging": true,
            "searching": true,
            "ordering": true,
            "info": true,
            "pageLength": 10, 
            "order": [[1, 'asc']] 
        });
    });
    </script>
</body>
</html>
