<%@page import="oo.uu.Springmvc.Model.UserModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>User Dashboard</title>
<link href="<c:url value="/resources/CSS/UserDashboard.css"/>" rel="stylesheet">

</head>
<body>
<% UserModel uModel=(UserModel)session.getAttribute("User"); %>
 <div class="wrapper-container">
        <div class="header">
            <div class="logo1">
               
            </div>
<!-- -------------------------------------------------------------------------------------------- -->
     <div class="hero">
       <nav>
       <%-- <img class="logo" alt="images" src="<c:url value="/resources/img/mlogo.png"/>"> --%>
     <button class="btn hamburger" id="toggleButton">&#9776;</button>
       <div class="heading">
		<p>User Dashboard</p>
		</div>
<div class="search-container">
    <input type="search" placeholder="Search" class="header-search-bar">
    <img src="<c:url value='/resources/img/search.png'/>" alt="search icon" class="search-icon">
</div>
                 
         <ul class="menu-text">
           <!--  <li><a href="#home">Home</a></li> -->
           <!--  <li><a href="#help">Help</a></li> -->
         </ul>
        
        <img class="noti-icon" alt="images" src="<c:url value="/resources/img/Notification.png.png"/>"onclick="Notifications()">
        <div class="noti-sub-menu-wrap" id="notiSubMenu">
            <div class="noti-sub-menu">
                <h1>Notifications</h1>
                <div class="noti-info">
                 <input type="text">
                 <input type="text">
                 <input type="text">
                 <input type="text">
                 <input type="text">
                </div>
            </div>
            
        </div>
<!-- ---------------------USER-PROFILE------------------------ -->
       
        <img class="user-pic" alt="images" src="<c:url value="/resources/img/usericon.jpg"/>" onclick="profileMenu()">
       
        
        
        <div class="sub-menu-wrap" id="subMenu">
            <div class="sub-menu">
                <div class="user-info">
                
                <img alt="images" src="<c:url value="/resources/img/usericon.jpg"/>">
                   <h3>Hey! <%=uModel.getName() %></h3>
                  <!--  <h3>vaibhavkinge287@gmail.com</h3> -->
           
                </div>
                <hr>
                <a href="userprofile" class="sub-menu-link">
                <img alt="images" src="<c:url value="/resources/img/user.png"/>">
                   <p>Personal info</p>
                   <span>></span>
                </a>
                <a href="sendemail" class="sub-menu-link">
                 <img alt="images" src="<c:url value="/resources/img/mail.png"/>">
                     <p>Send Email</p>
                     <span>></span>
                  </a>
                  <a href="#" class="sub-menu-link">
                  <img alt="images" src="<c:url value="/resources/img/help.png"/>">
                     <p>Help & Support</p>
                     <span>></span>
                  </a>
                  <a href="logout" class="sub-menu-link">
                  <img alt="images" src="<c:url value="/resources/img/logout.png"/>">
                     <p>Logout</p>
                     <span>></span>
                  </a>
            </div>
        </div>
       </nav>      
     </div>
