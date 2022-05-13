package es.tfg.hospital.modelo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.tfg.hospital.modelo.beans.Perfil;
import es.tfg.hospital.modelo.beans.Usuario;

public interface PerfilRepo extends JpaRepository<Perfil, Integer>{

	//@Query("select DISTINCT u from Usuario u inner join u.perfil p where p.idPerfil=2")
	//List<Usuario> findMedicos();

}
