package es.tfg.hospital.modelo.dao;



import java.util.List;

import es.tfg.hospital.modelo.beans.Usuario;



public interface IntUsuarioDao {
	
	Usuario buscarUsuario(String DNI);
	List<Usuario>buscarTodos();
	List<Usuario>buscarMedicos(String dni);
	List<Usuario> buscarConectados(String dni);
	List<Usuario> buscarPacientes();
	Integer contarMedicos();
	int insertUno(Usuario usuario);
	public void cambioContraseña(String nuevaContraseña, String id);
	Usuario buscarUsuarioPorNombre(String nombre);
	int editarUsuario(Usuario usuario);

}
