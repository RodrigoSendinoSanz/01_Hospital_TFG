package es.tfg.hospital.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import es.tfg.hospital.modelo.beans.Comentario;

public interface ComentarioRepo extends JpaRepository<Comentario, Integer>{

	@Query(value="select * from comentarios where DNI_1 = ?1 and DNI_2 = ?2 union select * from comentarios where DNI_1 = ?2 and DNI_2 = ?1", nativeQuery = true)
	public List<Comentario> mostrarChat(String dni_1, String dni_2);
}
