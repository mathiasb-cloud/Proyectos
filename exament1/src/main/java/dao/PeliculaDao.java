package dao;

import java.util.List;
import entidades.Pelicula;

public interface PeliculaDao {
	void create(Pelicula pelicula);
	void update(Pelicula pelicula);
	void delete(Integer id);
	Pelicula find(Integer id);
	List<Pelicula> findAll();
}
