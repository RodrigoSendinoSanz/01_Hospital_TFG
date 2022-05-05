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
      .details .recentCitas {
        position: relative;
        display: grid;
        min-height: 0px;
        background: var(--white);
        padding: 20px;
        box-shadow: 0 7px 25px rgb(0 0 0 / 8%);
        border-radius: 20px;
        height: max-content;
      }
      .swal2-styled.swal2-confirm{
        background-color: #287bff !important;
        color: white;
        border:none;
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

        <div class="cardBox">
          <a href="./medicinas.html">
            <div class="card">
              <div>
                <div class="numbers">Medicinas</div>
                <div class="cardName">Ver tus medicinas</div>
              </div>
              <div class="iconBox">
                <ion-icon name="fitness-outline"></ion-icon>
              </div>
            </div>
          </a>
          <a href="./todas.html">
            <div class="card">
              <div>
                <div class="numbers">Citas</div>
                <div class="cardName">Citas realizadas</div>
              </div>
              <div class="iconBox">
                <ion-icon name="pulse-outline"></ion-icon>
              </div>
            </div>
          </a>
          <a href="./todos chat.html">
            <div class="card">
              <div>
                <div class="numbers">Consultas</div>
                <div class="cardName">Consultas realizadas</div>
              </div>
              <div class="iconBox">
                <ion-icon name="chatbubbles-outline"></ion-icon>
              </div>
            </div>
          </a>
          <a href="./medicos.html">
            <div class="card">
              <div>
                <div class="numbers">120</div>
                <div class="cardName">Médicos disponibles</div>
              </div>
              <div class="iconBox">
                <ion-icon name="medkit-outline"></ion-icon>
              </div>
            </div>
          </a>
        </div>

        <div class="infoheader">
          <div class="caja">
            <div id="calendar"></div>
            <a href="./cita.html" class="btnCita">Pedir cita</a>
          </div>
          <div class="caja">
            <p class="titulonoticas">Noticias:<br /></p>
            <div id="noticias"></div>
          </div>
        </div>

        <div class="details">
          <!-- 14 citas -->
        <sec:authorize access="hasAuthority('Paciente')">
          <div class="recentCitas">
            <div class="cardHeader">
              <h2>Ultimas citas</h2>
              <a href="./todas.html" class="btnblue">Ver todas</a>
            </div>
            <table>
              <thead>
                <tr>
                  <td>Fecha</td>
                  <td>Dirección</td>
                  <td>Estado</td>
                  <td>Información</td>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>2022-10-28</td>
                  <td>Calle 2º</td>
                  <td><span class="status realizado">Realizado</span></td>
                  <td><a href="/verUna" class="btnMas">Ver mas</a></td>
                </tr>
                <tr>
                  <td>2023-04-28</td>
                  <td>Calle 2º</td>
                  <td><span class="status cancelado">Cancelado</span></td>
                  <td><a href="/verUna" class="btnMas">Ver mas</a></td>
                </tr>
                <tr>
                  <td>2024-04-28</td>
                  <td>Calle 23º</td>
                  <td><span class="status pendiente">Pendiente</span></td>
                  <td><a href="./verUna.html" class="btnMas">Ver mas</a></td>
                </tr>
                <tr>
                  <td>2022-04-28</td>
                  <td>Calle 42º</td>
                  <td><span class="status enprogreso">En progreso</span></td>
                  <td><a href="./verUna.html" class="btnMas">Ver mas</a></td>
                </tr>
                
              </tbody>
            </table>
          </div>
         </sec:authorize>
          
		<sec:authorize access="hasAuthority('Medico')">
           <div class="recentCitas">
            <div class="cardHeader">
              <h2>Ultimas citas</h2>
              <a href="./todas.html" class="btnblue">Ver todas</a>
            </div>
            <table>
              <thead>
                <tr>
                  <td>Fecha</td>
                  <td>Dirección</td>
                  <td>Estado</td>
                  <td>Información</td>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>2022-10-28</td>
                  <td>Calle 2º</td>
                  <td><span class="status realizado">Realizado</span></td>
                  <td>
                    <a href="#" class="btnMas cancelar">Cancelar</a> 
                    <a href="./editarUna.html" class="btnMas">Editar</a>
                  </td>
                </tr>
                <tr>
                  <td>2023-04-28</td>
                  <td>Calle 2º</td>
                  <td><span class="status cancelado">Cancelado</span></td>
                  <td>
                    <a href="#" class="btnMas cancelar">Cancelar</a> 
                    <a href="./editarUna.html" class="btnMas">Editar</a>
                  </td>
                </tr>
                <tr>
                  <td>2024-04-28</td>
                  <td>Calle 23º</td>
                  <td><span class="status pendiente">Pendiente</span></td>
                  <td>
                    <a href="#" class="btnMas cancelar">Cancelar</a> 
                    <a href="./editarUna.html" class="btnMas">Editar</a>
                  </td>
                </tr>
                <tr>
                  <td>2022-04-28</td>
                  <td>Calle 42º</td>
                  <td><span class="status enprogreso">En progreso</span></td>
                  <td>
                    <a href="#" class="btnMas cancelar">Cancelar</a> 
                    <a href="./editarUna.html" class="btnMas">Editar</a>
                  </td>
                </tr>  
              </tbody>
            </table>
          </div>
         </sec:authorize>
          

          <div class="recentUsuarios">
            <div class="cardHeader">
              <h2>Conectados</h2>
            </div>
            <table>
              <tbody>
                <tr>
                      <td width="60px">
                        <a href="./chat.html">
                          <div class="imgBx">
                            <img
                              src="https://empresas.blogthinkbig.com/wp-content/uploads/2019/11/Imagen3-245003649.jpg?w=800"
                              alt=""
                            />
                          </div>
                        </a>
                      </td>
                  <td>
                      <h4>[Nombre] <br /><span>[Tipo de usuario]</span></h4>
                  </td>
                </tr>
                <tr>
                  <td width="60px">
                    <div class="imgBx"><img src="./img/img2.jpg" alt="" /></div>
                  </td>
                  <td>
                    <h4>Jose <br /><span>Paciente</span></h4>
                  </td>
                </tr>
                <tr>
                  <td width="60px">
                    <div class="imgBx"><img src="./img/img3.jpg" alt="" /></div>
                  </td>
                  <td>
                    <h4>Xian <br /><span>Paciente</span></h4>
                  </td>
                </tr>
                <tr>
                  <td width="60px">
                    <div class="imgBx"><img src="./img/img4.jpg" alt="" /></div>
                  </td>
                  <td>
                    <h4>Marcos <br /><span>Paciente</span></h4>
                  </td>
                </tr>
                <tr>
                  <td width="60px">
                    <div class="imgBx"><img src="./img/img5.jpg" alt="" /></div>
                  </td>
                  <td>
                    <h4>Giorgina <br /><span>Paciente</span></h4>
                  </td>
                </tr>
                <tr>
                  <td width="60px">
                    <div class="imgBx"><img src="./img/img6.jpg" alt="" /></div>
                  </td>
                  <td>
                    <h4>Andersen <br /><span>Médico</span></h4>
                  </td>
                </tr>
                <tr>
                  <td width="60px">
                    <div class="imgBx"><img src="./img/img7.jpg" alt="" /></div>
                  </td>
                  <td>
                    <h4>Maria <br /><span>Médico</span></h4>
                  </td>
                </tr>
                <tr>
                  <td width="60px">
                    <div class="imgBx"><img src="./img/img8.jpg" alt="" /></div>
                  </td>
                  <td>
                    <h4>Juan <br /><span>Médico</span></h4>
                  </td>
                </tr>
                <tr>
                  <td width="60px">
                    <div class="imgBx"><img src="./img/img9.jpg" alt="" /></div>
                  </td>
                  <td>
                    <h4>Sara <br /><span>Médico</span></h4>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

    <link href="./cal/main.css" rel="stylesheet" />
    <script src="./cal/main.js"></script>
    <script>
      var today = new Date();
      var dd = String(today.getDate()).padStart(2, "0");
      var mm = String(today.getMonth() + 1).padStart(2, "0"); //January is 0!
      var yyyy = today.getFullYear();
      today = yyyy + "-" + mm + "-" + dd;

      document.addEventListener("DOMContentLoaded", function () {
        var calendarEl = document.getElementById("calendar");
        //----------- Resvisar -----------
        var calendar = new FullCalendar.Calendar(calendarEl, {
          locale: "es",
          firstDay: 1,
          headerToolbar: {
            left: "prev,next today",
            center: "title",
            right: ""
            //right: 'dayGridMonth,timeGridWeek,timeGridDay,listMonth',
            //right: "addEventButton",
          },
          customButtons: {
            addEventButton: {
              text: "Pide tu cita",
              click: function () {
                //Idea : aÃ±adir la funcion como externa (SE DERIVARA A UN JSP)
                //Resvisar poner opciones
                var dateStr = prompt("Enter a date in YYYY-MM-DD format");
                var titleStr = prompt("Enter a titulo");
                var horaStr = prompt("Enter a hora");
                var date = new Date(dateStr + "T" + horaStr + ":00"); // will be in local time
                var titulo = titleStr + " " + horaStr;
                location.href = "ir a pagina de cita";
                if (!isNaN(date.valueOf())) {
                  // valid?
                  calendar.addEvent({
                    title: titulo,
                    start: date,
                    allDay: true,
                  });
                  // Ejecutar solo si viene de poner cita
                  const Toast = Swal.mixin({
                    toast: true,
                    position: "top-end",
                    showConfirmButton: false,
                    timer: 3000,
                    timerProgressBar: true,
                    didOpen: (toast) => {
                      toast.addEventListener("mouseenter", Swal.stopTimer);
                      toast.addEventListener("mouseleave", Swal.resumeTimer);
                    },
                  });
                  // Ejecutar solo si viene de poner cita
                  Toast.fire({
                    icon: "success",
                    title: "Se ha creado la cita",
                  });
                } else {
                  const Toast = Swal.mixin({
                    toast: true,
                    position: "top-end",
                    showConfirmButton: false,
                    timer: 3000,
                    timerProgressBar: true,
                    didOpen: (toast) => {
                      toast.addEventListener("mouseenter", Swal.stopTimer);
                      toast.addEventListener("mouseleave", Swal.resumeTimer);
                    },
                  });
                  Toast.fire({
                    icon: "error",
                    title: "No se ha creado la cita",
                  });
                }
              },
            },
          },
          initialDate: today,
          navLinks: true, // can click day/week names to navigate views
          businessHours: true, // display business hours
          editable: true,
          selectable: true,
          events: [
            // borrar todo menos el primero y hacer un for de las citas de cada Usuario
            {
              title: "Business Lunch",
              start: "2022-04-03T13:00:00",
              constraint: "businessHours",
            },
            {
              title: "Meeting",
              start: "2022-04-13T11:00:00",
              constraint: "availableForMeeting", // defined below
              color: "#257e4a",
            },
            {
              title: "Conference",
              start: "2022-04-18",
              end: "2022-04-20",
            },
            {
              title: "Party",
              start: "2022-04-29T20:00:00",
            },

            // areas where "Meeting" must be dropped
            {
              groupId: "availableForMeeting",
              start: "2022-04-11T10:00:00",
              end: "2022-04-11T16:00:00",
              display: "background",
            },
            {
              groupId: "availableForMeeting",
              start: "2022-04-13T10:00:00",
              end: "2022-04-13T16:00:00",
              display: "background",
            },

            // red areas where no events can be dropped
            {
              start: "2022-04-24",
              end: "2022-04-28",
              overlap: false,
              display: "background",
              color: "#ff9f89",
            },
            {
              start: "2022-04-06",
              end: "2022-04-08",
              overlap: false,
              display: "background",
              color: "#ff9f89",
            },
          ],
        });

        calendar.render();
      });
    </script>

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
		</script>
      //----------- Revisar BOTON Mostrar solo cuando no haya datos de informacion de usuario -------------------
      
      <c:if test="${infousu == 'rellenar'}">//Crear model datosUsuario datos usuario(!= para que no salga)
         <script>
	      Swal.fire({
	        title: "<strong>¿Quieres rellenar tus datos de <u>perfil</u>?</strong>",
	        icon: "info",
	        html:
	          "Rellene estos <b>datos</b>, " + "para mejorar nuestros analisis.",
	        showCloseButton: true,
	        focusConfirm: false,
	        confirmButtonText:
	          '<a href="/usuario" class="btn">Rellenar datos personales</a> ',
	      });
	      </script>
      </c:if>
     <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
      <script>
      
            var noticias = document.querySelector("#noticias");
            var noticiasTitulo = document.querySelector(".titulonoticas");
      
            const options = {
              method: 'GET',
              url: 'https://free-news.p.rapidapi.com/v1/search',
              params: {q: 'Salud', lang: 'es', page: '1', page_size: '6'},
              headers: {
                'x-rapidapi-key': '90cad11506mshd20305fc7490e71p12fb87jsn442317af3e7f',
                'x-rapidapi-host': 'free-news.p.rapidapi.com'
              }
            };
      
            axios.request(options).then(function (response) {
            console.log(response.data.articles);
            if(response.status == "error"){
              noticiasTitulo.innerHTML = " ";
              const tituloError = document.createElement("h2");
              const titulo = document.createTextNode("No hay noticias disponibles");
              tituloError.appendChild(titulo);
              noticiasTitulo.appendChild(tituloError);
            }else{
              var noticiasinfo = response.data.articles;
              for (let res in noticiasinfo) {
                console.log(noticiasinfo[res].author);
                const paratitulo = document.createElement("p");
                const paratsubtitulo = document.createElement("p");
                const titulo = document.createTextNode(noticiasinfo[res].title);
                const subtitulo = document.createTextNode(
                noticiasinfo[res].author
                );
                paratitulo.classList.add("titulonoticia");
                paratitulo.appendChild(titulo);
                paratsubtitulo.classList.add("subtitulonoticia");
                paratsubtitulo.appendChild(subtitulo);
                const small = document.createElement("small");
                const autor = document.createTextNode(noticiasinfo[res].clean_url);
                small.appendChild(autor);
                const bloqueNoticia = document.createElement("article");
                bloqueNoticia.appendChild(paratitulo);
                bloqueNoticia.appendChild(paratsubtitulo);
                bloqueNoticia.appendChild(small);
                noticias.appendChild(bloqueNoticia);
              }
            }
          }).catch(function (error) {
                console.error(error);
            });
      /*
            //https://api.covid19api.com/summaryc6b3b3b47e703164d1f6c7e95be2364a
            const options = {
            method: "GET",
            headers: {
              "X-API-KEY": "YVOwOnUbZGiF-D6dy9orPA7blkmI8qMKi2YWOy7tSYo",
            },
          };
      */
      </script>
</body>
</html>