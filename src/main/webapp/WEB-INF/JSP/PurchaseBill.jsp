<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Purchase-bill</title>
<link href="<c:url value='/resources/CSS/PurchaseBill.css'/>" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
	src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
</head>
<body>	
	<div class="add-invoice">
    <h1>Add Invoice </h1>
    <form id="invoiceForm" name="frm" action="" method="POST">
        <div class="form-row">
            
            <div class="select-class">
                <label for="productListId">Product List</label> 
                <select id="productListId" name="productListId" onchange="getProductListId(this.value)">
                    <option value="">Select Product List</option>
                    <c:forEach var="prdordlst" items="${plList}">
                        <option value="${prdordlst.productListId}" >${prdordlst.productListName}</option>
                    </c:forEach>
                </select>
                
                <label>Vendor Name:</label>
                <input type="hidden" id="vendorId"  name="invVendorId">
                <input type="text" id="vendorname" placeholder="Vendor Name" name="invVendorName" required>
            </div>
            
        
            <div class="input-class">
                <label>Invoice Date:</label>
                <input type="date" name="invoiceDate" id="invoiceDate" placeholder="Select Date" required>
                
                <label>Invoice No:</label>
                <input type="text" name="invoiceNo" id="invoiceNo" value="INV" placeholder="Enter Invoice No" required>
            </div>
        </div>
        
        <!-- Products Table -->
        <label>Select Products</label>
        <table id="addInvoice">
            <thead>
                <tr>
                    <th><input type="checkbox" id="selectAll" onclick="toggleSelectAll()" required> Select All</th>
                    <th>Sr.No</th>
                    <th>Product Name</th>
                    <th>Product Quantity</th>
                    <th>Product Unit</th>
                    <th>Product Price</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody id="dataRows">
               
           </tbody>
           <tfoot>
              <tr>
                <td colspan="6" style="text-align: right;">Grand Total:</td>
                <td id="grandTotal">0.00</td>
              </tr>
           </tfoot>
       </table>
            
        <!-- Submit Button -->
        <div class="select-class">
            <input type="button" id="submit" value="Submit" class="submit-button">
        </div>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>

<script src="<c:url value='/resources/JS/PurchaseInvoice.js' />"></script>
<script>
        function showAlert() {
            alert("Product is added to order list!");
        }

        document.addEventListener("DOMContentLoaded", function() {
            const submitButton = document.getElementById("submit");
            submitButton.addEventListener("click", showAlert);
        });
    </script>
</body>
</html>