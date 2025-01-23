<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Guide</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: 'Roboto', sans-serif;
}

.container {
	width: 90%;
	margin: 2rem auto;
}

nav.navbar {
	display: flex;
	justify-content: center;
	position: sticky;
	top: 0;
	padding: 10px;
}

nav.navbar ul {
	list-style: none;
	padding: 0;
	margin: 0;
	display: flex;
}

nav.navbar ul li {
	margin: 0 10px;
}

nav.navbar ul li a {
	color: black;
	text-decoration: none;
	padding: 7px 15px;
	display: block;
	
}

nav.navbar ul li a:hover {
	background-color: lightgrey;
}

.hamburger {
	display: none;
	font-size: 30px;
	cursor: pointer;
	color: black;
	margin-right: auto;
}


@media (max-width: 500px) {
	nav.navbar ul {
		display: none;
		flex-direction: column;
		width: 100%;
		text-align: center;
	}
	nav.navbar ul li {
		margin: 0;
	}
	nav.navbar ul li a {
		padding: 10px;
		border-top: 1px solid #fff;
	}
	nav.navbar ul.show {
		display: flex;
	}
	.hamburger {
		display: block;
	}
}

.section-container {
	background: white;
	margin-bottom: 20px;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

h2.section-title {
	color: grey;
	margin-bottom: 10px;
}

p.section-description {
	line-height: 1.6;
	color: black;
}

ul.section-list {
	margin-left: 20px;
	line-height: 1.6;
	color: black;
}

ul.section-list li.note {
	color: #d9534f;
	font-weight: bold;
}

</style>
</head>
<body>
<header>
    <nav class="navbar">
      <span class="hamburger" onclick="toggleMenu()">&#9776;</span>
      <ul id="nav-menu">
        <li><a href="#vendor-section">Vendor</a></li>
        <li><a href="#product-section">Product</a></li>
        <li><a href="#stock-section">Stock</a></li>
        <li><a href="#historical-data-section">Historical Data</a></li>
        <li><a href="#prediction-section">Prediction</a></li>
        <li><a href="#workflow-section">System Workflow</a></li>
      </ul>
    </nav>
  </header>

  <div class="container">
    <section class="vendor-section section-container" id="vendor-section">
      <h2 class="section-title">1. Vendor Management</h2>
      <p class="section-description"><strong>Purpose:</strong> To manage vendor details such as adding, viewing, updating, and deleting vendors.</p>
      <ul class="section-list">
        <li><strong>Add Vendor:</strong> Navigate to the "Vendor Section" &rarr; Click on <em>Add Vendor</em> &rarr; Fill in vendor details &rarr; Click <em>Save</em>.</li>
        <li><strong>View/Delete/Update/Search Vendor:</strong> Navigate to "Vendor Section" &rarr; Click on <em>View/Delete/Update/Search</em> to manage vendors.</li>
      </ul>
    </section>

    <section class="product-section section-container" id="product-section">
      <h2 class="section-title">2. Product Management</h2>
      <p class="section-description"><strong>Purpose:</strong> To manage the product list for stock management, including adding, viewing, updating, and deleting products.</p>
      <ul class="section-list">
        <li><strong>Add Product:</strong> Navigate to the "Product Section" &rarr; Click on <em>Add Product</em> &rarr; Fill in product details &rarr; Click <em>Save</em>.</li>
        <li><strong>View/Delete/Update/Search Product:</strong> Use <em>View/Delete/Update/Search</em> to manage products.</li>
      </ul>
    </section>

    <section class="stock-section section-container" id="stock-section">
      <h2 class="section-title">3. Stock Management</h2>
      <p class="section-description"><strong>Purpose:</strong> To manage stock by adding invoices, tracking current stock, and managing consumed stock.</p>
      <ul class="section-list">
        <li><strong>Add Invoice Data in Stock:</strong> Navigate to "Stock Section" &rarr; Click on <em>Add Invoice Data in Stock</em> &rarr; Enter invoice details &rarr; Click <em>Add to Stock</em>.</li>
        <li><strong>Current Stock:</strong> View available stock by clicking on <em>Current Stock</em>.</li>
        <li><strong>Consume Stock:</strong> Record consumed stock by selecting a product and quantity used in <em>Consume Stock</em>.</li>
      </ul>
    </section>

    <section class="historical-data-section section-container" id="historical-data-section">
      <h2 class="section-title">4. Historical Data</h2>
      <p class="section-description"><strong>Purpose:</strong> To view and manage stock consumption data sorted by date, month, or year, used for generating predictions.</p>
      <ul class="section-list">
        <li><strong>View Historical Data:</strong> Navigate to "Historical Data" section to view stock consumption sorted by <em>date, month, or year.</em></li>
        <li class="note"><strong>Note:</strong> Manual product list creation can affect prediction accuracy, so it’s recommended to rely on automatic data.</li>
      </ul>
    </section>

    <section class="prediction-section section-container" id="prediction-section">
      <h2 class="section-title">5. Prediction Based on Historical Data</h2>
      <p class="section-description"><strong>Purpose:</strong> To predict future stock requirements based on historical consumption patterns.</p>
      <ul class="section-list">
        <li><strong>Year-Wise Prediction:</strong> View yearly stock predictions in the "Prediction" section.</li>
        <li><strong>Month-Wise Prediction:</strong> Click on <em>Month-Wise</em> to see monthly stock predictions.</li>
        <li><strong>Date-Wise Prediction:</strong> View daily predictions based on past consumption in <em>Date-Wise</em>.</li>
      </ul>
    </section>

    <section class="workflow-section section-container" id="workflow-section">
      <h2 class="section-title">6. General System Workflow Overview</h2>
      <p class="section-description">The system follows these key steps:</p>
      <ul class="section-list">
        <li><strong>Vendor and Product Management:</strong> Add vendors and products to maintain an up-to-date database.</li>
        <li><strong>Stock Management:</strong> Record product invoices and consumption.</li>
        <li><strong>Historical Data & Prediction:</strong> Track consumption and use predictions to plan future orders.</li>
      </ul>
    </section>
  </div>

  <script>
    function toggleMenu() {
      const navMenu = document.getElementById('nav-menu');
      navMenu.classList.toggle('show');
    }
  </script>
</body>
</html>
