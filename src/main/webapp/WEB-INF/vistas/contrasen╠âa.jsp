<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="shortcut icon" href="/img/logo.png" />
    <link rel="stylesheet" href="/css/styleusuario.css" />
    <style>
        table {
            width:100%;
        }
        thead {
            display: none;
        }
        tr:nth-of-type(2n) {
            background-color: inherit;
        }
        tr{
            display: grid;
            grid-template-columns: 1fr;
        }
        tbody td {
            display: block;
            text-align:center;
        }
        tbody td:before {
            content: attr(data-th);
            display: block;
            text-align:center;
        }
        label input::placeholder{
            color: grey;
        }
    </style>
    <title>Hospital</title>
  </head>
  <body>
    <div class="container">
      <div class="navegation">
        <ul>
          <li>
            <a href="#">
              <span class="icon"><img src="./img/logo.png" /></span>
              <span class="title">
                <h2>Hospital</h2>
              </span>
            </a>
          </li>
          <li>
            <a href="./index.html">
              <span class="icon">
                <ion-icon name="home-outline"></ion-icon>
              </span>
              <span class="title">Dasboard</span>
            </a>
          </li>
          <li>
            <a href="./pacientes.html">
              <!-- mostrar solo a medico -->
              <span class="icon">
                <ion-icon name="people-outline"></ion-icon>
              </span>
              <span class="title">Pacientes</span>
            </a>
          </li>
          <li>
            <a href="./todos chat.html">
              <span class="icon">
                <ion-icon name="chatbox-outline"></ion-icon>
              </span>
              <span class="title">Mensajes</span>
            </a>
          </li>
          <li>
            <a href="./ayuda.html">
              <span class="icon">
                <ion-icon name="help-circle-outline"></ion-icon>
              </span>
              <span class="title">Ayuda</span>
            </a>
          </li>
          <li>
            <a href="/usuario">
              <span class="icon">
                <ion-icon name="settings-outline"></ion-icon>
              </span>
              <span class="title">Opciones</span>
            </a>
          </li>
          <li class="hovered">
            <a href="./contrasenÌa.html">
              <span class="icon">
                <ion-icon name="lock-closed-outline"></ion-icon>
              </span>
              <span class="title">Contraseña</span>
            </a>
          </li>
          <li>
            <a href="/logout">
              <span class="icon">
                <ion-icon name="log-out-outline"></ion-icon>
              </span>
              <span class="title">Sign Out</span>
            </a>
          </li>
        </ul>
      </div>

      <div class="main">
        <div class="topbar">
          <div class="toggle">
            <ion-icon name="menu-outline"></ion-icon>
          </div>
          <div class="search">
            <label>
              <input type="text" placeholder="Busca tu cita aqui" />
              <ion-icon name="search-outline"></ion-icon>
            </label>
          </div>
          <div class="user">
            <a href="./usuario.html">
              <img src="./img/user.jpg" />
            </a>
          </div>
        </div>
      <div class="tablas">
        <div class="details">
          <div class="tablaDetalle">
            <div class="cardHeader">
              <h2>Cambiar contraseña</h2>
            </div>
            <table>
              <thead>
              </thead>
              <tbody>
                <tr>
                  <form action="./index.html">
                    <td>
                      <input
                        type="text"
                        name="dni"
                        id="dni"
                        placeholder="ContraseÃ±a actual"
                       />
                    </td>
                    <td>
                      <input
                        type="text"
                        name="email"
                        id="email"
                        placeholder="Nueva contraseÃ±a"
                      />
                    </td>
                    <td>
                      <input
                        type="text"
                        name="nombre"
                        id="nombre"
                        placeholder="Respite la nueva contraseÃ±a"
                      />
                    </td>
                    <td>
                      <input type="submit" class="btnMas" value="Actualizar">
                    </td>
                  </form>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.8/dist/sweetalert2.all.min.js"></script>
    <!-- Usar alertas  -->
    <script
      type="module"
      src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"
    ></script>
    <script
      nomodule
      src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"
    ></script>


    <script>
      let toggle = document.querySelector(".toggle");
      let navegation = document.querySelector(".navegation");
      let main = document.querySelector(".main");

      toggle.onclick = function () {
        navegation.classList.toggle("active");
        main.classList.toggle("active");
      };
      

      let list = document.querySelectorAll(".navegation li");

      function activeLink() {
        list.forEach((item) => item.classList.remove("hovered"));
        this.classList.add("hovered");
      }
      list.forEach((item) => item.addEventListener("mouseover", activeLink));


      /*Cambiar el atributo del nombre segun el valor de select*/
      let select = document.querySelector("#select");
      let icono = document.querySelector("#icono");
      let option = document.querySelector("option");

      select.onchange = function () {
        if (this.value == "masculino") {
          icono.setAttribute("name", "male-outline");
        } else if (this.value == "femenino") {
          icono.setAttribute("name", "female-outline");
        } else if (this.value == "intersex") {
          icono.setAttribute("name", "male-female-outline");
        }
      };
    </script>
  </body>
</html>
