$(document).ready(function() {
    // Initialize DataTable for #addprodconsumelist
    $('#addprodconsumelist').DataTable({
        "paging": true,
        "searching": true,
        "ordering": true,
        "info": true,
        "pageLength": 7,
        "columnDefs": [
            { "orderable": true, "targets": [1, 2] }, // Sr.No and Product Name
            { "orderable": false, "targets": [0, 3, 4, 5] } // Select All, Quantity, Unit, Date
        ],
        "order": [[1, 'asc']] // Order by Sr.No ascending
    });

    document.getElementById('submit').addEventListener('click', function(event) {
        event.preventDefault(); // Prevent form submission
        const selectedData = [];

        // Loop through each row of the table
        document.querySelectorAll('#addprodconsumelist tbody tr').forEach(function(row) {
            const checkbox = row.querySelector('.inputcheak'); 

            // Check if the checkbox is selected
            if (checkbox && checkbox.checked) {
                const rowData = {}; // Create an empty object for each row's data

                // Fetch data from the columns
                rowData.p = {};
                rowData.p.prodId = row.cells[1].id; // Product ID (matches JSP)
                rowData.consumeStockQuantity = row.cells[3].children[0].value; 
                rowData.unitId = row.cells[4].children[0].value; 
                rowData.consumeStockDate = row.cells[5].children[0].value; 
                selectedData.push(rowData);
            }
        });

        // Convert the selected data to JSON
        const jsonData = JSON.stringify(selectedData);
        console.log("JSON Data: ", jsonData);

        // Send the JSON data to the server using Fetch API
        fetch('addconsumestock', {
            method: "POST",
            headers: {
                'Content-Type': 'application/json' // Ensure the server recognizes JSON data
            },
            body: jsonData // Send the JSON data
        })
        .then(response => response.text()) // Parse response
        .then(data => {
            console.log("Response from server: ", data); // Handle the response
        })
        .catch(error => console.error("Error: ", error)); // Handle errors
    });
});
