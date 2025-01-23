<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>View Product List</title>
<link href="<c:url value='/resources/CSS/ViewProductList.css'/>" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- DataTables JS -->
<script
	src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
</head>
<body>
  <div class="wrapper-productlist-table">
    <h3 class="h3-text">Purchase Section</h3>
    <div class="productlist-table">
         <h1>View Product List</h1>
       <table id="ProdListLst" class="ProdListLsts">
       <thead>
         <tr>
           <th>Sr.No</th>
           <th>List Name</th>
           <th>Vendor NameS</th>
           <th>List Date</th>
           <th>Action</th>
         </tr>
         </thead>
         <tbody> <!-- Ensure tbody is outside of c:forEach -->
         <% int count=0; %>
         <c:forEach var="productlst" items="${plList}">
         <tr>
            <td><%= ++count %></td>
            <td>${productlst.getProductListName()}</td>
            <td>${productlst.getName()}</td>
            <td>${productlst.getProductListDate()}</td>
            <td><a href="deleteprodlist?dpid=${productlst.getProductListId()}">Delete</a></td>
         </tr>
         </c:forEach>
         </tbody>
         <% count=0; %>
       </table>
       <div class="back">
       <ul><li><a href="productlist"><i class="fas fa-arrow-left"></i> Back To Add</a></li></ul>
       </div>
   </div> 
   </div>

   
   <script>
       $(document).ready(function() {
           $('#ProdListLst').DataTable({
               "paging": true, 
               "searching": true, 
               "ordering": true, 
               "info": true, 
               "lengthChange": true 
           });
       });
   </script>
   
</body>
</html>
