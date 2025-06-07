package dao;

import java.util.List;
import entidades.Genero;

public interface GeneroDao {
	List<Genero> findAll();
	Genero find(int id);
}
