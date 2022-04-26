package es.tfg.hospital.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo database table.
 * 
 */
@Entity
@NamedQuery(name="Tipo.findAll", query="SELECT t FROM Tipo t")
public class Tipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TIPO")
	private int idTipo;

	private String descripcion;

	//bi-directional many-to-one association to Medicina
	@OneToMany(mappedBy="tipo")
	private List<Medicina> medicinas;

	public Tipo() {
	}

	public int getIdTipo() {
		return this.idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Medicina> getMedicinas() {
		return this.medicinas;
	}

	public void setMedicinas(List<Medicina> medicinas) {
		this.medicinas = medicinas;
	}

	public Medicina addMedicina(Medicina medicina) {
		getMedicinas().add(medicina);
		medicina.setTipo(this);

		return medicina;
	}

	public Medicina removeMedicina(Medicina medicina) {
		getMedicinas().remove(medicina);
		medicina.setTipo(null);

		return medicina;
	}

}