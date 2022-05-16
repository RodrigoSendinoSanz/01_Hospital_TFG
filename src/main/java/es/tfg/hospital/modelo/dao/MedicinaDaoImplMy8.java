package es.tfg.hospital.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.tfg.hospital.modelo.beans.Medicina;
import es.tfg.hospital.modelo.repository.MedicinaRepo;

@Service
public class MedicinaDaoImplMy8 implements IntMedicinaDao {

	@Autowired
	private MedicinaRepo medirepo;

	@Override
	public List<Medicina> buscarTodasMedicinas() {
		// TODO Auto-generated method stub
		return medirepo.todasMedicinas();
	}
	
}
