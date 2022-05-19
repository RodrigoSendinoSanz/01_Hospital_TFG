# Trabajo fin de grado Desarrollo de Aplicaciones Web
<img src="https://github.com/RodrigoSendinoSanz/01_Hospital_TFG/blob/main/MemoriaTFG/tfgcabezera.png" alt="cabecera">

  Aplicación web de gestión de servicios sanitarios online 

- Contenido/Contents
     - [Introducción](#Introducción)
     - [Objetivos del proyecto](#objetivos-del-proyecto)
     - [Módulos Formativos Aplicados en el TFG](##módulos-formativos-aplicados-en-el-tfg)
     - [Herramientas/Lenguajes Utilizados](#herramientaslenguajes-utilizados)
     - [Fases del Proyecto](#fases-del-proyecto)
     - [Conclusiones](#Conclusiones)
     - [Bibliografía](#Bibliografía)
     - [Anexos](#Anexos)



## Introducción
En este Trabajo Fin de Grado para el Ciclo Formativo de Grado Superior en Desarrollo de Aplicaciones Web, exponemos una aplicación web basada en la gestión servicios sanitarios en el ámbito de uso de medico/cliente.

Se ha elegido esta idea debido a la incipiente cantidad de servicios sanitarios online a consecuencia de esta pasada pandemia, en la cual, nos hemos podido percatar de una atención médica de forma telemática es algo necesario y ha llegado para quedarse y puede abrir nuevos campos e integraciones en la rama del desarrollo web que podría mejorar sustancialmente el uso del cualquier sistema sanitario, generando una sensación mucho más positiva y cercana para el usuario.

Esta aplicación web está enfocada para uso médico, ya que cuenta con diferentes campos e información almacenada del usuario que podrá consultar y actualizar los datos siempre que quiera, de estos datos se almacenarán sólo los más vitales, por lo que hace que la aplicación sea más ligera y rápida.

Con esta página web se trata de crear un sistema de gestión médica ágil y sencillo que facilite las gestiones tanto de los pacientes como de los médicos, generando un historial clínico que se puede consultar en cualquier momento, la capacidad de pedir citas y visualizar las mismas en un calendario, ver las medicinas asignadas y los datos de diagnóstico y físicos de forma individual y con tu médico, también se ha incorporado un sistema de mensajes con el cual puedes realizar una consulta a tu médico o poder enviar mensajes a otros pacientes, en definitiva crear una red sanitaria en la que puedas acceder de una forma clara y accesible a la información que necesites en el momento que necesites.

En conclusión, esta aplicación expone la información de manera que los pacientes puedan acceder fácilmente a ella y puedan interactuar para realizar consultas con su médico y realizar las funciones de citación médica y puedan visualizar las mismas de forma clara en su navegador, y puedan acceder hasta una descarga del pdf de la misma citación, esta aplicación pone toda la información a servicio del consultante para que pueda tener toda la información necesaria sobre sus citas médicas, medicinas, diagnósticos, sin que tenga que realizar ningún procedimiento dificultoso para el usuario.
----------
In this Final Degree Project for the Higher Degree Training Cycle in Web Application Development, we expose a web application based on the management of health services in the field of doctor/client use.

This idea has been chosen due to the incipient number of online health services as a result of this past pandemic, in which, we have been able to realize that telematic medical care is something necessary and has come to stay and can open new fields and integrations in the branch of web development that could substantially improve the use of any health system, showing a much more positive and close feeling for the user.

This web application is focused on medical use, since it has different fields and saved information of the user that can consult and update the data whenever he wants, of these data only the most vital will be stored, which makes the application more light and fast.

With this web page, it is about creating an agile and simple medical management system that facilitates the management of both patients and doctors, discovering a clinical history that can be consulted at any time, the ability to request appointments and view them. in a calendar, see the exposed medicines and the diagnostic and physical data individually and with your doctor, a message system has also been incorporated with which you can consult your doctor or be able to send messages to other patients, in definitively create a health network in which you can access in a clear and accessible way the information you need at the time you need.

In conclusion, this application exposes the information in a way that patients can easily access it and can interact to make consultations with their doctor and perform the functions of medical appointment and they can see the same clear forms in their browser, and they can access up to a download the pdf of the same citation, this application puts all the information at the service of the consultant so that he can have all the necessary information about his medical appointments, medications, diagnoses, without having to carry out any difficult procedure for the user.

## Objetivos del proyecto
-- Situación actual
Para diversificarnos y destacarnos en el mercado nos hemos fijado 3 factores diferenciadores. 
En esta sección  muestro los objetivos prioritarios y como los hemos reflejado nuestra propia estrategia.
- Cercanía
**Conseguir un trato directo y ágil**
Al tener la información accesible siempre que se quiera consultar creamos un trato sincero y directo

- Cercanía
**Criterios de diseño y opciones de usuario**
Abordando temas de accesibilidad utilizamos un diseño sencillo y con opciones inclusivas para todos.

- Interactividad
**Chat interno**
Se incorporan un chat donde los usuarios pueden interactuar entre si

-- Sistemas actuales
Con el fin de realizar un estudio de la competencia y comprobar los diferentes proyectos en curso de los diferentes sistemas de gestión sanitaria hemos realizado esta tabla:


| Nombre              | Descripción                                                                      | Datos interesantes                            |
|---------------------|----------------------------------------------------------------------------------|-----------------------------------------------|
| Jimena              | Servicio de Informático de Hospital                                              | Buena aceptación de los medicos               |
|                     |                                                                                  | Telemedicina                                  |
| SACYL conecta       | Aplicación de gestión de citas en Castilla y Leon                                | Posibilidad de revisar y descargar documentos |
|                     |                                                                                  | Búsqueda de centros cercanos                  |
| Mi Carpeta de Salud | Consulta su información clínica, citas sanitarias y otros servicios en Madrid    | Acceso mediante cl@ve, dni electronico...     |
| Clic Salud+         | Consulta su información clínica, citas sanitarias y otros servicios en Andalucía | Consulta de datos personales                  |

# Módulos Formativos Aplicados en el TFG
Durante el desarrollo del proyecto, hemos utilizado diferentes los módulos del grado los cuales son:
#### Programación y Desarrollo Web Entorno Servidor
En el  **Back-End** de la aplicación se ha utilizado el lenguaje de programación  **Java** utilizando el paradigma de programación orientada a objetos, esta parte se encarga de darle todo el dinamismo de la pagina y controla su lógica.
#### Lenguajes de Marcas y Desarrollo Web Entorno Cliente
Hemos utilizado esta asignatura para la parte  **Front-End** aplicando el  **HTML** (estructura),  **CSS** (estilos) y  **JavaScript** (Peticiones a apis, alertas).
Javascript tambien se ha utilizado en el formulario de registro para validar la información introducida.
#### Bases de Datos
En nuestra aplicación hemos creado un esquema de base de datos que consta de 10 tablas, con diferentes relaciones, las tablas son:

- usuario
- usuario_perfil
- perfil
- diagnostico
- información
- cita
- historial clinico
- medicina
- tipo
- comentarios

Mas adelante exploraremos mas afondo estas tablas.
#### Entornos de Desarrollo
Con el fin de realizar un versionado de la aplicación se ha utilizado git el cual es  un software de control de versiones diseñado por Linus Torvalds y tambien hemos realizado la plataforma GitHub creando el repositorio de este mismo proyecto.
#### Despliegue de Aplicaciones Web
Hemos utilizado este modulo para realizar un resumen/tutorial de como realizar el despliegue de esta aplicación.
#### Diseño de Interfaces Web
En este modulo se basa todo el sistema de estilo y esquema visual de la pagina, creando la guía visual y el wireframe de la aplicación junto a su modelo totalmente responsive.
Tambien hemos trabajado las asignaturas de  **Ingles** traduciendo la introducción de este trabajo e Empresa e  **Iniciativa Emprendedora** en los puntos anteriores de Situación actual y Sistemas actuales
----------

## Herramientas/Lenguajes Utilizados
A continuación vamos a mostrar las herramientas y lenguajes que hemos utilizado en esta aplicación.
#### Eclipse Java EE
Eclipse es un entorno de desarrollo software multi-lenguaje construido alrededor de un workspace al que pueden incluirse un gran número de plug-ins que proporcionan funcionalidades concretas relacionadas con lenguajes específicos o con la interacción con otras herramientas implicadas en el desarrollo de una aplicación.
#### MySQL WorkBench
MySQL Workbench es una herramienta visual de diseño de bases de datos que integra desarrollo de software, administración de bases de datos, diseño de bases de datos, gestión y mantenimiento para el sistema de base de datos MySQL.
#### Visual Studio Code
Visual Studio Code es un editor de código fuente desarrollado por Microsoft para Windows, Linux, macOS y Web. Incluye soporte para la depuración, control integrado de Git, resaltado de sintaxis, finalización inteligente de código, fragmentos y refactorización de código. 

También es personalizable, por lo que los usuarios pueden cambiar el tema del editor, los atajos de teclado y las preferencias. Es gratuito y de código abierto,1​2​ aunque la descarga oficial está bajo software privativo e incluye características personalizadas por Microsoft.
#### Git / GitHub
GitHub es una forja (plataforma de desarrollo colaborativo) para alojar proyectos utilizando el sistema de control de versiones Git. Se utiliza principalmente para la creación de código fuente de programas de ordenador. 

El software que opera GitHub fue escrito en Ruby on Rails. Desde enero de 2010, GitHub opera bajo el nombre de GitHub, Inc. Anteriormente era conocida como Logical Awesome LLC. El código de los proyectos alojados en GitHub se almacena generalmente de forma pública.​
#### Spring
Spring es un framework del lenguaje de programación java, y un framework en programación es el resultado de la evolución de la ingeniería del software, estos son creados por programadores para programadores, con la finalidad de estandarizar el trabajo, resolver, agilizar y manejar los problemas y complejidades que van apareciendo en el mundo de la programación, a medida las exigencias van creciendo. Creando así, en la comunidad de desarrolladores, un abanico de posibilidades para una creación cada vez más evolucionada de aplicaciones.​
###  Lenguajes Utilizados
- Java
Java es un lenguaje de programación orientado a objetos que se incorporó al ámbito de la informática en los años noventa. La idea de Java es que pueda realizarse programas con la posibilidad de ejecutarse en cualquier contexto, en cualquier ambiente, siendo así su portabilidad uno de sus principales logros. 

Fue desarrollado por Sun Microsystems, posteriormente adquirido por Oracle. En la actualidad puede utilizarse de modo gratuito, pudiéndose conseguir sin problemas un paquete para desarrolladores que oriente la actividad de programar en este lenguaje. Puede ser modificado por cualquiera, circunstancia que lo convierte en lo que comúnmente se denomina “código abierto”.

- JavaScript
JavaScript es el lenguaje de programación encargado de dotar de mayor interactividad y dinamismo a las páginas web. Cuando JavaScript se ejecuta en el navegador, no necesita de un compilador. El navegador lee directamente el código, sin necesidad de terceros. Por tanto, se le reconoce como uno de los tres lenguajes nativos de la web junto a HTML (contenido y su estructura) y a CSS (diseño del contenido y su estructura).
----------


## Fases del Proyecto
Esta sección expondremos los diferentes ciclos que ha tenido el proyecto:
#### Idea
El equipo, después de pensar varias ideas para realizar su trabajo fin de grado (TFG). Nos surgen algunas ideas, las cuales eran montar un blog donde usuario intercambien información sobre diversos temas o una web de un restaurante de comida. Después de meditarlo optamos por realizar un proyecto que auné estos conceptos y sea algo actual, por lo que se opto por realizar una aplicación web de gestión medica.
#### Casos de Uso 
El diagrama de casos de uso es una forma de diagrama de comportamiento en lenguaje de modelado unificado (UML, del inglés Unified Modelling Language), con la que se representan procesos empresariales, así como sistemas y procesos de programación orientada a objetos.

En nuestro proyecto los actores involucrados en los casos de uso son: Paciente y Médico (Mas info en el pdf)
#### WireFrame
Para hacer el wireframe he utilizado la herramienta de figma para crear como será la interfaz de usuario (UI) y teniendo en consideración la experiencia de usuario (UX) , con la finalidad de crear un diseño simple y que te aporte la información precisa a el alcance de un click, primando los bordes redondeados y diseñando también teniendo muy en cuenta los dispositivos móviles, haciendo uso de diseño enteramente responsivo.
#### Guía de Estilos
Las guías de estilo, también denominadas libros de estilo, hacen referencia en el ámbito del marketing online a los manuales para el diseño uniforme de páginas web. Aquí, muestro la guía de estilo de este proyecto. 

| Color             | Hex      |
|-------------------|----------|
| --blue            |  #287bff |
| --white           |  #fff    |
| --grey            |  #f5f5f5 |
| --black1          |  #222    |
| --black2          |  #999    |
| Realizado         |  #8de02c |
| Pendiente         |  #f9ca3f |
| Cancelado         |  #f00    |
| Enprogreso        |  #1795c9 |

Tipografia: 'Poppins', sans-serif;
font-size: 2em
font-weight: 500
**Estilo de cajas:**
border-radius: 20px
box-shadow: 0 7px 25px rgb(0 0 0 / 8%)
#### Bases de Datos
Como nuestra aplicación va a tener: usuarios con sus respectivos datos, medicinas que se pueden recetar, las citas de cuando te podrán atender, el historial medico de cada  usuario, necesitaremos un sitio donde poder almacenar esos datos.

Por eso tenemos que crear una Base de datos utilizando SQL como lenguaje y MySQL Workbench como herramienta además de poder almacenar los datos también podemos: acceder, modificarlos, o guardar nuevos registros.
Para este caso se decidió crear un esquema de datos que reúna los datos que vemos necesarios para el mejor funcionamiento de la aplicación.
Hemos utilizado DDL (Lenguaje de Definición de Datos) para crear la base de datos y DML (Lenguaje de Manipulación de Datos) para insertar y manipular la información.
#### HTML
HTML (HyperText Markup Language) es un lenguaje de marcas utilizado para crear paginas web con este lenguaje podremos mostrar el contenido de la web.

Esto se hace utilizando como herramienta el Visual Studio Code, no es obligatorio usar esta herramienta pero es bastante cómoda.
#### CSS
Para los estilos de este proyecto se contará con 3 archivos css los cuales son: 

- style.css
- stylelogin.css
- styleusuario.css

También se han realizados pequeños ajustes puntuales e individuales utilizando <style> dentro del html, para realizar un diseño lo mas responsivo posible se ha utilizado el inspector del navegador para ir creando las mediaquerys necesarias.
Igualmente también se han utilizado keyframes para la animación del icono y efectos de hover para recalcar botones o campos interactivos.
Las mediaquerys van desde los @media (max-width:1910px) a los @media (max-width: 320px)
#### JS
En la parte del desarrollo front hemos incorporado una api que muestra las citas que tiene cada usuario en un calendario utilizando la api: https://fullcalendar.io/demos y también realizamos otra llamada a otra api, que nos muestra un panel de noticias relacionadas con sanidad, con el fin de enriquecer el contenido de la web utilizando la librería axios para manejar las peticiones AJAX: https://rapidapi.com/search/news e insertando esta información utilizando la creación de elementos textos y nodos de js
#### API´s
En la parte del desarrollo front hemos incorporado una api que muestra las citas que tiene cada usuario en un calendario utilizando la api: https://fullcalendar.io/demos y también realizamos otra llamada a otra api, que nos muestra un panel de noticias relacionadas con sanidad, con el fin de enriquecer el contenido de la web utilizando la librería axios para manejar las peticiones AJAX: https://rapidapi.com/search/news e insertando esta información utilizando la creación de elementos textos y nodos de js
#### Modelo, Vista, Controlador (MVC)
El Modelo-Vista-Controlador es una arquitectura software.
Se encarga de recibir en el controlador la petición enviada por usuario, una vez recibida la petición el controlador analizara que tiene que hacer y pedirá tanto los datos como las funciones que necesita de los modelo para así poder procesar la información y pasársela a la vista que esta será recibida por el cliente, el cual podrá visualizarlo en su buscador
#### Apache Tomcat
Apache Tomcat es un contenedor de servlets que se puede usar para compilar y ejecutar aplicaciones web realizadas en Java. Implementa y da soporte tanto a servlets como a páginas JSP (Java Server Pages) o Java Sockets. Además, Tomcat es compatible con otras tecnologías como Java Expression Language y Java WebSocket, del ecosistema Java.
Estructura de directorios:
- bin - arranque, cierre, y otros scripts y ejecutables.
- common - clases comunes.
- conf - ficheros XML y los correspondientes DTD 
- logs - logs de Catalina y de las aplicaciones
- server - clases utilizadas solamente por Catalina
- shared - clases compartidas por las aplicaciones web.
- webapps - directorio que contiene las aplicaciones web.
- work - almacenamiento temporal de ficheros y directorio
Tambien podemos utilizar Heroku como esplicamos en el pdf
----------


## Conclusiones
Rellenar
----------


## Bibliografía
Rellenar
----------


# Anexos
Rellenar
----------



Creado por/Created by: 
Rodrigo Sendino Sanz - Ignacio Viseras Riego
