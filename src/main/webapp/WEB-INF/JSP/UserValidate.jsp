 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>user validate</title>
<link href="<c:url value='/resources/CSS/UserValidate.css'/>"
	rel="stylesheet">
</head>
<body>

	<div class="content-wrapper">

		<header>
			<img class="logo" alt="Logo"
				src="<c:url value="/resources/img/mlogo.png"/>">
			<div class="container">
				<h1>Store Predict</h1>
				<nav>
					<ul>
						<li><a href="indexpage">Home</a></li>
						<li><a href="#" onclick="openLogin()">SignIn</a></li>
						<li><a href="#" onclick="signinPage()">SignUp</a></li>
					</ul>
				</nav>
			</div>
		</header>
		<!-- ========================================  LOGIN FROM   ====================================================== -->
		<div class="main-parent-frm-side">


			<div class="login-form-div" id="openLoginPage">
				<form id="loginForm" class="login-form" action="dashboard"
					method="post" onsubmit="validateForm(event)">
					<p class="heading">Login</p>

					<span class="span-lgn">Username</span> 
					<input id="username" onclick="validateName(inputId, validationMessageId"
						class="lgn-ipt1" type="text" name="username"
						placeholder="Enter Username"  required> <span
						class="span-lgn">Password</span> 
						
						<input id="password"
						class="lgn-ipt2" type="password" name="password"
						placeholder="Enter Password" onclick="validatePassword()" required>

					<div class="forgot-password-container">
						<a class="forgot-password" href="#">Forgot password</a>
					</div>

					<input class="lgn-ipt3" type="submit" value="Sign In">

					<div class="dontacount">
						<span>Don't have an account?</span> <a class="signup" href="#"
							onclick="signinPage()">Sign Up</a>
					</div>

					<p class="message" id="message"></p>
				</form>
			</div>
<!-- ========================================  SIGN IN  ========================================================= -->
			<div class="form-container" id="signinFormDiv">
				<h2>Sign In</h2>
				<form name="frm" id="signinForm" action="signinuser" method="Post" onsubmit="validateForm(event)">
					<div class="form-div">
						<label for="name">Name</label> <input type="text" id="name"
							name="name" placeholder="Enter name" onclick="validateForm()" required>
					</div>
					<div class="form-div">
						<label for="email">Email</label> <input type="email" id="email"
							name="email" placeholder="Enter email" onclick="validateForm()" required>
					</div>
					<div class="form-div">
						<label for="contact">Contact</label> <input type="tel"
							id="contact" name="contact" placeholder="Enter contact" onclick="validateForm()" required>
					</div>
					<div class="form-div">
						<label for="username">Username</label> <input type="text"
							id="username" name="username" placeholder="Enter username" onclick="validateForm()"
							required>
					</div>
					<div class="form-div">
						<label for="password">Password</label> <input type="password"
							id="password" name="password" placeholder="Enter password" onclick="validateForm()"
							required>
					</div>
					<button type="submit" class="submit-btn">SignUp</button>

					<p class="message" id="message"></p>
				</form>
			</div>
		</div>
		<footer>
			<p>&copy; 2024 Mess Store Prediction System. All Rights Reserved.</p>
		</footer>
	</div>
	<script src="<c:url value="/resources/JS/UserValidate.js" />"></script>
</body>
</html>

<%-- 

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Validate Page</title>
<link href="<c:url value='/resources/CSS/UserValidate.css'/>" rel="stylesheet">
</head>
<body>
	<div class="content-wrapper">
		<header>
			<img class="logo" alt="Logo" src="<c:url value='/resources/img/mlogo.png'/>">
			<div class="container">
				<h1>Store Predict</h1>
				<nav>
					<ul>
						<li><a href="indexpage">Home</a></li>
						<li><a href="#" onclick="openLogin()">SignIn</a></li>
						<li><a href="#" onclick="signinPage()">SignUp</a></li>
					</ul>
				</nav>
			</div>
		</header>

		<!-- LOGIN FORM -->
		<div class="main-parent-frm-side">
			<div class="login-form-div" id="openLoginPage">
				<form id="loginForm" class="login-form" action="dashboard" method="POST" >
					<p class="heading">Login</p>
					<span class="span-lgn">Username</span>
					<input id="username" class="lgn-ipt1" type="text" name="username" placeholder="Enter Username"  required>
					<span id="usernameValidation" class="validationMessage"></span>

					<span class="span-lgn">Password</span>
					<input id="password" class="lgn-ipt2" type="password" name="password" placeholder="Enter Password" required>
					<span id="passwordValidation" class="validationMessage"></span>

					<div class="forgot-password-container">
						<a class="forgot-password" href="#">Forgot password</a>
					</div>

					<input class="lgn-ipt3" type="submit" value="Sign In">

					<div class="dontacount">
						<span>Don't have an account?</span> 
						<a class="signup" href="" onclick="signinPage()">Sign Up</a>
					</div>

					<p class="message" id="message"></p>
				</form>
			</div>

			<!-- SIGN UP FORM -->
			<div class="form-container" id="signinFormDiv">
				<h2>Sign In</h2>
				<form id="signinForm" action="signinuser" method="Post" >
					<div class="form-div">
						<label for="name">Name</label> 
						<input type="text" id="firstName" name="name" placeholder="Enter name">
						<span id="firstNameValidation" class="validationMessage"></span>
					</div>

					<div class="form-div">
						<label for="email">Email</label> 
						<input type="email" id="email" name="email" placeholder="Enter email">
						<span id="emailValidation" class="validationMessage"></span>
					</div>

					<div class="form-div">
						<label for="contact">Contact</label> 
						<input type="text" id="contact" name="contact" placeholder="Enter contact">
						<span id="validationMessage" class="validationMessage"></span>
					</div>

					<div class="form-div">
						<label for="username">Username</label> 
						<input type="text" id="firstName" name="username" placeholder="Enter username">
						<span id="usernameValidation" class="validationMessage"></span>
					</div>

					<div class="form-div">
						<label for="password">Password</label> 
						<input style="margin-top=10px" type="password" id="password" name="password" placeholder="Enter password">
					<span id="passwordValidation" class="validationMessage"></span>
					</div>

					<button type="submit" id="submitBtn" class="submit-btn">Sign Up</button>
					<p class="message" id="message"></p>
				</form>
			</div>
		</div>

		<footer>
			<p>&copy; 2024 Mess Store Prediction System. All Rights Reserved.</p>
		</footer>
	</div>
 --%>
	<%-- <script src="<c:url value='/resources/JS/UserValidate.js' />"></script>
	
</body>
</html> --%>
