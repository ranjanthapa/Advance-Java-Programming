<%@ page import="constants.Education" %>

<%@ page import="constants.Education" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up | DrillTheWay</title>
    <link rel="stylesheet" href="css/styles.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">

</head>
<body>
       <%@ include file="includes/navigation.jsp" %>


<div class="container">
<img src="images/registration-as-candidate.jpeg"/>
    <div class="form-box">
        <h2>Create an Account</h2>
        <p>Sign up as a Candidate</p>
        <form action="register" method="POST">
        <input type="text" name="type" value="candidate" hidden/>
            <div class="form-group-h">
                <div class="input-container">
                    <input type="text" name="firstName" placeholder=" " required>
                    <label for="firstname">First Name</label>
                </div>

                 <div class="input-container">
                    <input type="text" name="lastName" placeholder=" " required>
                    <label for="lastName">Last Name</label>
                </div>
            </div>

            <div class="input-container">
                 <input type="email" name="email" placeholder=" " required>
                 <label for="email">Email</label>
            </div>

            <div class="input-container">
                 <input type="text" name="phoneNumber" placeholder=" " required>
                 <label for="phoneNumber">Phone Number</label>
            </div>
            <div class="input-container">
                <input type="text" name="location" placeholder=" " required>
                <label for="location">Location</label>
            </div>

            <div class='form-group-h'>
                <div class="input-container flex-grow   ">
                    <input type="url" name="website" placeholder=" ">
                    <label for="website">Portfolio (Optional)</label>
                </div>


                <div class="input-container">
                    <select name="education" required>
                        <option value="" disabled selected hidden>Education</option>
                        <option value="High School">High School</option>
                        <option value="Diploma">Diploma</option>
                        <option value="Bachelor">Bachelor</option>
                        <option value="Master">Master</option>
                        <option value="PhD">PhD</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <div class="input-container password-container">
                     <input type="password" name="password" placeholder="Password" id="password" required>
                     <label for="password">Password</label>
                      <button type="button" onclick="toggleEyeButton(this, 'password')" id="toggle-btn" class="password-eye" style="display: none;">
                        <i class="fa-solid fa-eye-slash"></i>
                      </button>
                </div>

                <div class="input-container password-container">
                     <input type="password" name="confirmPassword" placeholder=" " id="confirmPassword"  required>
                     <label for="confirmPassword">Confirm Password</label>
                      <button type="button" onclick="toggleEyeButton(this, 'confirmPassword')" id="toggle-btn"
                      class="confirm-password-eye" style="display: none;">
                            <i class="fa-solid fa-eye-slash"></i>
                      </button>
                </div>
            </div>
            <button type="submit" class="btn">Register</button>
        </form>
        <div class="divider-text">
            <hr>
          <span>or</span>
           <hr>
        </div>
         <p class="register-option">Already have an account? Login as </p>

                <div class= "horizontal login-option">
                    <a href="login.jsp">Candidate  </a>
                    <span>/</span>
                    <a href="login-as-recruiter.jsp"> Recruiter</a>
                </div>

    </div>
</div>
</body>
<script>
    document.addEventListener('DOMContentLoaded', () => {
        const passwordInput = document.getElementById("password");
        const confirmInput = document.getElementById("confirmPassword");
        const passwordEye = document.querySelector(".password-eye");
        const confirmEye = document.querySelector(".confirm-password-eye");

        function toggleVisibilityIcon(inputField, button) {
            inputField.addEventListener('input', () => {
            if (inputField.value) {
              button.style.display = "inline-block";
            } else {
              button.style.display = "none";
            }
            });

          if (inputField.value) {
            button.style.display = "inline-block";
          }
        }

        toggleVisibilityIcon(passwordInput, passwordEye);
        toggleVisibilityIcon(confirmInput, confirmEye);
      });

</script>
<script src="scripts/index.js"></script>
</html>
