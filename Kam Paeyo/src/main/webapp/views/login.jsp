<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login | DrillTheWay</title>
    <link rel="stylesheet" href="css/styles.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
</head>
<body>


<div class="container">

<img src="images/login-image.jpeg"/>
    <div class="form-box">
        <h2>Login to your account</h2>
        <p class="text-justify-center">One <span class="font-bold">click </span>and ready to manage job posts and unlock exciting <br> opportunities!</p>
        <% String error = (String) request.getAttribute("error"); %>
        <% if (error != null) { %>
            <div class="error-message" style="color: red; text-align: center; margin-bottom: 10px;">
                <%= error %>
            </div>
        <% } %>

        <form method="post" action="login">
            <div class="input-container">
                <input type="email" name="email" placeholder=" " required>
                 <label for="email">Email</label>
            </div>

            <div class="input-container password-container">
                <input type="password" name="password" placeholder=" " required id="password">
                 <label for="password">Password</label>
                 <button type="button" onclick="toggleEyeButton(this, 'password')" id="toggle-btn" style="display: none;">
                   <i class="fa-solid fa-eye"></i>
                 </button>
            </div>

            <button type="submit" class="btn">Login</button>

        </form>
        <div class="divider-text">
                    <hr>
                  <span>or</span>
                   <hr>
                </div>
                <p class="register-option">Login as an recruiter? <a href="#">Signup</a></p>

        <p class="register-option">Don't have an account? <a href="signup-as-candidate.jsp">Sign up</a></p>
    </div>
</div>
<script>
    document.addEventListener('DOMContentLoaded', () => {
        const passwordField = document.getElementById('password');
        const eyeButton = document.getElementById('toggle-btn');
        if (passwordField.value) {
            eyeButton.style.display = 'inline-block'; // Show the button if there's a value
        }
        passwordField.addEventListener('input', () => {
            if (passwordField.value) {
                eyeButton.style.display = 'inline-block';
            } else {
                eyeButton.style.display = 'none';
            }
        });
    });
</script>

<script src="scripts/index.js"></script>

</body>
</html>
