package es.tfg.hospital.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String dni;

	private String apellido;

	private String direccion;

	private String email;

	private int enabled;

	private String imgurl;

	private String nombre;

	private int onlineusu;

	private String password;

	private String telefono;

	//bi-directional many-to-one association to Cita
	@OneToMany(mappedBy="usuario")
	private List<Cita> citas;

	//bi-directional many-to-one association to Diagnostico
	@OneToMany(mappedBy="usuario")
	private List<Diagnostico> diagnosticos;

	//bi-directional many-to-one association to Informacion
	@OneToMany(mappedBy="usuario")
	private List<Informacion> informacions;

	//bi-directional many-to-many association to Perfil
	@ManyToMany
	@JoinTable(
		name="usuario_perfil"
		, joinColumns={
			@JoinColumn(name="DNI")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_PERFIL")
			}
		)
	private List<Perfil> perfils;

	public Usuario() {
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEnabled() {
		return this.enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getImgurl() {
		return this.imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getOnlineusu() {
		return this.onlineusu;
	}

	public void setOnlineusu(int onlineusu) {
		this.onlineusu = onlineusu;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Cita> getCitas() {
		return this.citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public Cita addCita(Cita cita) {
		getCitas().add(cita);
		cita.setUsuario(this);

		return cita;
	}

	public Cita removeCita(Cita cita) {
		getCitas().remove(cita);
		cita.setUsuario(null);

		return cita;
	}

	public List<Diagnostico> getDiagnosticos() {
		return this.diagnosticos;
	}

	public void setDiagnosticos(List<Diagnostico> diagnosticos) {
		this.diagnosticos = diagnosticos;
	}

	public Diagnostico addDiagnostico(Diagnostico diagnostico) {
		getDiagnosticos().add(diagnostico);
		diagnostico.setUsuario(this);

		return diagnostico;
	}

	public Diagnostico removeDiagnostico(Diagnostico diagnostico) {
		getDiagnosticos().remove(diagnostico);
		diagnostico.setUsuario(null);

		return diagnostico;
	}

	public List<Informacion> getInformacions() {
		return this.informacions;
	}

	public void setInformacions(List<Informacion> informacions) {
		this.informacions = informacions;
	}

	public Informacion addInformacion(Informacion informacion) {
		getInformacions().add(informacion);
		informacion.setUsuario(this);

		return informacion;
	}

	public Informacion removeInformacion(Informacion informacion) {
		getInformacions().remove(informacion);
		informacion.setUsuario(null);

		return informacion;
	}

	public List<Perfil> getPerfils() {
		return this.perfils;
	}

	public void setPerfils(List<Perfil> perfils) {
		this.perfils = perfils;
	}

	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", apellido=" + apellido + ", direccion=" + direccion + ", email=" + email
				+ ", enabled=" + enabled + ", imgurl=" + imgurl + ", nombre=" + nombre + ", onlineusu=" + onlineusu
				+ ", password=" + password + ", telefono=" + telefono + ", citas=" + citas + ", diagnosticos="
				+ diagnosticos + ", informacions=" + informacions + ", perfils=" + perfils + "]";
	}
	
	

}