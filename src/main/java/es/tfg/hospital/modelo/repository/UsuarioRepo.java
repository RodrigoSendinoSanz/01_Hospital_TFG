package es.tfg.hospital.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import es.tfg.hospital.modelo.beans.Usuario;



public interface UsuarioRepo extends JpaRepository<Usuario, String>{
	
	@Query("select u from Usuario u where u.onlineusu = '1'")
	List<Usuario> mostrarConectados();

}
