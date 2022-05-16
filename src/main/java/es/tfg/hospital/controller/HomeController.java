package es.tfg.hospital.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.tfg.hospital.modelo.beans.Cita;
import es.tfg.hospital.modelo.beans.Diagnostico;
import es.tfg.hospital.modelo.beans.HistorialClinico;
import es.tfg.hospital.modelo.beans.Informacion;
import es.tfg.hospital.modelo.beans.Medicina;
import es.tfg.hospital.modelo.beans.Perfil;
import es.tfg.hospital.modelo.beans.Usuario;
import es.tfg.hospital.modelo.dao.IntCitaDao;
import es.tfg.hospital.modelo.dao.IntDiagnosticoDao;
import es.tfg.hospital.modelo.dao.IntHistorialClinicoDao;
import es.tfg.hospital.modelo.dao.IntInformacionDao;
import es.tfg.hospital.modelo.dao.IntMedicinaDao;
import es.tfg.hospital.modelo.dao.IntPerfilDao;
import es.tfg.hospital.modelo.dao.IntUsuarioDao;

@Controller
//@RequestMapping("/pruebas")
public class HomeController {

	@Autowired
	private PasswordEncoder pwenco;

	//@Autowired
	//private IntLibroDao ldao;
	
	@Autowired
	private IntUsuarioDao udao;
	
	@Autowired
	private IntPerfilDao pdao;

	@Autowired
	private IntDiagnosticoDao ddao;
	
	@Autowired
	private IntInformacionDao idao;
	
	@Autowired
	private IntCitaDao cdao;
	
	@Autowired
	private IntMedicinaDao mdao;
	
	@Autowired
	private IntHistorialClinicoDao hdao;
	

	/**
	 * Comprobamos si la session del usuario esta guardada
	 * @param misesion
	 * @return accede al index en caso de tener la session iniciada 
	 * /si no accederemos al login
	 */
	@GetMapping("")
	public String acceso(HttpSession misesion){
		if(misesion.getAttribute("dni") == null) {//comprobamos si la session esta guardada el idSessCuent se crea en la linea 57
			return "redirect:/login";//si da nulo significa q no y lo metemos en el login
		}else {
			return "redirect:/index";//de ser asi iniciamos 
		}
	}
	
	/**
	 * Acceso al login
	 * @param model
	 * @return login
	 */
	@GetMapping(value={"/login"})
	public String mostrarFormInicio(Model model) {
		return "login";
	}


