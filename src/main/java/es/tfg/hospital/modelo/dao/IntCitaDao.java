package es.tfg.hospital.modelo.dao;

import java.util.List;

import es.tfg.hospital.modelo.beans.Cita;

public interface IntCitaDao {
	List<Cita> buscarCitas(String dni);
	List<Cita>buscarTodos();
	int insertUna(Cita cita);
	Cita buscarUnaCita(int idCita);
	List<Cita> buscarCitasPorMedico(String dni);
	List<Cita> buscarCitaPorNombre(String nombrePaciente);
	int editarCita(Cita cita);
}