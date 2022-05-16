package es.tfg.hospital.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cita database table.
 * 
 */
@Entity
@NamedQuery(name="Cita.findAll", query="SELECT c FROM Cita c")
public class Cita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CITA")
	private int idCita;

	@Column(name="DIRECCION_CENTROSALUD")
	private String direccionCentrosalud;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_CITA")
	private Date fechaCita;

	@Column(name="HORA_CITA")
	private String horaCita;

	@Column(name="NOMBRE_MEDICO")
	private String nombreMedico;

	@Column(name="NOMBRE_PACIENTE")
	private String nombrePaciente;

	private String sintomas;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="DNI")
	private Usuario usuario;

	//bi-directional many-to-one association to HistorialClinico
	@OneToMany(mappedBy="cita")
	private List<HistorialClinico> historialClinicos;

	public Cita() {
	}

	
	
	public int getIdCita() {
		return this.idCita;
	}

	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}

	public String getDireccionCentrosalud() {
		return this.direccionCentrosalud;
	}

	public void setDireccionCentrosalud(String direccionCentrosalud) {
		this.direccionCentrosalud = direccionCentrosalud;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaCita() {
		return this.fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	public String getHoraCita() {
		return this.horaCita;
	}

	public void setHoraCita(String horaCita) {
		this.horaCita = horaCita;
	}

	public String getNombreMedico() {
		return this.nombreMedico;
	}

	public void setNombreMedico(String nombreMedico) {
		this.nombreMedico = nombreMedico;
	}

	public String getNombrePaciente() {
		return this.nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public String getSintomas() {
		return this.sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<HistorialClinico> getHistorialClinicos() {
		return this.historialClinicos;
	}

	public void setHistorialClinicos(List<HistorialClinico> historialClinicos) {
		this.historialClinicos = historialClinicos;
	}

	public HistorialClinico addHistorialClinico(HistorialClinico historialClinico) {
		getHistorialClinicos().add(historialClinico);
		historialClinico.setCita(this);

		return historialClinico;
	}

	public HistorialClinico removeHistorialClinico(HistorialClinico historialClinico) {
		getHistorialClinicos().remove(historialClinico);
		historialClinico.setCita(null);

		return historialClinico;
	}



	@Override
	public String toString() {
		return "Cita [idCita=" + idCita + ", direccionCentrosalud=" + direccionCentrosalud + ", estado=" + estado
				+ ", fechaCita=" + fechaCita + ", horaCita=" + horaCita + ", nombreMedico=" + nombreMedico
				+ ", nombrePaciente=" + nombrePaciente + ", sintomas=" + sintomas + "]";
	}



	
	
}