package es.tfg.hospital.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.tfg.hospital.modelo.beans.Cita;
import es.tfg.hospital.modelo.beans.Informacion;
import es.tfg.hospital.modelo.repository.CitaRepo;


@Service
public class CitaDaoImplMy8 implements IntCitaDao{

	@Autowired
	private CitaRepo citarepo;

	/**
	 * Busca las citas a raiz del dni
	 */
	@Override
	public List<Cita> buscarCitas(String dni) {
		// TODO Auto-generated method stub
		return citarepo.findCitabyUsuario(dni);
	}

	/**
	 * Saca una lista de todas las citas
	 */
	@Override
	public List<Cita> buscarTodos() {
		// TODO Auto-generated method stub
		return citarepo.findAll();
	}

	/**
	 * Crea una nueva cita
	 */
	@Override
	public int insertUna(Cita cita) {
		int filas = 0;
		if(citarepo.findAll().contains(cita)) {
			filas=2;
		}else {
		try {
			citarepo.save(cita);
			
			filas=1;
		} catch(Exception e) {
			e.printStackTrace();
		}
			return filas;
		}
		return filas;
	}

	/**
	 * Busca una nueva cita usando como referencia el idCita
	 */
	@Override
	public Cita buscarUnaCita(int idCita) {
		// TODO Auto-generated method stub
		return citarepo.findUnaCita(idCita);
	}

	/**
	 * Busca las citas que hay por cada medico
	 */
	@Override
	public List<Cita> buscarCitasPorMedico(String nombreMedico) {
		// TODO Auto-generated method stub
		return citarepo.findCitabyMedico(nombreMedico);
	}

	/**
	 * edita los campos de la cita 
	 */
	@Override
	public int editarCita(Cita cita) {

			int filas=0;
			//Si no existe no lo añadimos
			if (citarepo.findAll().indexOf(cita)==-1) {
			return filas;	
			//Si existe lo modificamos
			}else {
				try {
					citarepo.save(cita);
					filas=1;
				}catch (Exception e) {
					e.printStackTrace();
				}
				return filas;
			}
		
	}

}
