<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Consume Stock</title>
    
    <!-- CSS -->
    <link href="<c:url value='/resources/CSS/AddProdInConsumeList.css'/>" rel="stylesheet">
    <link rel="stylesheet" type="text/css"
        href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css" />
    
    <!-- jQuery and DataTables JS -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
</head>
<body>
    <div class="wrapper-frm-container">
        <h3 class="h3-text">Stock Section</h3>
        <div class="form-container">
            <h1>Add Consume Product</h1>
            
            <form id="productForm" name="frm" action="" method="POST">
                <!-- Products Table -->
                <label>Products</label>
                <table id="addprodconsumelist" class="product-table">
                    <thead>
                        <tr>
                            <th><input type="checkbox" id="selectAll"> Select All</th>
                            <th>Sr.No</th>
                            <th>Product Name</th>
                            <th>Product Quantity</th>
                            <th>Product Unit</th>
                            <th>Consume Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            int count = 0;
                        %>
                        <c:forEach var="product" items="${prodwisestock}">
                            <tr>
                                <td><input class="inputcheak" type="checkbox" name="select1"></td>
                                <td id="${product.prodId}"><%=++count%></td>
                                <td>${product.prodName}</td>
                                <td><input type="text" placeholder="Enter Quantity" name="consumeStockQuantity"></td>
                                <td>
                                    <select class="unit-select" name="unitId">
                                        <option value="">Select Unit</option>
                                        <c:forEach var="stk" items="${stkList}">
                                            <option value="${stk.unitId}">${stk.unitName}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                                <td><input type="date" name="consumeStockDate"></td>
                            </tr>
                        </c:forEach>
                        <%
                            count = 0;
                        %>
                    </tbody>
                </table>
                <div class="form-group">
                    <input type="button" id="submit" value="Submit" class="submit-button">
                </div>
            </form>
        </div>
    </div>

    <!-- JavaScript -->
    <script src="<c:url value='/resources/JS/AddProdInConsumeList.js'/>"></script>
</body>
</html>
