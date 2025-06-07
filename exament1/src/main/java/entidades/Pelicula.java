package entidades;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "pelicula")
@NamedQuery(name = "Pelicula.findAll", query = "SELECT p FROM Pelicula p")
public class Pelicula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idpelicula;

	private String nombre;

	private String director;

	@Temporal(TemporalType.DATE)
	private Date fechEstreno;

	@ManyToOne
	@JoinColumn(name = "idgenero")
	private Genero genero;

	public Pelicula() {}

	public int getIdpelicula() {
		return idpelicula;
	}

	public void setIdpelicula(int idpelicula) {
		this.idpelicula = idpelicula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Date getFechEstreno() {
		return fechEstreno;
	}

	public void setFechEstreno(Date fechEstreno) {
		this.fechEstreno = fechEstreno;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
}
