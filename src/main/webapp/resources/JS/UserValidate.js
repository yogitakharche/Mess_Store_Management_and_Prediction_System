let openLoginPage = document.getElementById("openLoginPage");
let signinFormDiv = document.getElementById("signinFormDiv");

openLoginPage.style.display = "block";
signinFormDiv.style.display = "none";

function signinPage() {
    openLoginPage.style.display = "none";
    signinFormDiv.style.display = "block";
}

function openLogin(){
	openLoginPage.style.display = "block";
	    signinFormDiv.style.display = "none";
}

/*=====================  VALIDATION ON LOGIN FROM  =============================*/ 


/*// Name Validation (Both First and Last Name)
function validateName(inputId, validationMessageId) {
    const nameInput = document.getElementById(inputId);
    const validationMessage = document.getElementById(validationMessageId);
	const regex = /^[a-zA-Z]+( [a-zA-Z]+)*$/;
    const regex = /^[a-zA-Z]+$/; // Only letters allowed

    if (regex.test(nameInput.value)) {
        validationMessage.textContent = "";
        validationMessage.style.color = "green";
        return true;
    } else if (nameInput.value === "") {
        validationMessage.textContent = "";
        return false;
    } else {
        validationMessage.textContent = "Invalid name. Only letters are allowed.";
        validationMessage.style.color = "red";
        return false;
    }
}
function validateName(inputId, validationMessageId) {
    const nameInput = document.getElementById(inputId);
    const validationMessage = document.getElementById(validationMessageId);

    // Regex: no leading space, letters only, one space between words allowed
    const regex = /^[a-zA-Z]+( [a-zA-Z]+)*$/;

    if (regex.test(nameInput.value)) {
        validationMessage.textContent = "";
        validationMessage.style.color = "green";
        return true;
    } else if (nameInput.value === "") {
        validationMessage.textContent = "";
        return false;
    } else {
        validationMessage.textContent = "Invalid name. Only letters are allowed, and only one space between words.";
        validationMessage.style.color = "red";
        return false;
    }
}

// Contact Validation
function validateContact() {
    const contactInput = document.getElementById("contact");
    const validationMessage = document.getElementById("validationMessage");
    const regex = /^[0-9]{10}$/;

    if (/[^0-9]/.test(contactInput.value)) {
        validationMessage.textContent = "Invalid contact number.";
        validationMessage.style.color = "red";
        return false;
    } else if (regex.test(contactInput.value)) {
        validationMessage.textContent = "";
        validationMessage.style.color = "green";
        return true;
    } else {
        validationMessage.textContent = "Incomplete contact number.";
        validationMessage.style.color = "orange";
        return false;
    }
}

// Email Validation
function validateEmail() {
    const emailInput = document.getElementById("email");
    const validationMessage = document.getElementById("emailValidation");
    const trimmedValue = emailInput.value.trimStart();
    const regex = /^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

    if (emailInput.value.startsWith(" ")) {
        validationMessage.textContent = "Email cannot start with a space.";
        validationMessage.style.color = "red";
        return false;
    } else if (trimmedValue.split("@").length - 1 !== 1) {
        validationMessage.textContent = "Invalid email requires only one '@' symbol.";
        validationMessage.style.color = "red";
        return false;
    } else if (regex.test(trimmedValue)) {
        validationMessage.textContent = "";
        validationMessage.style.color = "green";
        return true;
    } else if (emailInput.value === "") {
        validationMessage.textContent = "";
        return false;
    } else {
        validationMessage.textContent = "Invalid email address.";
        validationMessage.style.color = "red";
        return false;
    }
}

// Password Validation
function validatePassword() {
    const passwordInput = document.getElementById("password");
    const validationMessage = document.getElementById("passwordValidation");

    const regex = /^(?=.[a-z])(?=.[A-Z])(?=.\d)(?=.[\W_]).{8,15}$/;

    if (regex.test(passwordInput.value)) {
        validationMessage.textContent = "";
        validationMessage.style.color = "green";
        return true;
    } else if (passwordInput.value === "") {
        validationMessage.textContent = "";
        return false;
    } else {
        validationMessage.textContent = "Invalid password. Must be 8-15 characters, include 1 uppercase, 1 lowercase, 1 digit, and 1 special symbol.";
        validationMessage.style.color = "red";
        return false;
    }
}

// Toggle Password Visibility
document.getElementById("togglePassword").addEventListener("click", function () {
    const passwordField = document.getElementById("password");
    const type = passwordField.getAttribute("type") === "password" ? "text" : "password";
    passwordField.setAttribute("type", type);
    this.textContent = type === "password" ? "Show" : "Hide"; // Toggle between "Show" and "Hide"
});

// Form Validation: Enable or Disable Submit Button
function validateForm() {
    const isFirstNameValid = validateName('firstName', 'firstNameValidation');
    const isLastNameValid = validateName('lastName', 'lastNameValidation');
    const isContactValid = validateContact();
    const isEmailValid = validateEmail();
    const isPasswordValid = validatePassword();

    // Check if all validations pass
    if (isFirstNameValid && isLastNameValid && isContactValid && isEmailValid && isPasswordValid) {
        document.getElementById("submitBtn").disabled = false;
    } else {
        document.getElementById("submitBtn").disabled = true;
    }
}





*/