
$(document).ready(function() {
	$('#orderlisttable').DataTable({
		"paging": true, "searching": true, "ordering": true, "info": true,
		"pageLength": 7, "columnDefs": [{ "orderable": true, "targets": [0, 1] },
		{ "orderable": false, "targets": [2] }],
		"order": [[0, 'asc']]
	});

/* ====================================================================================== */

	/*document.getElementById('submit').addEventListener('click', function(event) {
		event.preventDefault();
		const selectedData = [];

		console.log("Processing data...");

		const productListId = document.getElementById('productListId').value;
		console.log(productListId)
		console.log("helo")
		// Loop through each row
		document.querySelectorAll('#orderlistbodytable tr').forEach(function(row) {
			const checkbox = row.querySelector('.inputcheck');

			// Check if the checkbox is selected
			if (checkbox.checked) {
				const rowData = {};

				// Fetch data from the columns
				console.log("helo")
				rowData.prodId = row.cells[1].id;
				rowData.prodName = row.cells[2].innerText;
				rowData.productQuantity = row.cells[3].children[0].value;
				rowData.unitId = row.cells[4].children[0].value;
				rowData.productPrice = row.cells[5].children[0].value;
				
				rowData.productListId=productListId;
				// Push the row data to the selectedData array
				selectedData.push(rowData);
				console.log(rowData) 

			}
		});

		// Convert the array to JSON format
		const jsonData = JSON.stringify(selectedData);
		console.log(jsonData)

		// Ensure the content type is JSON
		fetch('orderlists', {method: "POST",headers: { 'Content-Type': 'application/json' },body: jsonData
		
	    }).then(response => response.text()).then(data => {
				console.log("Response:", data);
			}).catch(error => console.error("Error:", error));

		console.log("JSON Data:", jsonData);
	});
*/
});

document.getElementById('submit').addEventListener('click', function(event) {
    event.preventDefault(); // Prevent form submission
    const selectedData = [];

    const productListId = document.getElementById('productListId').value;
    console.log("Selected Product List ID: ", productListId);

    // Loop through each row of the table
    document.querySelectorAll('#orderlistbodytable tr').forEach(function(row) {
        const checkbox = row.querySelector('.inputcheck'); // Fetch checkbox
        
        // Check if the checkbox is selected
        if (checkbox && checkbox.checked) {
            const rowData = {}; // Create an empty object for each row's data
               
            // Fetch data from the columns
          
           
           /* rowData.productPrice = row.cells[5].children[0].value; // Price input*/
            rowData.productListId = productListId; // Product List ID from select dropdown
			rowData.pm={}
			rowData.sm={}
			rowData.pm.prodId = row.cells[1].id; // Assuming this is the product ID
			rowData.pm.prodName = row.cells[2].innerText; // Product name
            rowData.productQuantity = row.cells[3].children[0].value; // Quantity input
		    rowData.sm.unitId = row.cells[4].children[0].value; // Unit dropdown
            // Push row data to the selectedData array
            selectedData.push(rowData);
        }
    });

    // Convert the selected data to JSON
    const jsonData = JSON.stringify(selectedData);
    console.log("JSON Data: ", jsonData);

    // Send the JSON data to the server using Fetch API
    fetch('orderlists', {
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





document.getElementById("submit").addEventListener("click", function() {
	
    alert("submitted........");
});
