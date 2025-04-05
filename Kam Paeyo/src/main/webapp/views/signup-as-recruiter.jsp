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
                <div class="input-container">
                    <input type="password" name="password" placeholder=" " required>
                    <label for="password">Password</label>
                </div>

                <div class="input-container">
                    <input type="password" name="confirm-password" placeholder=" " required>
                    <label for="confirm-password">Confirm Password</label>
                </div>
            </div>


            <button type="submit" class="btn">Sign Up</button>
        </form>

        <p>Already have an account? <a href="login.jsp">Login</a></p>
    </div>
</div>
</body>
</html>
