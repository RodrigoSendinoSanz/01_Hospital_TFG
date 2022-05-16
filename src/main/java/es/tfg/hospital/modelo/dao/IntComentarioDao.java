package es.tfg.hospital.modelo.dao;

import java.util.List;

import es.tfg.hospital.modelo.beans.Comentario;

public interface IntComentarioDao {

	List<Comentario> mostrarChat(String dni_1, String dni_2);
	int enviarComentario(Comentario comentario);
}
