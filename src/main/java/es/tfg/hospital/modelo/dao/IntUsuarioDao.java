package es.tfg.hospital.modelo.dao;



import java.util.List;

import es.tfg.hospital.modelo.beans.Usuario;



public interface IntUsuarioDao {
	
	Usuario buscarUsuario(String DNI);
	List<Usuario>buscarTodos();
	int insertUno(Usuario usuario);

}
