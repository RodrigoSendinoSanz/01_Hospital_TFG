package es.tfg.hospital.modelo.dao;



import java.util.List;

import es.tfg.hospital.modelo.beans.Perfil;
import es.tfg.hospital.modelo.beans.Usuario;


public interface IntPerfilDao {
	
	Perfil buscarPerfil(int idPerfil);
	List<Perfil>buscarTodos();
	int insertUno(Perfil perfil);
	//List<Usuario>buscarMedicos();
}
