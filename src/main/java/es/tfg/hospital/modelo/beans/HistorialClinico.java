package es.tfg.hospital.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the historial_clinico database table.
 * 
 */
@Entity
@Table(name="historial_clinico")
@NamedQuery(name="HistorialClinico.findAll", query="SELECT h FROM HistorialClinico h")
public class HistorialClinico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_HISTORIAL")
	private int idHistorial;

	@Column(name="DES_CITAHIS")
	private String desCitahis;

	private String instrucciones;

	//bi-directional many-to-one association to Cita
	@ManyToOne
	@JoinColumn(name="ID_CITA")
	private Cita cita;

	//bi-directional many-to-one association to Medicina
	@ManyToOne
	@JoinColumn(name="COD_MED")
	private Medicina medicina;

	public HistorialClinico() {
	}

	public int getIdHistorial() {
		return this.idHistorial;
	}

	public void setIdHistorial(int idHistorial) {
		this.idHistorial = idHistorial;
	}

	public String getDesCitahis() {
		return this.desCitahis;
	}

	public void setDesCitahis(String desCitahis) {
		this.desCitahis = desCitahis;
	}

	public String getInstrucciones() {
		return this.instrucciones;
	}

	public void setInstrucciones(String instrucciones) {
		this.instrucciones = instrucciones;
	}

	public Cita getCita() {
		return this.cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	public Medicina getMedicina() {
		return this.medicina;
	}

	public void setMedicina(Medicina medicina) {
		this.medicina = medicina;
	}

}