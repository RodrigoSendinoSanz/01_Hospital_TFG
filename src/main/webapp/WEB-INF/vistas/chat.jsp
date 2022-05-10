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
    <link rel="stylesheet" href="/css/style.css" />
    <title>Hospital</title>
    <style>
      .details {
          position: relative;
          width: 100%;
          padding: 20px;
          padding-top: 0;
          display: grid;
          grid-gap: 30px;
          grid-template-columns: 1fr;
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
      .cajachat1,.cajachat2{
          position: relative;
          display: grid;
          max-height:100px;
          margin: 2em;
          background: var(--white);
          padding: 20px;
          box-shadow: 0 7px 25px rgb(0 0 0 / 8%);
          border-radius: 20px;
          display: flex;
          flex-direction: column;
      }
      .cajachat1{
        align-self: flex-start;
        text-align: start;
      }
      .cajachat2{
        align-self: flex-end;
        text-align: end;
      }

      .usuario{
        font-size: larger;
        font-weight: 600;
        display: flex;
        align-items: flex-start;
      }
      .details .recentUsuarios table tr td {
          padding: 20px 20px;
      }
      .details .recentUsuarios table tr td h4 {
          font-size: 16px;
          font-weight: 500;
          padding: 1em;
          line-height: 1.2em;
      }
      .details .recentUsuarios .imgBx {
          position: relative;
          width: 50px;
          height: 50px;
          border-radius: 50%;
          overflow: hidden;
      }
      .btnMas {
          position: relative;
          padding: 5px 10px;
          background: var(--white);
          color: var(--blue);
          border: 1px solid var(--blue);
          text-decoration: none;
          border-radius: 6px;
          margin-left: 1em;
      }
      .chat{
        display:flex;
        align-self: center;
        width: 100%;
        margin: 2em;
      }
      .cajachat1{
        background: rgba( 74, 144, 226, 0.25 );
        box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
        backdrop-filter: blur( 4px );
        -webkit-backdrop-filter: blur( 4px );
        border-radius: 10px;
        border: 1px solid rgba( 255, 255, 255, 0.18 );
      }
      .cajachat2{
        background: rgba( 184, 233, 134, 0.25 );
        box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
        backdrop-filter: blur( 4px );
        -webkit-backdrop-filter: blur( 4px );
        border-radius: 10px;
        border: 1px solid rgba( 255, 255, 255, 0.18 );
      }
      .cajatexto{
        margin: 0.5em;
      }
      .btn{
         margin-left: 0.5em;
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
          <li class="hovered">
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
            <a href="usuario">
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
              <img src="./img/user.jpg" />
            </a>
          </div>
        </div>

        <div class="details">
          <!-- 14 citas -->
          <div class="recentUsuarios">
            <div class="cardHeader">
              <h2>Chat</h2>
            </div>
            <table>
              <tbody>
                <div class="cajachat1">
                  <p class="usuario">Juan:<br /></p>
                  <div id="mensaje1">Prueba de chat</div>
                </div>
                <div class="cajachat2">
                  <p class="usuario">Pepe:<br /></p>
                  <div id="mensaje2">Prueba chat</div>
                </div>
                <div class="search chat">
                  <label>
                      <form action="">
                        <input type="text" placeholder="Escribe aqui tu mensaje" class="cajatexto"/>
                        <input type="submit" class="btnblue cajatexto"></input>
                      </form>
                  </label>
                </div>
              </tbody>
            </table>
          </div>
      </div>
    </div>
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
    </script>
  </body>
</html>
