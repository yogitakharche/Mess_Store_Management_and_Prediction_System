<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DashboardPredChart.jsp</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            width: 80%;
            margin: auto;
            padding: 20px;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        canvas {
            margin-bottom: 50px;
        }
    </style>
</head>
<body>
<from name="frm" action="charting">
<div class="container">
    <h2>Mess Store Material Prediction Charts</h2>
    
    <!-- Consumption Prediction Chart -->
    <canvas id="consumptionChart"></canvas>
    
    <!-- Stock Prediction Chart -->
    <canvas id="stockPredictionChart"></canvas>
</div>
</from>
<script>
    // Consumption Prediction Data (Example)
    const consumptionData = {
        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
        datasets: [{
            label: 'Tur Dal Consumption (kg)',
            data: [50, 45, 60, 55, 70, 65, 75, 80, 85, 90, 95, 100],
            borderColor: 'rgba(75, 192, 192, 1)',
            backgroundColor: 'rgba(75, 192, 192, 0.2)',
            fill: true,
            tension: 0.1
        },
        {
            label: 'Wheat Consumption (kg)',
            data: [80, 85, 90, 95, 100, 110, 120, 130, 135, 140, 145, 150],
            borderColor: 'rgba(255, 99, 132, 1)',
            backgroundColor: 'rgba(255, 99, 132, 0.2)',
            fill: true,
            tension: 0.1
        }]
    };

    // Stock Prediction Data (Example)
    const stockPredictionData = {
        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
        datasets: [{
            label: 'Tur Dal Stock (kg)',
            data: [100, 95, 90, 85, 80, 75, 70, 65, 60, 55, 50, 45],
            borderColor: 'rgba(54, 162, 235, 1)',
            backgroundColor: 'rgba(54, 162, 235, 0.2)',
            fill: true,
            tension: 0.1
        },
        {
            label: 'Wheat Stock (kg)',
            data: [150, 145, 140, 135, 130, 125, 120, 115, 110, 105, 100, 95],
            borderColor: 'rgba(255, 206, 86, 1)',
            backgroundColor: 'rgba(255, 206, 86, 0.2)',
            fill: true,
            tension: 0.1
        }]
    };

    // Configuration for Consumption Chart
    const consumptionConfig = {
        type: 'line',
        data: consumptionData,
        options: {
            responsive: true,
            plugins: {
                legend: {
                    position: 'top',
                },
                tooltip: {
                    enabled: true,
                },
            },
            scales: {
                x: {
                    title: {
                        display: true,
                        text: 'Months'
                    }
                },
                y: {
                    title: {
                        display: true,
                        text: 'Quantity (kg)'
                    }
                }
            }
        }
    };

    // Configuration for Stock Prediction Chart
    const stockPredictionConfig = {
        type: 'line',
        data: stockPredictionData,
        options: {
            responsive: true,
            plugins: {
                legend: {
                    position: 'top',
                },
                tooltip: {
                    enabled: true,
                },
            },
            scales: {
                x: {
                    title: {
                        display: true,
                        text: 'Months'
                    }
                },
                y: {
                    title: {
                        display: true,
                        text: 'Stock Level (kg)'
                    }
                }
            }
        }
    };

    // Rendering the Charts
    const consumptionChart = new Chart(
        document.getElementById('consumptionChart'),
        consumptionConfig
    );

    const stockPredictionChart = new Chart(
        document.getElementById('stockPredictionChart'),
        stockPredictionConfig
    );
</script>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

</body>
</html>