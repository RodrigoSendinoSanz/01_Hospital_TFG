package es.tfg.hospital.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import es.tfg.hospital.modelo.beans.HistorialClinico;


public interface HistorialClinicoRepo extends JpaRepository<HistorialClinico, Integer>{
	
	@Query("select h from HistorialClinico h inner join Cita c ON h.cita.idCita = c.idCita where c.usuario.dni = ?1")
	public List<HistorialClinico> buscarHistorialClinicoPordni(String dni);

	
}