	/**
	 * Acceso al index
	 * @param aut
	 * @param model
	 * @param misesion
	 * @return
	 */
	@GetMapping("/index")
	public String procesarLogin(Authentication aut, Model model, HttpSession misesion) {
		String rol =null;
		
		if (aut != null) {
			model.addAttribute("usuario", aut.getName());
			
			for (GrantedAuthority ele: aut.getAuthorities()) {
				rol=ele.getAuthority();
			}
		
			model.addAttribute("autorizaciones", aut.getAuthorities());
			misesion.setAttribute("autorizaciones", aut.getAuthorities());
			misesion.setAttribute("icono", udao.buscarUsuario(aut.getName()).getImgurl());
			misesion.setAttribute("password", udao.buscarUsuario(aut.getName()).getPassword());
			misesion.setAttribute("dni", udao.buscarUsuario(aut.getName()).getDni());
			misesion.setAttribute("nombre", udao.buscarUsuario(aut.getName()).getNombre());
			model.addAttribute("dni", aut.getName());
			misesion.setAttribute("usuario", udao.buscarUsuario(aut.getName()));
			misesion.setAttribute("usuarioInfo", idao.buscarInformacion(aut.getName()));
			misesion.setAttribute("usuarioDia", ddao.buscarDiagnostico(aut.getName()));
			udao.buscarUsuario(aut.getName()).setOnlineusu(1);
			
			List<Usuario> ListUsuCone= udao.buscarConectados(udao.buscarUsuario(aut.getName()).getDni());
			model.addAttribute("ListUsuCone",ListUsuCone);
			misesion.setAttribute("numeroMedicos", udao.contarMedicos());
			
			if(rol.equalsIgnoreCase("Paciente")){
				List<Cita> citasLista= cdao.buscarCitas((String) model.getAttribute("dni"));
				model.addAttribute("citasLista",citasLista);
				System.out.println("INFO:       /// "+aut.getAuthorities().toString());//lo borro?
			}else if (rol.equalsIgnoreCase("Medico")){
				List<Cita> citasListaMedico= cdao.buscarCitasPorMedico((String) model.getAttribute("usuario"));
				model.addAttribute("citasListaMedico",citasListaMedico);
				System.out.println(citasListaMedico.toString());
				System.out.println("INFO:       /// "+aut.getAuthorities().toString());//lo borro?
				misesion.setAttribute("citasListaMedico",citasListaMedico);
			}else {
				return "redirect:/";
			}
			
			if (idao.buscarInformacion(aut.getName()) == null) {
				model.addAttribute("infousu", "rellenar");
				System.out.println(" Infos Rellenar");
			} else {
				model.addAttribute("infousu", "norellenar");
				System.out.println("Infos Completos");
			}
			
			Usuario usuario = udao.buscarUsuario(aut.getName());
			usuario.setOnlineusu(1);
			udao.editarUsuario(usuario);
			
			// Generamos la lista con las novedades respecto a los libros
			//List<Libro> lista = ldao.buscarNovedades();
			//model.addAttribute("listaNovedades", lista);

			//model.addAttribute("listaTemas", tdao.buscarTodos());
			//ArrayList<Libro> listaCarrito = (ArrayList<Libro>) misesion.getAttribute("listaCarrito");

			//misesion.setAttribute("listaCarrito", listaCarrito);
			//misesion.setAttribute("nombreusuario", aut.getName());
			return "index";
		} else {
			System.out.println("procesar else");
			model.addAttribute("error", "error");//NO LE LLEGA EL ERROR
			return "/login";//IMPORTANTE NO MUESTAR LA ALETRA DEL EL ERROR
		}

	}

	/**
	 * Ver detalles del libro
	 * @param model
	 * @param isbn
	 * @return
	 */
	@GetMapping("/verDetalle/{id}")
	public String mostrarVerDetalleLibro(Model model, @PathVariable("id") long isbn) {
		//Libro libro = ldao.buscarLibro(isbn);

		//model.addAttribute("libro", libro);

		return "/verDetalle";
	}

	@GetMapping("/buscarCitaPorNombre")
	public String buscarCitaPorNombre(Model model) {
		return "todas";
	}
	
	@PostMapping("/buscarCitaPorNombre")
	public String buscarCitaPorNombre(Model model, HttpSession misesion,@RequestParam("nombre") String nombre ) {
		List<Cita> citasDelUsaurio= (List<Cita>) cdao.buscarCitaPorNombre(nombre);
		model.addAttribute("citas",citasDelUsaurio);
		return "todas";
	}
	
	/**
	 * Mostrando todos los libros
	 * @param model
	 * @return
	 */
	@GetMapping("/usuario")
	public String mostrarUsuario(Model model) {
		return "usuario";
	}
	
	/**
	 * Mostrar 1 solo usaurio opteniendo su nombre
	 * @param model
	 * @param nombre
	 * @return
	 */
	@GetMapping("/verUsuario/{nombre}")
	public String verUnUsuario(Model model,@PathVariable String nombre) {
		System.out.println("entra usuario");
		Usuario usuariover= new Usuario();
		usuariover=udao.buscarUsuarioPorNombre(nombre);
		model.addAttribute("usuariover", usuariover);
		System.out.println("Pasa usuario");
		String dniusu= usuariover.getDni();
		Informacion infromacionver = new Informacion();
		infromacionver=idao.buscarInformacion(dniusu);
		model.addAttribute("infover", infromacionver);
		System.out.println("Pasa informacion");

		
		Diagnostico diagnosticonver = new Diagnostico();
		diagnosticonver=ddao.buscarDiagnostico(dniusu);
		model.addAttribute("diagnosticonver", diagnosticonver);
		System.out.println("Pasa diagnostico");
		
		return "usuarioVer";
	}
	


