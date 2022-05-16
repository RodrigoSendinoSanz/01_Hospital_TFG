package es.tfg.hospital.modelo.dao;

import java.util.List;


import es.tfg.hospital.modelo.beans.Medicina;

public interface IntMedicinaDao {

	List<Medicina> buscarTodasMedicinas();
	Medicina buscarUnaMedicina(String nombreMed);
}
