function getProductListId(productListId) {
    if (!productListId) return; // Don't make a request if nothing is selected.
    
    $.ajax({
        url: 'purchasebill', // URL that maps to the controller method
        type: 'POST',
        data: { productListId: productListId }, // Send the selected productListId
        dataType: 'json', // Expect a JSON response
        success: function(data) {
            console.log(data);
            let tableBody = $('#dataRows');
            tableBody.empty(); // Clear existing rows

            // Check if data is empty
            if (data.length === 0) {
                tableBody.append('<tr><td colspan="7">No data found</td></tr>');
                $('#grandTotal').text('0.00'); // Update grand total to 0
                return;
            }

            let count = 0;
            
            $.each(data, function(index, invoice) {
                let row = `<tr>
                    <td><input type="checkbox" class="inputcheak"></td>
                    <td>${++count}</td>
                    <td><input id="${invoice.invProductId}" type="text" value="${invoice.invProductName}" readonly></td>
                    <td><input type="text" value="${invoice.invProductQuantity}" class="productQuantity" data-index="${index}"></td>
                    <td><input id="${invoice.invUnitId}" type="text" value="${invoice.invUnitName}" readonly></td>
                    <td><input type="text" placeholder="Enter Price" class="productPrice" data-index="${index}"></td>
                    <td><input type="text" id="productTotal" class="productTotal" readonly></td>
                </tr>`;
                
                $('#vendorname').val(invoice.invVendorName); 
                $('#vendorId').val(invoice.invVendorId);         
                tableBody.append(row);
            });

            // Initialize calculation for all rows
            calculateTotals();
            
            // Add event listeners for input changes
            $('.productPrice, .productQuantity').on('input', function() {
                calculateTotals();
            });
        },
        error: function(xhr, status, error) {
            console.error('Error fetching data:', status, error);
            alert('Failed to fetch purchase bill details.');
        }
    });
	
}

function calculateTotals() {
    let grandTotal = 0;

    $('#dataRows tr').each(function() {
        let quantity = parseFloat($(this).find('.productQuantity').val()) || 0;
        let price = parseFloat($(this).find('.productPrice').val()) || 0;
        let total = quantity * price;
        $(this).find('.productTotal').val(total.toFixed(2));
        grandTotal += total;
    });

    $('#grandTotal').text(grandTotal.toFixed(2));
}

function toggleSelectAll() {
    let selectAllCheckbox = document.getElementById('selectAll');
    document.querySelectorAll('#dataRows input[type="checkbox"]').forEach(function(checkbox) {
        checkbox.checked = selectAllCheckbox.checked;
    });
}

document.getElementById('submit').addEventListener('click', function(event) {
    event.preventDefault();

    let invoicelist = {};
    const plist = [];
    
    // Fetch values from form
    let invProductListId = document.getElementById("productListId").value;
    let invVendorId = document.getElementById("vendorId").value;
    let invDate = document.getElementById("invoiceDate").value;
    let invoiceNo = document.getElementById("invoiceNo").value;
    let invGrandTotal = document.getElementById("grandTotal").innerText;
    
    // Basic validation
    if (!invProductListId || !invVendorId || !invDate || !invoiceNo) {
        alert("Please fill all the required fields.");
        return;
    }
    
    // Populate invoice data
    invoicelist.invProductListId = invProductListId;
    invoicelist.invVendorId = invVendorId;
    invoicelist.invDate = invDate;
    invoicelist.invoiceNo = invoiceNo;
    invoicelist.invGrandTotal = invGrandTotal;
    
    // Loop through each row
    document.querySelectorAll('#dataRows tr').forEach(function(row) {
        const checkbox = row.querySelector('.inputcheak');

        // Check if the checkbox is selected
        if (checkbox.checked) {
            const rowData = {};
            
            // Fetch data from the row columns
            rowData.invProductId = row.cells[2].children[0].id;
            rowData.invProductQuantity = row.cells[3].children[0].value;
            rowData.invUnitId = row.cells[4].children[0].id;
            rowData.invProductPrice = row.cells[5].children[0].value;
            rowData.total = row.cells[6].children[0].value;
            
            plist.push(rowData); // Add to plist
        }
    });
    
    invoicelist.plist = plist;
    
    // Convert to JSON
    const jsonData = JSON.stringify(invoicelist);
    console.log("JSON Data:", jsonData);

    // Send JSON data to the server
    fetch('purchasebills', {
        method: "POST",
        headers: { 'Content-Type': 'application/json' },
        body: jsonData
    })
    .then(response => response.text())
    .then(data => {
        console.log("Response:", data);
        // Handle success scenario (e.g., redirect, notification)
    })
    .catch(error => console.error("Error:", error));
});



