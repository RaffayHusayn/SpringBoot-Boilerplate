<html>
    <head>
        <title>Login Page</title>
    </head>
    <body>

        <h2>Login</h2>
       ${SPRING_SECURITY_LAST_EXCEPTION.message}
        <form action="login" method="post">
            <input name = "username" placeholder="Username">
            <input name = "password" placeholder="Password">
            <input type="submit" value="login" >
        </form>
    </body>
</html>