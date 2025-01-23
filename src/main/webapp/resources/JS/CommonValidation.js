function validateForm(form) {
    let isValid = true;
    const errors = [];

    // Validate required fields
    const requiredFields = form.querySelectorAll("[data-required]");
    requiredFields.forEach(field => {
        if (field.value.trim() === "") {
            isValid = false;
            errors.push(`${field.name} is required.`);
            field.classList.add("error");
        } else {
            field.classList.remove("error");
        }
    });

    // Validate email format
    const emailFields = form.querySelectorAll("[data-email]");
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    emailFields.forEach(field => {
        if (field.value && !emailRegex.test(field.value)) {
            isValid = false;
            errors.push(`${field.name} is not a valid email.`);
            field.classList.add("error");
        } else {
            field.classList.remove("error");
        }
    });

    // Validate numeric fields
    const numericFields = form.querySelectorAll("[data-numeric]");
    numericFields.forEach(field => {
        if (field.value && isNaN(field.value)) {
            isValid = false;
            errors.push(`${field.name} must be a number.`);
            field.classList.add("error");
        } else {
            field.classList.remove("error");
        }
    });

    // Custom validation message display
    const errorDisplay = document.getElementById("errorMessages");
    if (!isValid) {
        errorDisplay.innerHTML = errors.join("<br>");
        errorDisplay.style.display = "block";
    } else {
        errorDisplay.style.display = "none";
    }

    return isValid;
}
