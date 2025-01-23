let subMenu = document.getElementById("subMenu");
function profileMenu() {
	subMenu.classList.toggle("open-menu");
}

let notiSubMenu = document.getElementById("notiSubMenu");
function Notifications() {
	notiSubMenu.classList.toggle("open-noti");
}

let btnSubMenu = document.getElementById("btnSubMenu");
function admButton() {
	btnSubMenu.classList.toggle("open-admbtn");
}

document.addEventListener('DOMContentLoaded', () => {
	const dropdowns = document.querySelectorAll('.dropdown');
	let openDropdown = null;

	dropdowns.forEach(dropdown => {
		dropdown.addEventListener('click', function(event) {
			event.stopPropagation();
			if (openDropdown && openDropdown !== this) {
				openDropdown.querySelector('.dropdown-content').classList.remove('show');
			}
			this.querySelector('.dropdown-content').classList.toggle('show');
			openDropdown = this.querySelector('.dropdown-content').classList.contains('show') ? this : null;
		});
	});

	window.addEventListener('click', function() {
		if (openDropdown) {
			openDropdown.querySelector('.dropdown-content').classList.remove('show');
			openDropdown = null;
		}
	});
});



document.addEventListener("DOMContentLoaded", function() {
	
	var links = document.querySelectorAll(".load-content");

	
	links.forEach(function(link) {
		link.addEventListener("click", function(event) {
			event.preventDefault();

			var pageUrl = this.getAttribute("href"); 

			
			fetch(pageUrl)
				.then(function(response) {
					return response.text();
				})
				.then(function(data) {
					
					document.getElementById("content-container").innerHTML = data;
				})
				.catch(function(error) {
					console.error("Error loading the page:", error);
				});
		});
	});
});



function toggleDiv() {
       const sidebar = document.getElementById("sidebar");
       if (sidebar.style.display === "none" || sidebar.style.display === "") {
           sidebar.style.display = "block"; 
       } else {
           sidebar.style.display = "none";
       }
   }

   function checkWindowSize() {
       const sidebar = document.getElementById("sidebar");
       const toggleButton = document.getElementById("toggleButton");
       if (window.innerWidth >= 500) {
           sidebar.style.display = "block"; 
           toggleButton.style.display = "none"; 
       } else {
           toggleButton.style.display = "inline"; 
           sidebar.style.display = sidebar.style.display === "none" ? "block" : "none"; 
       }
   }

   document.getElementById("toggleButton").addEventListener("click", toggleDiv);
   window.addEventListener("resize", checkWindowSize);

   checkWindowSize();
   
  
   
