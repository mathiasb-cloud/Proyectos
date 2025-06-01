package dao;

import java.util.List;

import model.Tipodocumento;
import model.Estudiante;

public interface EstudianteDAO {
	public void create(Estudiante estudiante);
	public void update(Estudiante estudiante);
	public void delete(Integer id);
	public Tipodocumento find(Integer id);
	public List<Estudiante> findAll();
	

}
