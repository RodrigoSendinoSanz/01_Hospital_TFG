package es.tfg.hospital.modelo.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.tfg.hospital.modelo.beans.Perfil;
import es.tfg.hospital.modelo.repository.PerfilRepo;


@Service
public class PerfilDaoImplMy8 implements IntPerfilDao{

	@Autowired
	private PerfilRepo pfrepo;
	
	@Override
	public Perfil buscarPerfil(int idPerfil) {
		// TODO Auto-generated method stub
		return pfrepo.getById(idPerfil);
	}

	@Override
	public List<Perfil> buscarTodos() {
		// TODO Auto-generated method stub
		return pfrepo.findAll();
	}

	
	@Override
	public int insertUno(Perfil perfil) {
		int filas = 0;
		if(pfrepo.findAll().contains(perfil)) {
			filas=2;
		}else {
		try {
			pfrepo.save(perfil);
			
			filas=1;
		} catch(Exception e) {
			e.printStackTrace();
		}
			return filas;
		}
		return filas;
	}
}
