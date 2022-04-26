package es.tfg.hospital.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the informacion database table.
 * 
 */
@Entity
@NamedQuery(name="Informacion.findAll", query="SELECT i FROM Informacion i")
public class Informacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_INFO")
	private int idInfo;

	private String altura;

	private int edad;

	private int peso;

	private String sexo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="DNI")
	private Usuario usuario;

	public Informacion() {
	}

	public int getIdInfo() {
		return this.idInfo;
	}

	public void setIdInfo(int idInfo) {
		this.idInfo = idInfo;
	}

	public String getAltura() {
		return this.altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getPeso() {
		return this.peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}