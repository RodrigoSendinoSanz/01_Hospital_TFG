package es.tfg.hospital.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;


/**
 * The persistent class for the perfil database table.
 * 
 */
@Entity
@NamedQuery(name="Perfil.findAll", query="SELECT p FROM Perfil p")
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PERFIL")
	private int idPerfil;

	@Column(name="DESC_PER")
	private String descPer;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="perfils")
	private List<Usuario> usuarios;

	public Perfil() {
	}

	public int getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getDescPer() {
		return this.descPer;
	}

	public void setDescPer(String descPer) {
		this.descPer = descPer;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Perfil [idPerfil=" + idPerfil + ", descPer=" + descPer + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPerfil);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perfil other = (Perfil) obj;
		return idPerfil == other.idPerfil;
	}


	
	
}