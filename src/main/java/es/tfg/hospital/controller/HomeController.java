package es.tfg.hospital.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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

import es.tfg.hospital.modelos.beans.Perfil;
import es.tfg.hospital.modelos.beans.Usuario;

@Controller
//@RequestMapping("/pruebas")
public class HomeController {

	@Autowired
	private PasswordEncoder pwenco;

	//@Autowired
	//private IntLibroDao ldao;


	// Mostrar el login. Se puede personalizar el login en formInicio
	@GetMapping("/login")
	public String mostrarFormInicio() {
		return "login";
	}

	// Procesamos el login obteniendo el usuario
	@GetMapping("/")
	public String procesarLogin(Authentication aut, Model model, HttpSession misesion) {

		if (aut != null) {
			System.out.println("usuario : " + aut.getName());
			model.addAttribute("usuario", aut.getName());

			/*
			 * for (GrantedAuthority ele: aut.getAuthorities()) System.out.println("ROL : "
			 * + ele.getAuthority());
			 */
			model.addAttribute("autorizaciones", aut.getAuthorities());
			misesion.setAttribute("autorizaciones", aut.getAuthorities());

			// Generamos la lista con las novedades respecto a los libros
			//List<Libro> lista = ldao.buscarNovedades();
			//model.addAttribute("listaNovedades", lista);

			//model.addAttribute("listaTemas", tdao.buscarTodos());
			//ArrayList<Libro> listaCarrito = (ArrayList<Libro>) misesion.getAttribute("listaCarrito");

			//misesion.setAttribute("listaCarrito", listaCarrito);
			//misesion.setAttribute("nombreusuario", aut.getName());
		} else {
			//List<Libro> lista = ldao.buscarNovedades();
			//model.addAttribute("listaNovedades", lista);
		}

		return "index";//IMPORTANTE ***** cambiar a login***
	}

//	Ver detalles del libro
	@GetMapping("/verDetalle/{id}")
	public String mostrarVerDetalleLibro(Model model, @PathVariable("id") long isbn) {
		//Libro libro = ldao.buscarLibro(isbn);

		//model.addAttribute("libro", libro);

		return "/verDetalle";
	}

//Mostrando todos los libros	
	@GetMapping("/libros")
	public String mostrarLibros(Model model) {

		//List<Libro> lista = ldao.buscarTodos();

		//model.addAttribute("listaLibros", lista);

		return "librosTodos";
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

	@GetMapping("/registro")
	public String mostrarRegistro(Model model) {
		return "registro";
	}

	@PostMapping("/registro")
	public String procesarRegistro(Model model, Usuario usuario) {
/*
		// Crear usuario con contra cifrada
		usuario.setEnabled(1);
		String usuariocontra = usuario.getPassword();
		String encriptado = pwenco.encode(usuariocontra);
		usuario.setPassword(encriptado);

		List<Perfil> listaPerfiles = new ArrayList<Perfil>();
		Perfil rol = pdao.buscarPerfile(3);
		listaPerfiles.add(rol);
		usuario.setPerfils(listaPerfiles);

		System.out.println("=========================================" + usuario
				+ "==================================================");
		int usu = udao.insertUno(usuario);

		if (usu == 0)
			model.addAttribute("mensaje", "Usuario no insertado");

		else if (usu == 2) {
			model.addAttribute("mensaje", "Ya existe ese usuario");
		} else {
			model.addAttribute("mensaje", "Usuario dado de alta correctamente");

			System.out.println(usuario.getPerfils());
			System.out.println(new Date());
		}*/
		return "redirect:/";

	}

//Para encriptar el password de usuario en la base de datos
	@GetMapping("/pwd")
	@ResponseBody
	public String generarEncriptado() {
		String password = "hola";
		String encriptado = pwenco.encode(password);
		return encriptado;

	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		SecurityContextLogoutHandler logoutfandler = new SecurityContextLogoutHandler();
		logoutfandler.logout(request, null, null);
		return "redirect:/login";
	}

}