<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Consume List</title>
<link href="<c:url value='/resources/CSS/CreateConsumeList.css'/>" rel="stylesheet"> 
</head>
<body>
  <div class="wrapper-frm-container">
    <h3 class="h3-text">Historical Data</h3>
	<div class="form-container">
	   <h1>Create Consume List </h1>
		<form name="frm" action="createconsumelist" method="POST">
			<div class="frm-contain">
			<label for="textInput">Enter List Name:</label> 
			<input type="text" id="textInput" name="consumeListName" required>
			</div>
			
			<div class="frm-contain">
			<label for="dateInput">Select Date:</label> 
			<input type="date" id="dateInput" name="consumeListDate" required>
			</div>
			
			<div class="frm-contain">
			<button type="submit">Submit</button>
			</div>
		</form>
	</div>
	</div>
</body>
</html>