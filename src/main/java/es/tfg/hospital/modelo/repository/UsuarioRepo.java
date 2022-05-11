package es.tfg.hospital.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import es.tfg.hospital.modelo.beans.Usuario;



public interface UsuarioRepo extends JpaRepository<Usuario, String>{
	
	@Query("select u from Usuario u where u.onlineusu = '1'")
	List<Usuario> mostrarConectados();
	
	@Query("select u from Usuario u where u.nombre = ?1")
	Usuario getByNombre(String nombre);
	

	/* Sacar lista de todos los medicos (habria que hacer uno con un cont)
	//Buscar usuarios que solo sean clientes con un inner join
	@Query("select u from Usuario u inner join Perfil p where p.id_perfil=2")
	List<Usuario>findUsuariosMedicos();
	*/
	
}
