package es.tfg.hospital.modelo.dao;

import java.util.List;

import es.tfg.hospital.modelo.beans.Diagnostico;
import es.tfg.hospital.modelo.beans.Informacion;

public interface IntInformacionDao {
	Informacion buscarInformacion(String dni);
	List<Informacion>buscarTodos();
	int insertUno(Informacion informacion);

}
