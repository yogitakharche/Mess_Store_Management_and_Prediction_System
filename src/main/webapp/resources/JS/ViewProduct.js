
document.addEventListener("DOMContentLoaded", function() {

    // Update popup form
    const popupOverlay = document.querySelector('.popup-overlay');

    document.querySelectorAll('.update-btn').forEach(button => {
        button.addEventListener('click', function(event) {
            event.preventDefault();

            let vendorName = this.dataset.name;

            popupOverlay.innerHTML = `
                <div class="popup-content">
                    <span class="popup-close">&times;</span>
                    <h3>Update Product</h3>
                    <form id="updateForm">
                        <input type="text" id="name" value="${vendorName}" placeholder="Product Name" required />
                        <button type="submit">Submit</button>
                    </form>
                    <div class="success-msg">Update successful!</div>
                </div>
            `;
            popupOverlay.style.display = 'flex';
        });
    });

    // Close popup
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

    // Delete confirmation popup
    const confirmationPopup = document.getElementById('confirmationPopup');
    let deleteUrl = '';

    document.querySelectorAll('.delete-btn').forEach(button => {
        button.addEventListener('click', function(event) {
            event.preventDefault();
            deleteUrl = this.href;
            confirmationPopup.style.display = 'flex';
        });
    });

    document.getElementById('confirmYes').addEventListener('click', function() {
        window.location.href = deleteUrl;
    });

    document.getElementById('confirmNo').addEventListener('click', function() {
        confirmationPopup.style.display = 'none';
    });

    document.querySelector('.popup-close').addEventListener('click', function() {
        confirmationPopup.style.display = 'none';
    });
});


$(document).ready(function() {
	$('#ProdTable').DataTable({
		"paging": true, "searching": true, "ordering": true, "info": true,
		"pageLength": 10, "columnDefs": [{ "orderable": true, "targets": [0, 1] },
		{ "orderable": false, "targets": [2] }],
		"order": [[0, 'asc']]
	});
});
