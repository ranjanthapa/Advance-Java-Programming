// Toggle register dropdown
function activateRegisterBox() {
  const box = document.querySelector('.register-as-box');
  box.style.display = box.style.display === 'block' ? 'none' : 'block';
}

// Toggle password visibility
// Toggle password visibility
function toggleEyeButton(btn, fieldID) {
    const inputField = document.getElementById(fieldID);
    const icon = btn.querySelector("i");

    if (inputField.type === 'password') {
        inputField.type = 'text';
        icon.classList.remove('fa-eye-slash');
        icon.classList.add('fa-eye');
    } else {
        inputField.type = 'password';
        icon.classList.remove('fa-eye');
        icon.classList.add('fa-eye-slash');
    }
}


function closeForm() {
  const contentToHide = document.querySelector(".apply-job-form");
  if (contentToHide) {
    contentToHide.style.display = "none";
  }
}

function openForm(){
    const contentToHide = document.querySelector(".apply-job-form");
      if (contentToHide) {
        contentToHide.style.display = "block";
      }
}

// Wait for the DOM to fully load before attaching listeners
document.addEventListener('DOMContentLoaded', () => {
  const registerBtn = document.querySelector('.register-btn');
  if (registerBtn) {
    registerBtn.addEventListener('click', activateRegisterBox);
  }

});
