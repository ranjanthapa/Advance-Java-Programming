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



function openApplyForm() {
    document.getElementById("jobApplyOverlay").style.display = "flex";
}

function closeApplyForm() {
    document.getElementById("jobApplyOverlay").style.display = "none";
}

// Wait for the DOM to fully load before attaching listeners
document.addEventListener('DOMContentLoaded', () => {
  const registerBtn = document.querySelector('.register-btn');
  if (registerBtn) {
    registerBtn.addEventListener('click', activateRegisterBox);
  }

});



function viewApplication(button) {
    document.getElementById("jobApplyOverlay").style.display = "flex";
    const BASE_URL = 'KamPaeyo/'

    const name = button.dataset.name;
    const email = button.dataset.email;
    const contact = button.dataset.contact;
    const cover = button.dataset.cover;
   const resume = `${BASE_URL}${button.dataset.resume}`;
    const status = button.dataset.status;
    const id = button.dataset.id;

    document.getElementById("applicant-name").value = name;
    document.getElementById("applicant-email").value = email;
    document.getElementById("applicant-contact").value = contact;
    document.getElementById("applicant-cover-letter").value = cover;

    document.getElementById("resumeLink").href = `/${resume}`;
    document.getElementById("app-id").value = id;

    document.getElementById("appStatus").value = status;
}

function closeApplyForm() {
    document.getElementById("jobApplyOverlay").style.display = "none";
}


function closeApplyForm() {
    document.getElementById('jobApplyOverlay').style.display = 'none';
}