	/**
	 * Mostrando todos los Temas
	 * @param model
	 * @return
	 */
	@GetMapping("/cliente/temas")
	public String mostrarTemas(Model model) {

		//model.addAttribute("listaTemas", tdao.buscarTodos());
		return "temasTodos";
	}

	/**
	 * Mostrando uno de los Temas
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/cliente/tema/{idTema}")
	public String mostrarlibrosTema(Model model, @PathVariable("idTema") int id) {
		//model.addAttribute("tema", tdao.buscarTema(id));
		//model.addAttribute("listaLibrosTema", ldao.buscarporTema(id));
		return "verTema";
	}

	/**
	 * Eliminar Libros
	 * @param model
	 * @param isbn
	 * @return
	 */
	@GetMapping("/eliminar/{id}")
	public String procEliminar(Model model, @PathVariable("id") long isbn) {

		//long i = ldao.eliminarLibro(isbn);
		//if (i == 0)
			model.addAttribute("mensaje", "Libro no eliminado");
		//else {
//			Volvemos a traer la lista de novedades
		//	model.addAttribute("listaNovedades", ldao.buscarNovedades());
			//model.addAttribute("mensaje", "Libro eliminado");
		//}
		return "menuPrincipal";
	}

	@GetMapping("/editar/{id}")
	public String editarLibro(Model model, @PathVariable("id") long isbn) {
		//model.addAttribute("libro", ldao.buscarLibro(isbn));
		return "editarLibro";
	}
	/*
	@PostMapping("/editar")
	public String procEditarLibro(RedirectAttributes ratt, @RequestParam("isbn") long isbn,
			@RequestParam("titulo") String titulo,
			@RequestParam("autor") String autor) {

		Libro libro = ldao.buscarLibro(isbn);
		libro.setTitulo(titulo);
		libro.setAutor(autor);
		libro.setPrecioUnitario(precioUnitario);
		 
		int result = ldao.editarLibro(libro);

		if (result == 0) {
			ratt.addFlashAttribute("mensaje", "Ha fallado la edicion del libro");
			return "redirect:/";
		} else {
			ratt.addFlashAttribute("mensaje", "El libro se ha editado correctamente");
			return "redirect:/";
		}
		
	}
 	*/
	
	@PostMapping("/cliente/buscar")
	public String buscarLibro(Model model, @RequestParam("busquedalibro") String busquedalibro) {

		//model.addAttribute("libro", ldao.buscarLibroTitulo(busquedalibro));
		return "librosBusqueda";
	}

