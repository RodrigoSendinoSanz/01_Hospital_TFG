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
              <img src="${icono}" />
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
                    <form action="/modificarUsuario" id="from1" method="post">
						<label for="DNI">DNI</label>
                        <input
                          type="text"
                          name="dni"
                          id="dni"
                          placeholder="${usuario.dni }"
                          value="${usuario.dni }"
                          readonly  
                        />
						<label for="email">Email</label>
                        <input
                          type="email"
                          name="email"
                          id="email"
                          placeholder="${usuario.email }"
                          value="${usuario.email }"
                        />
						<label for="nombre">Nombre</label>
                        <input
                          type="text"
                          name="nombre"
                          id="nombre"
                          placeholder="${usuario.nombre }"
                          value="${usuario.nombre }"
                        />
						<label for="apellido">Apellido</label>
                        <input
                          type="text"
                          name="apellido"
                          id="apaellido"
                          placeholder="${usuario.apellido }"
                          value="${usuario.apellido }"
                        />
						<label for="domicilio">Domicilio</label>
                        <input
                          type="text"
                          name="domicilio"
                          id="domicilio"
                          placeholder="${usuario.direccion }"
                          value="${usuario.direccion }"
                        />
						<label for="telefono">Telefono</label>
                        <input
                          type="number"
                          name="telefono"
                          id="telefono"
                          placeholder="${usuario.telefono }"
                          value="${usuario.telefono }"
                        />
						<label for="imgurl">Imagen URL</label>
                        <input
                          type="url"
                          name="imgurl"
                          id="imgurl"
                          placeholder="${usuario.imgurl }"
                          value="${usuario.imgurl }"
                        />

                        <input
                          type="submit"
                          class="btnMas"
                          value="Actualizar"
                        />
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
                    <form action="/modificarInformacion" id="from2" method="post">
                    	<input id="dni" name="dni" type="hidden" value="${usuario.dni }"/>
                    	<label for="peso">Peso</label>
                        <input
                          type="number"
                          name="peso"
                          id="peso"
                          min="15"
                          placeholder="${usuarioInfo.peso }"
                          value="${usuarioInfo.peso }"
                        />
                        <label for="altura">Altura</label>
                        <input
                          type="number"
                          name="altura"
                          id="altura"
                          placeholder="${usuarioInfo.altura }"
                          value="${usuarioInfo.altura }"
                        />
                        <label for="edad">Edad</label>
                        <input
                          type="number"
                          name="edad"
                          id="edad"
                          min="18"
                          placeholder="${usuarioInfo.edad }"
                          value="${usuarioInfo.edad }"
                        />
                        <label for="sexo">Sexo</label>
                        <ion-icon name="male-outline" id="sexo"></ion-icon>
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
                        <input
                          type="submit"
                          class="btnMas"
                          value="Actualizar"
                        />
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
                  
                  <sec:authorize access="hasAuthority('Paciente')">
                  <form action="" id="from3">
                        <label for="alergias">Alergias</label>
                        <input
                          type="text"
                          name="alergias"
                          id="diagnostico"
                          placeholder="${usuarioDia.alergias }"
                          disabled
                        />
                        <label for="tratamientos">Tratamientos</label>
                        <input
                          type="text"
                          name="tratamientos"
                          id="diagnostico"
                          placeholder="${usuarioDia.tratamiento }"
                          disabled
                        />
                        <label for="operaciones">Operaciones</label>
                        <input
                          type="text"
                          name="operaciones"
                          id="diagnostico"
                          placeholder="${usuarioDia.operaciones }"
                          disabled
                        />
                        <label for="enfermedades">Enfermedades</label>
                        <input
                          type="text"
                          name="enfermedades"
                          id="diagnostico"
                          placeholder="${usuarioDia.enfermedades }"
                          disabled
                        />
                        <input id="dni" name="dni" type="hidden" value="${usuario.dni }">
                        <input
                          type="submit"
                          class="btnMas"
                          value="No puedes editar estos campos solo lo puede rellenar un medico"
                          disabled
                        />
                         <!-- Mostrar  solo si viene siendo un medico (quitar el disabled) -->
                    </form>
                    </sec:authorize>
                  
                  
                  
                  
                    <sec:authorize access="hasAuthority('Medico')">
                    <form action="" id="from3">
                        <label for="alergias">Alergias</label>
                        <input
                          type="text"
                          name="alergias"
                          id="diagnostico"
                          placeholder="${usuarioDia.alergias }"
                        />
                        <label for="tratamientos">Tratamientos</label>
                        <input
                          type="text"
                          name="tratamientos"
                          id="diagnostico"
                          placeholder="${usuarioDia.tratamiento }"
                        />
                        <label for="operaciones">Operaciones</label>
                        <input
                          type="text"
                          name="operaciones"
                          id="diagnostico"
                          placeholder="${usuarioDia.operaciones }"
                        />
                        <label for="enfermedades">Enfermedades</label>
                        <input
                          type="text"
                          name="enfermedades"
                          id="diagnostico"
                          placeholder="${usuarioDia.enfermedades }"
                        />
                        <input
                          type="submit"
                          class="btnMas"
                          value="Actualizar"             
                        />

                         <!-- Mostrar  solo si viene siendo un medico (quitar el disabled) -->
                    </form>
                    </sec:authorize>
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
       <c:if test="${mensaje == 'incorreccto'}">
        console.log("pasa por el if");
         <script>
         	Swal.fire("No guardado!", "", "error");
	      </script>
      </c:if>
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
            document.querySelector("#from1").submit()
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
            document.querySelector("#from2").submit();
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
            document.querySelector("#from3").submit();
          } else if (result.isDenied) {
            Swal.fire("Los cambios no se han gurdado", "", "info");
          }
        });
      });

      /*Cambiar el atributo del nombre segun el valor de select*/
      let select = document.querySelector("#select");
      let icono = document.querySelector("#sexo");
      let option = document.querySelector("option");

      select.onchange = function () {
        if (this.value == "m") {
          icono.setAttribute("name", "male-outline");
        } else if (this.value == "f") {
          icono.setAttribute("name", "female-outline");
        } else if (this.value == "x") {
          icono.setAttribute("name", "male-female-outline");
        }
      };
    </script>
  </body>
</html>
