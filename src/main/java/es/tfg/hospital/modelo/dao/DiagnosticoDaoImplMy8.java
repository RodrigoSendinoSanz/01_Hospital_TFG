package es.tfg.hospital.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.tfg.hospital.modelo.beans.Diagnostico;
import es.tfg.hospital.modelo.repository.DiagnosticoRepo;

@Service
public class DiagnosticoDaoImplMy8 implements IntDiagnosticoDao{

	@Autowired
	private DiagnosticoRepo diarepo;
	
	@Override
	public Diagnostico buscarDiagnostico(String dni) {
		return diarepo.findDiagnosticobyUsuario(dni);
	}

	@Override
	public List<Diagnostico> buscarTodos() {
		// TODO Auto-generated method stub
		return diarepo.findAll();
	}

	@Override
	public int insertUno(Diagnostico diagnostico) {
		int filas = 0;
		if(diarepo.findAll().contains(diagnostico)) {
			filas=2;
		}else {
		try {
			diarepo.save(diagnostico);
			
			filas=1;
		} catch(Exception e) {
			e.printStackTrace();
		}
			return filas;
		}
		return filas;
	}

}
