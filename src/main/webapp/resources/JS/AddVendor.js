$(document).ready(function() {
			$('#MessStoreDataTable').DataTable({
				"paging": true,
				"searching": true,
				"ordering": true,
				"info": true,
				"pageLength": 7,
				"columnDefs": [{
					"orderable": true,
					"targets": [0, 1, 2, 3, 4]
				}, {
					"orderable": false,
					"targets": [5, 6] // Disable sorting on Delete and Update columns
				}],
				"order": [[0, 'asc']] // Default sort by first column (Sr.No)
			});
		});

		// Client-side validation (optional)
		$("#addVendorForm").on("submit", function(e) {
			let valid = true;
			$(this).find('input[required]').each(function() {
				if ($(this).val() === '') {
					valid = false;
					alert('All fields must be filled out.');
					return false;
				}
			});
			return valid;
		});