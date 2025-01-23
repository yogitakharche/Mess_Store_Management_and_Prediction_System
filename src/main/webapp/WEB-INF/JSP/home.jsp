<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="A prediction system for stock management and message accommodation.">
<meta name="keywords"
	content="store prediction, store predict, mess store prediction, mess store inventory prediction, hotel kitchen stock management, stock prediction system, linear regression prediction, purchase order prediction, grocery stock forecasting, food inventory prediction,coolsun, predictive analytics, AI stock prediction, business inventory prediction system, machine learning for stock prediction, predictive modeling, time-series forecasting for inventory, data-driven inventory management, real-time inventory prediction, supply chain optimization, message accommodation prediction, AI for communication systems, intelligent message sorting, message management AI">
<meta name="author" content="Yogita Kharche">
<title>Store Predictions</title>
<link href="<c:url value="/resources/CSS/style.css"/>" rel="stylesheet">


</head>
<body>
	<div class="wrapper-container">
		<!-- Header Section -->
		<header> <img class="logo" alt="Logo"
			src="<c:url value="/resources/img/mlogo.png"/>">
		<div class="container">
			<h1>Store Predict</h1>
			<nav>
			<ul>
				<li><a href="#home">Home</a></li>
				<li><a href="#features">Features</a></li>
				<li><a href="#about">About</a></li>
				<!-- <li><a href="validateuser">Sign In</a></li>
                        <li><a href="validateuser">Sign Up</a></li> -->
			</ul>
			</nav>
		</div>
		</header>

	
		<section class="hero" id="home">
		<h2>Welcome to Mess Store Prediction System</h2>
		<p>Accurately Predict Your Stock and Manage Inventory with Ease</p>
		<div class="button">
			<a href="validateuser">Get Started</a>
		</div>
		</section>

		
		<section class="key-features" id="features">
		<h2>Key Features</h2>
		<div class="feature-boxes">
			<div class="feature-box">
				<img class="user-pic" alt="images"
					src="<c:url value="/resources/img/inventry.png"/>">
				<h3>Efficient Inventory Tracking</h3>
				<p>Track your inventory seamlessly with our advanced system.</p>
			</div>
			<div class="feature-box">
				<img class="user-pic" alt="images"
					src="<c:url value="/resources/img/venderint.png"/>">
				<h3>Vendor Integration</h3>
				<p>Efficiently manage and communicate with your vendors.</p>
			</div>
			<div class="feature-box">
				<img class="user-pic" alt="images"
					src="<c:url value="/resources/img/realtim.png"/>">
				<h3>Real-Time Analytics</h3>
				<p>Analyze your stock data and make informed decisions with
					real-time analytics.</p>
			</div>
			<div class="feature-box">
				<img class="user-pic" alt="images"
					src="<c:url value="/resources/img/autorepo.png"/>">
				<h3>Automated Reports</h3>
				<p>Generate automated reports for better insights and
					decision-making.</p>
			</div>
		</div>
		</section>
		<section class="about" id="about">
		<div class="about-container">
			<h2 class="about-title">About Us</h2>
			<p class="about-text">Welcome to the Mess Store Prediction
				System, where we provide advanced tools to help you manage and
				predict your inventory effectively. Our system is designed to assist
				businesses in maintaining optimal stock levels, integrating with
				vendors, and making informed decisions based on real-time data.</p>
			<p class="about-text">Our mission is to streamline inventory
				management, enhance vendor relationships, and offer powerful
				analytics for better decision-making. Discover how our system can
				transform your inventory management process and drive your business
				forward.</p>
		</div>
		</section>
		<!-- Zigzag Section -->
		<section class="zigzag-section" id="about">
		<div class="zigzag-container">
			<div class="zigzag-item">
				<img class="user-pic" alt="images"
					src="<c:url value="/resources/img/inventory1.png"/>">
				<!--   <img src="../resources/img/storage12.jpeg" alt="Image 1"> -->
				<div>
					<h3>Efficient Inventory Tracking</h3>
					<p>Efficiently track and manage your inventory to ensure you
						never run out of stock.</p>
				</div>
			</div>
			<div class="zigzag-item zigzag-item-right">
				<img class="user-pic" alt="images"
					src="<c:url value="/resources/img/vendintegrate2.png"/>">
				<div>
					<h3>Vendor Integration</h3>
					<p>Efficiently manage and communicate with your vendors.</p>
				</div>
			</div>
			<div class="zigzag-item">
				<img class="user-pic" alt="images"
					src="<c:url value="/resources/img/realtime3.png"/>">
				<div>
					<h3>Real-Time Analytics</h3>
					<p>Analyze your stock data and make informed decisions with
						real-time analytics.</p>
				</div>
			</div>
			<div class="zigzag-item zigzag-item-right">
				<img class="user-pic" alt="images"
					src="<c:url value="/resources/img/autoreport4.png"/>">
				<div>
					<h3>Automated Reports</h3>
					<p>Generate automated reports for better insights and
						decision-making.</p>
				</div>
			</div>
		</div>
		</section>

		
		<footer>
		<p>&copy; 2024 Mess Store Prediction System. All Rights Reserved.</p>
		</footer>
	</div>
	<script src="<c:url value="/resources/JS/HomePage.js"/>"></script>
</body>
</html>
