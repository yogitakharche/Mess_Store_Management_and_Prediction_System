<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>order-list</title>
<link href="<c:url value='/resources/CSS/OrderList.css'/>" rel="stylesheet">
<link rel="stylesheet" type="text/css"
      href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
</head>
<body>
    <div class="wrapper-frm-container">
        <h3 class="h3-text">Purchase Section</h3>
        <div class="form-container">
            <h1>Create Order List</h1>
            <form name="frm" id="orderfrom" action="" method="POST">
                <div class="form-group">
                    <label for="productListId">Product List</label>
                    <select id="productListId" name="productListId">
                        <option value="#">Select Product List</option>
                        <c:forEach var="ollist" items="${plList}">
                            <option value="${ollist.getProductListId()}">${ollist.getProductListName()}</option>
                        </c:forEach>
                    </select>
                </div>

                <!-- Products Table -->
                <label>Products</label>
                <table id="orderlisttable" class="product-table">
                    <thead>
                        <tr>
                            <th><input type="checkbox" id="selectAll"> Select All</th>
                            <th>Sr.No</th>
                            <th>Product Name</th>
                            <th>Product Quantity</th>
                            <th>Product Unit</th>
                           <!--  <th>Product Price</th> -->
                        </tr>
                    </thead>
                    <tbody id="orderlistbodytable">
                    <% int count=0; %>
                        <c:forEach var="product" items="${prodList}">
                            <tr>
                                <td><input class="inputcheck" type="checkbox" name="select1"></td>
                                <td id="${product.getProdId()}"><%= ++count %></td>
                                <td>${product.getProdName()}</td>
                                <td><input type="text" placeholder="Enter Quantity"></td>
                                <td>
                                    <select id="unit" name="unitId">
                                        <option value="">Unit</option>
                                        <c:forEach var="stk" items="${stkList}">
                                            <option value="${stk.getUnitId()}">${stk.getUnitName()}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                                <!-- <td><input type="text" placeholder="Enter Price"></td> -->
                            </tr>
                        </c:forEach>
                        <% count=0; %>
                    </tbody>
                </table>

               <div class="sub-btn">
                   <input type="submit" id="submit" value="Submit" class="submit-button">
               </div>
                <p>${odrLstOk}</p>
            </form>
        </div>
    </div>

    <!-- Your JS for handling form submission -->
    <script src="<c:url value='/resources/JS/orderList.js'/>"></script>
</body>
</html>