	@GetMapping("/addCarrito/{id}")
	public String addCarrito(Model model, @PathVariable("id") long isbn, HttpSession misesion) {
		/*
		 Libro addlib = ldao.buscarLibro(isbn);

		System.out.println(addlib);

		System.out.println(misesion.getAttribute("nombreusuario"));
		Pedido pedido = new Pedido(0,
				udao.buscarUsuario((String) misesion.getAttribute("nombreusuario")).getDireccion(), "En carrito",
				new Date(), null, udao.buscarUsuario((String) misesion.getAttribute("nombreusuario")));

		if (misesion.getAttribute("pedidoCarrito") == null) {
			LineasPedido lp = new LineasPedido(0, 1, new Date(), addlib.getPrecioUnitario(), addlib, pedido);

			List<LineasPedido> listapedido = new ArrayList<>();
			System.out.println("El isbn es " + isbn);
			listapedido.add(lp);

			pedido.setLineasPedidos(listapedido);

			model.addAttribute("listaPedido", listapedido);
			misesion.setAttribute("listaPedido", listapedido);
			misesion.getAttribute("nombreusuario");
			model.addAttribute("usuario", misesion.getAttribute("nombreusuario"));
			model.addAttribute("autorizaciones", misesion.getAttribute("autorizaciones"));

			pedao.insertUno(pedido);
			int pedidocarrito = pedido.getIdPedido();
			System.out.println("Este es el pedido " + pedido.toString());
			misesion.setAttribute("pedidoCarrito", pedidocarrito);
			lpdao.insertUno(lp);
		} else {
			LineasPedido lp = new LineasPedido(0, 1, new Date(), addlib.getPrecioUnitario(), addlib, pedido);

			List<LineasPedido> listapedido = new ArrayList<>();

			listapedido.add(lp);

			pedido.setLineasPedidos(listapedido);
			System.out.println(
					"lpdao.buscarIdPedido(pedido.getIdPedido()) ==== " + lpdao.buscarIdPedido(pedido.getIdPedido()));
			System.out.println("AUX:" + misesion.getAttribute("RegIdPedido"));
			System.out.println(
					"lpdaoAux   ====    " + lpdao.buscarIdPedido((int) misesion.getAttribute("pedidoCarrito")));
			model.addAttribute("listaPedido", lpdao.buscarIdPedido((int) misesion.getAttribute("pedidoCarrito")));
			misesion.setAttribute("listaPedido", listapedido);
			misesion.getAttribute("nombreusuario");
			model.addAttribute("usuario", misesion.getAttribute("nombreusuario"));
			model.addAttribute("autorizaciones", misesion.getAttribute("autorizaciones"));
			addlib.setIsbn(isbn);
			pedido.setIdPedido((int) misesion.getAttribute("pedidoCarrito"));
			addlib.setIsbn(isbn);
			int pedidocarrito = pedido.getIdPedido();
			misesion.setAttribute("pedidoCarrito", pedidocarrito);
			lpdao.insertUno(lp);

		}
		 */
		return "redirect:/verCarrito";

	}

	@GetMapping("/verCarrito")
	public String verCarrito(Model model, HttpSession misesion) {

		// ArrayList<Libro> carrito = (ArrayList<Libro>)
		// misesion.getAttribute("listaCarrito");

		// List<LineasPedido> listapedido = (List<LineasPedido>)
		// misesion.getAttribute("listaPedido");
		/*
		if (misesion.getAttribute("pedidoCarrito") == null) {

			return "verCarrito";
		} else {
 
			model.addAttribute("listaPedido", lpdao.buscarIdPedido((int) misesion.getAttribute("pedidoCarrito")));
			model.addAttribute("usuario", misesion.getAttribute("nombreusuario"));
			return "verCarrito";
			
		}
		*/
		return "verCarrito";

	}


	@GetMapping("/cliente/comprar/{id}")
	public String compraLibros(Model model, @PathVariable("id") int numOrden, HttpSession misesion) {
		/*
		misesion.getAttribute("listapedido");

		int i = lpdao.editarLineasPedido(lpdao.buscarLineasPedido(numOrden));

		if (i == 0)
			model.addAttribute("mensaje", "Libro del carrito no eliminado");
		else {
//			Volvemos a traer la lista de novedades
			model.addAttribute("listaNovedades", ldao.buscarNovedades());
			model.addAttribute("mensaje", "Libro del carrito eliminado");
			model.addAttribute("usuario", misesion.getAttribute("nombreusuario"));
		}
		 		*/
		return "redirect:/";

	}

	@GetMapping("/eliminarDeCarrito/{id}")
	public String procEliminarDeCarrito(Model model, @PathVariable("id") int numOrden, HttpSession misesion) {
/*
		misesion.getAttribute("listapedido");

		lpdao.buscarLineasPedido(0);

		List<LineasPedido> listapedido = (List<LineasPedido>) misesion.getAttribute("listaPedido");

		int i = lpdao.eliminarPorNumeroOrden(numOrden);

		if (i == 0)
			model.addAttribute("mensaje", "Libro del carrito no eliminado");
		else {
//			Volvemos a traer la lista de novedades
			model.addAttribute("listaNovedades", ldao.buscarNovedades());
			model.addAttribute("mensaje", "Libro del carrito eliminado");
			model.addAttribute("usuario", misesion.getAttribute("nombreusuario"));
//			listapedido.remove(0);
		}
		*/
		return "menuPrincipal";
	}

