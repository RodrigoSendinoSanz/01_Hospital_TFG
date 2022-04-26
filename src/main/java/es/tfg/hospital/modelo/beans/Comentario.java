package es.tfg.hospital.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the comentarios database table.
 * 
 */
@Entity
@Table(name="comentarios")
@NamedQuery(name="Comentario.findAll", query="SELECT c FROM Comentario c")
public class Comentario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_COM")
	private int idCom;

	private String comentario;

	@Column(name="DNI_1")
	private String dni1;

	@Column(name="DNI_2")
	private String dni2;

	public Comentario() {
	}

	public int getIdCom() {
		return this.idCom;
	}

	public void setIdCom(int idCom) {
		this.idCom = idCom;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getDni1() {
		return this.dni1;
	}

	public void setDni1(String dni1) {
		this.dni1 = dni1;
	}

	public String getDni2() {
		return this.dni2;
	}

	public void setDni2(String dni2) {
		this.dni2 = dni2;
	}

}