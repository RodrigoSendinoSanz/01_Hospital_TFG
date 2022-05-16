package es.tfg.hospital.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import es.tfg.hospital.modelo.beans.Usuario;



public interface UsuarioRepo extends JpaRepository<Usuario, String>{
	
	@Query("select u from Usuario u where u.onlineusu = '1' and u.dni != ?1")
	List<Usuario> buscarConectados(String dni);
	
	@Query("select u from Usuario u where u.nombre = ?1")
	Usuario getByNombre(String nombre);

	@Query("select u from Usuario u inner join u.perfils p where p.idPerfil=2 and u.dni != ?1")
	List<Usuario> mostrarMedicos(String dni);
	
	@Query("select u from Usuario u inner join u.perfils p where p.idPerfil=2")
	List<Usuario> listaMedicos();
	
	@Query("select u from Usuario u inner join u.perfils p where p.idPerfil=1")
	List<Usuario> mostrarPacientes();
	
	@Query("select count(u) from Usuario u inner join u.perfils p where p.idPerfil=2")
	Integer contarMedicos();
	//Medicos online
	//SELECT * FROM hospital_bbdd.usuario where dni in(SELECT DNI FROM hospital_bbdd.usuario_perfil where id_perfil ='2') and onlineusu = '1';


	
	//Medicos
	//SELECT * FROM hospital_bbdd.usuario where dni in(SELECT DNI FROM hospital_bbdd.usuario_perfil where id_perfil ='2');
	
	
	
	
	
	
	// Sacar lista de todos los medicos (habria que hacer uno con un cont)
	//Buscar usuarios que solo sean clientes con un inner join
	//@Query("select u from Usuario u where u.dni in(select up.dni from Usuario_Perfil up where up.id_perfil ='2')")
	//List<Usuario> findUsuariosMedicos();
	
	//@Query("select DISTINCT u from Usuario u inner join u.perfil p where p.id_perfil = 2")
	//List<Usuario> findUsuariosMedicos();
	
	//@Query("select u from Usuario u where u.dni in(select up.dni from Usuario_Perfil up where up.id_perfil ='2') and u.onlineusu = '1'")
	//List<Usuario> findUsuariosMedicosConectados();
	
	//@Query("select COUNT(u) from Usuario u where u.dni in(select up.dni from Usuario_Perfil up where up.id_perfil ='2')")
	//Integer findNumUsuariosMedicos();
	
}