	/**
	 * Dar de alta un tema
	 * @return
	 */
	@GetMapping("/admon/altaTema")
	public String mostrarAltaTema() {

		return "altaTema";
	}

	@PostMapping("/admon/altaTema")
	public String procesarAltaTema(Model model) {

		/*int reg = tdao.insertUno(tema);

		// Depende si el alta se realiza o no, vamos a mandar un mensaje a la barra de
		// direcciones
		// informando de lo que ha pasado.
		if (reg == 0)
			model.addAttribute("mensaje", "Tema no insertado");
		else {
			model.addAttribute("mensaje", "Tema dado de alta correctamente");
		}*/
		return "redirect:/";

	}

	@GetMapping("/admon/altaLibro")
	public String mostrarAltaLibro(Model model) {
		//model.addAttribute("listaTemas", tdao.buscarTodos());
		return "altaLibro";
	}

	@PostMapping("/admon/altaLibro")
	public String procesarAltaLibro(Model model,  Usuario usuario) {
		/*
		int lib = ldao.insertUno(libro);
		// Depende si el alta se realiza o no, vamos a mandar un mensaje a la barra de
		// direcciones
		// informando de lo que ha pasado.

		if (lib == 0)
			model.addAttribute("mensaje", "Libro no insertado");
		else if (lib == 2) {
			model.addAttribute("mensaje", "Ya existe ese libro");
		} else {
			model.addAttribute("mensaje", "Libro dado de alta correctamente");
		}
		*/
		return "redirect:/";

	}

	@GetMapping("/datos/{usuario}")
	public String mostrarVerDetalleLibro(Model model, @PathVariable("usuario") String usuario, HttpSession misesion) {
		/*
		Usuario usuarioDatos = udao.buscarUsuario(usuario);
		if (misesion.getAttribute("pedidoCarrito") == null) {
			model.addAttribute("usuarioDatos", usuarioDatos);
			return "verUsuario";
		} else {
			model.addAttribute("listaPedido", lpdao.buscarIdPedido((int) misesion.getAttribute("pedidoCarrito")));
			model.addAttribute("usuarioDatos", usuarioDatos);
		 */
			return "verUsuario";
		//}

	}
	/**
	 * muestra una cita
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/verUna/{id}")
	public String mostrarCita(Model model,@PathVariable int id) {
		Cita cita= new Cita();
		cita=cdao.buscarUnaCita(id);
		model.addAttribute("cita", cita);
		
		return "verUna";
	}
	
	/**
	 * Get para editar una cita
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/editarUna/{id}")
		public String mostrarEditar(Model model,@PathVariable int id) {
		Cita cita= new Cita();
		cita=cdao.buscarUnaCita(id);
		
		List<Medicina> medicinaLista = new ArrayList<Medicina>();
		medicinaLista=mdao.buscarTodasMedicinas();
		model.addAttribute("cita", cita);
		model.addAttribute("medicinaLista", medicinaLista);
		return "editarUna";
		}
	
	@PostMapping("/editarUna")
	public String editarUna(Model model, @RequestParam("idCita") String idCita,
			@RequestParam("fechaCita") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaCita,
			@RequestParam("horaCita") String horaCita, @RequestParam("direccionCentrosalud") String direccionCentrosalud, 
			@RequestParam("sintomas") String sintomas, @RequestParam("estado") String estado, @RequestParam("nombreMed") String nombreMed) {
		Cita cita= new Cita();
		cita.setFechaCita(fechaCita);
		cita.setHoraCita(horaCita);
		cita.setDireccionCentrosalud(direccionCentrosalud);
		cita.setSintomas(sintomas);
		cita.setEstado(estado);
		Medicina medicina= new Medicina();
		System.out.println(cita);
		cdao.editarCita(cita);
		medicina.setNombreMed(nombreMed);
		HistorialClinico historialClinico = new HistorialClinico(idCita, estado, cita, medicina);
		System.out.println("6546546546545465"+historialClinico);
		int result = hdao.insertUna(historialClinico);
		
		if (result == 0) {
			model.addAttribute("mensaje", "incorreccto");
			return "redirect:/editarUna";
		} else {
			model.addAttribute("mensaje", "correcto");
			return "redirect:/index";
		}
	}
	
	@GetMapping("/pedircita")
	public String mostrarPedirCita(Model model) {
		List<Usuario> listaDeMedicos = new ArrayList<Usuario>(udao.listaMedicos());
		model.addAttribute("listaDeMedicos",listaDeMedicos);
		return "cita";
	}

	/**
	 * Post para pedir una cita
	 * @param model
	 * @param redir
	 * @param idCita
	 * @param fechaCita
	 * @param horaCita
	 * @param estado
	 * @param direccionCentrosalud
	 * @param sintomas
	 * @return
	 */
	@PostMapping("/pedircita")
	public String pedircita(RedirectAttributes ratt, Model model, RedirectAttributes redir,	@RequestParam("fechaCita") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaCita,@RequestParam("horaCita") String horaCita,
			@RequestParam("estado") String estado, @RequestParam("direccionCentrosalud") String direccionCentrosalud,
			@RequestParam("sintomas") String sintomas, @RequestParam("dni") Usuario dni, @RequestParam("nombre") String nombre, @RequestParam("nombre_medico") String nombre_medico) {
		Cita cita= new Cita();

		cita.setFechaCita(fechaCita);
		cita.setHoraCita(horaCita);
		cita.setDireccionCentrosalud(direccionCentrosalud);
		cita.setSintomas(sintomas);
		cita.setNombreMedico(nombre_medico);
		cita.setNombrePaciente(nombre);
		cita.setEstado(estado);
		cita.setUsuario(dni);
		
		
		int result = cdao.insertUna(cita);
		if (result == 0) {
			ratt.addFlashAttribute("mensaje", "Ha fallado la edicion del usuario");
			model.addAttribute("mensaje", "incorreccto");
			return "redirect:/pedircita";
		} else {
			model.addAttribute("mensaje", "correcto");
			ratt.addFlashAttribute("mensaje", "correcto");
			return "redirect:/index";
		}
	}

