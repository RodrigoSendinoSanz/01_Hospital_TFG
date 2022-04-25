<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Registro </title>
    <link rel="shortcut icon" href="/img/logo.png" />
    <link rel="stylesheet" href="/css/style.css" />
   </head>
<body>
  <div class="wrapper">
    <h2>Registro</h2>
    <form action="./login.html">
      <div class="input-box">
        <input type="password" placeholder="Tu antingua contraseña" required name="password">
      </div>
      <div class="input-box">
        <input type="password" placeholder="Introduce una nueva constraseña" required name="password">
      </div>
      <div class="input-box">
        <input type="password" placeholder="Vuelve a introducir la nueva constraseña" required name="password">
      </div>
      <div class="input-box button">
        <input type="submit" value="Registarse ahora" >
      </div>
    </form>
  </div>
</body>
</html>