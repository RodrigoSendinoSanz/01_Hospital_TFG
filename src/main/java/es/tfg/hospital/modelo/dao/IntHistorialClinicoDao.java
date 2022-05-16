package es.tfg.hospital.modelo.dao;


import java.util.List;

import es.tfg.hospital.modelo.beans.HistorialClinico;

public interface IntHistorialClinicoDao {

	int insertUna(HistorialClinico historialClinico);
	List<HistorialClinico> buscarHistorialClinicoPordni(String dni);
}