<!-- -------------------------------------------------------------------------------------------- -->
        </div>
        <div class="containt-container">
          <div class="side-bar" id="sidebar">
          
            <div class="buttons">
                <ul>
                    <%--  <li class="dropdown"><a href="#"><img class="admin-png" alt="images" src="<c:url value="/resources/img/subadmin.webp"/>">Sub Admin Section</a> 
                        
                        <ul class="dropdown-content">
                        
                            <li><a href="${pageContext.request.contextPath}/viewuser">Add Sub Admin</a></li>
                        </ul>
                    </li> --%>

                    <li class="dropdown"><a href="#"><img class="admin-png" alt="images" src="<c:url value="/resources/img/vendor.png"/>">Vendor Section</a>
                        <ul class="dropdown-content">
                            <li><a href="${pageContext.request.contextPath}/addvendor">Add Vendor</a></li>
                            <li><a href="${pageContext.request.contextPath}/viewvendor">View Vendor</a></li>
                            <li><a href="${pageContext.request.contextPath}/viewvendor">Action On Vendor</a></li>
                        </ul>
                    </li>

                    <li class="dropdown"><a href="#"><img class="admin-png" alt="images" src="<c:url value="/resources/img/product.png"/>">Product Section</a>
                        <ul class="dropdown-content">
                            <li><a href="${pageContext.request.contextPath}/product">Add Product</a></li>
                            <li><a href="${pageContext.request.contextPath}/viewproduct">View Product</a></li>
                            <li><a href="${pageContext.request.contextPath}/viewproduct">Action On Product</a></li>
                            <li><a href="${pageContext.request.contextPath}/addunit">Product Unit</a></li>
                            
                        </ul>
                    </li>

                    <li class="dropdown"><a href="#"><img class="admin-png" alt="images" src="<c:url value="/resources/img/purchase.png"/>">Purchase Section</a>
                        <ul class="dropdown-content">
                            <li><a href="${pageContext.request.contextPath}/productlist">Create Product List</a></li>
                            <li><a href="${pageContext.request.contextPath}/orderlist">Create Order List</a></li>
                            <li><a href="${pageContext.request.contextPath}/purchasebill">Add Purchase Invoice</a></li>
                            <li><a href="${pageContext.request.contextPath}/viewprodlist">View Product List</a></li>
                            <li><a href="${pageContext.request.contextPath}/orderListMap">View Order List</a></li>
                            <li><a href="${pageContext.request.contextPath}/viewinvoice">View Purchase Invoice</a></li>
                        </ul>
                    </li>

                    <li class="dropdown"><a href="#"><img class="admin-png" alt="images" src="<c:url value="/resources/img/stock.webp"/>">Stock Section</a>
                        <ul class="dropdown-content">
                            <li><a href="${pageContext.request.contextPath}/allstock">View All Stock</a></li>
                            <li><a href="${pageContext.request.contextPath}/viewproductwisestock">Product Wise Stock</a></li>
                            <li><a href="${pageContext.request.contextPath}/addconsumestocks">Add Consume Stock</a></li>
                            <li><a href="${pageContext.request.contextPath}/viewconsumestock">View Consume Stock</a></li>
                            <li><a href="${pageContext.request.contextPath}/viewremainingstock">View Remaining Stock</a></li>
                            
                            
                            
                            <%-- <li><a href="${pageContext.request.contextPath}/createconsumelists">Create Consume List</a></li> --%>
                            <%-- <li><a href="${pageContext.request.contextPath}/addProdinconsumelsts">Add Product Consume List</a></li> --%>
                            <%-- <li><a href="${pageContext.request.contextPath}/viewcurrentstock">View Stock</a></li> --%>
                            
                        </ul>
                    </li>
                    
                    <li class="dropdown"><a href="#"><img class="admin-png" alt="images" src="<c:url value="/resources/img/historical.png"/>">Historical Data</a>
                        <ul class="dropdown-content">
                            <li><a href="${pageContext.request.contextPath}/datewiseconsumedata">Day Consume Stock</a></li>
                            <li><a href="${pageContext.request.contextPath}/monthwiseconsumedata">Month Consume Stock</a></li>
                            <li><a href="${pageContext.request.contextPath}/yearwiseconsumedata">Year Consume Stock</a></li>
                        </ul>
                    </li>

                    <li class="dropdown"><a href="#"><img class="admin-png" alt="images" src="<c:url value="/resources/img/predict.png"/>">Material Predict</a>
                        <ul class="dropdown-content">
                            <li><a href="#">Day Required Stock</a></li>
                            <li><a href="${pageContext.request.contextPath}/monthrequired">Month Required Stock</a></li>
                            <li><a href="${pageContext.request.contextPath}/yearrequired">Year Required Stock</a></li>
                        </ul>
                    </li>
                    
                    <%-- <li class="dropdown"><a href="#"><img class="admin-png" alt="images" src="<c:url value="/resources/img/Cost.png"/>">Cost Predict</a>
                        <ul class="dropdown-content">
                            <li><a href="#">Day Required Cost</a></li>
                            <li><a href="#">Month Required Cost</a></li>
                            <li><a href="#">Year Required Cost</a></li>
                        </ul>
                    </li> --%>

                    <li class="dropdown"><a href="#"><img class="admin-png" alt="images" src="<c:url value="/resources/img/usermanual.webp"/>">User Guide</a>
                        <ul class="dropdown-content">
                            <li><a href="${pageContext.request.contextPath}/userguide">User Guide</a></li>
                        </ul>
                    </li>
                </ul>
            </div>      
<!-- --------------------------------------------------------------- -->
          </div>
          
          <div class="containt-bar">
               <jsp:include page="${page}"/>
               <jsp:include page="${UpdatePage}"/>
               <jsp:include page="${VendUPdatePage}"/>
               <jsp:include page="${UpdateProdPage}"/>
               <jsp:include page="${purch}"/>
               <jsp:include page="${Stock}"/>
               <jsp:include page="${historicalPage}"/>
               <jsp:include page="${vworderPage}"/>
               <jsp:include page="${EmailPage}"/>
               <jsp:include page="${UserPage}"/>
               <jsp:include page="${Chart}"/>
               <jsp:include page="${pwstock}"/>
               <jsp:include page="${remstock}"/>
          </div>    
      </div>  
    </div>
   <script src="<c:url value="/resources/JS/AdminDashboard.js" />"></script>
</body>
</html>