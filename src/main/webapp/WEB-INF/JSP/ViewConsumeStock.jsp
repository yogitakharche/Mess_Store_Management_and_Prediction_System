<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Consume Stock</title>
    <link href="<c:url value='/resources/CSS/ViewConsumeStock.css'/>" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css" />
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- DataTables JS -->
    <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
    <!-- Chart.js -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
    <div class="container">
        <div class="content-container">
            <div class="table-container">
                <h1>Consume Stock</h1>
                <table id="ConsumeStock" class="consume-stock-table">
                    <thead>
                        <tr>
                            <th>Sr.No</th>
                            <th>Product Name</th>
                            <th>Quantity</th>
                            <th>Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                        int count = 0;
                        %>
                        <c:forEach var="constk" items="${consList}">
                            <tr>
                                <td><%= ++count %></td>
                                <td>${constk.getProdName()}</td>
                                <td>${constk.getConsumeStockQuantity()} ${constk.getUnitName()}</td>
                                <td>${constk.getConsumeStockDate()}</td>
                            </tr>
                        </c:forEach>
                        <%
                        count = 0;
                        %>
                    </tbody>
                </table>
            </div>
            <!-- Chart container -->
            <div class="chart-container">
                <canvas id="consumeStockChart"></canvas>
            </div>
        </div>
    </div>

    <script>
        $(document).ready(function() {
            // Initialize DataTable
            $('#ConsumeStock').DataTable({
                "paging": true,
                "searching": true,
                "ordering": true,
                "info": true,
                "pageLength": 10,
                "order": [[0, 'asc']]
            });

            // Dynamic Data for the chart (you'll fetch this from your backend)
            const productNames = [];
            const quantities = [];
            <c:forEach var="constk" items="${consList}">
                productNames.push('${constk.getProdName()}');
                quantities.push(${constk.getConsumeStockQuantity()});
            </c:forEach>

            // Chart.js setup for circular chart (pie chart)
            const ctx = document.getElementById('consumeStockChart').getContext('2d');
            const consumeStockChart = new Chart(ctx, {
                type: 'pie', // You can change this to 'doughnut' for a donut chart
                data: {
                    labels: productNames, // Product names as labels
                    datasets: [{
                        label: 'Consumed Quantity',
                        data: quantities, // Quantity data
                        backgroundColor: [
                            'rgba(255, 99, 132, 0.2)',
                            'rgba(54, 162, 235, 0.2)',
                            'rgba(255, 206, 86, 0.2)',
                            'rgba(75, 192, 192, 0.2)',
                            'rgba(153, 102, 255, 0.2)',
                            'rgba(255, 159, 64, 0.2)'
                        ],
                        borderColor: [
                            'rgba(255, 99, 132, 1)',
                            'rgba(54, 162, 235, 1)',
                            'rgba(255, 206, 86, 1)',
                            'rgba(75, 192, 192, 1)',
                            'rgba(153, 102, 255, 1)',
                            'rgba(255, 159, 64, 1)'
                        ],
                        borderWidth: 1
                    }]
                },
                options: {
                    responsive: true,
                    plugins: {
                        legend: {
                            position: 'right', // Position of the legend
                        }
                    }
                }
            });
        });
    </script>
</body>
</html>
