<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product-list</title>
<link href="<c:url value='/resources/CSS/ProductList.css'/>" rel="stylesheet">
<script src="<c:url value='/resources/JS/ProductList.js'/>" defer></script>
</head>
<body>
   <div class="prodlst-wrapper-container">
        <h3 class="h3-text">Purchase Section</h3>
        <div class="product-list-container">
            <h1>Create Product List</h1>
            <form name="frm" action="productlist" method="post">
                <label for="productListName">Product List</label>
                <input type="text" name="productListName" placeholder="Enter name" required>
                
                <label for="vendor">Vendor Name</label>
                <select name="id" required>
                    <option value="">Select Vendor</option>
                    <c:forEach var="vendor" items="${vlist}">
                        <option value="${vendor.id}">${vendor.name}</option>
                    </c:forEach>
                </select>

                <label for="productListDate">List Date</label>
                <input type="date" name="productListDate" required>

                <input type="submit" value="Submit">
            </form>

            <!-- Popup message for success -->
            <div class="popup" id="successPopup" data-success="${success}">
                <p>List Created successfully!</p>
                <button onclick="hidePopup()">Close</button>
            </div>
        </div>
    </div>
</body>
</html>