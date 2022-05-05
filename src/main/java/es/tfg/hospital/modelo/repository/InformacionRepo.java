package es.tfg.hospital.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.tfg.hospital.modelo.beans.Informacion;

public interface InformacionRepo extends JpaRepository<Informacion, Integer>{
	
	@Query("select f from Informacion f where f.usuario.dni = ?1")
	Informacion findInformacionbyUsuario(String dni);
}
