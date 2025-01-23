<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Vendor</title>
<link href="<c:url value='/resources/CSS/AddVendor.css'/>"
	rel="stylesheet">

</head>
<body>
	<div class="vendor-container">
		<h3 class="h3-text">Vendor Section</h3>
		
		<div class="add-vendor-form animated">
			<h1>Add Vendor</h1>
			
			<form name="frm" action="addvendor" method="get" id="addVendorForm" onsubmit="return validateForm()">
				<span>Name:</span>
				<input class="ipt" type="text" name="name" required> 
				
				<span>Email:</span>
				<input class="ipt" type="email" name="email" required> 
				
				<span>Contact:</span>
				<input class="ipt" type="text" name="contact" required> 
				
				<span>ShopName:</span>
				<input class="ipt" type="text" name="shopname" required>
				
				<input class="submit-btnn" type="submit" name="submit" value="Save">
			</form>
		</div>
		<div id="popup" class="popup"></div>
	</div>
	<script>
    function validateForm() {
        var name = document.forms["frm"]["name"].value;
        var email = document.forms["frm"]["email"].value;
        var contact = document.forms["frm"]["contact"].value;
        var shopname = document.forms["frm"]["shopname"].value;
        
        var namePattern = /^[A-Za-z ]{2,30}$/;
        var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        var contactPattern = /^[0-9]{10}$/;
        
        if (!namePattern.test(name)) {
            showPopup("Invalid Name");
            return false;
        }
        if (!emailPattern.test(email)) {
            showPopup("Invalid Email");
            return false;
        }
        if (!contactPattern.test(contact)) {
            showPopup("Invalid Contact");
            return false;
        }
        if (shopname.length < 2) {
            showPopup("Shop Name must be at least 2 characters");
            return false;
        }
        return true;
    }

    function showPopup(message) {
        var popup = document.getElementById("popup");
        popup.innerHTML = message;
        popup.classList.add("show");
        setTimeout(function() {
            popup.classList.remove("show");
        }, 3000);
    }

    function showMessage(msg) {
        if (msg !== "") {
            showPopup(msg);
        }
    }
    window.onload = function() {
		showMessage("${msg}");
	}
</script>
</body>
</html>
