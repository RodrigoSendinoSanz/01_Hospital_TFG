package es.tfg.hospital.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
import es.tfg.hospital.modelo.beans.Informacion;
import es.tfg.hospital.modelo.beans.Perfil;
import es.tfg.hospital.modelo.beans.Usuario;
import es.tfg.hospital.modelo.dao.IntCitaDao;
import es.tfg.hospital.modelo.dao.IntDiagnosticoDao;
import es.tfg.hospital.modelo.dao.IntInformacionDao;
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

//	@GetMapping("")
//	public String acceso(HttpSession sess){
//		if(sess.getAttribute("idSessCuent") == null) {//comprobamos si la session esta guardada el idSessCuent se crea en la linea 57
//			return "redirect:/login";//si da nulo significa q no y lo metemos en el login
//		}else {
//			return"index";//de ser asi iniciamos 
//		}
//	}
	// Mostrar el login. Se puede personalizar el login en formInicio
	@GetMapping(value={"/","/login"})
	public String mostrarFormInicio(Model model) {
		System.out.println(model.getAttribute("error"));
		/*System.out.println("getmatpin login");
		System.out.println(udao.buscarTodos());
		System.out.println(udao.buscarUsuario("34728920w").toString());
		System.out.println(pdao.buscarTodos());
		System.out.println(pdao.buscarPerfil(1).toString());*/
		
		return "login";
	}

	// Procesamos el login obteniendo el usuario

	@GetMapping("/index")//no funciona!
	public String procesarLogin(Authentication aut, Model model, HttpSession misesion) {
		String rol =null;
		
		System.out.println("procesar login");
		if (aut != null) {
			System.out.println("usuario : " + aut.getName());
			model.addAttribute("usuario", aut.getName());
			System.out.println("procesar login");
			
			for (GrantedAuthority ele: aut.getAuthorities()) {
				
				rol=ele.getAuthority();
			}
		
			System.out.println(aut.getAuthorities());
			model.addAttribute("autorizaciones", aut.getAuthorities());
			misesion.setAttribute("autorizaciones", aut.getAuthorities());
			misesion.setAttribute("icono", udao.buscarUsuario(aut.getName()).getImgurl());
			misesion.setAttribute("password", udao.buscarUsuario(aut.getName()).getPassword());
			misesion.setAttribute("dni", udao.buscarUsuario(aut.getName()).getDni());
			misesion.setAttribute("nombre", udao.buscarUsuario(aut.getName()).getNombre());
			model.addAttribute("dni", aut.getName());
			model.addAttribute("dniCont", udao.buscarUsuario(aut.getName()).getDni());//dni para cambiarcont
			System.out.println("procesar if");
			misesion.setAttribute("usuario", udao.buscarUsuario(aut.getName()));
			misesion.setAttribute("usuarioInfo", idao.buscarInformacion(aut.getName()));
			misesion.setAttribute("usuarioDia", ddao.buscarDiagnostico(aut.getName()));
			udao.buscarUsuario(aut.getName()).setOnlineusu(1);
			System.out.println(ddao.buscarDiagnostico(aut.getName()));
			System.out.println(idao.buscarInformacion(aut.getName()));
			
			List<Usuario> ListUsuCone= udao.buscarConectados();
			model.addAttribute("ListUsuCone",ListUsuCone);
			

			if(rol.equalsIgnoreCase("Paciente")){
				List<Cita> citasLista= cdao.buscarCitas((String) model.getAttribute("dni"));
				model.addAttribute("citasLista",citasLista);
				System.out.println("INFO:       /// "+aut.getAuthorities().toString());
			}else if (rol.equalsIgnoreCase("Medico")){
				List<Cita> citasListaMedico= cdao.buscarCitasPorMedico((String) model.getAttribute("usuario"));
				model.addAttribute("citasListaMedico",citasListaMedico);
				System.out.println(citasListaMedico.toString());
				System.out.println("INFO:       /// "+aut.getAuthorities().toString());
				misesion.setAttribute("citasListaMedico",citasListaMedico);
			}else {
				return "redirect:/";
			}
			
			if(idao.buscarInformacion(aut.getName()) == null) {
				model.addAttribute("infousu", "rellenar");
				System.out.println(" Infos Rellenar");
			}else {
				model.addAttribute("infousu", "norellenar");
				System.out.println("Infos Completos");
			}
			
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

//	Ver detalles del libro
	@GetMapping("/verDetalle/{id}")
	public String mostrarVerDetalleLibro(Model model, @PathVariable("id") long isbn) {
		//Libro libro = ldao.buscarLibro(isbn);

		//model.addAttribute("libro", libro);

		return "/verDetalle";
	}

//Mostrando todos los libros	
	@GetMapping("/usuario")
	public String mostrarUsuario(Model model) {

		return "usuario";
	}
	
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
	


	// Mostrando todos los Temas
	@GetMapping("/cliente/temas")
	public String mostrarTemas(Model model) {

		//model.addAttribute("listaTemas", tdao.buscarTodos());
		return "temasTodos";
	}

	// Mostrando uno de los Temas
	@GetMapping("/cliente/tema/{idTema}")
	public String mostrarlibrosTema(Model model, @PathVariable("idTema") int id) {
		//model.addAttribute("tema", tdao.buscarTema(id));
		//model.addAttribute("listaLibrosTema", ldao.buscarporTema(id));
		return "verTema";
	}

	// Eliminar Libros
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

	// Dar de alta un tema
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
	@GetMapping("/verUna/{id}")
	public String mostrarCita(Model model,@PathVariable int id) {
		Cita cita= new Cita();
		cita=cdao.buscarUnaCita(id);
		model.addAttribute("cita", cita);
		
		return "verUna";
	}

	@GetMapping("/editarUna/{id}")
	public String mostrarEditar(Model model,@PathVariable int id) {
		Cita cita= new Cita();
		cita=cdao.buscarUnaCita(id);
		model.addAttribute("cita", cita);
		
		return "editarUna";
	}
	
	@GetMapping("/registro")
	public String mostrarRegistro(Model model) {
		return "registro";
	}
	
	@PostMapping("/modificarUsuario")
	public String modificarUsuario(Model model) {
		return "redirect:/usuario";
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
		return "pacientes";
	}
	
	@GetMapping("/medicinas")
	public String mostrarMedicinas(Model model) {
		return "medicinas";
	}
	
	@GetMapping("/medicos")
	public String mostrarMedicos(Model model) {
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
	
	@GetMapping("/historialclinico")
	public String mostrarHistorial(Model model,HttpSession misesion) {
		model.addAttribute("historial", "Rellenar");
		return "historial";
	}

	@GetMapping("/todoschat")
	public String mostrarTodoschat(Model model) {
		return "todoschat";
	}

	@GetMapping("/recuperarcontrasena")
	public String mostrarRecuperarContrasena(Model model) {
		return "recuperarcontrasena";
	}

	@GetMapping("/contrasena")
	public String mostrarContrasena(Model model) {
		return "contrasena";
	}
	
	@PostMapping("/cambioContrasena")
	public String cambioContraseña(Model model, HttpSession misesion, @RequestParam("contraseñaActual") String contraseñaActual, @RequestParam("nuevaContraseña") String nuevaContraseña, @RequestParam("contraseñaVerificada") String contraseñaVerificada, Usuario usario) {
//	    String aaaaa = pwenco.encode("a");
//	    String aa = pwenco.encode("a");
//	    Boolean desf  = pwenco.matches(contraseñaActual, misesion.getAttribute("password").toString());
//		System.out.println("----aaaaa-----" + aaaaa);
//		System.out.println("----aa-----" + aa);
//		System.out.println("----decode-----" + desf);
//		System.out.println("-----Accede para cambiar la contraseña-----");
//		System.out.println("-----Session -----"+ misesion.getAttribute("password"));
//		System.out.println("-----cifrada actual-----" + contraseñaActualCifrada);
		System.out.println("Dni aqui en teoria"+(String) misesion.getAttribute("dni"));
		
		if(Boolean.TRUE.equals(pwenco.matches(contraseñaActual, misesion.getAttribute("password").toString()))){

			if(Boolean.TRUE.equals(nuevaContraseña.equals(contraseñaVerificada))){
				System.out.println("accede");
				System.out.println("Dni aqui en teoria"+(String) misesion.getAttribute("dni"));
				String contraseñaVerificadaCifrada = pwenco.encode(contraseñaVerificada);
				System.out.println("accedeasdadasd");
				System.out.println("dnidnidnidndi "+ misesion.getAttribute("dni"));
				udao.cambioContraseña(contraseñaVerificadaCifrada, misesion.getAttribute("dni").toString());
				System.out.println("------------------------");
				System.out.println("accede para cambiar la contraseña a " + contraseñaVerificadaCifrada);
			}
		}
//		String usuariocontra = misesion.
//		String encriptado = pwenco.encode(usuariocontra);
//		//recibir la contraseñaActual y comprobar que es correcta
//		if(misesion.get)
//		Comprobar que las nuevas contraseñas son correctas
//		cambiar contraseñas
//
//		usuario.setPassword(encriptado);
		
		return "contrasena";
	}
	
	//Para encriptar el password de usuario en la base de datos
	@GetMapping("/pwd")
	@ResponseBody
	public String generarEncriptado() {
		String password = "hola";
		String encriptado = pwenco.encode(password);
		return encriptado;

	}

	@GetMapping("/logout")//Aun que pongas la URL no pasa por aqui al salir
	public String logout(HttpServletRequest request,HttpSession misesion) {
		System.out.println("Adios");

		udao.buscarUsuario((String) misesion.getAttribute("dni")).setOnlineusu(0);
		SecurityContextLogoutHandler logoutfandler = new SecurityContextLogoutHandler();
		logoutfandler.logout(request, null, null);
		return "redirect:/login";
	}

}