	/**
	 * Cancela una cita
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/cancelarUna/{id}")
	public String cancelarCita(Model model,@PathVariable int id) {
		Cita cita= new Cita();
		cita=cdao.buscarUnaCita(id);
		cita.setEstado("Cancelado");
		cdao.editarCita(cita);
		model.addAttribute("cita", cita);
		
		return "redirect:/index";
	}

	/**
	 * modificar un usuario
	 * @param ratt
	 * @param model
	 * @param dni
	 * @param email
	 * @param nombre
	 * @param apellido
	 * @param domicilio
	 * @param telefono
	 * @param imgurl
	 * @return
	 */
	@PostMapping("/modificarDatosUsuario")
	public String modificarDatosUsuario(RedirectAttributes ratt,Model model, @RequestParam("dni") String dni,
			@RequestParam("email") String email,@RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,@RequestParam("direccion") String direccion,
			@RequestParam("telefono") String telefono,@RequestParam("imgurl") String imgurl) {
		Usuario usuario = udao.buscarUsuario(dni);
		
		usuario.setEmail(dni == "" ? usuario.getEmail() : email);
		usuario.setNombre(nombre == "" ? usuario.getNombre() : nombre);
		usuario.setApellido(apellido == "" ? usuario.getApellido() : apellido);
		usuario.setDireccion(direccion == "" ? usuario.getDireccion() : direccion);
		usuario.setTelefono(telefono == "" ? usuario.getTelefono() : telefono);
		usuario.setImgurl(imgurl == "" ? usuario.getImgurl() : imgurl);

		int result = udao.editarUsuario(usuario);

		if (result == 0) {
			ratt.addFlashAttribute("mensaje", "Ha fallado la edicion del usuario");
			model.addAttribute("mensaje", "incorreccto");
			System.out.println("Usuario Nooooo editado");
			System.out.println(usuario);
			return "redirect:/usuario";
		} else {
			model.addAttribute("mensaje", "correcto");
			ratt.addFlashAttribute("mensaje", "correcto");//no se ven las alertas en el index
			System.out.println("Usuario editado");
			return "redirect:/index";
		}
	}

