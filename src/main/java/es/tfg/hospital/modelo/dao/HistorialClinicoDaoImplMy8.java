package es.tfg.hospital.modelo.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.tfg.hospital.modelo.beans.HistorialClinico;
import es.tfg.hospital.modelo.repository.HistorialClinicoRepo;

@Service
public class HistorialClinicoDaoImplMy8 implements IntHistorialClinicoDao{

	@Autowired
	private HistorialClinicoRepo historialrepo;
	
	@Override
	public int insertUna(HistorialClinico historialClinico) {
		int filas = 0;

		try {
			historialrepo.save(historialClinico);
			filas=1;
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return filas;
	}

	@Override
	public List<HistorialClinico> buscarHistorialClinicoPordni(String dni) {
		// TODO Auto-generated method stub
		return historialrepo.buscarHistorialClinicoPordni(dni);
	}
	
	
}
