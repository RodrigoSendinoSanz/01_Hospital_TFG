<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="shortcut icon" href="/img/logo.png" />
    <link rel="stylesheet" href="/css/stylelogin.css">
   </head>
<body>
  <div class="wrapper">
    <h2>Login</h2>
     <form action="./index.html">
      <div class="input-box">
        <input type="text" placeholder="Introduce tu DNI" required name="dni">
      </div>
      <div class="input-box">
        <input type="password" placeholder="Introduce tu contraseña" required name="password">
      </div>
      <div class="input-box button">
        <input type="Submit" value="Entrar">
      </div>
      <div class="text">
        <h3>¿Se te ha olvidado la constaseña?<br><a href="./recuperarcontraseña.html">Recuperar constraseña</a></h3>
        <h3>¿No tienes una cuenta?<br><a href="/registro">Registrate ahora</a></h3>
    </form>
  </div>
</body>
</html>
