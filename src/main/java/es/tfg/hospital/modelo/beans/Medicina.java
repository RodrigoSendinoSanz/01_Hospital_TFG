package es.tfg.hospital.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the medicina database table.
 * 
 */
@Entity
@NamedQuery(name="Medicina.findAll", query="SELECT m FROM Medicina m")
public class Medicina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_MED")
	private int codMed;

	private String activo;

	private int cantidad;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_FIN")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_INICIO")
	private Date fechaInicio;

	@Column(name="NOMBRE_MED")
	private String nombreMed;

	//bi-directional many-to-one association to HistorialClinico
	@OneToMany(mappedBy="medicina")
	private List<HistorialClinico> historialClinicos;

	//bi-directional many-to-one association to Tipo
	@ManyToOne
	@JoinColumn(name="ID_TIPO")
	private Tipo tipo;

	public Medicina() {
	}

	public int getCodMed() {
		return this.codMed;
	}

	public void setCodMed(int codMed) {
		this.codMed = codMed;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getNombreMed() {
		return this.nombreMed;
	}

	public void setNombreMed(String nombreMed) {
		this.nombreMed = nombreMed;
	}

	public List<HistorialClinico> getHistorialClinicos() {
		return this.historialClinicos;
	}

	public void setHistorialClinicos(List<HistorialClinico> historialClinicos) {
		this.historialClinicos = historialClinicos;
	}

	public HistorialClinico addHistorialClinico(HistorialClinico historialClinico) {
		getHistorialClinicos().add(historialClinico);
		historialClinico.setMedicina(this);

		return historialClinico;
	}

	public HistorialClinico removeHistorialClinico(HistorialClinico historialClinico) {
		getHistorialClinicos().remove(historialClinico);
		historialClinico.setMedicina(null);

		return historialClinico;
	}

	public Tipo getTipo() {
		return this.tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

}