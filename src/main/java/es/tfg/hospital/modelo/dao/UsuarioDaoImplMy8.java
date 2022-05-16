package es.tfg.hospital.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import es.tfg.hospital.modelo.beans.Usuario;
import es.tfg.hospital.modelo.repository.UsuarioRepo;


@Service
public class UsuarioDaoImplMy8 implements IntUsuarioDao{

	@Autowired
	private UsuarioRepo urepo;
	
	/**
	 * Busca el Usuario pasado utilizando el dni como referencia
	 */
	@Override
	public Usuario buscarUsuario(String DNI) {
		// TODO Auto-generated method stub
		return urepo.getById(DNI);
	}

	/**
	 * Devuelve la lista entera de Usuarios
	 */
	@Override
	public List<Usuario> buscarTodos() {
		// TODO Auto-generated method stub
		return urepo.findAll();
	}

	/**
	 * Metodo que para cambiar la contraseña
	 */
	@Override
	public void cambioContraseña(String nuevaContraseña, String id) {
		System.out.println(id);
		Usuario usuario = buscarUsuario(id);
		usuario.setPassword(nuevaContraseña);
		urepo.save(usuario);
	}
	
	/**
	 * Metodo para insertar un nuevo usario
	 */
	@Override
	public int insertUno(Usuario usuario) {
		int filas = 0;
		if(urepo.findAll().contains(usuario)) {
			filas=2;
		}else {
		try {
			urepo.save(usuario);
			
			filas=1;
		} catch(Exception e) {
			e.printStackTrace();
		}
			return filas;
		}
		return filas;
	}

	/**
	 * Metodo para buscar usuarios a por su nombre
	 */
	@Override
	public Usuario buscarUsuarioPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return urepo.getByNombre(nombre);
	}

	/**
	 * Metodo para editar un Usuario
	 */
	@Override
	public int editarUsuario(Usuario usuario) {
			int filas=0;

				try {
					urepo.save(usuario);
					filas=1;
				}catch (Exception e) {
					e.printStackTrace();
					
				}
				return filas;
			}

	/**
	 * Metodo para contar los medicos
	 */
	@Override
	public Integer contarMedicos() {
		// TODO Auto-generated method stub
		return urepo.contarMedicos();
	}

	/**
	 * Metodo para saber cuantos usuarios hay conectados
	 */
	@Override
	public List<Usuario> buscarConectados(String dni) {
		// TODO Auto-generated method stub
		return urepo.buscarConectados(dni);
	}



	/**
	 * Metodo para buscar los pacientes
	 */
	@Override
	public List<Usuario> buscarPacientes() {
		// TODO Auto-generated method stub
		return urepo.mostrarPacientes();
	}

	/**
	 * Metodo para buscar medicos a raiz de un dni
	 */
	@Override
	public List<Usuario> buscarMedicos(String dni) {
		// TODO Auto-generated method stub
		return urepo.mostrarMedicos(dni);
	}

	@Override
	public List<Usuario> listaMedicos() {
		// TODO Auto-generated method stub
		return urepo.listaMedicos();
	}

	}

