package es.tfg.hospital.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.tfg.hospital.modelo.beans.Usuario;



public interface UsuarioRepo extends JpaRepository<Usuario, String>{

}
