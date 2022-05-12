package es.tfg.hospital.modelo.dao;



import java.util.List;

import es.tfg.hospital.modelo.beans.Usuario;



public interface IntUsuarioDao {
	
	Usuario buscarUsuario(String DNI);
	List<Usuario>buscarTodos();
	int insertUno(Usuario usuario);
	List<Usuario>buscarConectados();
	public void cambioContraseña(String nuevaContraseña, String id);
	Usuario buscarUsuarioPorNombre(String nombre);
	int editarUsuario(Usuario usuario);
}
