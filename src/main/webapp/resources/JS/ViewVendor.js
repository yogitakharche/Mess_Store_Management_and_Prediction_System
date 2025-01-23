
	document.addEventListener("DOMContentLoaded", function() {

	    // Update popup form
	    const popupOverlay = document.createElement('div');
	    popupOverlay.classList.add('popup-overlay');
	    document.body.appendChild(popupOverlay);

	    document.querySelectorAll('.update-btn').forEach(button => {
	        button.addEventListener('click', function(event) {
	            event.preventDefault();

	            let vendorName = this.dataset.name;
	            let vendorEmail = this.dataset.email;
	            let vendorContact = this.dataset.contact;
	            let vendorShop = this.dataset.shopname;
	            
	            popupOverlay.innerHTML = `
	                <div class="popup-content">
	                    <span class="popup-close">&times;</span>
	                    <h3>Update Vendor</h3>
	                    <form id="updateForm">
	                        <input type="text" id="name" value="${vendorName}" placeholder="Vendor Name" required />
	                        <input type="email" id="email" value="${vendorEmail}" placeholder="Vendor Email" required />
	                        <input type="text" id="contact" value="${vendorContact}" placeholder="Vendor Contact" required />
	                        <input type="text" id="shopname" value="${vendorShop}" placeholder="Shop Name" required />
	                        <button type="submit">Submit</button>
	                    </form>
	                    <div class="success-msg">Update successful!</div>
	                </div>
	            `;
	            popupOverlay.style.display = 'flex';
	        });
	    });

	    // Close popup on clicking the 'X' button using event delegation
	    popupOverlay.addEventListener('click', function(event) {
	        if (event.target.classList.contains('popup-close') || event.target === popupOverlay) {
	            popupOverlay.style.display = 'none';
	        }
	    });

	    // Handle form submission
	    popupOverlay.addEventListener('submit', function(e) {
	        e.preventDefault();
	        const successMsg = popupOverlay.querySelector('.success-msg');
	        successMsg.style.display = 'block';
	        setTimeout(() => {
	            popupOverlay.style.display = 'none';
	        }, 2000);
	    });
	});


document.addEventListener("DOMContentLoaded", function() {
    const confirmationPopup = document.getElementById('confirmationPopup');
    const confirmYes = document.getElementById('confirmYes');
    const confirmNo = document.getElementById('confirmNo');
    const popupClose = document.querySelector('.popup-close');
    let deleteUrl = '';

    // Show confirmation popup
    document.querySelectorAll('.delete-btn').forEach(button => {
        button.addEventListener('click', function(event) {
            event.preventDefault();
            deleteUrl = this.href; // Store the delete URL
            confirmationPopup.style.display = 'flex';
        });
    });

    // Confirm deletion
    confirmYes.addEventListener('click', function() {
        window.location.href = deleteUrl; // Redirect to delete URL
    });

    // Cancel deletion
    confirmNo.addEventListener('click', function() {
        confirmationPopup.style.display = 'none'; // Hide the popup
    });

    // Close the popup
    popupClose.addEventListener('click', function() {
        confirmationPopup.style.display = 'none'; // Hide the popup
    });
});



/*$(document).ready(function() {
	$('#vend-tab').DataTable({
		"paging": true, "searching": true, "ordering": true, "info": true,
		"pageLength": 10, "columnDefs": [{ "orderable": true, "targets": [0, 1] },
		{ "orderable": false, "targets": [2] }],
		"order": [[0, 'asc']]
	});
})*/
