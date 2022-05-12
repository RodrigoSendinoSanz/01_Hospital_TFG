package es.tfg.hospital.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.tfg.hospital.modelo.beans.Diagnostico;
import es.tfg.hospital.modelo.beans.Informacion;
import es.tfg.hospital.modelo.beans.Usuario;
import es.tfg.hospital.modelo.repository.InformacionRepo;

@Service
public class InformacionDaoImplMy8 implements IntInformacionDao{

	@Autowired
	private InformacionRepo infrepo;
	
	@Override
	public Informacion buscarInformacion(String dni) {
		
		return infrepo.findInformacionbyUsuario(dni);
	}

	@Override
	public List<Informacion> buscarTodos() {
		// TODO Auto-generated method stub
		return infrepo.findAll();
	}

	@Override
	public int insertUno(Informacion informacion) {
		int filas = 0;
		if(infrepo.findAll().contains(informacion)) {
			filas=2;
		}else {
		try {
			infrepo.save(informacion);
			
			filas=1;
		} catch(Exception e) {
			e.printStackTrace();
		}
			return filas;
		}
		return filas;
	}

	@Override
	public int editarInformacion(Informacion informacion) {

		int filas=0;
		//Si no existe no lo añadimos
		if (infrepo.findAll().indexOf(informacion)==-1) {
		return filas;	
		//Si existe lo modificamos
		}else {
			try {
				infrepo.save(informacion);
				filas=1;
			}catch (Exception e) {
				e.printStackTrace();
				
			}
			return filas;
		}
	}

}
