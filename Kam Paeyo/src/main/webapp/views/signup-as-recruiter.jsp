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
    <div class="form-box">
        <h2>Create an Account</h2>
        <p>Sign up as a recruiter</p>
        <form>

            <div class="input-container">
                <input type="text" name="fullname" placeholder=" " required>
                <label for="firmName">Firm Name</label>
            </div>

            <div class="input-container">
                <input type="email" name="email" placeholder=" " required>
                <label for="email">Company Email</label>
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
            <button type="submit" class="btn">Sign Up</button>
        </form>

        <p>Already have an account? <a href="login.jsp">Login</a></p>
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
</html>
