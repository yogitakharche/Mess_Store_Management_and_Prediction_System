<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Date Wise Consume Stock</title>
<link href="<c:url value='/resources/CSS/DateWiseConsumeList.css'/>" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.datatables.net/1.13.5/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/buttons/2.3.5/css/buttons.dataTables.min.css">

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.5/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/2.3.5/js/dataTables.buttons.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
    <script src="https://cdn.datatables.net/buttons/2.3.5/js/buttons.html5.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/2.3.5/js/buttons.print.min.js"></script>
</head>
<body>

    <div class="container">
        <h1>Date Wise Consume Stock</h1>
        <div class="search-bar">
            <form id="searchForm" action="datewiseconsumedata" method="POST">
                <label for="date">Search by Date:</label>
                <input type="date" id="searchDate" name="date" onchange="filterByDate()">
            </form>
        </div>

        <table class="consume-stock-table" id="consumeTable">
            <thead>
                <tr>
                    <th>Sr.No</th>
                    <th>Product ID</th>
                    <th>Consumed Quantity</th>
                    <th>Date</th>
                </tr>
            </thead>
            <tbody>
                <%
                int count = 0;
                %>
                <c:forEach var="item" items="${dateConsumeList}">
                    <tr data-date="${item.getConsumeProductDate()}">
                        <td><%=++count%></td>
                        <td>${item.getProdModel().getProdName()}</td>
                        <td>${item.getConsumeProductQty()} &nbsp; ${item.getStkModel().getUnitName()}</td>
                        <td>${item.getConsumeProductDate()}</td>
                    </tr>
                </c:forEach>
                <%
                count = 0;
                %>
            </tbody>
        </table>
    </div>

    <div id="noDataModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeModal()">&times;</span>
            <p>No consume stock present on this date.</p>
        </div>
    </div>

    <script>
        $(document).ready(function() {
            $('#consumeTable').DataTable({
                dom: 'Bfrtip',buttons: ['copy','csv','excel','pdf','print'],
                responsive: true,paging: true,searching: true,ordering: true,
                order: [[ 0, "asc" ]],lengthMenu: [10, 25, 50, 100],pageLength: 10
            });
            $('.dt-button').css({
                'height': '25px', 
                'padding': '3px 30px', 
                'font-size': '10px' 
            });
        });

        function filterByDate() {
            var searchDate = document.getElementById("searchDate").value;
            var table = $('#consumeTable').DataTable();
            var rows = table.rows().nodes();
            var found = false;
            rows.each(function(row) {
                var rowDate = $(row).data("date");
                if (rowDate === searchDate || searchDate === "") {
                    $(row).show();
                    found = true;
                } else {
                    $(row).hide();
                }
            });
            if (!found && searchDate) {
                openModal(searchDate);
            } else {
                closeModal();
            }
        }

        function openModal(searchDate) {
            var modal = document.getElementById("noDataModal");
            var message = "No consume stock present on " + searchDate + ".";
            modal.querySelector("p").textContent = message;
            modal.style.display = "block";
        }

        function closeModal() {
            var modal = document.getElementById("noDataModal");
            modal.style.display = "none";
            document.getElementById("searchDate").value = "";
            $('#consumeTable').DataTable().search('').draw();
            $('#consumeTable tbody tr').show();
        }

        window.onclick = function(event) {
            var modal = document.getElementById("noDataModal");
            if (event.target === modal) {
                closeModal();
            }
        }
    </script>
</body>
</html>
