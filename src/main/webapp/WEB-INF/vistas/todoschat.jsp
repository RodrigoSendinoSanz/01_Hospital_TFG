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
    </style>
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
          <li class="hovered">
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
            <a href="/usuario">
              <img src="./img/user.jpg" />
            </a>
          </div>
        </div>

        <div class="details">
          <!-- 14 citas -->
          <div class="recentUsuarios">
            <div class="cardHeader">
              <h2>Chats</h2>
            </div>
            <table>
              <tbody>
                <tr>
                  <td width="60px">
                    <div class="imgBx">
                      <img
                        src="https://empresas.blogthinkbig.com/wp-content/uploads/2019/11/Imagen3-245003649.jpg?w=800"
                        alt=""
                      />
                    </div>
                  </td>
                  <td>
                    <h4>[Nombre] <br /><span>[Tipo de usuario]</span></h4>
                    <a href="./chat.html" class="btnMas">Escribir</a>
                  </td>
                </tr>
                <tr>
                  <td width="60px">
                    <div class="imgBx"><img src="./img/img2.jpg" alt="" /></div>
                  </td>
                  <td>
                    <h4>Jose <br /><span>España</span></h4>
                  </td>
                </tr>
                <tr>
                  <td width="60px">
                    <div class="imgBx"><img src="./img/img3.jpg" alt="" /></div>
                  </td>
                  <td>
                    <h4>Xian <br /><span>UK</span></h4>
                  </td>
                </tr>
                <tr>
                  <td width="60px">
                    <div class="imgBx"><img src="./img/img4.jpg" alt="" /></div>
                  </td>
                  <td>
                    <h4>Marcos <br /><span>Brasil</span></h4>
                  </td>
                </tr>
                <tr>
                  <td width="60px">
                    <div class="imgBx"><img src="./img/img5.jpg" alt="" /></div>
                  </td>
                  <td>
                    <h4>Giorgina <br /><span>Lituania</span></h4>
                  </td>
                </tr>
                <tr>
                  <td width="60px">
                    <div class="imgBx"><img src="./img/img6.jpg" alt="" /></div>
                  </td>
                  <td>
                    <h4>Andersen <br /><span>Suiza</span></h4>
                  </td>
                </tr>
                <tr>
                  <td width="60px">
                    <div class="imgBx"><img src="./img/img7.jpg" alt="" /></div>
                  </td>
                  <td>
                    <h4>Maria <br /><span>EEUU</span></h4>
                  </td>
                </tr>
                <tr>
                  <td width="60px">
                    <div class="imgBx"><img src="./img/img8.jpg" alt="" /></div>
                  </td>
                  <td>
                    <h4>Juan <br /><span>Suiza</span></h4>
                  </td>
                </tr>
                <tr>
                  <td width="60px">
                    <div class="imgBx"><img src="./img/img9.jpg" alt="" /></div>
                  </td>
                  <td>
                    <h4>Sara <br /><span>España</span></h4>
                  </td>
                </tr>
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
