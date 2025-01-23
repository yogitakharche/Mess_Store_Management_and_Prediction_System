<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Month Required Stock</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: 'Poppins', sans-serif;
	background-color: #f0f4f7;
	justify-content: center;
	align-items: center;
	height: 100vh;
	overflow: hidden;
}

.headers {
	background: linear-gradient(to right, #d3d3d3, #f0f4f7);
	padding: 20px;
	text-align: center;
	border-radius: 15px 15px 0 0;
	color: black;
	font-size: 24px;
	font-weight: bold;
}

.container {
	display: flex;
	background-color: #fff;
	border-radius: 15px;
	box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
	width: 99.9%;
	height: 90vh;
}

.left-panel {
	width: 40%;
	padding: 20px;
	border-right: 1px solid #ddd;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
}

h1 {
	font-size: 24px;
	margin-bottom: 10px;
	color: black;
}

.form-group {
	margin-bottom: 15px;
}

label {
	display: block;
	font-weight: bold;
	margin-bottom: 8px;
	color: black;
}

select {
	width: 100%;
	padding: 10px;
	border-radius: 8px;
	border: 1px solid #ccc;
	font-size: 16px;
	transition: border-color 0.3s;
}

select:focus {
	border-color: #28a745;
}

button {
	width: 100%;
	background-color: lightgrey;
	color: black;
	padding: 6px;
	border: none;
	border-radius: 8px;
	cursor: pointer;
	font-size: 18px;
	margin-top: 10px;
	transition: background-color 0.3s ease;
}

button:hover {
	background-color: grey;
}

.result {
	margin-top: 10px;
	flex-grow: 1;
	overflow-y: auto;
	padding-right: 10px;
}

.month-card {
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 10px;
	margin: 8px 0;
	border-radius: 8px;
	background-color: #f7f9fc;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.05);
}

.month {
	font-weight: bold;
	font-size: 16px;
	color: black;
}

.units {
	font-size: 18px;
	color: #28a745;
	font-weight: bold;
}

.right-panel {
	width: 60%;
	padding: 20px;
	display: flex;
	justify-content: center;
	align-items: center;
}

canvas {
	width: 100% !important;
	max-height: 400px;
}

@media ( max-width : 500px) {
	body {
		overflow: hidden;
	}
	.container {
		flex-direction: column;
		height: 100vh;
		margin: 0;
	}
	.left-panel, .right-panel {
		width: 100%;
		border-right: none;
		border-bottom: 1px solid #ddd;
	}
	.right-panel {
		padding-top: 20px;
	}
	h1 {
		font-size: 20px;
	}
	label, .month, .units {
		font-size: 14px;
	}
	button {
		font-size: 16px;
	}
	canvas {
		max-height: 400px;
		width: 100%;
	}
	.result {
		max-height: 200px;
		overflow-y: auto;
	}
}
</style>
</head>
<body>
	<div class="headers">Month Required Product</div>
	<div class="container">
		<div class="left-panel">
			<h1>Product Requirement</h1>
			<div class="form-group">
				<label for="productSelect">Select Product</label> 
				<select name="prod_Id" id="productSelect">
					<option value="">-- Select a product --</option>
					 <c:forEach var="mReqStk" items="${prodList}">
                        <option value="${mReqStk.getProdName()}" >${mReqStk.getProdName()}</option>
                    </c:forEach>
				</select>
			</div>
			<button onclick="showRequirements()">Show Requirements</button>
			<div class="result" id="result"></div>
		</div>
		<div class="right-panel">
			<canvas id="productChart"></canvas>
		</div>
	</div>
	<script src="<c:url value="/resources/JS/MonthRequiredStock.js" />"></script>
</body>
</html>