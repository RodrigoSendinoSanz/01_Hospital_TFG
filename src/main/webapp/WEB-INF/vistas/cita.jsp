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
    <title>Hospital</title>
  </head>
  <style>
      .search label ion-icon {
          position: absolute;
          top: 12px;
          left: 10px;
          font-size: 1.2em;
      }
      .invisible{
        visibility: hidden;
      }
      button[type=submit]{
        visibility: hidden;
      }
      .details .tablaDetalle table tbody tr:hover {
            color: var(--black);
      }
  </style>
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
          <li class="hovered">
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
            <a href="usuario">
              <span class="icon">
                <ion-icon name="settings-outline"></ion-icon>
              </span>
              <span class="title">Opciones</span>
            </a>
          </li>
          <li>
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
              <form action="./verUna.html">
                  <input type="text" placeholder="Busca tu cita aqui" />
                  <ion-icon name="search-outline"></ion-icon>
                  <button type="submit" class="buscar">
                  </button>
            </form>
            </label>
          </div>
          <div class="user">
            <a href="#">
              <img src="./img/user.jpg" />
            </a>
          </div>
        </div>
        <div class="tablas">
          <div class="details">
            <div class="tablaDetalle">
              <div class="cardHeader">
                <h2>Pide tu cita</h2>
              </div>
              <table>
                <thead></thead>
                <tbody>
                  <tr>
                    <form action="./index.html" id="from1">
                      <td>
                        Fecha
                      <label for="fecha">
                        <input
                        type="date"
                        name="fecha"
                        id="fecha"
                        placeholder="fecha"
                        required
                      />
                      </label>
                    </td>
                    <td>
                      <label for="hora">Hora
                          <select name="hora" required>
                            <option value="08:30">8:30</option>
                            <option value="09:30">9:30</option>
                            <option value="10:30">9:30</option>
                            <option value="11:30">11:30</option>
                            <option value="12:30">12:30</option>
                            <option value="13:30">13:30</option>
                            <option value="16:30">16:30</option>
                            <option value="17:30">17:30</option>
                            <option value="18:30">18:30</option>
                            <option value="19:30">19:30</option>
                            <option value="20:30">20:30</option>
                            <option value="21:30">21:30</option>

                          </select>
                        </label>
                    </td>
                    <td>
                      <label for="direccion">Centro
                          <select name="direccion" required>
                            <option value="Direccion1">Direccion1</option>
                            <option value="Direccion2">Direccion2</option>
                            <option value="Direccion3">Direccion3</option>
                          </select>
                        </label>
                    </td>
                      <td>
                        <label for="sintomas">Motivo
                        <input
                          type="text"
                          name="sintomas"
                          id="sintomas"
                          required
                        />
                        </label>
                      </td>
                      <td>
                        <label for="nombre_medico">Médico
                          <select name="nombre_medico" required>
                            <option value="med123">Médico bien</option>
                            <option value="Medico1">Médico 2</option>
                            <option value="Medico2">Médico 3</option>
                          </select>
                        </label>
                      </td>
                      <td>
                        <input
                          type="submit"
                          class="btnMas"
                          value="Realizar cita"
                        />
                      </td>
                    </form>
                  </tr>
                </tbody>
              </table>
            </div>
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



      document.querySelector("#from1").addEventListener("submit", function (e) {
        var form = this;

        e.preventDefault();

        Swal.fire({
          title: "¿Estas seguro de querer pedir esta cita?",
          showDenyButton: true,
          confirmButtonText: "Si",
          denyButtonText: `No`,
        }).then((result) => {
          /* Read more about isConfirmed, isDenied below */
          if (result.isConfirmed) {
            Swal.fire("¡Cita realizada!", "", "success");
            window.location.assign("./index.html");
          } else if (result.isDenied) {
            Swal.fire("No se han realizado la cita", "", "info");
          }
        });
      });
    </script>
  </body>
</html>
