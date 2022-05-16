package es.tfg.hospital.modelo.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.tfg.hospital.modelo.beans.Cita;
import es.tfg.hospital.modelo.beans.Comentario;
import es.tfg.hospital.modelo.repository.ComentarioRepo;

@Service
public class ComentarioDaoImplMy8 implements IntComentarioDao{

	@Autowired
	private ComentarioRepo comentariorepo;
	
	@Override
	public List<Comentario> mostrarChat(String dni_1, String dni_2) {
		return comentariorepo.mostrarChat(dni_1, dni_2);
	}
	

	@Override
	public int enviarComentario(Comentario comentario) {
		int filas = 0;

		try {
			comentariorepo.save(comentario);
			filas=1;
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return filas;
	}

}
