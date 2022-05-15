package es.tfg.hospital.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.tfg.hospital.modelo.beans.Medicina;


public interface MedicinaRepo extends JpaRepository<Medicina, Integer>{

//	@Query("select f from Informacion f where f.usuario.dni = ?1")
//	Medicina findInformacionbyUsuario(String dni);
}
