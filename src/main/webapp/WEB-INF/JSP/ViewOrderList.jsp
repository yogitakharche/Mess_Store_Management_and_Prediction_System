<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Order List</title>
<link href="<c:url value='/resources/CSS/ViewOrderList.css'/>" rel="stylesheet">
<link rel="stylesheet" type="text/css"
    href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.4.0/jspdf.umd.min.js"></script>

</head>
<body>

<h1>Order List</h1>
<div class="wrapper-orderlist-table">
    <c:forEach var="entry" items="${orderListMap}">
        <div class="order-card">
            <div class="order-header">
                <span>${entry.key}</span>
                <a href="#" class="delete-btn"><i class="fas fa-trash-alt"></i></a>
                <button onclick="printOrderList(this)" class="print-btn">Print</button>
            </div>
            <table class="nested-table">
                <thead>
                    <tr>
                        <th>Products</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="product" items="${entry.value}" varStatus="status">
                        <tr>
                            <td>${status.count} &nbsp; &nbsp; &nbsp; ${product.pm.prodName} &nbsp; &nbsp; &nbsp; ${product.productQuantity} ${product.sm.unitName} &nbsp; &nbsp; &nbsp; <a href="#" class="delete-btn"><i class="fas fa-trash-alt"></i></a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </c:forEach>
</div>

<script>
$(document).ready(function() {
    $('.nested-table').DataTable({
        "paging": true,
        "searching": true,
        "ordering": true,
        "info": false,
        "pageLength": 2,
        "order": [[0, 'asc']]
    });
});

function printOrderList(button) {
    var card = button.closest('.order-card');
    var orderHeader = card.querySelector('.order-header').innerHTML;
    var nestedTable = card.querySelector('.nested-table');

    var printWindow = window.open('', '_blank', 'width=600,height=400');
    printWindow.document.write('<html><head><title>Print Order List</title><style>');
    printWindow.document.write('body { font-family: Arial, sans-serif; }');
    printWindow.document.write('.nested-table { width: 100%; border-collapse: collapse; }');
    printWindow.document.write('.nested-table th, .nested-table td { border: 1px solid black; padding: 8px; }');
    printWindow.document.write('</style></head><body>');
    printWindow.document.write('<div class="print-header"><h2>Order List: ' + orderHeader + '</h2></div>');
    printWindow.document.write(nestedTable.outerHTML);
    printWindow.document.write('</body></html>');
    printWindow.document.close();
    printWindow.print();
}
</script>
</body>
</html>
