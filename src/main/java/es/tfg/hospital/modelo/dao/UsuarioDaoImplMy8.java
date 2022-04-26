package es.tfg.hospital.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.tfg.hospital.modelo.beans.Usuario;
import es.tfg.hospital.modelo.repository.UsuarioRepo;


@Service
public class UsuarioDaoImplMy8 implements IntUsuarioDao{

	@Autowired
	private UsuarioRepo urepo;
	
	@Override
	public Usuario buscarUsuario(String idUsuario) {
		// TODO Auto-generated method stub
		return urepo.getById(idUsuario);
	}

	@Override
	public List<Usuario> buscarTodos() {
		// TODO Auto-generated method stub
		return urepo.findAll();
	}

	@Override
	public int insertUno(Usuario usuario) {
		int filas = 0;
		if(urepo.findAll().contains(usuario)) {
			filas=2;
		}else {
		try {
			urepo.save(usuario);
			
			filas=1;
		} catch(Exception e) {
			e.printStackTrace();
		}
			return filas;
		}
		return filas;
	}


}
