<%@page import="oo.uu.Springmvc.Model.UserModel"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user profile</title>
<link href="<c:url value='/resources/CSS/UserProfile.css'/>" rel="stylesheet">
</head>
<body>
   <% UserModel uModel=(UserModel)session.getAttribute("User"); %>
   
	<!-- Main container for the profile page -->
	<from name="frm" action="userprofile">
	<div class="profile-container">

		<div class="sidebar">
			<div class="profile-pic-container">
			
			<img class="profile-pic" alt="User Profile Picture" src="<c:url value="/resources/img/usericon.jpg"/>">
			
				
			</div>
			<h2 class="user-name"><%=uModel.getName() %></h2>
			<!-- <p class="user-role">Admin</p> -->
			<button class="edit-profile-btn">Edit Profile</button>
		   </div>

		<!-- Main content area for user details -->
		<div class="profile-details">
			<h2>Profile Information</h2>
			<div class="profile-info-grid">
				<div class="info-item">
					<span class="label">Name:</span> <span class="value"><%=uModel.getName() %></span>
				</div>
				<div class="info-item">
					<span class="label">Email:</span> <span class="value"><%=uModel.getEmail() %></span>
				</div>
				<div class="info-item">
					<span class="label">Contact:</span> <span class="value"><%=uModel.getContact() %></span>
				</div>
				<div class="info-item">
					<span class="label">Username:</span> <span class="value"><%=uModel.getUsername() %></span>
				</div>
				<div class="info-item">
					<span class="label">Password:</span> <span class="value"><%=uModel.getPassword() %></span>
				</div>
			</div>

			<h2>Account Settings</h2>
			<div class="settings">
				<button class="settings-btn">Change Password</button>
				<button class="settings-btn">Privacy Settings</button>
			</div>
		</div>
	</div>
	</from>
</body>
</html>