package es.tfg.hospital.modelo.dao;



import java.util.List;

import es.tfg.hospital.modelo.beans.Usuario;



public interface IntUsuarioDao {
	
	Usuario buscarUsuario(String idUsuario);
	List<Usuario>buscarTodos();
	int insertUno(Usuario usuario);

}
