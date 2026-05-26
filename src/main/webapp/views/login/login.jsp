<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
    
<head>
    <meta charset="UTF-8">
    <title>Login - Clínica Pet Care</title>

    <link rel="stylesheet" href="assets/css/login.css">    
</head>

<body>

<div class="login-container">

    <div class="left">

        <div class="logo">
    
            <div class="logo-icon">
                🐾
            </div>

            <h1>Clínica Pet Care</h1>

        </div>

        <div class="pet-emoji">
            <div>🐶</div>
            <div>🐱</div>

        </div>

    </div>

    <div class="right">

        <h2>Bem-vindo!</h2>

        <p>
            Faça login para acessar o sistema.
        </p>

        <% if(request.getAttribute("erro") != null){ %>
            <div class="error">
                <%= request.getAttribute("erro") %>
            </div>
        <% } %>

        <form action="login" method="post">

            <div class="input-group">
                <label>E-mail</label>
                <input type="email"
                       name="email"
                       placeholder="admin@clinicavet.com"
                       required>
            </div>

            <div class="input-group">
                <label>Senha</label>
                <input type="password"
                       name="senha"
                       placeholder="Digite sua senha"
                       required>
            </div>

            <button type="submit" class="btn-login">
                Entrar no sistema
            </button>

        </form>

        <div class="footer-text">
            Clínica Pet Care © 2026
        </div>

    </div>

</div>

</body>
</html>