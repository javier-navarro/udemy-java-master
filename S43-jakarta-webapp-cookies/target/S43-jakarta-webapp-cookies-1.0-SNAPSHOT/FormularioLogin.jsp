<%page contentType= %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario Login</title>
</head>
<body>
    <h1>Iniciar Sesion</h1>
    <form action="/S43-jakarta-webapp-cookies/login" method="post">
        <div>
            <label for="username">USERNAME</label>
            <div>
                <input type="text" name="username" id="username">
            </div>
        </div>
        <div>
            <label for="password"> PASSWORD</label>
            <div>
                <input type="password" name="password" id="password">
            </div>
        </div>
        <div>
            <input type="submit" value="login">
        </div>
    </form>
</body>
</html>