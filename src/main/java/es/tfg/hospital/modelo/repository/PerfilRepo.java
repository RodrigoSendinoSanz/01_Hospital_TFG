package es.tfg.hospital.modelo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import es.tfg.hospital.modelo.beans.Perfil;

public interface PerfilRepo extends JpaRepository<Perfil, Integer>{

}
