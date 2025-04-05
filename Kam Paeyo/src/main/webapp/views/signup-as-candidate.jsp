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
        <p>Sign up as a Candidate</p>
        <form action="register" method="post">
            <div class="form-group">
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

            <div class="form-group">
            <div class="input-container password-container">
                 <input type="password" name="password" placeholder="Password" required>
                 <label for="password">Password</label>

            </div>

            <div class="input-container password-container">
                 <input type="password" name="confirmPassword" placeholder="Password" required>
                 <label for="confirmPassword">Confirm Password</label>

            </div>

            </div>
            <button type="submit" class="btn">Sign Up</button>
        </form>
        <p>Already have an account? <a href="login.jsp">Login</a></p>
    </div>
</div>
</body>

<script src="scripts/index.js"></script>
</html>
