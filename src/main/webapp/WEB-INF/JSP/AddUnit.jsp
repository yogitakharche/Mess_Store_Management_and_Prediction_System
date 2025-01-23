<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add unit</title>
    <style>
       
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            color: #333;
         
            justify-content: center;
            align-items: flex-start;
            flex-wrap: wrap;
            height: 100vh;
        
        }

        .container {
            background-color: #dcdcdc;
            padding: 20px;
            border-radius: 8px;
            width: 100%;
            max-width: 400px;
            margin-bottom: 20px;
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        
        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            font-size: 16px;
            color: #666;
            margin-bottom: 5px;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
            color: #333;
            background-color: #f2f2f2;
            transition: all 0.3s ease;
        }

        input[type="text"]:focus {
            outline: none;
            border-color: #aaa;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
        }

        input[type="submit"] {
            background-color: #888;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #555;
        }

      
        .table-container {
            background-color: #dcdcdc;
            padding: 20px;
            border-radius: 8px;
            width: 100%;
            max-width: 600px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            animation: fadeIn 1s ease-out;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ccc;
            transition: background-color 0.3s ease;
        }

        th {
            background-color: #888;
            color: white;
        }

        td:hover {
            background-color: #f1f1f1;
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }

      
        @media screen and (max-width: 768px) {
            .container, .table-container {
                padding: 15px;
            }
            h1 {
                font-size: 24px;
            }
        }

    </style>

    
    
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

</head>
<body>

    <div class="container">
        <h1>Add Product Unit</h1>
        <form name="frm" action="addunits" method="POST">

            <div class="form-group">
                <label for="unitName">Unit</label>
                <input type="text" id="unitName" name="unitName" placeholder="Enter unit name" required>
            </div>
            <div class="form-group">
                <input type="submit" name="s" value="Submit"/>
            </div>
        </form>
    </div>

   
    <div class="table-container">
        <h1>Product Units</h1>
        <table id="myTable">
            <thead>
                <tr>
                    <th>Sr.No</th>
                    <th>Unit Name</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
            <% int count=0; %>
            <c:forEach var="unit" items="${stkList}">
                <tr>
                    <td><%= ++count %></td>
                    <td>${unit.getUnitName()}</td>
                    <td><a href="#" class="icon-btn delete-btn" title="Delete">
                            <i class="fas fa-trash-alt"></i>
                        </a></td>
                </tr>
               </c:forEach>
                <%count=0; %>
            </tbody>
        </table>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
    <script>
        $(document).ready( function () {
            $('#myTable').DataTable({
                "paging": true,
                "searching": true,
                "info": true
            });
        });
    </script>
</body>
</html>