	@PostMapping("/modificarInformacion")
	public String modificarInformacion(RedirectAttributes ratt,Model model, @RequestParam("peso") Integer peso,
			@RequestParam("altura") String altura, @RequestParam("edad") Integer edad,@RequestParam("sexo") String sexo,
			@RequestParam("dni") String dni) {
		Informacion informacion = idao.buscarInformacion(dni);
			if(informacion==null){
				Informacion informacionNuevo = new Informacion(udao.buscarUsuario(dni), altura, edad, peso, sexo);
				
				int result = idao.editarInformacion(informacionNuevo);

				if (result == 0) {
					ratt.addFlashAttribute("mensaje", "Ha fallado la edicion del usuario");
					model.addAttribute("mensaje", "incorreccto");
					return "redirect:/usuario";
				} else {
					model.addAttribute("mensaje", "correcto");
					ratt.addFlashAttribute("mensaje", "correcto");//no se ven las alertas en el index
					return "redirect:/index";
				}

			}else {
				informacion.setUsuario(udao.buscarUsuario(dni));
				informacion.setAltura(altura);
				informacion.setEdad(edad);
				informacion.setPeso(peso);
				informacion.setSexo(sexo);
				int result = idao.editarInformacion(informacion);

				if (result == 0) {
					ratt.addFlashAttribute("mensaje", "Hubo un problema al añadir al informacion");
					model.addAttribute("mensaje", "incorreccto");
					return "redirect:/usuario";
				} else {
					model.addAttribute("mensaje", "La informacion se añadio exitosamente");
					ratt.addFlashAttribute("mensaje", "correcto");//no se ven las alertas en el index
					return "redirect:/index";
				}
			}
	}
	
	/**
	 * acceso a registro
	 * @param model
	 * @return
	 */
	@GetMapping("/registro")
	public String mostrarRegistro(Model model) {
		return "registro";
	}
	
	@PostMapping("/registro")
	public String procesarRegistro(Model model, Usuario usuario) {
		// Crear usuario con contra cifrada
		usuario.setEnabled(1);
		String usuariocontra = usuario.getPassword();
		String encriptado = pwenco.encode(usuariocontra);
		usuario.setPassword(encriptado);

		List<Perfil> listaPerfiles = new ArrayList<Perfil>();
		Perfil rol = pdao.buscarPerfil(1);
		listaPerfiles.add(rol);
		usuario.setPerfils(listaPerfiles);

		System.out.println("=========================================" + usuario
				+ "==================================================");
		usuario.setImgurl("https://w7.pngwing.com/pngs/831/88/png-transparent-user-profile-computer-icons-user-interface-mystique-miscellaneous-user-interface-design-smile.png");
		int usu = udao.insertUno(usuario);

		if (usu == 0)
			model.addAttribute("mensaje", "Usuario no insertado");
		else if (usu == 2) {
			model.addAttribute("mensaje", "Ya existe ese usuario");
		} else {
			model.addAttribute("mensaje", "Usuario dado de alta correctamente");
			System.out.println(usuario.getPerfils());
			System.out.println(new Date());
		}
		return "redirect:/";

	}

	@GetMapping("/ayuda")
	public String mostrarAyuda(Model model) {
		return "ayuda";
	}
	
	@GetMapping("/pacientes")
	public String mostrarPacientes(Model model) {
		model.addAttribute("listaPacientes",udao.buscarPacientes());
		return "pacientes";
	}
	
	@GetMapping("/medicinas")
	public String mostrarMedicinas(Model model) {
		return "medicinas";
	}
	
	@GetMapping("/medicos")
	public String mostrarMedicos(Model model,HttpSession misesion) {
		List<Usuario> listaMedicos= udao.buscarMedicos((String) misesion.getAttribute("dni"));
		model.addAttribute("listaMedicos",listaMedicos);
		return "medicos";
	}
	
