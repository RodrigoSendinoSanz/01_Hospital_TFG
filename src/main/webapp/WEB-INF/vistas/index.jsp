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
      .botones {
      		position: relative;
		    padding: 5px 10px;
		    background: var(--white);
		    color: var(--blue);
		    border: 1px solid var(--blue);
		    text-decoration: none;
		    border-radius: 6px;
		    display: inline-block;
		    margin: 3px;
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

        <div class="cardBox">
          <a href="/medicinas">
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
          <a href="/historialclinico">
            <div class="card">
              <div>
                <div class="numbers">Historial</div>
                <div class="cardName">Tu historial clinico</div>
              </div>
              <div class="iconBox">
                <ion-icon name="pulse-outline"></ion-icon>
              </div>
            </div>
          </a>
          <a href="/todoschat">
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
          <a href="/medicos">
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
            <sec:authorize access="hasAuthority('Paciente')"><a href="/cita" class="btnCita">Pedir cita</a></sec:authorize>
          </div>
          <div class="caja">
            <p class="titulonoticas">Noticias:<br /></p>
            <div id="noticias"></div>
          </div>
        </div>

        <div class="details">
        <sec:authorize access="hasAuthority('Paciente')">
          <div class="recentCitas">
            <div class="cardHeader">
              <h2>Ultimas citas</h2>
              <a href="/todas" class="btnblue">Ver todas</a>
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
              <c:forEach var="ele" items="${citasLista }">
                <tr>
                  <td>${ele.fechaCita}</td>
                  <td>${ele.direccionCentrosalud}</td>
                  <td><span class="status ${ele.estado}">${ele.estado}</span></td>
                  <td><a href="/verUna/${ele.idCita}" class="btnMas">Ver mas</a></td>
                </tr>
               </c:forEach>  
              </tbody>
            </table>
          </div>
         </sec:authorize>
          
		<sec:authorize access="hasAuthority('Medico')">
           <div class="recentCitas">
            <div class="cardHeader">
              <h2>Ultimas citas</h2>
              <a href="/todasMed" class="btnblue">Ver todas</a>
            </div>
            <table>
              <thead>
                <tr>
                  <td>Fecha</td>
                  <td>Dirección</td>
                  <td>Estado</td>
                  <td>Opciones</td>
                </tr>
              </thead>
              <tbody>
               <c:forEach var="ele" items="${citasListaMedico }">
	                <tr>
	                  <td>${ele.fechaCita}</td>
	                  <td>${ele.direccionCentrosalud}</td>
	                  <td><span class="status ${ele.estado}">${ele.estado}</span></td>
	                  <td>
	                    <a href="/borraUna/${ele.idCita}" class="botones cancelar">Cancelar</a> 
	                    <a href="/editarUna/${ele.idCita}" class="botones">Editar</a>
	                  </td>
	                </tr>
                </c:forEach> 
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
                 <c:forEach var="usu" items="${ListUsuCone }">
						 <tr>
			                  <td width="60px">
			                    <div class="imgBx"><a href="/chat"><img src="${usu.imgurl }" alt="icono" /></a></div>
			                  </td>
			                  <td>
			                    <h4>${usu.nombre } <br /><span>${usu.apellido }</span></h4>
			                  </td>
		                </tr>
				</c:forEach>
                
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
                  
                  // PASAR UN MODEL DESDE PEDIR CITA ----------Ejecutar solo si viene de poner cita---------------
                  
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
			<sec:authorize access="hasAuthority('Paciente')">
	            <c:forEach var="ele" items="${citasLista }">
	            {
	                title: `Cita en : ${ele.direccionCentrosalud}, Fecha:${ele.fechaCita}/${ele.horaCita}, Medico:${ele.nombreMedico}`,
	                start: `${ele.fechaCita}T${ele.horaCita}:00`,
	                constraint: "availableForMeeting", // defined below
	                color: "#257e4a",
	              },
	
	           </c:forEach>
	        </sec:authorize>
			<sec:authorize access="hasAuthority('Medico')">
            <c:forEach var="ele" items="${citasListaMedico }">
            {
                title: `Cita en : ${ele.direccionCentrosalud}, Fecha:${ele.fechaCita}/${ele.horaCita}, Paciente:${ele.nombrePaciente}`,
                start: `${ele.fechaCita}T${ele.horaCita}:00`,
                constraint: "availableForMeeting", // defined below
                color: "#257e4a",
              },

           </c:forEach>
        </sec:authorize>
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
      
      
       <c:if test="${mensaje == 'correcto'}">
        console.log("pasa por el if");
         <script>
         	Swal.fire("Guardado!", "", "success");
	      </script>
      </c:if>
      <c:if test="${infousu == 'rellenar'}">
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
      /*---------- Descomentar para las noticias
            const options = {
              method: 'GET',
              url: 'https://free-news.p.rapidapi.com/v1/search',
              params: {q: 'Salud', lang: 'es', page: '1', page_size: '6'},
              headers: {
                'x-rapidapi-key': '90cad11506mshd20305fc7490e71p12fb87jsn442317af3e7f',
                'x-rapidapi-host': 'free-news.p.rapidapi.com'
              }
            };
      ----------- Descomentar para las noticias */
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

      </script>
</body>
</html>
