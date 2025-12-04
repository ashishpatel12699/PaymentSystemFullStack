// Simple alert when form is submitted
function showSuccessMessage() {
    alert("Form submitted successfully!");
}

// Add click event for all buttons with .success-btn class
document.addEventListener("DOMContentLoaded", function() {
    const buttons = document.querySelectorAll(".success-btn");
    buttons.forEach(btn => {
        btn.addEventListener("click", showSuccessMessage);
    });
});
