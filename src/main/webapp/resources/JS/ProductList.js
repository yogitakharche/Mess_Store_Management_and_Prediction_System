function hidePopup() {
    document.getElementById("successPopup").classList.remove("show");
}

// Show the popup if the 'success' attribute is set
window.onload = function() {
    var successPopup = document.getElementById("successPopup");
    
    // Check if success element exists and show the popup
    if (successPopup && successPopup.getAttribute("createlist") === "true") {
        successPopup.classList.add("show");
    }
};