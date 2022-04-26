<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Registro </title>
    <link rel="shortcut icon" href="/img/logo.png" />
    <link rel="stylesheet" href="/css/stylelogin.css">
   </head>
<body>
  <div class="wrapper">
    <h2>Registro</h2>
    <form action="./login.html" onsubmit="validar()">
      <div class="input-box">
        <input type="text" placeholder="Introduce el DNI" required name="dni">
      </div>
      <div class="input-box">
        <input type="password" placeholder="Introduce una contraseña" required name="password">
      </div>
      <div class="input-box">
        <input type="email" placeholder="Introduce tu email" required name="email">
      </div>
      <div class="input-box">
        <input type="text" placeholder="Introduce tu nombre" required name="nombre">
      </div>
      <div class="input-box">
        <input type="text" placeholder="Introduce tu apellido" required name="apellidos">
      </div>
      <div class="input-box">
        <input type="text" placeholder="Introduce tu dirección" required name="direccion">
      </div>
      <div class="input-box">
        <input type="text" placeholder="Introduce tu teléfono" required name="telefono">
      </div>
      <div class="policy">
        <input type="checkbox" required>
        <h3>Acepto los <a href="#">terminos y condiciones</a></h3>
      </div>
      <div class="input-box button">
        <input type="submit" value="Registarse ahora" onclick="validar()">
      </div>
    </form>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.8/dist/sweetalert2.all.min.js"></script>
    <script>
      /* Antes de enviar el formulario comprbar que los campos esten rellenos */
      //ejecutar la funcion validar() cuando se pulse el boton de registro ------- NO VA!!
      function validar() {
        var dni = document.getElementById("dni").value;
        var password = document.getElementById("password").value;
        var email = document.getElementById("email").value;
        var nombre = document.getElementById("nombre").value;
        var apellidos = document.getElementById("apellidos").value;
        var direccion = document.getElementById("direccion").value;
        var telefono = document.getElementById("telefono").value;
        var check = document.getElementById("check").checked;
        if (dni == "" || password == "" || email == "" || nombre == "" || apellidos == "" || direccion == "" || telefono == "" || check == false) {
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Debes rellenar todos los campos',
          })
          return false;
        }
        else {
          return true;
        }
      }



    </script>
  </div>
</body>
</html>
