<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Remaining Stock</title>
    <link href="<c:url value='/resources/CSS/ViewRemainingStock.css'/>" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css" />
</head>
<body>
    <div class="container">
        <h1>Remaining Stock</h1>
        <div class="search-container">
            <input type="text" id="searchInput" placeholder="Search by Product Name or Sr.No" />
            <div class="button-container">
                <button id="sortName">Sort by Name</button>
                <button id="sortSrNo">Sort by Sr.No</button>
                <button id="sortQuantity">Sort by Quantity</button>
            </div>
        </div>
        <div id="cardContainer" class="card-container">
            <% int count = 0; %>
            <c:forEach var="remainingstk" items="${remainstock}">
                <div class="card" data-srno="<%= ++count %>" data-name="${remainingstk.getProdName()}" data-quantity="${remainingstk.getCurrentStockQuantity()}">
                    <div class="card-content">
                        <h2>Sr No <%= count %></h2>
                        <p><strong>Product Name:</strong> ${remainingstk.getProdName()}</p>
                        <p><strong>Quantity:</strong> ${remainingstk.getCurrentStockQuantity()} &nbsp; ${remainingstk.getUnitName()}</p>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#searchInput').on('keyup', function() {
                const value = $(this).val().toLowerCase();
                $('#cardContainer .card').filter(function() {
                    const nameMatches = $(this).data('name').toLowerCase().indexOf(value) > -1;
                    const srNoMatches = $(this).data('srno').toString().indexOf(value) > -1;
                    $(this).toggle(nameMatches || srNoMatches);
                });
            });

            $('#sortName').on('click', function() {
                const cards = $('#cardContainer .card').toArray();
                cards.sort((a, b) => {
                    const nameA = $(a).data('name').toLowerCase();
                    const nameB = $(b).data('name').toLowerCase();
                    return nameA < nameB ? -1 : nameA > nameB ? 1 : 0;
                });
                $('#cardContainer').html(cards);
            });

            $('#sortSrNo').on('click', function() {
                const cards = $('#cardContainer .card').toArray();
                cards.sort((a, b) => {
                    const srNoA = parseInt($(a).data('srno'));
                    const srNoB = parseInt($(b).data('srno'));
                    return srNoA - srNoB;
                });
                $('#cardContainer').html(cards);
            });

            $('#sortQuantity').on('click', function() {
                const cards = $('#cardContainer .card').toArray();
                cards.sort((a, b) => {
                    const quantityA = parseInt($(a).data('quantity'));
                    const quantityB = parseInt($(b).data('quantity'));
                    return quantityA - quantityB;
                });
                $('#cardContainer').html(cards);
            });
        });
    </script>
</body>
</html>
