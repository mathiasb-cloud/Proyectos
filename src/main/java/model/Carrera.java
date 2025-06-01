package model;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.String;
import jakarta.persistence.*;

@Entity
@Table(name = "carrera")
public class Carrera implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcarrera")
	private int id;
	
	@Column(name = "carrera")
	private String carrera;
	
	@Column(name = "estado")
	private Boolean estado;
	
	private static final long serialVersionUID = 1L;

	public Carrera() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getCarrera() {
		return this.carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}   
	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
   
}