	@GetMapping("/todas")
	public String mostrarTodas(Model model,HttpSession misesion) {
		model.addAttribute("citas", cdao.buscarCitas((String) misesion.getAttribute("dni")));
		return "todas";
	}
	
	@GetMapping("/todasMed")
	public String buscarCitasPorMedico(Model model,HttpSession misesion) {
		System.out.println("################ // "+ misesion.getAttribute("citasListaMedico"));
		List<Cita> citasListaMedico= (List<Cita>) misesion.getAttribute("citasListaMedico");
		model.addAttribute("citas",citasListaMedico);
		return "todas";
	}
	
	/**
	 * nos devuelve la pagina de historial
	 * @param model
	 * @param misesion
	 * @return
	 */
	@GetMapping("/historialclinico")
	public String mostrarHistorial(Model model,HttpSession misesion) {
		model.addAttribute("historial", hdao.buscarHistorialClinicoPordni((String) misesion.getAttribute("dni")));
		return "historial";
	}

	
	
	/**
	 * nos devuelve la pagina de todoschat
	 * @param model
	 * @return
	 */
	@GetMapping("/todoschat")
	public String mostrarTodoschat(Model model) {
		return "todoschat";
	}

	/**
	 * nos devuelve la pagina de recuperarcontrasena
	 * @param model
	 * @return
	 */
	@GetMapping("/recuperarcontrasena")
	public String mostrarRecuperarContrasena(Model model) {
		return "recuperarcontrasena";
	}

	/**
	 * nos devuelve la pagina de contrasena
	 * @param model
	 * @return
	 */
	@GetMapping("/contrasena")
	public String mostrarContrasena(Model model) {
		return "contrasena";
	}
	
	/**
	 * cambiaos la contraseña del Usiario
	 * @param model
	 * @param misesion
	 * @param contraseñaActual
	 * @param nuevaContraseña
	 * @param contraseñaVerificada
	 * @param usario
	 * @return Nos devuelve la pagina de contraseña
	 */
	@PostMapping("/cambioContraseña")
	public String cambioContraseña(Model model, HttpSession misesion, @RequestParam("contraseñaActual") String contraseñaActual, @RequestParam("nuevaContraseña") String nuevaContraseña, @RequestParam("contraseñaVerificada") String contraseñaVerificada, Usuario usario) {
		if(Boolean.TRUE.equals(pwenco.matches(contraseñaActual, misesion.getAttribute("password").toString()))){
			if(Boolean.TRUE.equals(nuevaContraseña.equals(contraseñaVerificada))){
				String contraseñaVerificadaCifrada = pwenco.encode(contraseñaVerificada);
				udao.cambioContraseña(contraseñaVerificadaCifrada, misesion.getAttribute("dni").toString());
			}
		}
		return "contrasena";
	}
	
	/**
	 * Para encriptar el password de usuario en la base de datos
	 * @return
	 */
	@GetMapping("/pwd")
	@ResponseBody
	public String generarEncriptado() {
		String password = "hola";
		String encriptado = pwenco.encode(password);
		return encriptado;

	}
	/**
	 * nos cierra la session del usuario
	 * @param request
	 * @param misesion
	 * @return
	 */
	@GetMapping("/cerrar")
	public String salirprueba(HttpServletRequest request,HttpSession misesion) {
		Usuario usuario = udao.buscarUsuario((String) misesion.getAttribute("dni"));
		usuario.setOnlineusu(0);
		udao.editarUsuario(usuario);
		SecurityContextLogoutHandler logoutfandler = new SecurityContextLogoutHandler();
		logoutfandler.logout(request, null, null);
		return "redirect:/logout";
	}

	/**
	 * nos redirige al login
	 * @param request
	 * @param misesion
	 * @return
	 */
	@GetMapping("/logout")
	public String logout(HttpServletRequest request,HttpSession misesion) {
		return "redirect:/login";
	}

}