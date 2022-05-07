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
      label input::placeholder{
            color: grey;
        }
    </style>
  </head>
  <body>
    <div class="container">
      <div class="navegation">
        <ul>
          <li>
            <a href="/index">
              <span class="icon"><img src="./img/logo.png" /></span>
              <span class="title">
                <h2>Hospital</h2>
              </span>
            </a>
          </li>
          <li>
            <a href="/index">
              <span class="icon">
                <ion-icon name="home-outline"></ion-icon>
              </span>
              <span class="title">Dasboard</span>
            </a>
          </li>
          <li>
            <a href="/pacientes">
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
            <a href="/ayuda">
              <span class="icon">
                <ion-icon name="help-circle-outline"></ion-icon>
              </span>
              <span class="title">Ayuda</span>
            </a>
          </li>
          <li class="hovered">
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
              <form action="./verUna.html">
                  <input type="text" placeholder="Busca tu cita aqui" />
                  <ion-icon name="search-outline"></ion-icon>
                  <button type="submit" class="buscar">
                  </button>
            </form>
            </label>
          </div>
          <div class="user">
            <a href="/usuario">
              <img src="./img/user.jpg" />
            </a>
          </div>
        </div>
        <div class="tablas">
          <div class="details">
            <div class="tablaDetalle">
              <div class="cardHeader">
                <h2>Datos usuario</h2>
              </div>
              <table>
                <thead></thead>
                <tbody>
                  <tr>
                    <form action="" id="from1">
                      <td>
                        <input
                          type="text"
                          name="dni"
                          id="dni"
                          placeholder="${usuario.dni }"
                        />
                      </td>
                      <td>
                        <input
                          type="email"
                          name="email"
                          id="email"
                          placeholder="${usuario.email }"
                        />
                      </td>
                      <td>
                        <input
                          type="text"
                          name="nombre"
                          id="nombre"
                          placeholder="${usuario.nombre }"
                        />
                      </td>
                      <td>
                        <input
                          type="text"
                          name="apellido"
                          id="apaellido"
                          placeholder="${usuario.apellido }"
                        />
                      </td>
                      <td>
                        <input
                          type="text"
                          name="domicilio"
                          id="domicilio"
                          placeholder="${usuario.direccion }"
                        />
                      </td>
                      <td>
                        <input
                          type="number"
                          name="telefono"
                          id="telefono"
                          placeholder="${usuario.telefono }"
                        />
                      </td>
                      <td>
                        <input
                          type="url"
                          name="imagen"
                          id="imagen"
                          placeholder="${usuario.imgurl }"
                        />
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

          <div class="details">
            <div class="tablaDetalle">
              <div class="cardHeader">
                <h2>Datos fisicos</h2>
              </div>
              <table>
                <thead></thead>
                <tbody>
                  <tr>
                    <form action="" id="from2">
                      <td>
                        <input
                          type="number"
                          name="peso"
                          id="peso"
                          min="15"
                          placeholder="${usuarioInfo.peso }"
                        />
                      </td>
                      <td>
                        <input
                          type="number"
                          name="altura"
                          id="altura"
                          placeholder="${usuarioInfo.altura }"
                          
                        />
                      </td>
                      <td>
                        <input
                          type="number"
                          name="edad"
                          id="edad"
                          min="18"
                          placeholder="${usuarioInfo.edad }"
                        />
                      </td>
                      <td>
                        <ion-icon name="male-outline" id="icono"></ion-icon>
                        <select name="sexo" id="select">
                          <option value="m"
                          <c:if test = "${usuarioInfo.sexo == 'm'}">
                          selected="selected"
                          </c:if>
                          >Masculino</option>
                          <option value="f"
                          <c:if test = "${usuarioInfo.sexo == 'f'}">
                          selected="selected"
                          </c:if>
                          >Femenino</option>
                          <option value="x"
                          <c:if test = "${usuarioInfo.sexo == 'x'}">
                          selected="selected"
                          </c:if>
                          >Intersexual</option>
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

          <div class="details">
            <div class="tablaDetalle">
              <div class="cardHeader">
                <h2>Datos de diagnostico</h2>
              </div>
              <table>
                <tbody>
                  <tr>
                    <form action="" id="from3">
                      <td>
                        <input
                          type="text"
                          name="alergias"
                          id="diagnostico"
                          placeholder="${usuarioDia.alergias }"
                          disabled
                        />
                      </td>
                      <td>
                        <input
                          type="text"
                          name="tratamientos"
                          id="diagnostico"
                          placeholder="${usuarioDia.tratamiento }"
                          disabled
                        />
                      </td>
                      <td>
                        <input
                          type="text"
                          name="operaciones"
                          id="diagnostico"
                          placeholder="${usuarioDia.operaciones }"
                          disabled
                        />
                      </td>
                      <td>
                        <input
                          type="text"
                          name="enfermedades"
                          id="diagnostico"
                          placeholder="${usuarioDia.enfermedades }"
                          disabled
                        />
                      </td>
                      <td>
                      <sec:authorize access="hasAuthority('Paciente')">
                        <input
                          type="submit"
                          class="btnMas"
                          value="No puedes editar estos campos solo lo puede rellenar un medico"
                          disabled
                        />
                       </sec:authorize>
                      
                      <sec:authorize access="hasAuthority('Medico')">
                        <input
                          type="submit"
                          class="btnMas"
                          value="Actualizar"             
                        />
                        </sec:authorize>
                         <!-- Mostrar  solo si viene siendo un medico (quitar el disabled) -->
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
          title: "¿Quieres guardar los cambios?",
          showDenyButton: true,
          showCancelButton: true,
          confirmButtonText: "Guardar",
          denyButtonText: `No guardar`,
        }).then((result) => {
          /* Read more about isConfirmed, isDenied below */
          if (result.isConfirmed) {
            Swal.fire("Guardado!", "", "success");
          } else if (result.isDenied) {
            Swal.fire("Los cambios no se han gurdado", "", "info");
          }
        });
      });

      document.querySelector("#from2").addEventListener("submit", function (e) {
        var form = this;

        e.preventDefault();

        Swal.fire({
          title: "¿Quieres guardar los cambios?",
          showDenyButton: true,
          showCancelButton: true,
          confirmButtonText: "Guardar",
          denyButtonText: `No guardar`,
        }).then((result) => {
          /* Read more about isConfirmed, isDenied below */
          if (result.isConfirmed) {
            Swal.fire("Guardado!", "", "success");
          } else if (result.isDenied) {
            Swal.fire("Los cambios no se han gurdado", "", "info");
          }
        });
      });

      document.querySelector("#from3").addEventListener("submit", function (e) {
        var form = this;

        e.preventDefault();

        Swal.fire({
          title: "¿Quieres guardar los cambios?",
          showDenyButton: true,
          showCancelButton: true,
          confirmButtonText: "Guardar",
          denyButtonText: `No guardar`,
        }).then((result) => {
          /* Read more about isConfirmed, isDenied below */
          if (result.isConfirmed) {
            Swal.fire("Guardado!", "", "success");
          } else if (result.isDenied) {
            Swal.fire("Los cambios no se han gurdado", "", "info");
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
