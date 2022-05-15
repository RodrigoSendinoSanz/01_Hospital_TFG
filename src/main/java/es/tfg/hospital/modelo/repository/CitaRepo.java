package es.tfg.hospital.modelo.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import es.tfg.hospital.modelo.beans.Cita;


public interface CitaRepo extends JpaRepository<Cita, Integer>{

	@Query("select c from Cita c where c.usuario.dni = ?1 ORDER BY c.fechaCita DESC")
	List<Cita> findCitabyUsuario(String dni);

	@Query("select c from Cita c where c.idCita = ?1")
	Cita findUnaCita(Integer idCita);
	
	@Query("select c from Cita c where c.nombreMedico = ?1")
	List<Cita> findCitabyMedico(String nombreMedico);
	
	@Query("select c from Cita c where c.nombrePaciente like %?1%")
	public List<Cita> buscarCitaPorNombre(String nombrePaciente);
}
