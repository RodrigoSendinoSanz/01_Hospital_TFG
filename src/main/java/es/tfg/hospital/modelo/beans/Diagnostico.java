package es.tfg.hospital.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the diagnostico database table.
 * 
 */
@Entity
@NamedQuery(name="Diagnostico.findAll", query="SELECT d FROM Diagnostico d")
public class Diagnostico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_DIAG")
	private int idDiag;

	private String alergias;

	private String enfermedades;

	private String operaciones;

	private String tratamiento;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="DNI")
	private Usuario usuario;

	public Diagnostico() {
	}

	public Diagnostico( String alergias, String enfermedades, String operaciones, String tratamiento,
			Usuario usuario) {
		this.alergias = alergias;
		this.enfermedades = enfermedades;
		this.operaciones = operaciones;
		this.tratamiento = tratamiento;
		this.usuario = usuario;
	}


	public int getIdDiag() {
		return this.idDiag;
	}

	public void setIdDiag(int idDiag) {
		this.idDiag = idDiag;
	}

	public String getAlergias() {
		return this.alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public String getEnfermedades() {
		return this.enfermedades;
	}

	public void setEnfermedades(String enfermedades) {
		this.enfermedades = enfermedades;
	}

	public String getOperaciones() {
		return this.operaciones;
	}

	public void setOperaciones(String operaciones) {
		this.operaciones = operaciones;
	}

	public String getTratamiento() {
		return this.tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}