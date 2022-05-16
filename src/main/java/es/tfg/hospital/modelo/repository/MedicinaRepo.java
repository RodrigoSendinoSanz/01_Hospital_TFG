package es.tfg.hospital.modelo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import es.tfg.hospital.modelo.beans.Medicina;


public interface MedicinaRepo  extends JpaRepository<Medicina, Integer> {

	@Query("select m from Medicina m")
	List<Medicina> todasMedicinas();
	
	@Query("select m from Medicina m where nombreMed = ?1")
	Medicina buscarUnaMedicina(String nombreMed);
	
		
	@Query("select m from Medicina m inner join HistorialClinico h ON m.codMed = h.medicina.codMed inner join Cita c ON c.usuario.dni = ?1")
	public List<Medicina> buscarMedicinasUsuario(String dni);
}
