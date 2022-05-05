package es.tfg.hospital.modelo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;




import es.tfg.hospital.modelo.beans.Diagnostico;


public interface DiagnosticoRepo extends JpaRepository<Diagnostico, Integer>{
	
	@Query("select d from Diagnostico d where d.usuario.dni = ?1")
	Diagnostico findDiagnosticobyUsuario(String dni);
}
