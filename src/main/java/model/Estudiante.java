package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the estudiante database table.
 * 
 */
@Entity
@NamedQuery(name="Estudiante.findAll", query="SELECT e FROM Estudiante e")
public class Estudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEstudiante;

	private String carrera;

	private String documento;

	private String nombresApellidos;

	private String telefono;

	private int tipoDocumento;

	//bi-directional many-to-many association to Estudiante
	@ManyToMany
	@JoinColumns({
		})
	private List<Estudiante> estudiantes1;

	//bi-directional many-to-many association to Estudiante
	@ManyToMany(mappedBy="estudiantes1")
	private List<Estudiante> estudiantes2;

	public Estudiante() {
	}

	public int getIdEstudiante() {
		return this.idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public String getCarrera() {
		return this.carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombresApellidos() {
		return this.nombresApellidos;
	}

	public void setNombresApellidos(String nombresApellidos) {
		this.nombresApellidos = nombresApellidos;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(int tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public List<Estudiante> getEstudiantes1() {
		return this.estudiantes1;
	}

	public void setEstudiantes1(List<Estudiante> estudiantes1) {
		this.estudiantes1 = estudiantes1;
	}

	public List<Estudiante> getEstudiantes2() {
		return this.estudiantes2;
	}

	public void setEstudiantes2(List<Estudiante> estudiantes2) {
		this.estudiantes2 = estudiantes2;
	}

}