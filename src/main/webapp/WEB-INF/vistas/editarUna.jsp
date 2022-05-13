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
    <style>
      .details .tablaDetalle table tbody tr:hover {
          color: var(--black);
      }
      h3{
        margin: 2em;
        border-bottom: 2px solid #287bff;
      }
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
    </style>
  </head>
  <body>
    <div class="container">
      <div class="navegation">
        <ul>
          <li>
            <a href="/index">
              <span class="icon"><img src="/img/logo.png" /></span>
              <span class="title">
                <h2>Hospital</h2>
              </span>
            </a>
          </li>
          <li class="hovered">
            <a href="/index">
              <span class="icon">
                <ion-icon name="home-outline"></ion-icon>
              </span>
              <span class="title">Dasboard</span>
            </a>
          </li>
          <sec:authorize access="hasAuthority('Medico')">
          <li>
            <a href="/pacientes">
              <!-- mostrar solo a medico -->
              <span class="icon">
                <ion-icon name="people-outline"></ion-icon>
              </span>
              <span class="title">Pacientes</span>
            </a>
          </li>
          </sec:authorize>
          <li>
            <a href="/todoschat">
              <span class="icon">
                <ion-icon name="chatbox-outline"></ion-icon>
              </span>
              <span class="title">Mensajes</span>
            </a>
          </li>
          <li>
            <a href="/ayuda">
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
          <li>
            <a href="/contrasena">
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
              <form action="/verUna">
                  <input type="text" placeholder="Busca tu cita aqui" />
                  <ion-icon name="search-outline"></ion-icon>
                  <button type="submit" class="buscar">
                  </button>
            </form>
            </label>
          </div>
          <div class="user">
            <a href="/usuario">
               <img src="${icono}" />
            </a>
          </div>
        </div>
        <div class="tablas">
          <div class="details">
            <div class="tablaDetalle">
              <div class="cardHeader">
                <h2>Datos de cita <a href="/verUsuario/${cita.nombrePaciente }">${cita.nombrePaciente }</a> </h2>
              </div>
              <table>
                <thead></thead>
                <tbody>
                  <tr>
                    <form action="/editarUna" id="form1" method ="post">
                      <input id="idCita" name="idCita" type="hidden" value="${cita.idCita }"/>
                      <td>
                        <input
                        type="text"
                        name="fecha"
                        id="fecha"
                        placeholder="${cita.fechaCita }"
                        value="${cita.fechaCita }"
                        />
                      </td>
                      <td>
                        <input
                        type="text"
                        name="hora"
                        id="hora"
                        placeholder="${cita.horaCita }"
                        value="${cita.horaCita }"
                        />
                      </td>
                      <td>
                        <input
                        type="text"
                        name="direccion"
                        id="direccion"
                        placeholder="${cita.direccionCentrosalud }"
                        value="${cita.direccionCentrosalud }"
                        />
                      </td>
                      <td>
                        <input
                        type="text"
                        name="sintomas"
                        id="sintomas"
                        placeholder="${cita.sintomas }"
                        value="${cita.sintomas }"
                        />
                      </td>
                      <td>
                        <select name="estado" id="select">
                          <option value="Realizado">Realizado</option>
                          <option value="Cancelado">Cancelado</option>
                          <option value="Pendiente">Pendiente</option>
                          <option value="Enprogreso">Enprogreso</option>
                        </select>
                      </td>
                      <td>
                        <input
                          type="submit"
                          class="btnMas"
                          value="Actualizar"
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

      document.querySelector("#form1").addEventListener("submit", function (e) {
        var form = this;

        e.preventDefault();

        Swal.fire({
          title: "¿Seguro que quieres editar esta cita?",
          showDenyButton: true,
          confirmButtonText: "Editar",
          denyButtonText: `No cancelar`,
        }).then((result) => {
          /* Read more about isConfirmed, isDenied below */
          if (result.isConfirmed) {
            Swal.fire("Cita Editada!", "", "success");
            e.submit();
          } else if (result.isDenied) {
            Swal.fire("La cita no se ha editado", "", "info");
          }
        });
      });

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
