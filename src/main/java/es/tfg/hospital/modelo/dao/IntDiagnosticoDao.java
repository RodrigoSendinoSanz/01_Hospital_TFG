package es.tfg.hospital.modelo.dao;

import java.util.List;

import es.tfg.hospital.modelo.beans.Diagnostico;



public interface IntDiagnosticoDao {
	Diagnostico buscarDiagnostico(String dni);
	List<Diagnostico>buscarTodos();
	int insertUno(Diagnostico diagnostico);
	int editarDiagnostico(Diagnostico diagnostico);
}
